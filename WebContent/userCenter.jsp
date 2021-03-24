<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/general.js"></script>
<script type="text/javascript" src="js/sign.js"></script>
<link rel="stylesheet" type="text/css" href="css/top.css"/>
<link rel="stylesheet" type="text/css" href="css/a_style.css"/>
<style type="text/css">
	body{
		background:#f5f5f5;
		background: url(/umi/images/bg-usercenter.jpg) no-repeat;
	}
</style>
<script type="text/javascript">
<c:if test="${sessionScope.user==null }">var login = false;</c:if>
<c:if test="${sessionScope.user!=null }"> var login = true;</c:if>
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
		<br />
		<div style="background:#FFF;border:solid 1px #EEE;margin:0 auto; width: 980px;min-height:580px; height:auto; margin-top:30px;text-align:center;">
			<iframe src="userCenterLeft" style="border:1px solid #EEE;"  scrolling="no" width="290px" height="580px"></iframe>
		<iframe name="iframe_right" style="border:1px solid #EEE;background-color: #E9EFF6;" src="userCenterRight/urShowInfo" width="680px" height="580px"></iframe>
		</div>
		<br />
	<iframe src="bottom" style="border:0;" scrolling="no" width="100%" height="50px"></iframe>
</body>
</html>