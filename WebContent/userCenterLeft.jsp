<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script type="text/javascript" src="js/jQuery.js"></script>
<style type="text/css">
			li{
				list-style: none;
				padding-top: 10px;
				font-size: 17px;
			}
			span{
				font-weight: bolder;
				font-size: 18px;
			    }
			a{
				color: #2D78F4;
				text-decoration: none;
			}
			a:visited{
				color: #2D78F4;
				 text-decoration: none;
			}
			a:hover{
				color: #E90000;
				 text-decoration: none;
			}
			a:active{
				 text-decoration: none;
				 color: #38D63B;
				}
		</style>
		<script type="text/javascript">
			$(function(){
				$("span").click(function(){
					$(this).next("ul").slideToggle(200);
				});
			});
		</script>
</head>
<body style="background-color: #E9EFF6">
	<dl >
			<dd>
				<span>账号管理</span>
				<ul>
		            <li><a href="userCenterRight/urShowInfo" target="iframe_right" >个人信息</a></li>
		            <li><a href="userCenterRight/urUpdInfo" target="iframe_right">修改资料</a></li>
		            <li><a href="userCenterRight/urUpdPwd" target="iframe_right">修改密码</a></li>
		            <li><a href="userCenterRight/urAttention" target="iframe_right" >我的关注</a></li>
	            </ul>
			</dd>
			<dd>
				<br>
				<span>发布板块管理</span>
				<ul>
					<li><a href="userCenterRight/urSendPost" target="_blank">发布板块</a></li>
		            <li><a href="userCenterRight/urPassPost" target="iframe_right">已通过</a></li>
		            <li><a href="userCenterRight/urCheckPost" target="iframe_right">正在审核</a></li>
		            <li><a href="userCenterRight/urNotPassPost" target="iframe_right">未通过</a></li>
		            <li><a href="/umi/apReq" target="iframe_right">求资源</a></li>
		            <li><a href="/umi/postReq" target="_blank">帮助他人发资源</a></li>
		            <li><a href="/umi/smpReq" target="iframe_right">查看自己所求资源</a></li>
	            </ul>
			</dd>
		</dl>
</body>
