package com.umi.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.umi.mapper.CommentMapper;
import com.umi.mapper.CommentreportMapper;
import com.umi.mapper.CommentuserMapper;
import com.umi.mapper.LikeandhaterecordMapper;
import com.umi.mapper.PostMapper;
import com.umi.mapper.ReportMapper;
import com.umi.mapper.UsersMapper;
import com.umi.mapper.UsersbuyMapper;
import com.umi.pojo.Comment;
import com.umi.pojo.CommentExample;
import com.umi.pojo.Commentreport;
import com.umi.pojo.CommentreportExample;
import com.umi.pojo.Commentuser;
import com.umi.pojo.CommentuserExample;
import com.umi.pojo.Likeandhaterecord;
import com.umi.pojo.LikeandhaterecordExample;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.Report;
import com.umi.pojo.ReportExample;
import com.umi.pojo.ShowPost;
import com.umi.pojo.Users;
import com.umi.pojo.Usersbuy;
import com.umi.pojo.UsersbuyExample;
import com.umi.service.ShowPostService;

@Service
public class ShowPostServiceImpl implements ShowPostService{
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private CommentMapper commentMapper;
	@Resource
	private CommentuserMapper commentuserMapper;
	@Resource
	private PostMapper postMapper;
	@Resource
	private LikeandhaterecordMapper likeandhaterecordMapper;
	@Resource
	private CommentreportMapper commentreportMapper;
	@Resource
	private UsersbuyMapper usersbuyMapper;
	@Resource
	private ReportMapper reportMapper;
	private Logger log = Logger.getLogger(PostServiceImpl.class);
	@Override
	public ShowPost selShowPostAllInfo(long postId,long userId,int pageNum,int commSize,String orderByColum) {
		ShowPost showPost = new ShowPost();
		
		PostWithBLOBs post = postMapper.selectByPrimaryKey(postId);
		if(post==null){
			return null;
		}
		
		if(pageNum<=0){
			pageNum = 1;
		}
		
		//查询用户对板块是赞或踩
		LikeandhaterecordExample lahcExample = new LikeandhaterecordExample();
		com.umi.pojo.LikeandhaterecordExample.Criteria lahcOr = lahcExample.or();
		lahcOr.andPostidEqualTo(postId);
		lahcOr.andUsersidEqualTo(userId);
		List<Likeandhaterecord> lahcList = likeandhaterecordMapper.selectByExample(lahcExample);
		if(lahcList==null||lahcList.size()<=0){
			showPost.setlOrh(0);
		}else{
			showPost.setlOrh(lahcList.get(0).getLorh());
		}
		
		Users user = usersMapper.selectByPrimaryKey(post.getUserid());
		if(user==null){
			return null;
		}
		
		
		
		int start = (pageNum-1)*commSize;
		CommentExample example = new CommentExample();
		
		com.umi.pojo.CommentExample.Criteria or = example.or();
		or.andPostidEqualTo(postId);
		
		long count = commentMapper.countByExample(example);
		showPost.setTotal(((int) count));
		showPost.setCurrentPage(pageNum);
		showPost.setTotalPage(((int) Math.ceil(count/((double)commSize))));
		
		example.setOrderByClause(orderByColum);
		example.setLimit(commSize);
		example.setOffset(start);
		List<Comment> commList = commentMapper.selectByExampleWithBLOBs(example);
		
		for (int i=0;i<commList.size();i++) {
			Comment comment = commList.get(i);
			Users seluser = usersMapper.selectByPrimaryKey(comment.getUserid());
			if(seluser!=null){
				comment.setUsername(seluser.getUsername());
				comment.setUsericon(seluser.getUsericon());
			}
			if(comment.getUserid()==userId){
				showPost.setIsComment(showPost.getIsComment()+1);
			}
			//查询用户对评论点赞或踩
			CommentuserExample cuExample = new CommentuserExample();
			com.umi.pojo.CommentuserExample.Criteria cuOr = cuExample.or();
			cuOr.andUseridEqualTo(userId);
			cuOr.andCommidEqualTo(comment.getCommid());
			List<Commentuser> cuList = commentuserMapper.selectByExample(cuExample );
			if(cuList==null||cuList.size()<=0){
				comment.setlOrH(0);
			}else{
				comment.setlOrH(cuList.get(0).getLorh());
			}
		}
		
		showPost.setUser(user);
		showPost.setPassPost(post);
		showPost.setCommentList(commList);
		return showPost;
	}

	@Override
	public boolean updBrowerNum(long postId) {
		PostWithBLOBs pwb = postMapper.selectByPrimaryKey(postId);
		if(pwb==null){
			return false;
		}
		
		PostWithBLOBs record = new PostWithBLOBs();
		record.setPostid(postId);
		record.setBrowsenum(pwb.getBrowsenum()+1);
		int updBro = postMapper.updateByPrimaryKeySelective(record );
		if(updBro>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean insComm(long userId,String postId, String fkCommId, String comm) {
		if(testString(fkCommId)||testString(comm)||testString(postId)){
			return false;
		}
		long fkCommIdLong = 0;
		long postIdLong = 0;
		try{
			fkCommIdLong = Long.parseLong(fkCommId);
			postIdLong = Long.parseLong(postId);
		}catch(Exception e){
			return false;
		}
		
		Comment record = new Comment();
		record.setComm(comm);
		record.setFkcommid(fkCommIdLong);
		record.setHatenum(new Long(0));
		record.setLikenum(new Long(0));
		record.setPostid(postIdLong);
		record.setReportnum(new Long(0));
		record.setSendtime(new Date());
		record.setUserid(userId);
		int i = commentMapper.insertSelective(record );
		if(i>0){
			log.info("用户:"+userId+"发布评论成功-postId:"+postIdLong);
			return true;
		}else{
			log.info("用户:"+userId+"发布评论失败-postId:"+postIdLong);
		}
		return false;
	}
	private boolean testString(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
	@Override
	public boolean updCommLikeNum(long userId, String commId, String type) {
		if(testString(commId)||testString(type)){
			return false;
		}
		long commIdLong = 0;
		try{
			commIdLong = Long.parseLong(commId);
		}catch(Exception e){
			return false;
		}
		
		CommentuserExample example = new CommentuserExample();
		com.umi.pojo.CommentuserExample.Criteria or = example.or();
		or.andCommidEqualTo(commIdLong);
		or.andUseridEqualTo(userId);
		
		Commentuser commentuser = null;
		
		List<Commentuser> selectByExample = commentuserMapper.selectByExample(example );
		if(selectByExample==null||selectByExample.size()<=0){
			Commentuser record = new Commentuser();
			record.setCommid(commIdLong);
			record.setUserid(userId);
			record.setLorh(0);
			commentuserMapper.insertSelective(record );
		}else{
			commentuser = selectByExample.get(0);
		}
		
		switch(type){
		case "0":
			if(commentuser.getLorh()==0){
				return false;
			}
			Commentuser record = new Commentuser();
			record.setLorh(0);
			int i = commentuserMapper.updateByExampleSelective(record , example);
			if(i<=0){
				return false;
			}
			Comment selectByPrimaryKey = commentMapper.selectByPrimaryKey(commIdLong);
			if(selectByPrimaryKey==null){
				return false;
			}
			Comment record1 = new Comment();
			record1.setCommid(commIdLong);
			record1.setLikenum(selectByPrimaryKey.getLikenum()-1);
			int updateByPrimaryKeySelective = commentMapper.updateByPrimaryKeySelective(record1);
			if(updateByPrimaryKeySelective<=0){
				return false;
			}
			return true;
		case "1":
			if(commentuser.getLorh()==1){
				return false;
			}
			Commentuser record3 = new Commentuser();
			record3.setLorh(1);
			int i1 = commentuserMapper.updateByExampleSelective(record3 , example);
			if(i1<=0){
				return false;
			}
			Comment selectByPrimaryKey2 = commentMapper.selectByPrimaryKey(commIdLong);
			if(selectByPrimaryKey2==null){
				return false;
			}
			Comment record4 = new Comment();
			record4.setCommid(commIdLong);
			record4.setLikenum(selectByPrimaryKey2.getLikenum()+1);
			if(commentuser.getLorh()==2){
				record4.setHatenum(selectByPrimaryKey2.getHatenum()-1);
			}
			int updateByPrimaryKeySelective1 = commentMapper.updateByPrimaryKeySelective(record4);
			if(updateByPrimaryKeySelective1<=0){
				return false;
			}
			return true;
		default:
			return false;
		}
	}
	@Override
	public boolean updCommHateNum(long userId, String commId, String type) {
		if(testString(commId)||testString(type)){
			return false;
		}
		long commIdLong = 0;
		try{
			commIdLong = Long.parseLong(commId);
		}catch(Exception e){
			return false;
		}
		
		CommentuserExample example = new CommentuserExample();
		com.umi.pojo.CommentuserExample.Criteria or = example.or();
		or.andCommidEqualTo(commIdLong);
		or.andUseridEqualTo(userId);
		
		Commentuser commentuser = null;
		
		List<Commentuser> selectByExample = commentuserMapper.selectByExample(example );
		if(selectByExample==null||selectByExample.size()<=0){
			Commentuser record = new Commentuser();
			record.setCommid(commIdLong);
			record.setUserid(userId);
			record.setLorh(0);
			commentuserMapper.insertSelective(record );
		}else{
			commentuser = selectByExample.get(0);
		}
		
		
		switch(type){
		case "0":
			if(commentuser.getLorh()==0){
				return false;
			}
			Commentuser record = new Commentuser();
			record.setLorh(0);
			int i = commentuserMapper.updateByExampleSelective(record , example);
			if(i<=0){
				return false;
			}
			Comment selectByPrimaryKey = commentMapper.selectByPrimaryKey(commIdLong);
			if(selectByPrimaryKey==null){
				return false;
			}
			Comment record1 = new Comment();
			record1.setCommid(commIdLong);
			record1.setHatenum(selectByPrimaryKey.getHatenum()-1);
			int updateByPrimaryKeySelective = commentMapper.updateByPrimaryKeySelective(record1);
			if(updateByPrimaryKeySelective<=0){
				return false;
			}
			return true;
		case "1":
			if(commentuser.getLorh()==2){
				return false;
			}
			Commentuser record3 = new Commentuser();
			record3.setLorh(2);
			int i1 = commentuserMapper.updateByExampleSelective(record3 , example);
			if(i1<=0){
				return false;
			}
			Comment selectByPrimaryKey2 = commentMapper.selectByPrimaryKey(commIdLong);
			if(selectByPrimaryKey2==null){
				return false;
			}
			Comment record4 = new Comment();
			record4.setCommid(commIdLong);
			record4.setHatenum(selectByPrimaryKey2.getHatenum()+1);
			//设置likeNum
			if(commentuser.getLorh()==1){
				record4.setLikenum(selectByPrimaryKey2.getLikenum()-1);
			}
			int updateByPrimaryKeySelective1 = commentMapper.updateByPrimaryKeySelective(record4);
			if(updateByPrimaryKeySelective1<=0){
				return false;
			}
			return true;
		default:
			return false;
		}
	}
	@Override
	public boolean updCommReportNum(long userId, String commId, String reason) {
		if(testString(commId)){
			return false;
		}
		
		long commIdLong = 0;
		try{
			commIdLong = Long.parseLong(commId);
		}catch(Exception e){
			return false;
		}
		
		CommentreportExample crExample = new CommentreportExample();
		com.umi.pojo.CommentreportExample.Criteria crOr = crExample.or();
		crOr.andCommidEqualTo(commIdLong);
		crOr.andUseridEqualTo(userId);
		List<Commentreport> crList = commentreportMapper.selectByExample(crExample);
		if(crList!=null&&crList.size()>0){
			return false;
		}
		
		Commentreport crRecord = new Commentreport();
		crRecord.setCommid(commIdLong);
		crRecord.setReason(reason);
		crRecord.setUserid(userId);
		int crIns = commentreportMapper.insertSelective(crRecord);
		if(crIns<=0){
			return false;
		}
		
		Comment cRecord = new Comment();
		cRecord.setCommid(commIdLong);
		Long reportnum = commentMapper.selectByPrimaryKey(commIdLong).getReportnum();
		if(reportnum==null){
			reportnum = new Long(0);
		}
		cRecord.setReportnum(reportnum+1);
		int cIns = commentMapper.updateByPrimaryKeySelective(cRecord );
		if(cIns>0){
			log.info("用户:"+userId+"举报评论commId:"+commIdLong+"成功");
			return true;
		}else{
			log.error("用户:"+userId+"举报评论commId:"+commIdLong+"失败");
		}
		return false;
	}
	@Override
	public String selResourceAdrr(long userId, String postId) {
		if(testString(postId)){
			return null;
		}
		
		long postIdLong = 0;
		try{
			postIdLong = Long.parseLong(postId);
		}catch(Exception e){
			return null;
		}
		
		PostWithBLOBs post = postMapper.selectByPrimaryKey(postIdLong);
		if(post==null){
			return null;
		}
		//如果是自己的板块，直接返回资源地址
		if(post.getUserid()==userId){
			return post.getResourceaddr();
		}
		
		UsersbuyExample ubExample = new UsersbuyExample();
		com.umi.pojo.UsersbuyExample.Criteria or = ubExample.or();
		or.andUsersidEqualTo(userId);
		or.andPostidEqualTo(postIdLong);
		List<Usersbuy> ubList = usersbuyMapper.selectByExample(ubExample );
		if(ubList!=null&&ubList.size()>0){
			return  post.getResourceaddr();
		}
		Usersbuy ubRecord = new Usersbuy();
		ubRecord.setBuytime(new Date());
		ubRecord.setPostid(postIdLong);
		ubRecord.setUsersid(userId);
		int ubIns = usersbuyMapper.insertSelective(ubRecord);
		if(ubIns<=0){
			return null;
		}
		
		Users user = usersMapper.selectByPrimaryKey(userId);
		if(user==null){
			return null;
		}
		
		int remainPoint = user.getFreepoint()-post.getPoint();
		if(remainPoint<0){
			return "not";
		}
		
		Users user1 = new Users();
		user1.setUserid(user.getUserid());
		user1.setFreepoint(remainPoint);
		int i = usersMapper.updateByPrimaryKeySelective(user1);
		if(i>0){
			return post.getResourceaddr();
		}
		
		return null;
	}

	@Override
	public boolean updPostLikeNum(long userId, String postId, String type) {
		if(testString(postId)||testString(type)){
			return false;
		}
		long postIdLong = 0;
		try{
			postIdLong = Long.parseLong(postId);
		}catch(Exception e){
			return false;
		}
		
		//查询有无赞、踩板块记录，没有进行添加
		Likeandhaterecord lahc = null;
		
		LikeandhaterecordExample lahcExample = new LikeandhaterecordExample();
		com.umi.pojo.LikeandhaterecordExample.Criteria lahcOr = lahcExample.or();
		lahcOr.andUsersidEqualTo(userId);
		lahcOr.andPostidEqualTo(postIdLong);
		
		List<Likeandhaterecord> lahcList = likeandhaterecordMapper.selectByExample(lahcExample );
		if(lahcList==null||lahcList.size()<=0){
			lahc = new Likeandhaterecord();
			lahc.setPostid(postIdLong);
			lahc.setUsersid(userId);
			lahc.setLorh(0);
			likeandhaterecordMapper.insertSelective(lahc );
		}else{
			lahc = lahcList.get(0);
		}
		
		//对type进行判断，进行相应处理
		switch(type){
		case "0":
			if(lahc.getLorh()==0){
				return false;
			}
			Likeandhaterecord record = new Likeandhaterecord();
			record.setLorh(0);//设置记录为无选择
			int updLahc = likeandhaterecordMapper.updateByExampleSelective(record , lahcExample);
			if(updLahc<=0){
				return false;
			}
			//查询post表like数量,并减少post表likeNum
			PostWithBLOBs pwb = postMapper.selectByPrimaryKey(postIdLong);
			if(pwb==null){
				return false;
			}
			PostWithBLOBs pRecord = new PostWithBLOBs();
			pRecord.setPostid(postIdLong);
			pRecord.setLikenum(pwb.getLikenum()-1);
			int updp = postMapper.updateByPrimaryKeySelective(pRecord );
			if(updp<=0){
				return false;
			}
			return true;
		case "1":
			if(lahc.getLorh()==1){
				return false;
			}
			Likeandhaterecord record1 = new Likeandhaterecord();
			record1.setLorh(1);//设置记录为 
			int updLahc1 = likeandhaterecordMapper.updateByExampleSelective(record1 , lahcExample);
			if(updLahc1<=0){
				return false;
			}
			//查询post表like数量,并增加post表likeNum
			PostWithBLOBs pwb1 = postMapper.selectByPrimaryKey(postIdLong);
			if(pwb1==null){
				return false;
			}
			PostWithBLOBs pRecord1 = new PostWithBLOBs();
			pRecord1.setPostid(postIdLong);
			pRecord1.setLikenum(pwb1.getLikenum()+1);
			//设置hateNum
			if(lahc.getLorh()==2){
				pRecord1.setHatenum(pwb1.getHatenum()-1);
			}
			int updp1 = postMapper.updateByPrimaryKeySelective(pRecord1);
			if(updp1<=0){
				return false;
			}
			return true;
		default:
			return false;
		}
	}
	@Override
	public boolean updPostHateNum(long userId, String postId, String type) {
		if(testString(postId)||testString(type)){
			return false;
		}
		long postIdLong = 0;
		try{
			postIdLong = Long.parseLong(postId);
		}catch(Exception e){
			return false;
		}
		
		//查询有无赞、踩板块记录，没有进行添加
		Likeandhaterecord lahc = null;
		
		LikeandhaterecordExample lahcExample = new LikeandhaterecordExample();
		com.umi.pojo.LikeandhaterecordExample.Criteria lahcOr = lahcExample.or();
		lahcOr.andUsersidEqualTo(userId);
		lahcOr.andPostidEqualTo(postIdLong);
		
		List<Likeandhaterecord> lahcList = likeandhaterecordMapper.selectByExample(lahcExample );
		if(lahcList==null||lahcList.size()<=0){
			lahc = new Likeandhaterecord();
			lahc.setPostid(postIdLong);
			lahc.setUsersid(userId);
			lahc.setLorh(0);
			likeandhaterecordMapper.insertSelective(lahc );
		}else{
			lahc = lahcList.get(0);
		}
		
		//对type进行判断，进行相应处理
		switch(type){
		case "0":
			if(lahc.getLorh()==0){
				return false;
			}
			Likeandhaterecord record = new Likeandhaterecord();
			record.setLorh(0);//设置记录为无选择
			int updLahc = likeandhaterecordMapper.updateByExampleSelective(record , lahcExample);
			if(updLahc<=0){
				return false;
			}
			//查询post表hate数量,并减少post表hate
			PostWithBLOBs pwb = postMapper.selectByPrimaryKey(postIdLong);
			if(pwb==null){
				return false;
			}
			PostWithBLOBs pRecord = new PostWithBLOBs();
			pRecord.setPostid(postIdLong);
			pRecord.setHatenum(pwb.getHatenum()-1);
			int updp = postMapper.updateByPrimaryKeySelective(pRecord );
			if(updp<=0){
				return false;
			}
			return true;
		case "1":
			if(lahc.getLorh()==2){
				return false;
			}
			Likeandhaterecord record1 = new Likeandhaterecord();
			record1.setLorh(2);//设置记录为 hate
			int updLahc1 = likeandhaterecordMapper.updateByExampleSelective(record1 , lahcExample);
			if(updLahc1<=0){
				return false;
			}
			//查询post表like数量,并增加post表likeNum
			PostWithBLOBs pwb1 = postMapper.selectByPrimaryKey(postIdLong);
			if(pwb1==null){
				return false;
			}
			PostWithBLOBs pRecord1 = new PostWithBLOBs();
			pRecord1.setPostid(postIdLong);
			pRecord1.setHatenum(pwb1.getHatenum()+1);
			//减少likeNum
			if(lahc.getLorh()==1){
				pRecord1.setLikenum(pwb1.getLikenum()-1);
			}
			int updp1 = postMapper.updateByPrimaryKeySelective(pRecord1);
			if(updp1<=0){
				return false;
			}
			return true;
		default:
			return false;
		}
	}
	@Override
	public boolean insNewPostReport(long userId, String postId, String reason) {
		if(testString(postId)){
			return false;
		}
		long postIdLong = 0;
		try{
			postIdLong = Long.parseLong(postId);
		}catch(Exception e){
			return false;
		}
		
		ReportExample example = new ReportExample();
		com.umi.pojo.ReportExample.Criteria or = example.or();
		or.andUsersidEqualTo(userId);
		or.andPostidEqualTo(postIdLong);
		List<Report> repList = reportMapper.selectByExample(example );
		if(repList!=null&&repList.size()>0){
			return false;
		}
		
		Report record = new Report();
		record.setReporttime(new Date());
		record.setIscheck(0);
		record.setPostid(postIdLong);
		record.setUsersid(userId);
		record.setCause(reason);
		int rep = reportMapper.insertSelective(record );
		if(rep>0){
			log.info("用户:"+userId+"举报板块postId:"+postId+"成功");
			return true;
		}else{
			log.error("用户:"+userId+"举报板块postId:"+postId+"失败");
		}
		return false;
	}
	@Override
	public boolean delComment(long commId, long userId) {
		Comment comment = commentMapper.selectByPrimaryKey(commId);
		if(comment==null){
			return false;
		}
		if(comment.getUserid() != userId){
			return false;
		}
		//删除用户赞，踩记录表数据
		CommentuserExample delcuExample = new CommentuserExample();
		com.umi.pojo.CommentuserExample.Criteria delcuOr = delcuExample.or();
		delcuOr.andCommidEqualTo(commId);
		commentuserMapper.deleteByExample(delcuExample );
		//删除用户举报评论数据
		CommentreportExample delcrExample = new CommentreportExample();
		com.umi.pojo.CommentreportExample.Criteria delcrOr = delcrExample.or();
		delcrOr.andCommidEqualTo(commId);
		commentreportMapper.deleteByExample(delcrExample);
		//删除comment表数据
		int delComm = commentMapper.deleteByPrimaryKey(commId);
		if(delComm>0){
			log.info("用户:"+userId+"删除评论commId"+commId+"成功");
			return true;
		}else{
			log.error("用户:"+userId+"删除评论commId"+commId+"失败");
		}
		return false;
	}

}
