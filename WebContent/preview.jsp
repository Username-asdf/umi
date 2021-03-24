<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>板块预览</title>
		<style type="text/css">
			#show{
				width: 980px;
				margin: 0 auto;
				margin-top: 30px;
				border: 1px solid #ccc;
				min-height: 500px;
			}
			table{
				width: 980px;
				height: 500px;
			}
			#left{
				width: 160px;
				border-right: solid 1px #ccc;
				background: #eee;
			}
			#post{
				min-height: 200px;
				height: auto;
			}
			hr{
				height: 0;
			}
			.white{
				background: #FFF;
				border: #fff 1px solid;
				padding-left: 20px;
			}
			body{
				background-color: #eee;
			}
		</style>
	</head>
	<body>
		<div id="show">
			<table>
				
				<tr>
					<td rowspan="5" id="left" valign="top" >
						<div id="" style="width: 160px; height: auto; text-align: center;margin-top: 10px;">
							<img width="120px" src="/umi/icon/${sessionScope.user.usericon}"/>
							<br />
							<span style="padding: 0 20px;">${sessionScope.user.username}</span>
						</div>
					</td>
					<td class="white">
						<div id="" style="height: 14px; width: 100%; border-bottom: 1px #ddd dashed;">
							<span style="font-size: 10px;">发布时间：${prePost.time}</span>
						</div>
					</td>
				</tr>
				<tr height="35px">
					<td class="white">
						<div id="" style="width: 100%;min-height: 35px; height: auto;">
							<h4>${prePost.postname}</h4>
						</div>
					</td>

				</tr>
				<tr>
					<td class="white">
						<div id="post">
							${prePost.displayinfo}
						</div>
					</td>
				</tr>
				<tr>
					<td class="white">
						<div id="" >
							<h5>资源地址:</h5>
							<input type="button" name="" id="" value="点击购买" />
							<span>(1积分)</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="white">
						<div id="" style="min-height: 50px;height:auto;margin-top: 20px;margin-bottom:20px;">
							<h5>隐藏信息:</h5>
							<span>${prePost.hiddeninfo}</span>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>