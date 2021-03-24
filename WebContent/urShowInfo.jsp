<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#content_ta{
		border:solid 1px #EEEEEE;
		border-bottom:0px;
		margin-left:180px;
		margin-top:10px;
	}
	#content_ta tr{
		height: 35px;
	}
	.content_td_left{
		width:100px;
		border-bottom:solid 1px #EEE;
		text-align:right;
	}
	.content_td_right{
		width:300px;
		padding-left:30px;
		border-bottom:solid 1px #EEE;
	}
</style>
</head>
<body>
	<img alt="头像" src="/umi/icon/${sessionScope.user.usericon}" width="168px" align="left">
	<table id="content_ta" cellspace="0">
			<tr class="">
				<td class="content_td_left">用户昵称:</td>
				<td class="content_td_right">${sessionScope.user.username}</td>
			</tr>
			<tr>
				<td class="content_td_left">手机号:</td>
				<td class="content_td_right">${sessionScope.user.phonenum}</td>
			</tr>
			<tr>
				<td class="content_td_left">性别:</td>
				<td class="content_td_right">${sessionScope.user.usersex}</td>
			</tr>
			<tr>
				<td class="content_td_left">积分:</td>
				<td class="content_td_right">${sessionScope.user.freepoint}</td>
			</tr>
			<tr>
				<td class="content_td_left">邮箱:</td>
				<td class="content_td_right">${sessionScope.user.mail}</td>
			</tr>
			<tr>
				<td class="content_td_left">个人简介:</td>
				<td class="content_td_right">${sessionScope.user.intro}</td>
			</tr>
		</table>
</body>
</html>