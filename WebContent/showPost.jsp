<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>${showPost.passPost.postname}</title>
		<meta name="description" content="${showPost.passPost.postname}"/>
		<meta name="keywords" content="${showPost.passPost.postname}--umi资源论坛" />
		<meta name="robots" content="all">
		
		<link rel="stylesheet" type="text/css" href="css/showPost.css"/>
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
		<script type="text/javascript" src="js/sign.js"></script>
		<script charset="utf-8" src="kindeditor/kindeditor-all-min.js"></script>
	　　 	<script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
		<script type="text/javascript" src="js/jQuery.js"></script>
		<script type="text/javascript" src="js/showPost.js"></script>  
	
    <script type="text/javascript">
    <c:if test="${sessionScope.user==null }">var login = false;</c:if>
	<c:if test="${sessionScope.user!=null }"> var login = true;</c:if>
	var postId = ${showPost.passPost.postid};
   	 var editor1;//全局变量
   	 var editor2;
    KindEditor.ready(function(K) {
      editor1 = K.create('#kindedito1', {
      allowImageUpload : true,
      items : [
           'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic',
   　　　　 'underline', 'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright',
  　　　　  'insertorderedlist', 'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
        uploadJson : "/umi/upload",
        fileManagerJson : '/umi/showUpload',
        allowFileManager : true
      });
    });
    
    $(function(){
    	$(".top_login").hover(function(){
    		if(login){
    			$(".top_menu")[0].style.display = "block";
    		}
    	});
    	$(".top_menu").mouseleave(function(){
    		if(login){
    			$(".top_menu")[0].style.display = "none";
    		}
    	});
    });
</script>
<style type="text/css">
	
</style>
	</head>
	<body>
		<!-- head -->
	<div style="position:relative;">
		<div style="width:100%;height:35px; text-align: end;margin-right:50px;">
	<c:if test="${sessionScope.user ==null}">
		<a href="/umi/login" class="top_login" target="_parent">
		<span class="top_login_text">登录</span>
		<span class="top_login_img"></span>
		</a>
	</c:if>
	<c:if test="${sessionScope.user != null}">
		<a href="javascript:void(0);" class="top_login" target="_parent">
			<span class="top_login_text">${sessionScope.user.username }</span>
			<span class="top_login_img"></span>
		</a>
	</c:if>
	&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="top_menu">
		<div class="top_menu_item">
			<c:if test="${sessionScope.sign==null}">
			<a id="signIn" href="javascript:void(0);">签到</a>
		</c:if>
		<c:if test="${sessionScope.sign!=null}">
			<a href="javascript:void(0);">已签到</a>
		</c:if>
		</div>
		<div class="top_menu_item"><a href="/umi/userCenter" target="_blank">用户中心</a></div>
		<div class="top_menu_item"><a href="/umi/exit" target="_parent">退出登录</a></div>
	</div>
	</div>
	<!-- head -->
		<div id="show">
			<table id="content_table">
				<tr>
					<td rowspan="7" class="left" valign="top" >
						<div id="" style="width: 160px; height: auto; text-align: center;margin-top: 10px;">
							<img width="120px" src="/umi/icon/${showPost.user.usericon}"/>
							<br />
							<span style="padding: 0 20px;"><a href="/umi/suInfo?userId=${showPost.user.userid}">${showPost.user.username }</a></span>
						</div>
					</td>
					<td class="white">
						<div id="" style="height: 14px; width: 100%; border-bottom: 1px #ddd dashed;">
							<span style="font-size: 10px;">发布时间：<fmt:formatDate value="${showPost.passPost.checktime}" pattern="yyyy-MM-dd HH:mm" /></span>
						</div>
					</td>
				</tr>
				<tr height="35px">
					<td class="white">
						<div id="" style="width: 100%;min-height: 35px; height: auto;">
							<h4>${showPost.passPost.postname}</h4>
						</div>
					</td>

				</tr>
				<tr>
					<td class="white">
						<div id="post">
							${showPost.passPost.displayinfo}
						</div>
					</td>
				</tr>
				<tr>
					<td class="white">
						<div id="" >
							<h5>资源地址:</h5>
							<a target="_blank" href="/umi/resourceAddr?postId=${showPost.passPost.postid}">点击购买</a>
							<span>(1积分)</span>
						</div>
					</td>
				</tr>
				<c:if test="${!empty showPost.passPost.hiddeninfo}">
				<c:if test="${showPost.isComment<=0}">
				<tr>
					<td class="white">
						<div id="" style="min-height: 50px;margin-top: 20px;">
							<span>隐藏信息，只有当评论后才能看到</span>
						</div>
					</td>
				</tr>
				</c:if>
				<c:if test="${showPost.isComment>0}">
				<tr>
					<td class="white">
						<div id="" style="min-height: 50px;margin-top: 20px;">
							<span>${showPost.passPost.hiddeninfo}</span>
						</div>
					</td>
				</tr>
				</c:if>
				</c:if>
				<c:if test="${empty showPost.passPost.hiddeninfo}">
					<tr><td></td></tr>
				</c:if>
				<!-- 板块赞，踩，举报 -->
				<tr style="height:35px;">
					<td class="white">
						<div class="comment">
						<div class="comment-ope" style="padding-left:0px;">
							<c:if test="${showPost.lOrh == 0}">
								<img id="postLike" src="/umi/images/zan1.png" postval="1" value="0" class="comment-ope-zan"/><span style="padding-left: 5px;">${showPost.passPost.likenum}</span>
								<img id="postHate" src="/umi/images/cai1.png" postval="1" value="0" class="comment-ope-cai"/><span style="padding-left: 5px;">${showPost.passPost.hatenum}</span>
							</c:if>
							<c:if test="${showPost.lOrh == 1}">
								<img id="postLike" src="/umi/images/zan3.png" postval="1" value="1" class="comment-ope-zan"/><span style="padding-left: 5px;">${showPost.passPost.likenum}</span>
								<img id="postHate" src="/umi/images/cai1.png" postval="1" value="0" class="comment-ope-cai"/><span style="padding-left: 5px;">${showPost.passPost.hatenum}</span>
							</c:if>
							<c:if test="${showPost.lOrh == 2}">
								<img id="postLike" src="/umi/images/zan1.png" postval="1" value="0" class="comment-ope-zan"/><span style="padding-left: 5px;">${showPost.passPost.likenum}</span>
								<img id="postHate" src="/umi/images/cai3.png" postval="1" value="1" class="comment-ope-cai"/><span style="padding-left: 5px;">${showPost.passPost.hatenum}</span>
							</c:if>
							<img src="images/a.png" value="0" alt="" class="comment-ope-more" />
							<div class="more" hidden="hidden">
								<c:if test="${sessionScope.user!=null }">
									<c:if test="${sessionScope.user.userid!=user.userid}">
									<span id="post-report-btn" class="report-button" postval="1" value="0">举报</span>
									</c:if>
									<c:if test="${sessionScope.user.userid==user.userid}">
									<span id="post-report-btn" class="report-button" postval="1" value="1">删除</span>
									</c:if>
								</c:if>
								<c:if test="${sessionScope.user==null }">
									<span id="post-report-btn" class="report-button" postval="1" value="0">举报</span>
								</c:if>
							</div>
						</div>
						</div>
					</td>
				</tr>
				<tr>
					<td class="white">
						<!-- 锚点  -->
						<a id="comment_a"></a>
						<div id="kindeditor">
    						<textarea class="kindedito" id="kindedito1" name="post" rows="10" cols="94" ></textarea>
						</div>
						<div style="text-align: right; padding-right: 20px;padding-top: 20px;">
							<input type="button" class="comment-submit" onclick="kindedito1(this)" name="" id="" value="发布评论" />
						</div>
					</td>
				</tr>
				
				<!--
					评论
                -->
               
                <c:forEach items="${showPost.commentList}" var="list">
				<tr username="${list.username }" commid="${list.commid }">
					<td class="left" valign="top">
						<div id="" style="width: 160px; height: auto; text-align: center;margin-top: 10px;">
							<img width="120px" src="/umi/icon/${list.usericon }"/>
							<br />
							<span style="padding: 0 20px;">
							<a href="/umi/suInfo?userId=${list.userid}">${list.username}</a>
							</span>
						</div>
					</td>
					<td class="white">
						<div class="comment">
						<div class="comment-content">${list.comm}</div>
							<div class="comment-ope">时间：<fmt:formatDate value="${list.sendtime}" pattern="yyyy-MM-dd HH:mm" />
								<c:choose>
									<c:when test="${list.lOrH==0}">
										<img src="images/zan1.png" value="0" class="comment-ope-zan"/><span style="padding-left: 5px;">${list.likenum}</span>
										<img src="images/cai1.png" value="0" class="comment-ope-cai"/><span style="padding-left: 5px;">${list.hatenum}</span>
									</c:when>
									<c:when test="${list.lOrH==1}">
										<img src="images/zan3.png" value="1" class="comment-ope-zan"/><span style="padding-left: 5px;">${list.likenum}</span>
										<img src="images/cai1.png" value="0" class="comment-ope-cai"/><span style="padding-left: 5px;">${list.hatenum}</span>
									</c:when>
									<c:when test="${list.lOrH==2}">
										<img src="images/zan1.png" value="0" class="comment-ope-zan"/><span style="padding-left: 5px;">${list.likenum}</span>
										<img src="images/cai3.png" value="1" class="comment-ope-cai"/><span style="padding-left: 5px;">${list.hatenum}</span>
									</c:when>
								</c:choose>
								
								<span class="reply">回复</span>
								<img src="images/a.png" value="0" alt="" class="comment-ope-more" />
								<div class="more" hidden="hidden">
									<c:if test="${sessionScope.user!=null }">
										<c:if test="${sessionScope.user.userid != list.userid }">
										<span class="report-button" value="0">举报</span>
										</c:if>
										<c:if test="${sessionScope.user.userid == list.userid }">
										<span class="report-button" value="1">删除</span>
										</c:if>
									</c:if>
									<c:if test="${sessionScope.user==null }">
										<span class="report-button" value="0">举报</span>
									</c:if>
								</div>
							</div>
						</div>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${showPost.currentPage == showPost.totalPage}">
				<tr>
					<td colspan="2" class="white" style="height:35px;color:green; text-align:center;">
						没有更多评论了~
					</td>
				</tr>
				</c:if>
				<tr>
					<td colspan="2" class="white" style="height:35px;">
						
						<a style="padding-left:20px;margin-right:260px;" href="/umi/showPost?postId=${showPost.passPost.postid }&pageNum=${showPost.currentPage-1<=0?1:showPost.currentPage-1}#comment_a">上一页</a>
						<span>当前页数:${showPost.currentPage} 总页数:${showPost.totalPage} 总条数:${showPost.total}</span>
						<a style="padding-right:20px;margin-left:260px;" href="/umi/showPost?postId=${showPost.passPost.postid }&pageNum=${showPost.currentPage+1>showPost.totalPage?showPost.totalPage:showPost.currentPage+1}#comment_a">下一页</a>
					</td>
				</tr>
			</table>
		</div>
		<!-- 底部 -->
		<iframe src="bottom" style="border:0;" scrolling="no" width="100%" height="50px"></iframe>
	</body>
</html>
