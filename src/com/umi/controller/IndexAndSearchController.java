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

import com.umi.pojo.PageInfo;
import com.umi.pojo.Sign;
import com.umi.pojo.Users;
import com.umi.service.IndexAndSearchService;

@Controller
public class IndexAndSearchController {

	@Resource
	private IndexAndSearchService indexAndSearchServiceImpl;
	@Value("${userc.SIGN_POST_POINT:1}")
	private int SIGN_POST_POINT;
	@Value("${postc.postListPageSize:10}")
	private int postListPageSize;
	/**
	 * 首页控制器
	 * 
	 * @return
	 */
	@RequestMapping({"/index","/"})
	public String index() {

		return "index.jsp";
	}
	/**
	 * 底部控制器
	 * @return
	 */
	@RequestMapping("bottom")
	public String bottom(){
		
		return "bottom.jsp";
	}
	/**
	 * 签到控制器
	 * 
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("sign")
	@ResponseBody
	public void sign(HttpSession session, HttpServletResponse resp) throws IOException {
		Object userObj = session.getAttribute("user");
		if (userObj == null) {
			return;
		}
		Users user = (Users) userObj;
		boolean checkSign = checkSign(session, user.getUserid());
		if (checkSign) {
			resp.getWriter().write("false");
			return;
		}
		int insNewSign = indexAndSearchServiceImpl.insNewSign(user.getUserid());
		boolean b = addFreepoint(user.getUserid(), SIGN_POST_POINT);
		if (insNewSign > 0 && b) {
			resp.getWriter().write("true");
			checkSign(session, user.getUserid());
			return;
		}
		resp.getWriter().write("false");
		return;
	}
	
	/**
	 * 根据条件查找板块
	 * @param req
	 * @param condition
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("search")
	public String searchPassPost(HttpSession session,HttpServletRequest req,String condition,
			String pageNum){
		//允许用户直接空串搜索
//		if(testString(condition)){
//			req.setAttribute("info", "什么也没有找到，换个关键字试试~");
//			return "/showList.jsp";
//		}
		if(condition==null){
			condition = "";
		}else{
			//字符串脱空格
			condition = condition.trim();
		}
		
		req.setAttribute("condition", condition);
		int pageNumInt = 1;
		if(!testString(pageNum)){
			try{
				pageNumInt = Integer.parseInt(pageNum);
			}catch(Exception e){
				return "redirect:/index";
			}
		}
		PageInfo pageInfo = indexAndSearchServiceImpl.selAllPostByTitle(condition,pageNumInt,postListPageSize);
		if(pageInfo!=null&&pageInfo.getTotal()>0){
			req.setAttribute("pageInfo", pageInfo);
		}else{
			req.setAttribute("info", "什么也没有找到，换个关键字试试~");
		}
		//设置login跳转
		session.setAttribute("redirect", req.getServletPath()+"?"+req.getQueryString());
		
		return "/showList.jsp";
	}
	/**
	 * 查询该用户今天是否签到
	 * 并把查询到的信息放入
	 * session.sign
	 * @param session
	 * @param userId
	 */
	private boolean checkSign(HttpSession session,long userId){
		Sign sign = indexAndSearchServiceImpl.selSignByUserId(userId);
		if(sign!=null){
			session.setAttribute("sign", sign);
			return true;
		}
		return false;
	}
	/**
	 * 修改用户积分-增加
	 * @param userId
	 * @param point
	 * @return
	 */
	private boolean addFreepoint(long userId,int point){
		int i = indexAndSearchServiceImpl.updFreepoint(userId, point);
		if(i>0){
			return true;
		}
		return false;
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
