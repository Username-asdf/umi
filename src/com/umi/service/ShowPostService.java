package com.umi.service;

import com.umi.pojo.ShowPost;

public interface ShowPostService {
	public ShowPost selShowPostAllInfo(long postId,long userId,int pageNum,int commSize,String orderByColum);
	/**
	 * 修改板块浏览量
	 * @param postId
	 * @return
	 */
	public boolean updBrowerNum(long postId);
	/**
	 * 用户发表评论
	 * @return
	 */
	public boolean insComm(long userId,String postId,String fkCommId,String comm);
	/**
	 * 用户修改评论likeNum
	 * @param userId
	 * @param commId
	 * @param type
	 * @return
	 */
	public boolean updCommLikeNum(long userId,String commId,String type);
	/**
	 * 用户修改评论hateNum
	 * @param userId
	 * @param commId
	 * @param type
	 * @return
	 */
	public boolean updCommHateNum(long userId,String commId,String type);
	/**
	 * 新增用户举报评论数据
	 * reason--待做
	 * 增加用户举报评论数
	 * @param userId
	 * @param commId
	 * @return
	 */
	public boolean updCommReportNum(long userId,String commId,String reason);
	/**
	 * 用户获取资源地址
	 * @param userId
	 * @param postId
	 * @return
	 */
	public String selResourceAdrr(long userId,String postId);
	/**
	 * 修改板块赞数
	 * @param userId
	 * @param postId
	 * @param type
	 * @return
	 */
	public boolean updPostLikeNum(long userId,String postId,String type);
	/**
	 * 修改板块踩数
	 * @param userId
	 * @param postId
	 * @param type
	 * @return
	 */
	public boolean updPostHateNum(long userId,String postId,String type);
	/**
	 * 用户举报板块
	 * @param userId
	 * @param postId
	 * @param reason
	 * @return
	 */
	public boolean insNewPostReport(long userId,String postId,String reason);
	/**
	 * 用户删除评论
	 * @param commId
	 * @param userId
	 * @return
	 */
	public boolean delComment(long commId,long userId);
}
