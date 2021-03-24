package com.umi.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.umi.mapper.PostMapper;
import com.umi.mapper.SignMapper;
import com.umi.mapper.UsersMapper;
import com.umi.pojo.PageInfo;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.Sign;
import com.umi.pojo.SignExample;
import com.umi.pojo.Users;
import com.umi.service.IndexAndSearchService;

@Service
public class IndexAndSearchServiceImpl implements IndexAndSearchService{
	@Resource
	private SignMapper signMapper;
	@Resource
	private PostMapper postMapper;
	@Resource
	private UsersMapper usersMapper;
	private Logger log = Logger.getLogger(IndexAndSearchServiceImpl.class);
	@Override
	public int insNewSign(long userId) {
		Sign sign = new Sign();
		sign.setTime(new Date(System.currentTimeMillis()));
		sign.setUsersid(userId);
		int i = signMapper.insertSelective(sign);
		if(i>0){
			log.info("用户:"+userId+"签到成功");
		}else{
			log.error("用户:"+userId+"签到失败");
		}
		return i;
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
	public PageInfo selAllPostByTitle(String condition, int pageNum, int pageSize) {
		long count = postMapper.selPostCountLikeTitle(condition);
		if(count<=0){
			return null;
		}
		int start = (pageNum-1)*pageSize;
		List<PostWithBLOBs> selPostLikeTitle = postMapper.selPostLikeTitle(condition, start, pageSize);
		if(selPostLikeTitle==null||selPostLikeTitle.size()<=0){
			return null;
		}
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCurrent(pageNum);
		pageInfo.setTotal((long) Math.ceil(count/((double)pageSize)));
		pageInfo.setList(selPostLikeTitle);
		pageInfo.setTotalNum(count);
		
		return pageInfo;
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
}
