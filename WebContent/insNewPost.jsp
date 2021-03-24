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
<script type="text/javascript" src="/umi/js/jQuery.js"></script>
<script type="text/javascript" src="/umi/js/sendPost.js"></script>
<style type="text/css">
	.input_text{
		width: 400px;
		height: 40px;
	}
	.input_btn{
		width: 80px;
	}
</style>
<script charset="utf-8" src="/umi/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="/umi/kindeditor/lang/zh-CN.js"></script>
	
    <script type="text/javascript">
    <c:if test="${reqId!=null}">var reqId = ${reqId};</c:if>
	<c:if test="${reqId==null}">var reqId = 0;</c:if>
    
	var editor;
    KindEditor.ready(function(K) {
            editor = K.create('#kindeditor', {
                    uploadJson : "/umi/upload",
                    fileManagerJson : '/umi/showUpload',
                    allowFileManager : true
            });
    });
</script>
</head>
 
<body>
	<div id="show" style="margin-left:200px;">
		<table>
			<tr>
				<td><h5>资源名称：</h5></td>
			</tr>
			<tr>
				<td>
					<input class="input_text" type="text" name="title" id="title" value="${title }" placeholder="请输入资源标题，必填" />					
				</td>
			</tr>
			<tr>
				<td><h5>正文：</h5></td>
			</tr>
			<tr>
				<td>
					<div id="">
    					<textarea id="kindeditor" name="post" rows="20" cols="100" placeholder="请输入正文，必填" >请输入正文，必填</textarea> 
					</div>
				</td>
			</tr>
			<tr>
				<td><h5>资源地址：</h5></td>
			</tr>
			<tr>
				<td>
					<input class="input_text" type="text" name="addr" id="addr" value="" placeholder="请输入资源地址，必填"/>
				</td>
			</tr>
			<tr>
				<td><h5>隐藏信息：</h5></td>
			</tr>
			<tr>
				<td>
					<input class="input_text" type="text" name="hidden" id="hidden" value="" placeholder="请输入隐藏信息，只有评论后才会显示" />
				</td>
			</tr>
			<tr>
				<td>
					<br />
					<input class="input_btn" type="button" name="" id="resetInfo"  value="重置" />
					<input class="input_btn" type="button" name="" id="submitInfo" value="提交" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>