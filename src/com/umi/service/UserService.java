package com.umi.service;

import java.util.List;

import com.umi.pojo.ShowUserInfo;
import com.umi.pojo.Users;

public interface UserService {
	
	/**
	 * 根据手机号检测手机号码是否已被注册
	 * @param phoneNum
	 * @return
	 */
	public Users selByPhoneNum(String phoneNum);
	
	/**
	 * 根据usersId查询个人信息
	 * @param usersId
	 * @return
	 */
	public Users selByUsersId(Long usersId);
	/**
	 * 用户查看自己关注的人
	 * @param usersId
	 * @return
	 */
	public List<Users> selFriendsByUsersId(long usersId);
	
	
	
	/**
	 * 用户填写完整信息
	 * @param users
	 * @return
	 */
	public int updOtherInfo(Users users);
	/**
	 * 修改用户积分
	 * @param userId
	 * @return
	 */
	public int updFreepoint(long userId,int point);
	/**
	 * 用户查看其他用户信息
	 * @param userId
	 * @return
	 */
	public ShowUserInfo selOtherUsers(long iUserId,String hUserId);
	/**
	 * 用户新增关注用户
	 * @param iUserId
	 * @param hUserId
	 * @return
	 */
	public boolean insNewFriend(long iUserId,String hUserId);
	/**
	 * 用户取消关注
	 * @param iUserId
	 * @param hUserId
	 * @return
	 */
	public boolean delFriend(long iUserId,String hUserId);
	
}
