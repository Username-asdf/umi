<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/umi/js/jQuery.js"></script>
<script type="text/javascript" src="/umi/js/sign.js"></script>
<link rel="stylesheet" type="text/css" href="/umi/css/a_style.css"/>
<style type="text/css">
	.top_login{
		display: inline-block;
		width:200px;
		height:42px;
		padding:0 12px;
	}
	.top_login_text{
		padding-right: 5px;
		position: relative;
		bottom: 8px; 
	}
	.top_login_img{
		width: 32px;
		height: 32px;
		display: inline-block;
		background: url(/umi/images/head1.png) no-repeat center center;
		background-color: #ececec;
		border-radius: 16px;
	}
	.top_menu{
		width:100px;
		height:120px;
		position:absolute;
		right:60px;
		top: 40px;
		background: rgb(255,255,255,0.5);
		text-align: center;
		border-radius: 4px;
		display: none;
	}
	.top_menu_item{
		padding-top: 15px;
		
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
	
</body>
</html>