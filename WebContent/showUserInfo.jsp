<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="/umi/css/showPost.css"/>
		<script type="text/javascript" src="/umi/js/jQuery.js"></script>
		<style type="text/css">
			.attention{
				padding: 5px 20px;
				background: #1890ff;
				color: #FFF;
				cursor: pointer;
			}
			.intro{
				position: relative;
				top: 10px;
			}
			.spList{
				
			}
			.spList_tb{
				text-align: center;
			}
			.spList_tb tr{
				height: 35px;
			}
			.spList_tb td{
				width: 200px;
				border: solid 1px;
			}
			#spList_div{
				height: 400px;
				overflow: auto;
				margin-bottom: 20px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				<c:if test="${sessionScope.user==null }">var login = false;var iUserId = 0;</c:if>
				<c:if test="${sessionScope.user!=null }"> var login = true;var iUserId = ${sessionScope.user.userid};</c:if>
				var userId = ${suInfo.user.userid};
				
				$(function(){
					
					function initAttention(){
						
						var value = $(".attention").attr("value");
						switch(value){
							case "0":
								$(".attention")[0].style.color = "#FFF";
								$(".attention")[0].style.background = "#1890ff";
								$(".attention").hover(function(){
									$(this)[0].style.background = "#00b5e5";
								});
								$(".attention").mouseleave(function(){
									$(this)[0].style.background = "#1890ff";
								});
								break;
							case "2":
								$(".attention")[0].style.color = "#99a2aa";
								$(".attention")[0].style.background = "#d3d3d3";
								$(".attention").hover(function(){
									$(this)[0].style.color = "#00a1d6";
								});
								$(".attention").mouseleave(function(){
									$(this)[0].style.color = "#99a2aa";
								});
								break;
						}
					}
					//初始化关注css
					initAttention();
	 				//value :
					//0 未关注
	                // 1 正在提交关注
	 				//2  已关注
					//3 正在提交取消关注
					$(".attention").click(function(){
						if(!login){
							alert("请先登录！");
							return false;
						}
						if(userId===iUserId){
							alert("自己不能关注自己！");
							return false;
						}
						var thisVal = $(this);
						var val = $(this).attr("value");
						if(val=="1"||val=="3"){
							return false;
						}else if(val=="0"){
							$(this).attr("value","1");
							$.post("/umi/aatten",{"userId":userId},function(data){
								if(data==="true"){
									thisVal.attr("value","2");
								}else{
									thisVal.attr("value","0");
									alert("请稍后再试！");
								}
								location.href = location.href;
							});
						}else if(val=="2"){
							$(this).attr("value","3");
							$.post("/umi/catten",{"userId":userId},function(data){
								if(data==="true"){
									thisVal.attr("value","0");
								}else{
									thisVal.attr("value","2");
									alert("请稍后再试！");
								}
								location.href = location.href;
							});
						}
					});
				});
			});
		</script>
		
	</head>
	<body>
	<c:if test="${suInfo!=null}">	
		<div id="show">
			<table id="content_table">
				<tr>
					<td rowspan="6" class="left" valign="top" >
						<div id="" style="width: 160px; height: auto; text-align: center;margin-top: 10px;">
							<img width="120px" src="/umi/icon/${suInfo.user.usericon }"/>
							<br /><br />
							<c:if test="${suInfo.isAtten>0}">
							<span class="attention" value="2">已关注</span>
							</c:if>
							<c:if test="${suInfo.isAtten<=0}">
							<span class="attention" value="0">+关注</span>
							</c:if>
							
						</div>
					</td>
					<td class="white" height="35px">
						<div id="" style="height: 30px; width: 100%; border-bottom: 1px #ddd dashed;">
							<span style="font-size: 17px;">昵称：${suInfo.user.username }</span>
						</div>
					</td>
				</tr>
				<tr height="35px">
					<td class="white">
						<div id="" style="width: 100%;min-height: 35px; height: auto;">
							<div class="intro">
								个人简介：${suInfo.user.intro}
							</div>
						</div>
					</td>

				</tr>
				<tr>
					<td class="white spList">
						<div id="spList_div">
							<table cellspacing="0" class="spList_tb">
							<tr >
								<td style="border: 0px;text-align: left; padding-left: 10px;" colspan="3">
									<span>发布的资源：</span>
								</td>
							</tr>
							<tr>
								<td>标题</td>
								<td>发布时间</td>
								<td>操作</td>
							</tr>
							
							<c:forEach items="${suInfo.postList}" var="list">
							<tr>
								<td>${list.postname}</td>
								<td><fmt:formatDate value="${list.checktime}" pattern="yyyy-MM-dd HH:mm" /></td>
								<td><a href="/umi/showPost?postId=${list.postid}">查看</a></td>
							</tr>
							</c:forEach>
							<c:if test="${suInfo.postListSize<=0}">
							<tr>
								<td colspan="3">还没有发布任何资源...</td>
							</tr>
							</c:if>
						</table>
						</div>
						
					</td>
				</tr>
			</table>
		</div>
	</c:if>
	<c:if test="${suInfo==null}">没有找到个人信息...</c:if>
	</body>
</html>
