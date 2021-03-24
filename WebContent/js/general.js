/**
 * 改变验证码
 */
function changeVaildCode(ele){
	$(ele).attr("src","valid?date="+new Date());
}
/**
 * 发送手机验证码
 */
$(function(){
//	$("#send").click(function(){
//		var reSendTime = 60;
//		$("#send").attr("value","60秒后重发");
//		$("#send").attr("disabled","true");
//		setInterval(function(){
//			reSendTime--;
//			$("#send").attr("value",reSendTime+"秒后重发");
//			$("#send").attr("disabled",true);
//			if(reSendTime<=0){
//				$("#send").attr("value","发送验证码");
//				$("#send").attr("disabled",false);
//				return;
//			}
//		},1000);
//		var phoneNum = $("#phoneNum").val();
//		var type = $("#send").attr("smsType");
//		$.post("phoneValid",{"phoneNum":phoneNum,"smsType":type},function(data){
//			if(data==="true"){
//				alert("验证码发送成功!");
//			}else{
//				alert("验证码发送失败，请稍后再试！");
//			}
//		});
//		
//	});
	
	
//	$("#findUpdPwd_submit").click(function(){
//		var newPwd = $("#newPwd").val();
//		var reNewPwd = $("#reNewPwd").val();
//		if(newPwd==""||reNewPwd==""){
//			return false;
//		}
//		if(newPwd!==reNewPwd){
//			alert("两次密码不一致");
//			return false;
//		}
//		$("#findUpdPwd_submit").attr("value","正在提交...");
//		$("#findUpdPwd_submit").attr("disabled",true);
//		var settime = setTimeout(function(){
//			alert("修改密码失败，请稍后再试！")
//			$("#findUpdPwd_submit").attr("value","提交");
//			$("#findUpdPwd_submit").attr("disabled",false);
//		}, 5000);
//		$.post("findUpdPwd",{"newPwd":newPwd},function(data){
//			if(data==="true"){
//				alert("修改密码成功！");
//				location.href="/umi/login";
//				clearTimeout(settime);
//			}else{
//				alert("修改密码失败，请稍后再试！")
//				$("#findUpdPwd_submit").attr("value","提交");
//				$("#findUpdPwd_submit").attr("disabled",false);
//			}
//		});
//	});
	
	
});