<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link type="text/css" rel="stylesheet" href="/umi/css/login.css" />
<link rel="stylesheet" type="text/css" href="/umi/css/tankuang.css"/>
<script type="text/javascript" src="/umi/js/jQuery.js"></script>
<script type="text/javascript" src="/umi/js/general.js"></script>
<script type="text/javascript" src="/umi/js/login.js"></script>
<script type="text/javascript">	

</script>
<style type="text/css">
	
</style>
</head>

<body>
	
<!-- 找回密码弹框 -->
<div class="full" id='full'>
	<div class="tankuang" style="width: 615px;height: 300px;">
		<div id="header">
			<span style="font-size: 18px;position: relative; top: 10px;">找回密码</span>
			<div id="header-right">x</div>
		</div>
		<div class="tankuang_content">
			<table id="ta1">
				<tr>
					<td class="ta1_left">手机号:</td>
					<td class="ta1_right">
						<input type="text" class="test_phoneNum" name="tk_phoneNum" test="false" id="tk_phoneNum" placeholder="请输入手机号" value="" />
						<div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
					</td>
				</tr>
				<tr>
					<td class="ta1_left">验证码:</td>
					<td class="ta1_right">
						<input type="text" style="width: 108px;" test="false" id="tk_vaild" placeholder="请输入验证码" value="" />
						<input type="button" name="" smsType="mode_findPwd" id="send" value="发送验证码" />
						<div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2"  class="ta1_td_next">
						<input type="button" name="" id="ta1_td_inp_next" value="下一步" />
					</td>
				</tr>
				<tr>
					<td class="ta1_bottom" colspan="2">
						<span id="ta1_bottom_msg"></span>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<!-- 找回密码弹框 -->
<div class="main">
  <div class="main0">
     <div class="main_left">
        <img src="/umi/images/login-image-3.png" class="theimg"/>
        <img src="/umi/images/login-image-2.png" class="secimg"/>
        <img src="/umi/images/login-image-1.png" class="firimg"/>
     </div>
     <form action="/umi/login" method="post">
     <div class="main_right">
        <div class="main_r_up">
            <img src="/umi/images/user.png" />
            <div class="pp">登录</div>
        </div>
        <div class="sub"><p>还没有账号？<a href="/umi/register"><span class="blue">立即注册</span></a><a href="javascript:void(0);" id="findpwd" style="padding-left: 10px;color:#31acfb;">找回密码</a></p></div>
        <div class="txt">
            <span style="letter-spacing:8px;">手机号:</span>
            <input type="text" test="false" name="phoneNum" value="${user_phoneNum}" class="txtphone" id="c_phoneNum" placeholder="请输入手机号"/>
            <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
        </div>
        <div class="txt">
            <span style="letter-spacing:4px;">登录密码:</span>
            <input type="password" test="false" name="pwd" value="${user_pwd}" class="txtphone" placeholder="请输入登录密码"/>
            <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
        </div>
        <div class="txt">
            <span style=" float:left;letter-spacing:8px;">验证码:</span>
            <input name="validCode" test="false" type="text" class="txtyzm" placeholder="请输入页面验证码"/>
           <a href="javascript:void(0);"><img onclick="changeVaildCode(this);" src="/umi/valid" width="80px" height="40px" style="border: 1px ; padding-left: 20px;" /></a>
           <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
        </div>
        <div class="xiayibu">登录</div>
        <span style="color:red;">${requestScope.info}</span>
     </div>
     </form>
  </div>
</div>


</body>
</html>
