<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript" src="js/jQuery.js"></script>
		<link rel="stylesheet" type="text/css" href="/umi/css/a_style.css"/>
		<style type="text/css">
			table{
				margin-left: 20px;
				margin-top: 30px;
				border: solid 1px #DDD;
				border-bottom: 0px;
			}
			tr{
				height: 35px;
			}
			.title,.time,.opr{
				border-bottom: solid 1px #DDD;
			}
			.title{
				width: 350px;
				padding-left: 20px;
			}
			.time{
				width: 150px;
				padding-left: 20px;
			}
			.opr{
				width: 80px;
				padding-left: 20px;
			}
			.xlk{
				width: 18px;
				height: 18px;
				cursor: pointer;
				display:inline-block;
				background: url(/umi/images/down.png);
			}
			.content{
				width: 573px;
				height: auto;
				max-height: 200px;
				overflow: auto;
			}
			.username{
				width: 250px;
				padding-left: 20px;
				border-bottom: solid 1px #DDD;
			}
			.otherInfo{
				text-align:center;
				border-bottom:solid 1px #EEE;"
			}
			.delReqPost{
				padding-left: 15px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$(".xlk").click(function(){
					var value = $(this).attr("value");
					$(this).parent().parent().next().slideToggle(600);
					if(value==="0"){
						$(this)[0].style.background = "url(/umi/images/up.png)";
						$(this).attr("value","1");
					}else{
						$(this)[0].style.background = "url(/umi/images/down.png)";
						$(this).attr("value","0");
					}
				});
				
				$(".delReqPost").click(function(){
					var conf = confirm("确定眼删除？");
					if(!conf){
						return false;
					}
					var reqId = $(this).attr("reqid");
					
					location.href = "/umi/delrp?reqId="+reqId;
				});
				
			});
		</script>
	</head>
	<body>
		<table cellspacing="0">
		<c:forEach items="${reqList}" var="reqList">
			<tr>
				<td class="title">${reqList.title}</td>
				<td class="time"><fmt:formatDate value="${reqList.time}" pattern="yyyy-MM-dd HH:mm" /></td>
				<td class="opr">
					<div class="xlk" value="0"></div>
					<a class="delReqPost" reqId="${reqList.requestid}" href="javascript:void(0);">删除</a>
				</td>
			</tr>
			<c:if test="${listSize==0}">
				<tr>
					<td colspan="3" class="otherInfo">还没有发布求资源信息</td>
				</tr>
			</c:if>
			<c:if test="${listSize!=0}">
			<tr style="display: none;">
				<td colspan="3">
					<div class="content">
						<table style="border:0px;margin-top: 0;margin-left: 30px;">
							<tr>
								<td class="username">用户昵称</td>
								<td class="time">时间</td>
								<td class="opr">操作</td>
							</tr>
							<c:forEach items="${reqList.list}" var="list">
							<tr>
								<td class="username"><a href="/umi/suInfo?userId=${list.userId}" target="_blank">${list.username}</a></td>
								<td class="time"><fmt:formatDate value="${list.time}" pattern="yyyy-MM-dd HH:mm" /></td>
								<td class="opr"><a href="/umi/showPost?postId=${list.postId}" target="_blank">查看</a></td>
							</tr>
							</c:forEach>
							<c:if test="${reqList.listSize==0}">
								<tr>
									<td colspan="3" class="otherInfo">还没有人发布资源</td>
								</tr>
							</c:if>
						</table>
					</div>
				</td>
			</tr>
			</c:if>
		</c:forEach>
		</table>
	</body>
</html>