<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="robots" content="all">
<meta name="description" content="umi论坛，资源论坛"/>
<meta name="keywords" content="umi论坛，资源论坛">
<meta name="keywords" content="在这里，你可以查找资源也可以发布资源，祝你玩得开心">
<title>umi论坛</title>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/sign.js"></script>
<link rel="stylesheet" type="text/css" href="css/top.css"/>
<style type="text/css">
	input[type=text]{
		width:539px;
		height:35px;
		padding-left:10px;
	}
	input[type=button]{
		height:42px;
		width:80px;
	}
	a{
		color: #000000;
		text-decoration: none;
	}
	a:hover{
		color: #2d78f4;
	}
	body{
		background:url(/umi/images/bg-index.jpg) no-repeat;
		/*background-position:-100px -300px;*/
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
	<div style="text-align:center; width:100%; height:400px;">
		<div style="margin:0 auto;width:640px;margin-top:200px;">
			<input type="text" id="condition" placeholder="请输入要搜索的资源" />
			<input id="search" type="button" value="搜索" />
		</div>
	</div>
	<iframe src="bottom" style="border:0;" scrolling="no" width="100%" height="50px"></iframe>
</body>
</html>