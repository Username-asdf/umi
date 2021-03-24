package com.umi.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.umi.pojo.ShowPost;
import com.umi.pojo.Users;
import com.umi.service.ShowPostService;

@Controller
public class ShowPostController {

	@Resource
	private ShowPostService showPostServiceImpl;
	@Value("${postc.commSize:10}")
	private int commSize;
	/**
	 * 根据postId展示板块
	 * @param req
	 * @param postId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("showPost")
	public String showPost(HttpServletRequest req,HttpSession session,HttpServletResponse resp,
			String postId,String pageNum) throws IOException{
		if(testString(postId)){
			return "redirect:/index";
		}
		long postLong = 0;
		int pageNumLong = 1;
		try{
			postLong = Long.parseLong(postId);
			pageNumLong = Integer.parseInt(pageNum);
		}catch(Exception e){
			
		}
		ShowPost showPost = null;
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			showPost = showPostServiceImpl.selShowPostAllInfo(postLong,0,pageNumLong,commSize,"likeNum desc");
		}else{
			showPost = showPostServiceImpl.selShowPostAllInfo(postLong,((Users)userObj).getUserid(),pageNumLong,commSize,"likeNum desc");
		}
		if(showPost==null){
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("没有找到板块！");
			return null;
		}
		//设置login跳转
		session.setAttribute("redirect", req.getServletPath()+"?"+req.getQueryString());
		
		//增加板块浏览量
		showPostServiceImpl.updBrowerNum(postLong);
		
		req.setAttribute("showPost", showPost);
		return "/showPost.jsp";
	}
	/**
	 * 增加评论
	 * @param session
	 * @param fkCommId
	 * @param comm
	 * @throws IOException 
	 */
	@RequestMapping("comment")
	@ResponseBody
	public void insNewComm(HttpServletResponse resp,HttpSession session,String postId,String fkCommId,String comm) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return;
		}
		Users user = (Users) userObj;
		
		boolean b = showPostServiceImpl.insComm(user.getUserid(), postId, fkCommId, comm);
		if(b){
			resp.getWriter().write("true");
		}else{
			resp.getWriter().write("false");
		}
		return;
	}
	/**
	 * 修改评论likeNum
	 * @param type 0 取消赞 1增加赞
	 * @param commId
	 * @throws IOException 
	 */
	@RequestMapping("uclNum")
	@ResponseBody
	public void updLikeNum(HttpServletResponse resp,HttpSession session,String type,String commId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("noLogin");
			return ;
		}
		Users user = (Users) userObj;
		boolean updCommLikeNum = showPostServiceImpl.updCommLikeNum(user.getUserid(), commId, type);
		if(updCommLikeNum){
			resp.getWriter().write("true");
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	/**
	 * 修改评论hateNum
	 * @param type 0 取消赞 1增加赞
	 * @param commId
	 * @throws IOException 
	 */
	@RequestMapping("uchNum")
	@ResponseBody
	public void updHateNum(HttpServletResponse resp,HttpSession session,String type,String commId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("noLogin");
			return ;
		}
		Users user = (Users) userObj;
		boolean updCommLikeNum = showPostServiceImpl.updCommHateNum(user.getUserid(), commId, type);
		if(updCommLikeNum){
			resp.getWriter().write("true");
			return;
		}
		resp.getWriter().write("false");
		return; 
	}  
	/**
	 * 用户举报评论
	 * @param session
	 * @param commId
	 * @throws IOException 
	 */
	@RequestMapping("commReport")
	@ResponseBody
	public void addCommReport(HttpServletResponse resp,HttpSession session,String commId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return ;
		}
		Users user = (Users) userObj;
		
		boolean ucr = showPostServiceImpl.updCommReportNum(user.getUserid(), commId, "");
		if(ucr){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 获取资源地址
	 * 积分足够减去积分，跳转到资源地址
	 * 积分不够提示积分不够
	 * @param resp
	 * @param session
	 * @param postId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("resourceAddr")
	public String getResourceAddr(HttpServletResponse resp, HttpSession session,
			HttpServletRequest req,String postId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/login";
		}
		Users user = (Users) userObj;
		String result = showPostServiceImpl.selResourceAdrr(user.getUserid(), postId);
		if(result==null){
			req.setAttribute("info", "result == null--未知错误");
			return "other.jsp";//其他页面--未知错误
		}else if(result.equals("not")){
			req.setAttribute("info", "积分不够");
			return "other.jsp";//其他页面--积分不够
		}else{
			resp.sendRedirect(result);
			return null;
		}
	}
	/**
	 * 查看更多评论
	 * 数据以json传输
	 * @param resp
	 * @param pageNum
	 * @throws IOException 
	 */
	@RequestMapping("smComm")
	@ResponseBody
	public void showMoreComment(HttpServletResponse resp,HttpSession session,
			String postId,String pageNum) throws IOException{
		
		if(testString(postId)){
			resp.getWriter().write("false");
			return ;
		}
		int pageNumInt = 0;
		if(!testString(pageNum)){
			try{
				pageNumInt = Integer.parseInt(pageNum);
			}catch(Exception e){
				
			}
		}
		
		long postIdLong = 0;
		try{
			postIdLong = Long.parseLong(postId);
		}catch(Exception e){
			resp.getWriter().write("false");
			return ;
		}
		
		ShowPost showPost = null;
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			showPost = showPostServiceImpl.selShowPostAllInfo(postIdLong, 0, pageNumInt, commSize, "likeNum desc");
		}else{
			Users user = (Users) userObj;
			showPost = showPostServiceImpl.selShowPostAllInfo(postIdLong, user.getUserid(), pageNumInt, commSize, "likeNum desc");
		}
		if(showPost!=null){
			resp.setContentType("application/json; charset=utf-8");
			resp.getWriter().write(new Gson().toJson(showPost));//将数据以json格式输出
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	/**
	 * 增加或减少板块赞数
	 * @param session
	 * @param resp
	 * @param postId
	 * @param type
	 * @throws IOException 
	 */
	@RequestMapping("uplNum")
	@ResponseBody
	public void updPostLikeNum(HttpSession session, HttpServletResponse resp,String postId,String type) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("noLogin");
			return ;
		}
		Users user = (Users) userObj;
		boolean updCommLikeNum = showPostServiceImpl.updPostLikeNum(user.getUserid(), postId, type);
		if(updCommLikeNum){
			resp.getWriter().write("true");
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	/**
	 * 增加或减少板块踩数
	 * @param session
	 * @param resp
	 * @param postId
	 * @param type
	 * @throws IOException 
	 */
	@RequestMapping("uphNum")
	@ResponseBody
	public void updPostHateNum(HttpSession session, HttpServletResponse resp,String postId,String type) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("noLogin");
			return ;
		}
		Users user = (Users) userObj;
		boolean updCommLikeNum = showPostServiceImpl.updPostHateNum(user.getUserid(), postId, type);
		if(updCommLikeNum){
			resp.getWriter().write("true");
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	/**
	 * 增加用户板块举报
	 * @param resp
	 * @param session
	 * @param postId
	 * @throws IOException 
	 */
	@RequestMapping("postReport")
	@ResponseBody
	public void addPostReport(HttpServletResponse resp,HttpSession session,String postId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return ;
		}
		Users user = (Users) userObj;
		
		boolean ucr = showPostServiceImpl.insNewPostReport(user.getUserid(), postId, "");
		if(ucr){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 用户删除评论
	 * @param session
	 * @param resp
	 * @param commId
	 * @throws IOException
	 */
	@RequestMapping("delComm")
	@ResponseBody
	public void delComm(HttpSession session,HttpServletResponse resp,String commId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("noLogin");
			return ;
		}
		
		Users user = (Users) userObj;
		
		long commIdLong = 0;
		if(testString(commId)){
			resp.getWriter().write("false");
			return ;
		}else{
			try{
				commIdLong = Long.parseLong(commId);
			}catch(Exception e){
				resp.getWriter().write("false");
				return ;
			}
		}
		
		boolean delComment = showPostServiceImpl.delComment(commIdLong, user.getUserid());
		if(delComment){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
		
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
}
