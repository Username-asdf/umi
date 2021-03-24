package com.umi.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.umi.mapper.CheckpostMapper;
import com.umi.mapper.LikeandhaterecordMapper;
import com.umi.mapper.NotpasspostMapper;
import com.umi.mapper.PostMapper;
import com.umi.mapper.ReportMapper;
import com.umi.mapper.RequestMapper;
import com.umi.mapper.UsersMapper;
import com.umi.pojo.Checkpost;
import com.umi.pojo.CheckpostExample;
import com.umi.pojo.CheckpostExample.Criteria;
import com.umi.pojo.CheckpostWithBLOBs;
import com.umi.pojo.LikeandhaterecordExample;
import com.umi.pojo.Notpasspost;
import com.umi.pojo.NotpasspostExample;
import com.umi.pojo.NotpasspostWithBLOBs;
import com.umi.pojo.PageInfo;
import com.umi.pojo.Post;
import com.umi.pojo.PostExample;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.ReportExample;
import com.umi.pojo.RequestExample;
import com.umi.pojo.RequestPost;
import com.umi.pojo.RequestWithBLOBs;
import com.umi.pojo.ShowPostRequest;
import com.umi.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Resource
	private CheckpostMapper checkpostMapper;
	@Resource
	private PostMapper postMapper;
	@Resource
	private NotpasspostMapper notpasspostMapper;
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private RequestMapper requestMapper;
	@Resource
	private LikeandhaterecordMapper likeandhaterecordMapper;
	@Resource
	private ReportMapper reportMapper;
	private Logger log = Logger.getLogger(PostServiceImpl.class);
	
	@Override
	public int insNewPost(String title,String post,String addr,String hidden,int point,long userId,String source) {
		long sourceLong = 0;
		if(!testString(source)){
			try{
				sourceLong = Long.parseLong(source);
			}catch(Exception e){
				
			}
		}
		CheckpostWithBLOBs record = new CheckpostWithBLOBs();
		record.setTime(new Date());
		record.setPoint(point);
		record.setUserid(userId);
		record.setDisplayinfo(post);
		record.setHiddeninfo(hidden);
		record.setPostname(title);
		record.setResourceaddr(addr);
		record.setSource(sourceLong);
		record.setSortid(0);
		int insertSelective = checkpostMapper.insertSelective(record);
		if(insertSelective>0){
			log.info("用户:"+userId+"发布板块成功--postName:"+title);
		}else{
			log.error("用户:"+userId+"发布板块失败--postName:"+title);
		}
		return insertSelective;
	}

	@Override
	public List<CheckpostWithBLOBs> selCheckPostByUserId(long userId) {
		CheckpostExample example = new CheckpostExample();
		Criteria or = example.or();
		or.andUseridEqualTo(userId);
		return checkpostMapper.selectByExampleWithBLOBs(example );
	}

	@Override
	public List<PostWithBLOBs> selPassPostByUserId(long userId) {
		PostExample example = new PostExample();
		com.umi.pojo.PostExample.Criteria or = example.or();
		or.andUseridEqualTo(userId);
		return postMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<NotpasspostWithBLOBs> selNotPassPostByUserId(long userId) {
		NotpasspostExample example = new NotpasspostExample();
		com.umi.pojo.NotpasspostExample.Criteria or = example.or();
		or.andUseridEqualTo(userId);
		return notpasspostMapper.selectByExampleWithBLOBs(example );
	}

	@Override
	public boolean delPassPost(long postId, long userId) {
		PostWithBLOBs post = postMapper.selectByPrimaryKey(postId);
		if(post==null){
			return false;
		}
		if(post.getUserid() != userId){
			return false;
		}
		
		//删除板块赞、踩记录表数据
		LikeandhaterecordExample lahcExample = new LikeandhaterecordExample();
		com.umi.pojo.LikeandhaterecordExample.Criteria lahcOr = lahcExample.or();
		lahcOr.andPostidEqualTo(postId);
		likeandhaterecordMapper.deleteByExample(lahcExample);
		//删除用户举报板块表数据
		ReportExample repExample = new ReportExample();
		com.umi.pojo.ReportExample.Criteria repOr = repExample.or();
		repOr.andPostidEqualTo(postId);
		reportMapper.deleteByExample(repExample );
		//删除板块数据
		int delPost = postMapper.deleteByPrimaryKey(postId);
		if(delPost>0){
			log.info("用户:"+userId+"删除已发布板块成功-postId:"+postId);
			return true;
		}else{
			log.error("用户:"+userId+"删除已发布板块失败-postId:"+postId);
		}
		return false;
	}

	@Override
	public boolean delCheckPost(long postId, long userId) {
		CheckpostExample example = new CheckpostExample();
		Criteria or = example.or();
		or.andPostidEqualTo(postId);
		or.andUseridEqualTo(userId);
		int i = checkpostMapper.deleteByExample(example );
		if(i>0){
			log.info("用户:"+userId+"删除正在审查板块成功-postId:"+postId);
			return true;
		}else{
			log.error("用户:"+userId+"删除正在审查板块失败-postId:"+postId);
		}
		return false;
	}

	@Override
	public boolean delNotPassPost(long postId, long userId) {
		NotpasspostExample example = new NotpasspostExample();
		com.umi.pojo.NotpasspostExample.Criteria or = example.or();
		or.andPostidEqualTo(postId);
		or.andUseridEqualTo(userId);
		int i = notpasspostMapper.deleteByExample(example );
		if(i>0){
			log.info("用户:"+userId+"删除未通过审查板块成功-postId:"+postId);
			return true;
		}else{
			log.error("用户:"+userId+"删除未通过审查块失败-postId:"+postId);
		}
		return false;
	}

	@Override
	public boolean updPassPost(long postId, long userId, String title, String post, String addr, String hidde) {
		PostExample example = new PostExample();
		com.umi.pojo.PostExample.Criteria or = example.or();
		or.andPostidEqualTo(postId);
		or.andUseridEqualTo(userId);
		List<Post> postList = postMapper.selectByExample(example );
		if(postList==null||postList.size()<=0){
			return false;
		}
		
		Post passPost = postList.get(0);
		
		boolean delPassPost = delPassPost(postId, userId);
		if(!delPassPost){
			return false;
		}
		
		int insNp = insNewPost(title, post, addr, hidde, passPost.getPoint(), userId, passPost.getSource()+"");
		if(insNp>0){
			log.info("用户:"+userId+"修改已通过审查成功-postId:"+postId);
			return true;
		}else{
			log.error("用户:"+userId+"修改已通过审查失败-postId:"+postId);
		}
		
		return false;
	}

	@Override
	public boolean updCheckPost(long postId, long userId, String title, String post, String addr, String hidde) {
		CheckpostExample example = new CheckpostExample();
		Criteria or = example.or();
		or.andPostidEqualTo(postId);
		or.andUseridEqualTo(userId);
		List<Checkpost> list = checkpostMapper.selectByExample(example );
		if(list==null||list.size()<=0){
			return false;
		}
		
		CheckpostWithBLOBs record = new CheckpostWithBLOBs();
		record.setDisplayinfo(post);
		record.setHiddeninfo(hidde);
		record.setPostname(title);
		record.setResourceaddr(addr);
		int i = checkpostMapper.updateByExampleSelective(record , example);
		if(i<0){
			log.info("用户:"+userId+"修改正在审查成功-postId:"+postId);
			return true;
		}else{
			log.error("用户:"+userId+"修改正在审查失败-postId:"+postId);
		}
		return false;
	}

	@Override
	public boolean updNotPassPost(long postId, long userId, String title, String post, String addr, String hidde) {
		NotpasspostExample example = new NotpasspostExample();
		com.umi.pojo.NotpasspostExample.Criteria or = example.or();
		or.andPostidEqualTo(postId);
		or.andUseridEqualTo(userId);
		List<Notpasspost> npList = notpasspostMapper.selectByExample(example );
		if(npList==null||npList.size()<=0){
			return false;
		}
		
		Notpasspost npPost = npList.get(0);
		
		boolean delNotPassPost = delNotPassPost(postId, userId);
		if(!delNotPassPost){
			return false;
		}
		int insNewPost = insNewPost(title, post, addr, hidde, npPost.getPoint(), userId,npPost.getSource()+"");
		if(insNewPost>0){
			log.info("用户："+userId+"修改未通过审查板块成功-postId:"+postId);
			return true;
		}else{
			log.error("用户："+userId+"修改未通过审查板块失败-postId:"+postId);
		}
		return false;
	}

	@Override
	public PostWithBLOBs selPassPostByPostId(long postId) {
		
		return postMapper.selectByPrimaryKey(postId);
	}

	@Override
	public NotpasspostWithBLOBs selNotPassPostByPostId(long postId) {
		return notpasspostMapper.selectByPrimaryKey(postId);
	}

	@Override
	public CheckpostWithBLOBs selCheckPostByPostId(long postId) {
		return checkpostMapper.selectByPrimaryKey(postId);
	}

	@Override
	public List<CheckpostWithBLOBs> selAllCheckPost() {
		CheckpostExample example = new CheckpostExample();
		Criteria or = example.or();
		or.andPostidIsNotNull();
		return checkpostMapper.selectByExampleWithBLOBs(example);
	}

	

	@Override
	public PageInfo selAllPostByDisplayInfo(String condition, int pageNum, int pageSize) {
		long count = postMapper.selPostCountLikeDisplayInfo("%"+condition+"%");
		if(count<=0){
			return null;
		}
		
		if(pageNum<=0){
			pageNum = 1;
		}
		
		int start = (pageNum-1)*pageSize;
		List<PostWithBLOBs> selPostLikeDisplayInfo = postMapper.selPostLikeDisplayInfo("%"+condition+"%", start, pageSize);
		if(selPostLikeDisplayInfo==null||selPostLikeDisplayInfo.size()<=0){
			return null;
		}
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCurrent(pageNum);
		pageInfo.setTotal((long) Math.ceil(count/((double)pageSize)));
		pageInfo.setList(selPostLikeDisplayInfo);
		pageInfo.setTotalNum(count);
		return pageInfo;
	}
	
	private boolean testString(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}

	

	@Override
	public boolean insNewRequset(long userId, String title) {
		if(testString(title)){
			return false;
		}
		
		RequestWithBLOBs record = new RequestWithBLOBs();
		record.setAccpet(new Long(0));
		record.setFinish(0);
		record.setTitle(title);
		record.setTime(new Date());
		record.setUsersid(userId);
		int rIns = requestMapper.insertSelective(record );
		if(rIns>0){
			log.info("用户:"+userId+"发布求资源成功");
			return true;
		}else{
			log.error("用户:"+userId+"发布求资源失败");
		}
		return false;
	}

	@Override
	public ShowPostRequest selShowPostRequest(String pageNum, int pageSize) {
		int pageNumInt = 1;
		if(!testString(pageNum)){
			try{
				pageNumInt = Integer.parseInt(pageNum);
			}catch(Exception e){
				log.info("selShowPostRequest解析pageNum出错");
			}
		}
		
		if(pageNumInt<=0){
			pageNumInt = 1;
		}
		
		int start = (pageNumInt-1)*pageSize;
		
		long countReq = requestMapper.countByExample(new RequestExample());
		
		ShowPostRequest spReq = new ShowPostRequest();
		spReq.setTotal(((int) Math.ceil(countReq/((double)pageSize))));
		spReq.setTotalNum(countReq);
		spReq.setCurrent(pageNumInt);
		
		RequestExample example = new RequestExample();
		com.umi.pojo.RequestExample.Criteria or = example.or();
		//设置求资源板块不展示
		or.andAccpetEqualTo(new Long(0));
		or.andFinishEqualTo(0);
		example.setOffset(start);
		example.setLimit(pageSize);
		example.setOrderByClause("requestId desc");
		List<RequestWithBLOBs> reqList = requestMapper.selectByExampleWithBLOBs(example);
		
		for (int i = 0; i < reqList.size(); i++) {
			RequestWithBLOBs rw  = reqList.get(i);
			
			PostExample pExample = new PostExample();
			com.umi.pojo.PostExample.Criteria pOr = pExample.or();
			pOr.andSourceEqualTo(rw.getRequestid());
			long countNum = postMapper.countByExample(pExample );
			
			rw.setNum(countNum);
		}
		
		spReq.setList(reqList);
		
		return spReq;
	}

	@Override
	public List<RequestWithBLOBs> selMyPostReq(long userId) {
		RequestExample rExample = new RequestExample();
		rExample.setOrderByClause("requestId desc");//设置查看用户自己发布的求资源信息的排序方式
		com.umi.pojo.RequestExample.Criteria rOr = rExample.or();
		rOr.andUsersidEqualTo(userId);
		List<RequestWithBLOBs> reqList = requestMapper.selectByExampleWithBLOBs(rExample );
		
		for (int i = 0; i < reqList.size(); i++) {
			RequestWithBLOBs rw = reqList.get(i);
			List<RequestPost> postList = postMapper.selUsernaemAndPostId(rw.getRequestid());
			rw.setListSize(postList.size());
			rw.setList(postList);
		}
		
		return reqList;
	}

	

	

	
	
	@Override
	public boolean delReqPost(long userId, String reqId) {
		if(testString(reqId)){
			log.error("用户:"+userId+"尝试删除求资源板块"+reqId+"失败");
			return false;
		}
		long reqIdLong = 0;
		try{
			reqIdLong = Long.parseLong(reqId);
		}catch(Exception e){
			log.error("用户:"+userId+"尝试删除求资源板块"+reqId+"失败");
			return false;
		}
		
		RequestWithBLOBs reqPost = requestMapper.selectByPrimaryKey(reqIdLong);
		if(reqPost==null||reqPost.getUsersid()!=userId){
			log.error("用户："+userId+"尝试删除一个不存在的板块或不属于自己的板块");
			return false;
		}
		
		int delReqPost = requestMapper.deleteByPrimaryKey(reqIdLong);
		if(delReqPost>0){
			log.info("用户:"+userId+"成功删除板块"+reqIdLong);
			return true;
		}
		
		log.error("用户:"+userId+"删除板块"+reqIdLong+"失败");
		return false;
	}

}
