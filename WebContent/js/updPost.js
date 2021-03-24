$(function(){
	$("#submitInfo").click(function(){
		var title = $("#title").val();
		var post = editor.html();
		var addr = $("#addr").val();
		var hidden = $("#hidden").val();
		if(title==""||post==""||addr==""){
			alert("请填写完整信息");
			return false;
		}
		var settime = setTimeout(function(){
			alert("提交失败，请稍后再试！")
			$("#submitInfo").attr("value","提交");
			$("#submitInfo").attr("disabled",false);
		},5000);
		$("#submitInfo").attr("value","正在提交...");
		$("#submitInfo").attr("disabled",true);
		$.post("/umi/updPost",{"title":title,"post":post,"addr":addr,
			"hidden":hidden,"postType":postType,"postId":postId},function(data){
			if(data==="true"){
				alert("提交成功！");
				clearTimeout(settime)
			}else{
				alert("提交失败，请稍后再试！")
			}
			$("#submitInfo").attr("value","提交");
			$("#submitInfo").attr("disabled",false);
		});
		
	});
	
	$("#resetInfo").click(function(){
		var conf = confirm("确定要清除所有内容");
		if(!conf){
			return false;
		}
		$("#title").val("");
		editor.html("");
		$("#addr").val("");
		$("#hidden").val("");
	});
});
