package com.umi.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.umi.mapper.SignMapper;
import com.umi.mapper.UsersMapper;
import com.umi.pojo.Sign;
import com.umi.pojo.SignExample;
import com.umi.pojo.Users;
import com.umi.pojo.UsersExample;
import com.umi.pojo.UsersExample.Criteria;
import com.umi.service.LoginAndRegisterService;

@Service
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService{
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private SignMapper signMapper;
	private Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public Users selByPhoneNumAndPwd(String phoneNum, String pwd){
		UsersExample example = new UsersExample();
		Criteria or = example.or();
		or.andPhonenumEqualTo(phoneNum);
		or.andPasswordEqualTo(pwd);
		List<Users> list = usersMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
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
	public int updPwd(String phoneNum, String newPwd) {
		UsersExample example = new UsersExample();
		Criteria or = example.or();
		or.andPhonenumEqualTo(phoneNum);
		Users record = new Users();
		record.setPassword(newPwd);
		int i = usersMapper.updateByExampleSelective(record, example);
		if(i>0){
			log.info("手机号:"+phoneNum+"-更新密码成功");
		}else{
			log.error("手机号:"+phoneNum+"-更新密码失败");
		}
		return i;
	}
	@Override
	public boolean selByUsername(String username) {
		if(testString(username)){
			return false;
		}
		UsersExample example = new UsersExample();
		Criteria or = example.or();
		or.andUsernameEqualTo(username);
		long count = usersMapper.countByExample(example);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public Sign selSignByUserId(long userId) {
		SignExample example = new SignExample();
		com.umi.pojo.SignExample.Criteria or = example.or();
		or.andUsersidEqualTo(userId);
		Date date = new Date();
		
		
		or.andTimeBetween(new Date(date.getYear(),date.getMonth(),date.getDate()), 
				new Date(date.getYear(),date.getMonth(),date.getDate()+1));
		List<Sign> list = signMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public int insUser(String phoneNum, String username, String pwd) {
		Users users = new Users();
		users.setPhonenum(phoneNum);
		users.setUsername(username);
		users.setPassword(pwd);
		users.setFreepoint(0);
		users.setIntro("这个人很懒，什么都没有留下~");
		users.setMail("邮箱还未填写");
		users.setExp(new Long(0));
		users.setRegdate(new Date());
		users.setUsericon("icon.jpg");
		users.setUsersex("男");
		users.setPaypoint(0);
		int i = usersMapper.insert(users);
		if(i>0){
			log.info("新增用户成功:phoneNum"+phoneNum+",username"+username);
		}else{
			log.error("新增用户失败:phoneNum"+phoneNum+",username"+username);
		}
		return i;
	}
	private boolean testString(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
}
