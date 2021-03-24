package com.umi.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.umi.pojo.CheckpostWithBLOBs;
import com.umi.service.AdminService;
import com.umi.service.PostService;
import com.umi.service.UserService;

@Controller
public class AdminController implements ApplicationListener<ContextRefreshedEvent>{
	
	@Resource
	private PostService postServiceImpl;
	@Resource
	private AdminService adminServiceImpl;
	@Resource
	private UserService userServiceImpl;
	
	private static boolean isAutoPassPost = true;
	private static int passPostGetPoint = 10;
	private static String notPassReason = "资源地址无法访问";
	private TimerTask timerTask = null;
	private Logger log = Logger.getLogger(AdminController.class);
	
	/**
	 * 控制板块自动通过检查
	 * @throws IOException 
	 */
	@RequestMapping("capp")
	@ResponseBody
	public void controlAutoPassPost(HttpServletResponse resp,String auto) throws IOException{
		if(!testString(auto)){
			if(auto.equals("true")){
				isAutoPassPost = true;
			}else if(auto.equals("false")){
				isAutoPassPost = false;
			}
		}
		resp.getWriter().write("true");
	}
	/**
	 * 板块自动通过审核
	 */
	
	private void autoPassPost(){
		
		if(timerTask==null){
			//定时任务
			timerTask = new TimerTask() {
				@Override
				public void run() {
					if(!isAutoPassPost){
						return;
					}
					List<CheckpostWithBLOBs> selAllCheckPost = postServiceImpl.selAllCheckPost();
					for (CheckpostWithBLOBs checkpostWithBLOBs : selAllCheckPost) {
						//检测资源地址是否可访问
						HttpURLConnection conn = null;
						try {
							URL url = new URL(checkpostWithBLOBs.getResourceaddr());
							conn = (HttpURLConnection) url.openConnection();
							conn.setRequestMethod("GET");
							conn.setReadTimeout(15*1000);
							conn.connect();
							
							if(conn.getResponseCode() == 200){
								adminServiceImpl.updCheckPost(checkpostWithBLOBs.getPostid(), AdminService.POST_PASS, new Long(1), null,passPostGetPoint);
							}
						} catch (MalformedURLException e) {
							log.error("AdminController.autoPassPost().new TimerTask() {...}.run()"+e.getMessage());
						} catch (IOException e) {
							log.error("AdminController.autoPassPost().new TimerTask() {...}.run()"+e.getMessage());
						}
						adminServiceImpl.updCheckPost(checkpostWithBLOBs.getPostid(), AdminService.POST_NOT_PASS, new Long(1), notPassReason,passPostGetPoint);
					}
				}
			};
			Timer timer = new Timer();
			// 定义开始等待时间  --- 等待 5 秒
			long delay = 5*60*1000;
			// 定义每次执行的间隔时间
			long intevalPeriod = 5*60*1000;
			timer.scheduleAtFixedRate(timerTask, delay, intevalPeriod);
		}
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
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		autoPassPost();
	}
}
