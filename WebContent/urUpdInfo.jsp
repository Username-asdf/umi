<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
	<span style="color:red;">${requestScope.info}</span>
	<form action="/umi/updInfo" enctype="multipart/form-data" method="post">
		<table id="content_ta">
			<tr>
				<td class="content_td_left">用户头像：</td>
				<td class="content_td_right"><input type="file" name="icon" id="icon"  /></td>
			</tr>
			<tr>
				<td class="content_td_left">性别：</td>
				<td class="content_td_right">
					<input type="radio" name="sex" id="sex" value="1" checked="checked" />男
					<input type="radio" name="sex" id="sex" value="0" />女
				</td>
			</tr>
			<tr>
				<td class="content_td_left">邮箱：</td>
				<td class="content_td_right"><input class="inp_text" placeholder="请输入邮箱" type="text" name="mail" id="mail" value="" /></td>
			</tr>
			<tr>
				<td class="content_td_left">个人简介：</td>
				<td class="content_td_right"><input class="inp_text" placeholder="请输入个人简介" type="text" name="intro" id="intro" value="" /></td>
			</tr>
			<tr>
				<td colspan="2" class="content_td_right submit"><input class="inp_sub" type="submit" value="提交"/></td>
			</tr>
		</table>
		</form>
</body>
</html>