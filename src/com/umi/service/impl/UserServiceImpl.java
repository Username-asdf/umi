package com.umi.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.umi.mapper.FriendsMapper;
import com.umi.mapper.PostMapper;
import com.umi.mapper.UsersMapper;
import com.umi.pojo.Friends;
import com.umi.pojo.FriendsExample;
import com.umi.pojo.PostExample;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.ShowUserInfo;
import com.umi.pojo.Users;
import com.umi.pojo.UsersExample;
import com.umi.pojo.UsersExample.Criteria;
import com.umi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UsersMapper usersMapper;
	@Resource
	private FriendsMapper friendsMapper;
	@Resource
	private PostMapper postMapper;
	private Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public int updOtherInfo(Users users) {
		int i = usersMapper.updateByPrimaryKeySelective(users);
		if(i>0){
			log.info("用户:"+users.getUserid()+"更新用户信息成功-"+users);
		}else{
			log.error("用户:"+users.getUserid()+"更新用户信息失败-"+users);
		}
		return i;
	}
	@Override
	public Users selByPhoneNum(String phoneNum) {
		UsersExample example = new UsersExample();
		Criteria or = example.or();
		or.andPhonenumEqualTo(phoneNum);
		List<Users> list = usersMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public Users selByUsersId(Long usersId) {
		return usersMapper.selectByPrimaryKey(usersId);
	}

	@Override
	public List<Users> selFriendsByUsersId(long usersId) {
		List<Users> list = null;
		FriendsExample example = new FriendsExample();
		com.umi.pojo.FriendsExample.Criteria or = example.or();
		or.andAttenduseridEqualTo(usersId);
		List<Friends> listFriends = friendsMapper.selectByExample(example);
		for(int i=0;i<listFriends.size();i++){
			if(list==null){
				list = new ArrayList<>();
			}
			Long beattenduserid = listFriends.get(i).getBeattenduserid();
			Users user = selByUsersId(beattenduserid);
			list.add(user);
		}
		return list;
	}

	@Override
	public int updFreepoint(long userId,int point) {
		Users user = usersMapper.selectByPrimaryKey(userId);
		if(user==null){
			return 0;
		}
		int remainPoint = user.getFreepoint()+point;
		if(remainPoint<0){
			return 0;
		}
		Users record = new Users();
		record.setUserid(userId);
		record.setFreepoint(remainPoint);
		int updateByPrimaryKeySelective = usersMapper.updateByPrimaryKeySelective(record);
		if(updateByPrimaryKeySelective>0){
			log.info("用户:"+userId+"更改用户积分成功--积分增加"+point+"剩余积分："+remainPoint);
		}else{
			log.error("用户:"+userId+"更改用户积分失败--point"+point+"剩余积分："+remainPoint);
		}
		return updateByPrimaryKeySelective;
	}

	private boolean testString(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
	
	@Override
	public ShowUserInfo selOtherUsers(long iUserId,String hUserId) {
		if(testString(hUserId)){
			return null;
		}
		
		long hUserIdLong = 0;
		try{
			hUserIdLong = Long.parseLong(hUserId);
		}catch(Exception e){
			return null;
		}
		
		ShowUserInfo suInfo = new ShowUserInfo();
		
		Users user = usersMapper.selectByPrimaryKey(hUserIdLong);
		if(user==null){
			return null;
		}
		suInfo.setUser(user);
		
		FriendsExample fExample = new FriendsExample();
		com.umi.pojo.FriendsExample.Criteria fOr = fExample.or();
		fOr.andAttenduseridEqualTo(iUserId);
		fOr.andBeattenduseridEqualTo(hUserIdLong);
		List<Friends> fList = friendsMapper.selectByExample(fExample );
		if(fList!=null&&fList.size()>0){
			suInfo.setIsAtten(1);
		}
		
		PostExample pExample = new PostExample();
		com.umi.pojo.PostExample.Criteria pOr = pExample.or();
		pOr.andUseridEqualTo(hUserIdLong);
		List<PostWithBLOBs> pList = postMapper.selectByExampleWithBLOBs(pExample);
		suInfo.setPostList(pList);
		suInfo.setPostListSize(pList.size());
		
		return suInfo;
	}

	@Override
	public boolean insNewFriend(long iUserId, String hUserId) {
		if(testString(hUserId)){
			return false;
		}
		
		long hUserIdLong = 0;
		try{
			hUserIdLong = Long.parseLong(hUserId);
		}catch(Exception e){
			return false;
		}
		
		Friends record = new Friends();
		record.setAttenduserid(iUserId);
		record.setBeattenduserid(hUserIdLong);
		int i = friendsMapper.insertSelective(record );
		if(i>0){
			log.info("用户:"+iUserId+"关注了用户:"+hUserId);
			return true;
		}
		return false;
	}

	@Override
	public boolean delFriend(long iUserId, String hUserId) {
		if(testString(hUserId)){
			return false;
		}
		
		long hUserIdLong = 0;
		try{
			hUserIdLong = Long.parseLong(hUserId);
		}catch(Exception e){
			return false;
		}
		
		FriendsExample example = new FriendsExample();
		com.umi.pojo.FriendsExample.Criteria or = example.or();
		or.andAttenduseridEqualTo(iUserId);
		or.andBeattenduseridEqualTo(hUserIdLong);
		int i = friendsMapper.deleteByExample(example );
		if(i>0){
			log.info("用户:"+iUserId+"取消关注了用户:"+hUserId);
			return true;
		}
		return false;
	}

	

}
