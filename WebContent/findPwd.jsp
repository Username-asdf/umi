<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/general.js"></script>
</head>
<body>
	<span style="color:red;">${requestScope.info}</span>
    <form action="findPwd" method="post">
    	手机号：<input type="text" name="phoneNum" id="phoneNum" value="" placeholder="请输入手机号" />
        <br />
       	 验证码：<input type="text" name="phoneValid" id="phoneValid" value="" /><input type="button" smsType="mode_findPwd" name="send" id="send" value="发送验证码" />
       	 <br/>
       	 <input type="submit" value="提交"/>
    </form>    
</body>
</html>