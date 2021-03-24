package com.umi.service;

import com.umi.pojo.Sign;
import com.umi.pojo.Users;

public interface LoginAndRegisterService {
	/**
	 * 根据手机号和密码进行登录
	 * @return
	 */
	public Users selByPhoneNumAndPwd(String phoneNum,String pwd);
	/**
	 * 根据手机号检测手机号码是否已被注册
	 * @param phoneNum
	 * @return
	 */
	public Users selByPhoneNum(String phoneNum);
	/**
	 * 根据手机号修改密码
	 * @param phoneNum
	 * @param newPwd
	 * @return
	 */
	public int updPwd(String phoneNum,String newPwd);
	/**
	 * 查询用户名是否已被注册
	 * @param username
	 * @return
	 */
	public boolean selByUsername(String username);
	/**
	 * 查询该用户今天是否已签到
	 * @param userId
	 * @return
	 */
	public Sign selSignByUserId(long userId);
	/**
	 * 增加新用户
	 * @param phoneNum
	 * @param username
	 * @param pwd
	 * @return
	 */
	public int insUser(String phoneNum,String username,String pwd);
	
}
