package com.umi.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface OtherService {
	
	int PHONE_VALID_NUM = 6;
	String VAILD_NUMBER = "number";
	String VAILD_ALPH = "alph";
	String VAILD_MIX = "mix";
	/**
	 * 生成验证码
	 * 将验证码以流的方式输出
	 * 并将验证码信息放入session code中
	 * @param session
	 * @param resp
	 */
	public void getVaildCode(HttpSession session,HttpServletResponse resp);
	/**
	 * 获取手机验证码
	 * @param phoneNum
	 */
	public boolean getPhoneVaildCode(String smsMode,String phoneNum,HttpSession session);
}
