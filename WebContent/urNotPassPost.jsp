<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script charset="utf-8" src="/umi/js/confDel.js"></script>
<link rel="stylesheet" href="/umi/css/a_style.css" />
<link rel="stylesheet" href="/umi/css/urPostList.css" />
</head>
<body>
	<table id="content_ta">
		<tr>
			<td class="title_td">标题</td>
			<td class="time_td">时间</td>
			<td class="reason_td">原因</td>
			<td class="opr_td">操作</td>
		</tr>
		<c:forEach items="${sessionScope.notPassPostList}" var="list">
		<tr>
			<td class="title_td">${list.postname}</td>
			<td class="time_td"><fmt:formatDate value="${list.checktime}" pattern="yyyy-MM-dd HH:mm" /></td>
			<td class="reason_td">${list.reason}</td>			
			<td class="opr_td">
				<a target="_blank" href="/umi/updPost?postType=not&postId=${list.postid}">修改</a>
				<span> | </span>
				<a onclick="return delConf();" href="/umi/delPost?postId=${list.postid}&postType=not">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>