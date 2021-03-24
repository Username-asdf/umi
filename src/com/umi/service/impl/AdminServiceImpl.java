package com.umi.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.umi.mapper.CheckpostMapper;
import com.umi.mapper.NotpasspostMapper;
import com.umi.mapper.PostMapper;
import com.umi.mapper.UsersMapper;
import com.umi.mapper.UsersbuyMapper;
import com.umi.pojo.Admin;
import com.umi.pojo.CheckpostWithBLOBs;
import com.umi.pojo.NotpasspostWithBLOBs;
import com.umi.pojo.Post;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.Report;
import com.umi.pojo.Usersbuy;
import com.umi.service.AdminService;
import com.umi.service.PostService;
import com.umi.service.UserService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Resource
	private CheckpostMapper checkpostMapper; 
	@Resource
	private PostMapper postMapper;
	@Resource
	private NotpasspostMapper notpasspostMapper;
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private UserService usersServiceImpl;
	@Resource
	private PostService postServiceImpl;
	@Resource
	private UsersbuyMapper usersbuyMapper; 
	private Logger log = Logger.getLogger(AdminServiceImpl.class);

	@Override
	public Admin selByPhoneNumAndPwd(String phoneNum, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updPwdByAdminId(String AdminId, String newPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Report> selReportPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updReportPostIsCheck(String isCheck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Post> selCheckPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updCheckPost(long postId,int operate,long adminId,String reason,int getPoint) {
		if(operate==POST_PASS){
			CheckpostWithBLOBs checkPost = checkpostMapper.selectByPrimaryKey(postId);
			if(checkPost!=null){
				
				PostWithBLOBs record = new PostWithBLOBs();
				record.setUserid(checkPost.getUserid());
				record.setAdminid(adminId);
				record.setPostname(checkPost.getPostname());
				record.setDisplayinfo(checkPost.getDisplayinfo());
				record.setResourceaddr(checkPost.getResourceaddr());
				record.setHiddeninfo(checkPost.getHiddeninfo());
				record.setBrowsenum(new Long(0));
				record.setLikenum(new Long(0));
				record.setHatenum(new Long(0));
				record.setPoint(checkPost.getPoint());
				record.setTime(checkPost.getTime());
				record.setChecktime(new Date());
				record.setSortid(checkPost.getSortid());
				int insertSelective = postMapper.insertSelective(record );
				if(insertSelective>0){
					int deleteByPrimaryKey = checkpostMapper.deleteByPrimaryKey(postId);
					if(deleteByPrimaryKey<=0){
						return false;
					}
					//增加用户积分
					usersServiceImpl.updFreepoint(checkPost.getUserid(), getPoint);
					log.info("管理员审核板块通过-成功");
					return true;
				}
			}
			return false;
		}else if(operate==POST_NOT_PASS){
			CheckpostWithBLOBs checkPost = checkpostMapper.selectByPrimaryKey(postId);
			if(checkPost!=null){
				NotpasspostWithBLOBs record = new NotpasspostWithBLOBs();
				record.setUserid(checkPost.getUserid());
				record.setAdminid(adminId);
				record.setPostname(checkPost.getPostname());
				record.setDisplayinfo(checkPost.getDisplayinfo());
				record.setResourceaddr(checkPost.getResourceaddr());
				record.setHiddeninfo(checkPost.getHiddeninfo());
				record.setPoint(checkPost.getPoint());
				record.setChecktime(new Date());
				record.setSortid(checkPost.getSortid());
				record.setReason(reason);
				int insertSelective = notpasspostMapper.insertSelective(record);
				if(insertSelective>0){
					int deleteByPrimaryKey = checkpostMapper.deleteByPrimaryKey(postId);
					if(deleteByPrimaryKey<=0){
						return false;
					}
					log.info("管理员审核板块不通过-成功");
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	}

	@Override
	public boolean updUsersPoint(long usersId, String point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUsersPost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Post> selDelPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
