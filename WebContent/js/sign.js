$(function(){
	$("#signIn").click(function(){
		var value = $("#signIn").html();
		if(value==="已签到"){
			return false;
		}
		var settime = setTimeout(function(){
			alert("签到失败，请稍后再试！");
		}, 5000);
		$.post("/umi/sign",{"data":"data"},function(data){
			if(data==="true"){
				$("#signIn")[0].innerHTML="已签到";
				alert("签到成功！");
				clearTimeout(settime);
			}else{
				alert("签到失败，请稍后再试！");
			}
		});
	});
});