package com.umi.service;

import java.util.List;

import com.umi.pojo.CheckpostWithBLOBs;
import com.umi.pojo.NotpasspostWithBLOBs;
import com.umi.pojo.PageInfo;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.RequestWithBLOBs;
import com.umi.pojo.ShowPostRequest;

public interface PostService {

	
	/**
	 * 根据条件查询所有已通过审核的板块
	 * 按内容
	 * @param condition
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo selAllPostByDisplayInfo(String condition,int pageNum,int pageSize);
	/**
	 * 用户创建新板块
	 * @return
	 */
	public int insNewPost(String title,String post,String addr,String hidden,int point,long userId,String source); 
	/**
	 * 用户求资源
	 * @param userId
	 * @param title
	 * @return
	 */
	public boolean insNewRequset(long userId,String title);
	
	/**
	 * 用户查看正在审核中的板块
	 * @param userId
	 * @return
	 */
	public List<CheckpostWithBLOBs> selCheckPostByUserId(long userId);
	/**
	 * 用户查看已发布的板块
	 * @param userId
	 * @return
	 */
	public List<PostWithBLOBs> selPassPostByUserId(long userId);
	/**
	 * 用户查看未成功发布板块
	 * @param userId
	 * @return
	 */
	public List<NotpasspostWithBLOBs> selNotPassPostByUserId(long userId);
	
	public PostWithBLOBs selPassPostByPostId(long postId);
	
	public NotpasspostWithBLOBs selNotPassPostByPostId(long postId);
	
	public CheckpostWithBLOBs selCheckPostByPostId(long postId);
	
	
	
	public List<CheckpostWithBLOBs> selAllCheckPost();
	/**
	 * 查询用户求资源信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public ShowPostRequest selShowPostRequest(String pageNum,int pageSize);
	/**
	 * 查询用户求资源
	 * 其他用户发布资源信息
	 * @param userId
	 * @return
	 */
	public List<RequestWithBLOBs> selMyPostReq(long userId);
	
	/**
	 * 用户删除已通过审核的板块
	 * @param postId
	 * @param userId
	 * @return
	 */
	public boolean delPassPost(long postId,long userId);
	/**
	 * 用户删除正在审核中的板块
	 * @param postId
	 * @param userId
	 * @return
	 */
	public boolean delCheckPost(long postId,long userId);
	/**
	 * 用户删除未通过审核的板块
	 * @param postId
	 * @param userId
	 * @return
	 */
	public boolean delNotPassPost(long postId,long userId);
	
	/**
	 * 用户删除求资源板块
	 * @param userId
	 * @param reqId
	 * @return
	 */
	public boolean delReqPost(long userId,String reqId);
	/**
	 * 用户修改通过审核的板块
	 * @param postId
	 * @param userId
	 * @param title
	 * @param post
	 * @param addr
	 * @param hidde
	 * @return
	 */
	public boolean updPassPost(long postId,long userId,String title,
			String post,String addr,String hidde);
	/**
	 * 用户修改正在审核中的板块
	 * @param postId
	 * @param userId
	 * @param title
	 * @param post
	 * @param addr
	 * @param hidde
	 * @return
	 */
	public boolean updCheckPost(long postId,long userId,String title,
			String post,String addr,String hidde);
	/**
	 * 用户修改未通过审核的板块
	 * @param postId
	 * @param userId
	 * @param title
	 * @param post
	 * @param addr
	 * @param hidde
	 * @return
	 */
	public boolean updNotPassPost(long postId,long userId,String title,
			String post,String addr,String hidde);
	
	
}
