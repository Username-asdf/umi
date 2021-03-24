package com.umi.service;

import com.umi.pojo.PageInfo;
import com.umi.pojo.Sign;

public interface IndexAndSearchService {
	/**
	 * 新增签到用户
	 * @param userId
	 * @return
	 */
	public int insNewSign(long userId);
	/**
	 * 查询该用户今天是否已签到
	 * @param userId
	 * @return
	 */
	public Sign selSignByUserId(long userId);
	/**
	 * 根据条件查询所有已通过审核的板块
	 * 按标题
	 * @return
	 */
	public PageInfo selAllPostByTitle(String condition,int pageNum,int pageSize);
	/**
	 * 修改用户积分
	 * @param userId
	 * @return
	 */
	public int updFreepoint(long userId,int point);
}
