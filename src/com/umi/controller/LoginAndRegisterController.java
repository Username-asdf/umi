package com.umi.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.umi.pojo.Sign;
import com.umi.pojo.Users;
import com.umi.service.LoginAndRegisterService;
import com.umi.service.OtherService;

@Controller
public class LoginAndRegisterController {
	
	@Resource
	private LoginAndRegisterService loginAndRegisterServiceImpl;
	@Resource
	private OtherService otherServiceImpl;
	
	private static int SESSION_TIME = 3600;
	
	@Value("${userc.REGISTER_SMS_MODE}")
	private String REGISTER_SMS_MODE;
	@Value("${userc.FIND_PWD_SMS_MODE}")
	private String FIND_PWD_SMS_MODE;
	@Value("${userc.PHONE_VALID_TIME}")
	private int PHONE_VALID_TIME;
	
	private Logger log = Logger.getLogger(LoginAndRegisterController.class);
	

	/**
	 * 用户登录控制器
	 * 
	 * @param session
	 * @param phoneNum
	 * @param pwd
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpSession session, HttpServletRequest req, HttpServletResponse resp, String phoneNum,
			String pwd, String validCode) {
		if (testString(phoneNum) || testString(pwd) || testString(validCode)) {
			return "login.jsp";
		}
		// 字符串脱空格
		phoneNum = phoneNum.trim();
		pwd = pwd.trim();
		validCode = validCode.trim();

		if (validCode.equals(session.getAttribute("code"))) {
			Users user = loginAndRegisterServiceImpl.selByPhoneNumAndPwd(phoneNum, pwd);
			if (user != null) {
				log.info("登录成功  " + user);
				session.setAttribute("user", user);
				// 设置session时长
				session.setMaxInactiveInterval(SESSION_TIME);
				Cookie cookie = new Cookie("JSESSIONID", session.getId());
				cookie.setMaxAge(SESSION_TIME);
				resp.addCookie(cookie);

				checkSign(session, user.getUserid());
				// 登陆后跳转到响应的界面
				if (session.getAttribute("redirect") != null) {
					String redir = (String) session.getAttribute("redirect");
					session.removeAttribute("redirect");
					return "redirect:" + redir;
				}
				return "redirect:index";
			}
		} else {
			req.setAttribute("info", "验证码错误");
			//
			req.setAttribute("user_phoneNum", phoneNum);
			req.setAttribute("user_pwd", pwd);

			return "login.jsp";
		}

		req.setAttribute("info", "手机号或密码错误");
		//
		req.setAttribute("user_phoneNum", phoneNum);
		req.setAttribute("user_pwd", pwd);

		log.info(phoneNum + "登录失败");
		return "login.jsp";

	}

	

	/**
	 * 用户退出登陆
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/index";
	}

	/**
	 * 用户注册控制器
	 * 
	 * @param phoneNum
	 * @param username
	 * @param pwd
	 * @return
	 */
	@RequestMapping("register")
	public String register(HttpServletRequest req, HttpSession session, String phoneNum, String username, String pwd,
			String phoneValid) {

		if (testString(phoneNum) || testString(username) || testString(pwd) || testString(phoneValid)) {
			return "register.jsp";
		}
		if (loginAndRegisterServiceImpl.selByPhoneNum(phoneNum) != null) {
			req.setAttribute("info", "该手机号码已被注册");
			return "register.jsp";
		}
		long sendTime = (long) (session.getAttribute("sendTime")!=null?session.getAttribute("sendTime"):new Long(0));
		
		System.out.println("sendTime:"+sendTime);
		System.out.println("PHONE_VALID_TIME:"+PHONE_VALID_TIME);
		
		if (System.currentTimeMillis() - sendTime > PHONE_VALID_TIME) {
			req.setAttribute("info", "验证码已过期");
			return "register.jsp";
		}

		if (phoneValid.equals(session.getAttribute("phoneValid"))) {
			int i = loginAndRegisterServiceImpl.insUser(phoneNum, username, pwd);
			if (i > 0) {
				log.info(phoneNum + "注册成功");
				req.setAttribute("info", "注册成功");
				return "register.jsp";
			}
		} else {
			req.setAttribute("info", "验证码错误");
			return "register.jsp";
		}
		log.info(phoneNum + " 注册失败");
		req.setAttribute("info", "注册失败，请稍后再试");
		return "register.jsp";
	}

	/**
	 * 用户修改密码控制器
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("updPwd")
	public void updPwd(HttpServletResponse resp, HttpSession session, String pwd, String newPwd) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		if (testString(pwd) || testString(newPwd)) {
			resp.getWriter().write("false");
			return;
		}
		Object userObj = session.getAttribute("user");
		if (userObj == null) {
			resp.getWriter().write("false");
			return;
		}
		Users user = (Users) userObj;
		if (pwd.equals(user.getPassword())) {
			loginAndRegisterServiceImpl.updPwd(user.getPhonenum(), newPwd);
			resp.getWriter().write("true");
			session.removeAttribute("user");
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	
	/**
	 * 获取验证码控制器
	 * @param resp
	 * @param session
	 */
	@RequestMapping("valid")
	@ResponseBody
	public void validCode(HttpServletResponse resp,HttpSession session){
		otherServiceImpl.getVaildCode(session, resp);
	}
	/**
	 * 获取手机验证码
	 * @param session
	 * @param phoneNum
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("phoneValid")
	@ResponseBody
	public void phoneVaildCode(HttpServletResponse resp,HttpSession session,
			String phoneNum,String smsType) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		if(testString(phoneNum)){
			resp.getWriter().write("手机号不能为空");
			return;
		}
		boolean b = false;
		if(smsType.equals("mode_register")){
			b = otherServiceImpl.getPhoneVaildCode(REGISTER_SMS_MODE,phoneNum,session);
		}else if(smsType.equals("mode_findPwd")){
			b = otherServiceImpl.getPhoneVaildCode(FIND_PWD_SMS_MODE,phoneNum,session);
		}
		if(b){
			session.setAttribute("sendTime", System.currentTimeMillis());
			resp.getWriter().write("true");
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	/**
	 * 检测手机号是否被注册
	 * @param resp
	 * @param phoneNum
	 * @throws IOException
	 */
	@RequestMapping("testPhone")
	@ResponseBody
	public void testPhoneExist(HttpServletResponse resp,String phoneNum) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		if(loginAndRegisterServiceImpl.selByPhoneNum(phoneNum)!=null){
			resp.getWriter().write("true");
			return;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 查询用户名是否被注册
	 * @param resp
	 * @param username
	 * @throws IOException
	 */
	@RequestMapping("testun")
	@ResponseBody
	public void testUsername(HttpServletResponse resp,String username) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		if(loginAndRegisterServiceImpl.selByUsername(username)){
			resp.getWriter().write("true");//查询到用户
			return;
		}
		resp.getWriter().write("false");//未查询到用户
		return ;
	}
	/**
	 * 找回密码，手机验证码检测
	 * @param req
	 * @param phoneNum
	 * @param phoneValid
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("findPwd")
	@ResponseBody
	public void findPwd(HttpSession session,HttpServletRequest req,HttpServletResponse resp,
			String phoneNum,String phoneValid) throws IOException{
		if(testString(phoneNum)||testString(phoneValid)){
			resp.getWriter().write("false");
			return ;
		}
		long sendTime = (long) session.getAttribute("sendTime");
		if(System.currentTimeMillis()-sendTime > PHONE_VALID_TIME){
			
			resp.getWriter().write("invaild");//过期
			return ;
		}
		
		if(phoneValid.equals(session.getAttribute("phoneValid"))){
			session.setAttribute("phoneNum", phoneNum);
			resp.getWriter().write("true");
			return ;
		}else{
			resp.getWriter().write("false");
			return ;
		}
	}
	/**
	 * 修改密码
	 * 方法描述：
	 * @param resp
	 * @param session
	 * @param newPwd
	 * @throws IOException
	 */
	@RequestMapping("findUpdPwd")
	@ResponseBody
	public void findUpdPwd(HttpServletResponse resp,HttpSession session,String newPwd) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		Object phone = session.getAttribute("phoneNum");
		
		if(phone==null||testString(newPwd)){
			resp.getWriter().write("false");
			return ;
		}
		String phoneNum = (String) phone;
		session.removeAttribute("phoneNum");
		int i = loginAndRegisterServiceImpl.updPwd(phoneNum, newPwd);
		if(i>0){
			resp.getWriter().write("true");
		}else{
			resp.getWriter().write("false");
		}
		return;
	}
	
	/**
	 * 检测字符串是否为null或为空串
	 * 如果为空串或null返回true
	 * @param str
	 * @return
	 */
	private boolean testString(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
	/**
	 * 查询该用户今天是否签到
	 * 并把查询到的信息放入
	 * session.sign
	 * @param session
	 * @param userId
	 */
	private boolean checkSign(HttpSession session,long userId){
		Sign sign = loginAndRegisterServiceImpl.selSignByUserId(userId);
		if(sign!=null){
			session.setAttribute("sign", sign);
			return true;
		}
		return false;
	}
}
