<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>资源搜索</title>
		<link rel="stylesheet" type="text/css" href="css/showList.css"/>
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
		<script type="text/javascript" src="js/jQuery.js"></script>
		<script type="text/javascript" src="js/search.js"></script>
		<link rel="stylesheet" type="text/css" href="css/tankuang.css"/>
		<script type="text/javascript" src="js/sign.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#header-right").hover(function(){
					$(this)[0].style.color="red";
				});
				$("#header-right").mouseleave(function(){
					$(this)[0].style.color="#ccc";
				});
				$("#header-right").click(function(){
					$("#full")[0].style.display = "none";
				});
				$(".request").click(function(){
					$("#full")[0].style.display = "block";
				});
				$("#t_submit").click(function(){
					var value = $("#titlte").val();
					if(value===""){
						return false;
					}
					$.post("/umi/areq",{"title":value},function(data){
						if(data==="true"){
							alert("提交成功！");
							$("#full")[0].style.display = "none";
						}else{
							alert("请稍后再试！");
						}
					});
				});
			});
			
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
		<style type="text/css">
			body{
				background: url(/umi/images/bg-showlist.jpg) no-repeat;
			}
		</style>
	</head>
	<body>
		<!--求资源弹框-->
		<div class="full" id='full'>
			<div class="tankuang">
				<div id="header">
					<span style="font-size: 18px;position: relative; top: 10px;">求资源</span>
					<div id="header-right" onclick="hidder()">x</div>
				</div>
				<div class="tankuang_content">
					<input type="text" placeholder="请输入资源名称" name="titlte" id="titlte" value="" />
					<input type="button" name="t_submit" id="t_submit" value="提交" />
				</div>
			</div>
		</div>
		<!--求资源弹框-->
<!-- head -->
	<div style="position:relative; margin-top:10px;">
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
		<div id="search_div">
			<input type="text" name="" id="condition" value="" placeholder="请输入要搜索的资源" />
			<input type="button" name="" id="search" value="搜索" />
		</div>
		<div id="show">
			<table cellspacing="0">
				<tr class="head">
					<td class="title">标题</td>
					<td class="user">发布者</td>
					<td class="count">赞/浏览量</td>
				</tr>
				<c:forEach items="${pageInfo.list}" var="list">
				<tr class="content">
					<td class="border_content">
						<a href="/umi/showPost?postId=${list.postid}">${list.postname}</a>
					</td>
					<td class="border_content">
						<span>${list.username }</span><br />
						<span style="font-size: 10px;">
						<fmt:formatDate value="${list.checktime}" pattern="yyyy-MM-dd HH:mm" />
						</span>
					</td>
					<td class="border_content">${list.likenum}/${list.browsenum}</td>
				</tr>
				
				</c:forEach>
				<c:if test="${info==null}">
				<c:if test="${pageInfo.current==pageInfo.total}">
				<tr class="content">
					<td colspan="3" align="center">
						<span style="color:#38D63B;">已经到底了~ </span>
					</td>
				</tr>
				</c:if>
				<tr class="content">
					<td colspan="3">
						<a class="a_left" href="/umi/search?condition=${condition}&pageNum=${pageInfo.current-1<=0?1:pageInfo.current-1}">上一页</a>
							<span>当前页数:${pageInfo.current} 总页数:${pageInfo.total} 总条数:${pageInfo.totalNum}</span>
						<a class="a_right" href="/umi/search?condition=${condition}&pageNum=${pageInfo.current+1>pageInfo.total?pageInfo.total:pageInfo.current+1}">下一页</a>
					</td>
				</tr>
				</c:if>
				<c:if test="${info!=null}">
				<tr class="content">
					<td colspan="3" align="center">
						<span>${info} 或 <a href="javascript:void(0);" class="request">求资源</a></span>
					</td>
				</tr>
				</c:if>
			</table>
		</div>
		<!-- 底部 -->
		<iframe src="bottom" style="border:0;" scrolling="no" width="100%" height="50px"></iframe>
	</body>
</html>
