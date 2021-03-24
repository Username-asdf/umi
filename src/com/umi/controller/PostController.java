package com.umi.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
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

import com.alibaba.fastjson.JSONObject;
import com.umi.pojo.CheckpostWithBLOBs;
import com.umi.pojo.NotpasspostWithBLOBs;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.RequestWithBLOBs;
import com.umi.pojo.ShowPostRequest;
import com.umi.pojo.Users;
import com.umi.service.PostService;

@Controller
public class PostController {
	@Resource
	private PostService postServiceImpl;
	@Value("${postc.uploadPath:D:/upload/}")
	private String UPLOAD_PATH ;
	@Value("${postc.POST_POINT:1}")
	private int POST_POINT;
	@Value("${postc.POST_REQUSET_PAGE_SIZE:10}")
	private int POST_REQUSET_PAGE_SIZE;
	@Value("${postc.UPLOAD_FILE_MAX_SIZE:1000000}")
	private long UPLOAD_FILE_MAX_SIZE;
	
	/**
	 * 增加新板块控制器
	 * @param req
	 * @param title
	 * @param post
	 * @param addr
	 * @param hidden
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("insNewPost")
	public String insNewPost(HttpServletResponse resp,HttpSession session,
			String title,String post,String addr,String hidden,String reqId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/login";
		}
		if(testString(title)||testString(post)||testString(addr)){
			return "/insNewPost.jsp";
		}
		Users user = (Users) session.getAttribute("user");
		if(hidden!=null&&hidden.equals("")){
			hidden = null;
		}
		int i = postServiceImpl.insNewPost(title, post, addr, hidden, POST_POINT, user.getUserid(), reqId);
		if(i>0){
			resp.getWriter().write("true");
			return null;
		}
		resp.getWriter().write("false");
		return null;
	}
	/**
	 * 用户修改板块
	 * @param session
	 * @param resp
	 * @param title
	 * @param post
	 * @param addr
	 * @param hidden
	 * @param postType
	 * @param postId
	 * @throws IOException
	 */
	@RequestMapping("updPost")
	public String updAllPost(HttpSession session,HttpServletResponse resp,
			HttpServletRequest req,
			String title,String post,String addr,String hidden,
			String postType,String postId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return null;
		}
		if(hidden!=null&&hidden.equals("")){
			hidden = null;
		}
		if(testString(postType)||testString(postId)){
			resp.getWriter().write("false");
			return null;
		}
		long postLong = 0;
		try{
			postLong = Long.parseLong(postId);
		}catch(Exception e){
			resp.getWriter().write("false");
			return null;
		}
		if(testString(title)||testString(post)||testString(addr)){
			switch(postType){
				case "pass":
					PostWithBLOBs selPassPostByPostId = postServiceImpl.selPassPostByPostId(postLong);
					if(selPassPostByPostId==null){
						resp.getWriter().write("false");
						return null;
					}
					req.setAttribute("info", selPassPostByPostId);
					break;
				case "not":
					NotpasspostWithBLOBs selNotPassPostByPostId = postServiceImpl.selNotPassPostByPostId(postLong);
					if(selNotPassPostByPostId==null){
						resp.getWriter().write("false");
						return null;
					}
					req.setAttribute("info", selNotPassPostByPostId);
					break;
				case "check":
					CheckpostWithBLOBs selCheckPostByPostId = postServiceImpl.selCheckPostByPostId(postLong);
					if(selCheckPostByPostId==null){
						resp.getWriter().write("false");
						return null;
					}
					req.setAttribute("info", selCheckPostByPostId);
					break;
				default:
					resp.getWriter().write("false");
					return null;
			}
			req.setAttribute("postType", postType);
			req.setAttribute("postId", postId);
			return "/updPost.jsp";
		}
		Users user = (Users) userObj;
		
		switch(postType){
			case "pass":
				boolean updPassPost = postServiceImpl.updPassPost(postLong, user.getUserid(), title, 
						post, addr, hidden);
				if(updPassPost){
					resp.getWriter().write("true");
				}
				break;
			case "not":
				boolean updNotPassPost = postServiceImpl.updNotPassPost(postLong, user.getUserid(), title,
						post, addr, hidden);
				if(updNotPassPost){
					resp.getWriter().write("true");
				}
				break;
			case "check":
				boolean updCheckPost = postServiceImpl.updCheckPost(postLong, user.getUserid(), title,
						post, addr, hidden);
				if(updCheckPost){
					resp.getWriter().write("true");
				}
				break;
			default:
				resp.getWriter().write("false");
		}
		return null;
	}
	/**
	 * 用户删除板块
	 * @return
	 */
	@RequestMapping("delPost")
	public String delAllPost(HttpSession session,HttpServletRequest req,
			String postId,String postType){
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/login";
		}
		Users user = (Users) userObj;
		if(testString(postId)||testString(postType)){
			return null;
		}
		long postLong = 0;
		try{
			postLong = Long.parseLong(postId);
		}catch(Exception e){
			return null;
		}
		switch(postType){
		case "pass":
			boolean delPassPost = postServiceImpl.delPassPost(postLong, user.getUserid());
			if(delPassPost){
				return "redirect:/userCenterRight/urPassPost";
			}
			break;
		case "not":
			boolean delNotPassPost = postServiceImpl.delNotPassPost(postLong, user.getUserid());
			if(delNotPassPost){
				return "redirect:/userCenterRight/urNotPassPost";
			}
			break;
		case "check":
			boolean delCheckPost = postServiceImpl.delCheckPost(postLong, user.getUserid());
			if(delCheckPost){
				return "redirect:/userCenterRight/urCheckPost";
			}
			break;
		default:
	}
		return null;
	}
	
	/**
	 * 
	 * 方法描述：预览板块
	 * @param req
	 * @param session
	 * @param postId
	 * @return
	 */
	@RequestMapping("prePost")
	public String previewPost(HttpServletRequest req,HttpSession session,String postId){
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/login";
		}
		
		CheckpostWithBLOBs post = new CheckpostWithBLOBs();
		post.setPostname("标题");
		post.setDisplayinfo("正文");
		post.setResourceaddr("资源地址");
		post.setTime(new Date());
		post.setHiddeninfo("隐藏信息，评论后查看。");
		if(testString(postId)){
			req.setAttribute("prePost", post);
			return "/preview.jsp";
		}
		long postLong = 0;
		try{
			postLong = Long.parseLong(postId);
		}catch(Exception e){
			req.setAttribute("prePost", post);
			return "/preview.jsp";
		}
		CheckpostWithBLOBs selCheckPostByPostId = postServiceImpl.selCheckPostByPostId(postLong);
		if(selCheckPostByPostId!=null){
			req.setAttribute("prePost", selCheckPostByPostId);
			return "/preview.jsp";
		}
		req.setAttribute("prePost", post);
		return "/preview.jsp";
	}
	
	/**
	 * 用户求资源
	 * @throws IOException 
	 */
	@RequestMapping("areq")
	public void addPostRequset(HttpSession session,HttpServletResponse resp,String title) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("false");
			return ;
		}
		Users user = (Users) userObj;
		boolean insNewRequset = postServiceImpl.insNewRequset(user.getUserid(), title);
		if(insNewRequset){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 展示求资源信息
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("postReq")
	public String showPostRequest(HttpServletRequest req,String pageNum){
		ShowPostRequest spReq = postServiceImpl.selShowPostRequest(pageNum, POST_REQUSET_PAGE_SIZE);
		req.setAttribute("spReq", spReq);
		return "/showPostRequest.jsp"; 
	}
	/**
	 * 转到求资源页面
	 * @return
	 */
	@RequestMapping("apReq")
	public String addPostRequest(){
		
		return "/urPostRequest.jsp";
	}
	/**
	 * 用户查看自己发布的请资源信息
	 * @param session
	 * @param req
	 * @return
	 */
	@RequestMapping("smpReq")
	public String showMyPostReq(HttpSession session,HttpServletRequest req){
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/login.jsp";
		}
		
		Users user = (Users) userObj;
		
		List<RequestWithBLOBs> reqList = postServiceImpl.selMyPostReq(user.getUserid());
		
		req.setAttribute("reqList", reqList);
		req.setAttribute("listSize", reqList.size());
		return "/urShowMyPostReq.jsp";
	}
	
	@RequestMapping("delrp")
	public String delReqPost(HttpSession session,String reqId){
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return "redirect:/smpReq";
		}
		Users user = (Users) userObj;
		
		postServiceImpl.delReqPost(user.getUserid(), reqId);
		
		return "redirect:/smpReq";
	}
	
	/**
	 * 用户在板块主页删除板块
	 * @throws IOException 
	 */
	@RequestMapping("delPassPost")
	@ResponseBody
	public void delPassPost(HttpSession session,HttpServletResponse resp,String postId) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("noLogin");
			return ;
		}
		
		Users user = (Users) userObj;
		
		long postIdLong = 0;
		if(testString(postId)){
			resp.getWriter().write("false");
			return ;
		}else{
			try{
				postIdLong = Long.parseLong(postId);
			}catch(Exception e){
				resp.getWriter().write("false");
				return ;
			}
		}
		
		boolean delPassPost = postServiceImpl.delPassPost(postIdLong, user.getUserid());
		if(delPassPost){
			resp.getWriter().write("true");
			return ;
		}
		resp.getWriter().write("false");
		return ;
	}
	/**
	 * 用户发布板块上传图片
	 * @param file
	 * @throws IOException 
	 */
	@RequestMapping("upload")
	public void upload(MultipartFile imgFile,HttpSession session,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			JSONObject json = new JSONObject();
			json.put("error", 1);
			json.put("message", "请先登录！");
			resp.getWriter().write(json.toJSONString());
			return ;
		}
		
		if(imgFile.isEmpty()){
			resp.getWriter().write("请选择文件！");
			return ;
		}
		
		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,txt,zip,rar,gz,bz2");
		
		String dirName = req.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		
		String filename = imgFile.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf("."));
		
		if(!extMap.containsKey(dirName)){
			if(!extMap.get(dirName).contains(suffix)){
				resp.getWriter().write("文件类型不正确！");
				return;
			}
		}
		
		if(imgFile.getSize()>UPLOAD_FILE_MAX_SIZE){
			resp.getWriter().write("文件大小超过限制！大小必须小于1MB!");
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		String imgFileName = ymd+"-"+UUID.randomUUID().toString()+suffix;
		String imagFilePath = UPLOAD_PATH+((Users)(userObj)).getPhonenum()+"/"+imgFileName;
		
		FileUtils.copyInputStreamToFile(imgFile.getInputStream(), new File(imagFilePath));
		
		JSONObject json = new JSONObject();
		json.put("error", 0);
		json.put("url", "/umi/getUpload/"+imgFileName);
		resp.getWriter().write(json.toJSONString());
		return ;
	}
	/**
	 * 用户获取上传图片
	 * @param session
	 * @param resp
	 * @param imgFile
	 * @throws IOException
	 */
	@RequestMapping("getUpload/{imgFile}.{suffix}")
	@ResponseBody
	public void getUpload(HttpSession session,HttpServletResponse resp,
			@PathVariable String imgFile,@PathVariable String suffix) throws IOException{
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			return ;
		}
		
		resp.setContentType("image/jpeg");
		
		if(testString(imgFile)){
			return;
		}
		
		Users user = (Users) userObj;
		String path = UPLOAD_PATH+user.getPhonenum()+"/";
		
		FileUtils.copyFile(new File(path+imgFile+"."+suffix), resp.getOutputStream());
	}
	/**
	 * 展示用户上传的图片
	 * @param req
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("showUpload")
	public void showUpload(HttpServletRequest req,HttpSession session,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		
		Object userObj = session.getAttribute("user");
		if(userObj==null){
			resp.getWriter().write("请先登录！");
			return ;
		}
		
		//根目录路径，可以指定绝对路径，比如 /var/www/attached/
		String rootPath = UPLOAD_PATH + ((Users)userObj).getPhonenum()+"/";
		//根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/
		String rootUrl  = "/umi/getUpload/";
		//图片扩展名
		String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

//		String dirName = req.getParameter("dir");
//		if (dirName != null) {
//			if(!Arrays.<String>asList(new String[]{"image", "flash", "media", "file"}).contains(dirName)){
//				resp.getWriter().write("Invalid Directory name.");
//				return;
//			}
//			rootPath += dirName + "/";
//			rootUrl += dirName + "/";
//			File saveDirFile = new File(rootPath);
//			if (!saveDirFile.exists()) {
//				saveDirFile.mkdirs();
//			}
//		}
		//根据path参数，设置各路径和URL
		String path = req.getParameter("path") != null ? req.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0, currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
		}

		//排序形式，name or size or type
		String order = req.getParameter("order") != null ? req.getParameter("order").toLowerCase() : "name";

		//不允许使用..移动到上一级目录
		if (path.indexOf("..") >= 0) {
			resp.getWriter().println("Access is not allowed.");
			return;
		}
		//最后一个字符不是/
		if (!"".equals(path) && !path.endsWith("/")) {
			resp.getWriter().println("Parameter is not valid.");
			return;
		}
		//目录不存在或不是目录
		File currentPathFile = new File(currentPath);
		if(!currentPathFile.isDirectory()){
			resp.getWriter().println("Directory does not exist.");
			return;
		}

		//遍历目录取的文件信息
		List<Hashtable> fileList = new ArrayList<Hashtable>();
		if(currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Hashtable<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if(file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if(file.isFile()){
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
				fileList.add(hash);
			}
		}

		if ("size".equals(order)) {
			Collections.sort(fileList, new SizeComparator());
		} else if ("type".equals(order)) {
			Collections.sort(fileList, new TypeComparator());
		} else {
			Collections.sort(fileList, new NameComparator());
		}
		JSONObject result = new JSONObject();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", fileList.size());
		result.put("file_list", fileList);

		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().println(result.toJSONString());
		
		
		
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
	
	public class NameComparator implements Comparator {
		public int compare(Object a, Object b) {
			Hashtable hashA = (Hashtable)a;
			Hashtable hashB = (Hashtable)b;
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
			}
		}
	}
	public class TypeComparator implements Comparator {
		public int compare(Object a, Object b) {
			Hashtable hashA = (Hashtable)a;
			Hashtable hashB = (Hashtable)b;
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String)hashA.get("filetype")).compareTo((String)hashB.get("filetype"));
			}
		}
	}
	public class SizeComparator implements Comparator {
		public int compare(Object a, Object b) {
			Hashtable hashA = (Hashtable)a;
			Hashtable hashB = (Hashtable)b;
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			} else {
				if (((Long)hashA.get("filesize")) > ((Long)hashB.get("filesize"))) {
					return 1;
				} else if (((Long)hashA.get("filesize")) < ((Long)hashB.get("filesize"))) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
}
