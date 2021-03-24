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
	#content_ta{
		border:solid 1px #EEEEEE;
		border-bottom:0px;
		margin-left:20px;
		margin-top:10px;
	}
	#content_ta tr{
		height: 35px;
	}
	.content_td_left{
		width:100px;
		border-bottom:solid 1px #EEE;
		text-align:right;
	}
	.content_td_right{
		width:300px;
		padding-left:30px;
		border-bottom:solid 1px #EEE;
	}
	.submit{
		text-align:right;
		padding-right:20px;
	}
	.inp_sub{
		width:80px;
		height:32px;
	}
	.inp_text{
		width:200px;
		height:28px;
		padding-left:10px;
	}
</style>
</head>
<body>
	<form action="" method="post">
	<table id="content_ta">
		<tr>
			<td class="content_td_left">旧密码：</td>
			<td class="content_td_right"><input type="password" class="inp_text" name="pwd" id="pwd" value="" /></td>
		</tr>
		<tr>
			<td class="content_td_left">新密码：</td>
			<td class="content_td_right"><input type="password" class="inp_text" name="newPwd" id="newPwd" value="" /></td>
		</tr>
		<tr>
			<td class="content_td_left">重复密码：</td>
			<td class="content_td_right"><input type="password" class="inp_text" name="reNewPwd" id="reNewPwd" value="" /></td>
		</tr>
		<tr>
			<td colspan="2"  class="content_td_right submit"><input class="inp_sub" id="updPwd_submit" type="button" value="提交"/></td>
		</tr>
	</table>
	</form>
</body>
</html>