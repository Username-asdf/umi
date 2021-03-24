package com.umi.service;

import java.util.List;

import com.umi.pojo.Admin;
import com.umi.pojo.Post;
import com.umi.pojo.Report;

public interface AdminService {
	
	public static final int POST_PASS = 1;
	public static final int POST_NOT_PASS = 2;
	
	/**
	 * 管理员根据手机号和密码进行登录
	 * @param phoneNum
	 * @param pwd
	 * @return
	 */
	public Admin selByPhoneNumAndPwd(String phoneNum,String pwd);
	/**
	 * 管理员修改密码
	 * @param phoneNum
	 * @param newPwd
	 * @return
	 */
	public boolean updPwdByAdminId(String AdminId,String newPwd);
	/**
	 * 管理员查看举报信息
	 * @return
	 */
	public List<Report> selReportPost();
	/**
	 * 管理员对举报信息进行处理标记
	 * @param isCheck
	 * @return
	 */
	public boolean updReportPostIsCheck(String isCheck);
	/**
	 * 管理员查看待审核的板块
	 * @return
	 */
	public List<Post> selCheckPost();
	/**
	 * 管理员处理待审核的板块
	 * @param postId
	 * @return
	 */
	public boolean updCheckPost(long postId,int operate,long adminId,String reason,int getPoint);
	/**
	 * 管理员增加用户积分
	 * @param usersId
	 * @param point
	 * @return
	 */
	public boolean updUsersPoint(long usersId,String point);
	/**
	 * 管理员删除用户板块
	 * @return
	 */
	public boolean delUsersPost();
	/**
	 * 管理员查看删除的板块
	 * @return
	 */
	public List<Post> selDelPost();
}
