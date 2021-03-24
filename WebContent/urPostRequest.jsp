<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/tankuang.css"/>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript">
			$(function(){
				$("#t_submit").click(function(){
					var value = $("#titlte").val();
					if(value===""){
						return false;
					}
					$.post("/umi/areq",{"title":value},function(data){
						if(data==="true"){
							alert("提交成功！");
							location.href = "/umi/apReq";
						}else{
							alert("请稍后再试！");
						}
					});
				});
			});
		</script>
</head>
<body>
	<div class="tankuang_content" style="top:30px;">
	<div style="wodth:auto; height:40px;font-size:18px;margin-top:30px;margin-left:80px;">求资源</div>
		<input type="text" style="margin-top:30px;" placeholder="请输入资源名称" name="titlte" id="titlte" value="" />
		<input type="button" name="t_submit" id="t_submit" value="提交" />
	</div>
</body>
</html>