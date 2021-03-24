<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/general.js"></script>
</head>
<body>
	<form id="findUpdPwd" action="findUpdPwd" method="post">
    	新密码：<input type="text" name="newPwd" id="newPwd" value="" />
    	<br />
    	确认密码：<input type="text" name="reNewPwd" id="reNewPwd" value="" />
    	<br />
    	<input type="button" id="findUpdPwd_submit" value="提交"/>
    </form>
</body>
</html>