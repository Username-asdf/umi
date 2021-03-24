<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="/umi/css/a_style.css" />
<style type="text/css">
	#content_ta{
		border:solid 1px #EEEEEE;
		border-bottom:0px;
		margin-left:20px;
		margin-top:10px;
	}
	#content_ta tr{
		height: 35px;
	}
	.icon_td{
		width:100px;
	}
	.username_td{
		width:200px;
	}
	.intro_td{
		width:300px;
	}
	.icon_td,.username_td,.intro_td{
		border-bottom:solid 1px #EEE;
		padding-left:20px;
	}
</style>
</head>
<body>
	<table id="content_ta">
		<tr>
			<td class="icon_td">头像</td>
			<td class="username_td">昵称</td>
			<td class="intro_td">个人简介</td>
		</tr>
		<c:forEach items="${sessionScope.urAttention}" var="list">
			<tr>
				<td class="icon_td"><img width="58px" src="/umi/icon/${list.usericon}" alt="头像"/></td>
				<td class="username_td">&nbsp;&nbsp;<a href="/umi/suInfo?userId=${list.userid}" target="_blank">${list.username}</a></td>
				<td class="intro_td">${list.intro}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>