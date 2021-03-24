package com.umi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.umi.pojo.CheckpostWithBLOBs;
import com.umi.pojo.NotpasspostWithBLOBs;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.ShowUserInfo;
import com.umi.pojo.Users;
import com.umi.service.AdminService;
import com.umi.service.OtherService;
import com.umi.service.PostService;
import com.umi.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	@Resource
	private OtherService otherServiceImpl;
	@Resource
	private PostService postServiceImpl;
	@Resource
	private AdminService adminServiceImpl;
	@Value("${userc.headIconPath:D:/images/}")
	private String USERS_ICON_PATH;
	
	/**
	 * 用户完善信息控制器
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("updInfo")
	public String updOtherInfo(HttpSession session,HttpServletRequest req,
			MultipartFile icon,HttpServletResponse resp,
			String intro,String sex,String mail) throws IOException{
		Users userSession = (Users) session.getAttribute("user");
		Users user = new Users();
		if(!icon.isEmpty()){
			String filename = icon.getOriginalFilename();
			String suffix = filename.substring(filename.lastIndexOf("."));
			
			//检测文件类型是否正确
			String uploadName = ".jpg,.jpeg,.png,.bmp";
			if(!uploadName.contains(suffix)){
				resp.setContentType("text/html;charset=utf-8");
				resp.getWriter().write("文件类型不正确，只能上传jpg,jpeg,png,bmp格式的图片！");
				return null;
			}
			
			String uuid = UUID.randomUUID().toString();
			String path = USERS_ICON_PATH+uuid+suffix;
			FileUtils.copyInputStreamToFile(icon.getInputStream(), new File(path));
			user.setUsericon(uuid+suffix);
		}else{
			user.setUsericon(userSession.getUsericon());
		}
		if(intro!=null&&!intro.equals("")){
			user.setIntro(intro);
		}else{
			user.setIntro(userSession.getIntro());
		}
		if(mail!=null&&!mail.equals("")){
			user.setMail(mail);
		}else{
			user.setMail(userSession.getMail());
		}
		if(sex!=null&&sex.equals("1")){
			user.setUsersex("男");
		}else if(sex!=null&&sex.equals("0")){
			user.setUsersex("女");
		}else{
			user.setUsersex(userSession.getUsersex());
		}
		user.setFreepoint(userSession.getFreepoint());
		user.setUserid(userSession.getUserid());
		int i = userServiceImpl.updOtherInfo(user);
		if(i>0){
			Users selByPhoneNum = userServiceImpl.selByPhoneNum(userSession.getPhonenum());
			session.setAttribute("user", selByPhoneNum);
			req.setAttribute("info", "修改成功！");
		}else{
			req.setAttribute("info", "修改失败，请稍后再试！");
		}
		return "urUpdInfo.jsp";
	}
	/**
	 * 显示用户中心控制器
	 * @return
	 */
	@RequestMapping("userCenter")
	public String userCenter(HttpServletRequest req,HttpSession session){
		Object user = session.getAttribute("user");
		if(user==null){
			req.setAttribute("info", "请先登录");
			return "redirect:login";
		}
		//设置login跳转
		session.setAttribute("redirect", req.getServletPath()+"?"+req.getQueryString());
		
		return "userCenter.jsp";
	}
	/**
	 * 导航栏控制器
	 * @return
	 */
	@RequestMapping("top")
	public String top(){
		return "top.jsp";
	}
	/**
	 * 用户中心左侧导航栏控制器
	 * @return
	 */
	@RequestMapping("userCenterLeft")
	public String userCenterLeft(){
		return "userCenterLeft.jsp";
	}
	@RequestMapping("userCenterRight/{name}")
	public String userCenterRight(@PathVariable String name,HttpServletRequest req,
			HttpSession session,String title,String reqId){
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/login";
		}
		String retValue = "";
		switch(name){
			case "urShowInfo":
				retValue = "/urShowInfo.jsp";
//				urShowInfo(session);
				break;
			case "urUpdInfo":
				retValue = "/urUpdInfo.jsp";
				break;
			case "urUpdPwd":
				retValue = "/urUpdPwd.jsp";
				break;
			case "urAttention":
				urAttention(session);
				retValue = "/urAttention.jsp";
				break;
			case "urPassPost":
				selPassPost(session);
				retValue = "/urPassPost.jsp";
				break;
			case "urSendPost":
				req.setAttribute("title", title);
				req.setAttribute("reqId", reqId);
				retValue = "/insNewPost.jsp";
				break;
			case "urCheckPost":
				selCheckPost(session);
				retValue = "/urCheckPost.jsp";
				break;
			case "urNotPassPost":
				selNotPassPost(session);
				retValue = "/urNotPassPost.jsp";
				break;
			default:
				
		}
		return retValue;
	}
	
	
	/**
	 * 获取用户头像
	 * @param icon
	 * @throws IOException 
	 */
	@RequestMapping("icon/{icon}.{suffix}")
	@ResponseBody
	public void getUserIcon(@PathVariable String icon,
			@PathVariable String suffix,
			HttpServletResponse resp) throws IOException{
		ServletOutputStream os = resp.getOutputStream();
		FileUtils.copyFile(new File(USERS_ICON_PATH+icon+"."+suffix), os);
		
	}
	/**
	 * 用户查看其他用户信息
	 * @return
	 */
	@RequestMapping("suInfo")
	public String showUserInfo(HttpSession session,HttpServletRequest req,String userId){
		Object userObj = session.getAttribute("user");
		ShowUserInfo selOtherUsers = null;
		if(userObj==null){
			selOtherUsers = userServiceImpl.selOtherUsers(0, userId);
		}else{
			Users user = (Users) userObj;
			selOtherUsers = userServiceImpl.selOtherUsers(user.getUserid(), userId);
		}
		req.setAttribute("suInfo", selOtherUsers);
		return "/showUserInfo.jsp";
	}
	/**
	 * 用户新增关注
	 * @param resp
	 * @param session
	 * @param userId
	 * @throws IOException 
	 */
	@RequestMapping("aatten")
	@ResponseBody
	public void addAttention(HttpServletResponse resp,HttpSession session,String userId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return ;
		}
		Users user = (Users) userObj;
		boolean inf = userServiceImpl.insNewFriend(user.getUserid(), userId);
		if(inf){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 用户取消关注
	 * @param resp
	 * @param session
	 * @param userId
	 * @throws IOException 
	 */
	@RequestMapping("catten")
	@ResponseBody
	public void cancelAttention(HttpServletResponse resp,HttpSession session,String userId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return ;
		}
		Users user = (Users) userObj;
		boolean df = userServiceImpl.delFriend(user.getUserid(), userId);
		if(df){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 查询用户关注信息并将信息放入
	 * session.urAttention
	 * @param session
	 */
	private void urAttention(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Users> listUsers = userServiceImpl.selFriendsByUsersId(user.getUserid());
		session.setAttribute("urAttention", listUsers);
	}
	
	/**
	 * 查询正在审核中的板块
	 * 并将信息放入
	 * session.checkPostList
	 * @param session
	 */
	private void selCheckPost(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		List<CheckpostWithBLOBs> checkPostList = postServiceImpl.selCheckPostByUserId(user.getUserid());
		session.setAttribute("checkPostList", checkPostList);
	}
	/**
	 * 查询通过审核中的板块
	 * 并将信息放入
	 * session.passPostList
	 * @param session
	 */
	private void selPassPost(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		List<PostWithBLOBs> passPostList = postServiceImpl.selPassPostByUserId(user.getUserid());
		session.setAttribute("passPostList", passPostList);
	}
	/**
	 * 查询通过未审核中的板块
	 * 并将信息放入
	 * session.notPassPostList
	 * @param session
	 */
	private void selNotPassPost(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		List<NotpasspostWithBLOBs> notPassPostList = postServiceImpl.selNotPassPostByUserId(user.getUserid());
		session.setAttribute("notPassPostList", notPassPostList);
	}
	
}
