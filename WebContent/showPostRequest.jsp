<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/showList.css"/>
		<title></title>
	</head>
	<body>
		<div id="show">
			<table cellspacing="0">
				<tr class="head">
					<td class="title">标题</td>
					<td class="user">已发布资源人数</td>
					<td class="count">操作</td>
				</tr>
				<c:forEach items="${spReq.list}" var="list">
				<tr class="content">
					<td class="border_content">${list.title }</td>
					<td class="border_content">
						<span>${list.num }</span><br />
					</td>
					<td class="border_content"><a href="/umi/userCenterRight/urSendPost?title=${list.title}&reqId=${list.requestid}">发布资源</a></td>
				</tr>
				</c:forEach>
				<c:if test="${spReq.current==spReq.total}">
				<tr class="content">
					<td colspan="3" align="center">
						<span style="color:#38D63B;">已经到底了~ </span>
					</td>
				</tr>
				</c:if>
				<tr class="content">
					<td colspan="3">
						<a class="a_left" href="/umi/postReq?pageNum=${spReq.current-1<=0?1:spReq.current-1}">上一页</a>
							<span>当前页数:${spReq.current} 总页数:${spReq.total} 总条数:${spReq.totalNum}</span>
						<a class="a_right" href="/umi/postReq?pageNum=${spReq.current+1>spReq.total?spReq.total:spReq.current+1}">下一页</a>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>