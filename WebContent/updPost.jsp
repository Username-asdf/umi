<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>新增板块</title>

    <script type="text/javascript" src="/umi/kindeditor/kindeditor-all-min.js"></script>
　　 <script charset="utf-8" src="/umi/kindeditor/lang/zh-CN.js"></script>
    <script type="text/javascript">
    var editor;
    KindEditor.ready(function(K) {
            editor = K.create('#kindeditor', {
                    themeType : "default",
                    uploadJson : "/umi/upload",
                    fileManagerJson : '/umi/showUpload',
                    allowFileManager : true
            });
    });
   	
</script>
<script type="text/javascript" src="/umi/js/jQuery.js"></script>
<script type="text/javascript" src="/umi/js/updPost.js"></script>
<script type="text/javascript">
	var postType = "${postType}";
	var postId = "${postId}";
</script>
<style type="text/css">
	input[type=text]{
		width: 400px;
		height: 40px;
	}
	input[type=button]{
		width: 80px;
	}
</style>
</head>
 
<body>
	<div id="show" style="margin-left:200px;">
		<table>
			<tr>
				<td><h5>资源名称：</h5></td>
			</tr>
			<tr>
				<td>
					<input type="text" name="title" id="title" value="${info.postname}" placeholder="请输入资源标题，必填" />					
				</td>
			</tr>
			<tr>
				<td><h5>正文：</h5></td>
			</tr>
			<tr>
				<td>
					<textarea id="kindeditor" name="post" rows="20" cols="100" placeholder="请输入正文，必填" >请输入正文，必填</textarea>
				</td>
			</tr>
			<tr>
				<td><h5>资源地址：</h5></td>
			</tr>
			<tr>
				<td>
					<input type="text" name="addr" id="addr" value="${info.resourceaddr }" placeholder="请输入资源地址，必填"/>
				</td>
			</tr>
			<tr>
				<td><h5>隐藏信息：</h5></td>
			</tr>
			<tr>
				<td>
					<input type="text" name="hidden" id="hidden" value="${info.hiddeninfo }" placeholder="请输入隐藏信息，只有评论后才会显示" />
				</td>
			</tr>
			<tr>
				<td>
					<br />
					<input type="button" name="" id="resetInfo"  value="重置" />
					<input type="button" name="" id="submitInfo" value="提交" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>