$(function(){
	$("#updPwd_submit").click(function(){
		var pwd = $("#pwd").val();
		var newPwd = $("#newPwd").val();
		var reNewPwd = $("#reNewPwd").val();
		if(newPwd==""||reNewPwd==""||pwd==""){
			return false;
		}
		if(newPwd!==reNewPwd){
			alert("两次密码不一致");
			return false;
		}
		$(this).attr("value","正在提交...");
		$(this).attr("disabled",true);
		var settime = setTimeout(function(){
			alert("修改密码失败，请稍后再试！")
			$("#updPwd_submit").attr("value","提交");
			$("#updPwd_submit").attr("disabled",false);
		}, 5000);
		$.post("/umi/updPwd",{"pwd":pwd,"newPwd":newPwd},function(data){
			if(data==="true"){
				alert("修改密码成功，请重新登录！");
			    top.location.href = "/umi/login";
			    clearTimeout(settime);
			}else{
				alert("修改密码失败，请稍后再试！")
				$("#updPwd_submit").attr("value","提交");
				$("#updPwd_submit").attr("disabled",false);
			}
		});
	});
});