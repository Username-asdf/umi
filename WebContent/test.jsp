<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="/umi/js/jQuery.js"></script>
<script type="text/javascript" src="/umi/js/updPwd.js"></script>
<style type="text/css">
	form{
		margin-top: 250px;
		margin-left: 800px;
		font-weight: bold;
	}
	input{
		height: 30px;
		width: 200px;
	}
	.submitbtn{
		background-color: #2D78F4;
		margin-left: 50px;
	    border:1px solid #ccc; 
	}
	
</style>
</head>
<body>
	<form action="" method="post">
	<table>
		<tr height="40px">
			<td>旧密码：</td>
			<td ><input type="text" name="pwd" id="pwd" value=""/></td>
		</tr>
		<tr height="40px">
			<td>新密码：</td>
			<td><input type="text" name="newPwd" id="newPwd" value="" placeholder="新密码" style="padding-left: 10px;"/></td>
		</tr>
		<tr height="40px">
			<td>重复密码：</td>
			<td><input type="text" name="reNewPwd" id="reNewPwd" value="" placeholder="重复密码" style="padding-left: 10px;" /><span style="padding-left: 20px; color: #D86060;">请确认输入的密码输入正确</span></td>
		</tr>
		<tr height="60px">
			<td colspan="2"><input class="submitbtn" id="updPwd_submit" type="button" value="提交"/></td>
		</tr>
	</table>
	</form>
</body>
</html>