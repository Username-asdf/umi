<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="css/zhuce.css" type="text/css">
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript">
$(function(){
	function testphoneNum(){
		var test = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
		var thisval = $("#inp_phoneNum");
		var phoneNum = thisval.val();
		if(phoneNum===""){
			thisval.next().html("手机号不能为空");
			thisval.attr("test","false");
			return false;
		}
		if(!test.test(phoneNum)){
			thisval.next().html("请输入正确的手机号");
			thisval.attr("test","false");
			return false;
		}
		$.post("/umi/testPhone",{"phoneNum":phoneNum},function(data){
			if(data==="true"){
				//手机号已被注册
				thisval.next().html("手机号已被注册");
				thisval.attr("test","false");
			}else{
				thisval.next().html("");
				thisval.attr("test","true");
			}
		});
		
	}
	$("#inp_phoneNum").blur(testphoneNum);
	function testusername(){
		var thisval = $("#inp_username");
		var username = thisval.val();
		if(username===""){
			thisval.next().html("用户名不能为空");
			thisval.attr("test","false");
			return false;
		}
		$.post("/umi/testun",{"username":username},function(data){
			if(data==="true"){
				//用户名已被注册
				thisval.next().html("用户名已被注册");
				thisval.attr("test","false");
			}else{
				thisval.next().html("");
				thisval.attr("test","true");
			}
		});
		
	}
	
	$("#inp_username").blur(testusername);
	function testpwd(){
		var pwdRegex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z]).{8,30}');
		var thisval = $("#inp_pwd");
		if(thisval.val()===""){
			thisval.next().html("密码不能为空");
			thisval.attr("test","false");
			return false;
		}
		if(!pwdRegex.test(thisval.val())){
			thisval.next().html("您的密码复杂度太低");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().html("");
		thisval.attr("test","true");
	}
	$("#inp_pwd").blur(testpwd);
	$("#send").click(function(){
		var inp_phone = $("#inp_phoneNum");
		//检测手机号是否为空
		testphoneNum();
		if(inp_phone.attr("test")==="false"){
			return false;
		}
		if($("#send").attr("value")==="1"){
			return false;
		}
		var reSendTime = 60;
		$("#send").html("60秒后重发");
		$("#send").attr("value","1");
		setInterval(function(){
			reSendTime--;
			$("#send").html(reSendTime+"秒后重发");
			if(reSendTime<=0){
				$("#send").html("获取短信验证码");
				$("#send").attr("value","0");
				return;
			}
		},1000);
		var phoneNum = inp_phone.val();
		var type = $("#send").attr("smsType");
		$.post("/umi/phoneValid",{"phoneNum":phoneNum,"smsType":type},function(data){
			var span_msg = $("#ta1_bottom_msg");
			if(data==="true"){
				span_msg[0].style.color = "green";
				span_msg.html("验证码发送成功，请注意查收！");
			}else{
				span_msg[0].style.color = "red";
				span_msg.html("验证码发送失败，请稍后再试！");
			}
			setTimeout(function(){
				span_msg.html("");
			}, 5000);
		});
		
	});
	function testvalid(){
		var thisval = $("#inp_valid");
		if(thisval.val()===""){
			thisval.next().next().html("验证码不能为空");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().next().html("");
		thisval.attr("test","true");
	}
	$("#inp_valid").blur(testvalid);
	$(".zhucebtn").click(function(){
		//检测输入框
		testphoneNum();
		testusername();
		testpwd();
		testvalid();
		
		if($("#inp_phoneNum").attr("test")==="true"&&
				$("#inp_username").attr("test")==="true"&&
				$("#inp_pwd").attr("test")==="true"&&
				$("#inp_valid").attr("test")==="true"){
			$("form").submit();
		}
	});
});
</script>
</head>
<body background="images/1.jpg">
   <div class="main">
      <div class="main0">
         <div class="main_left">
             <img src="images/zhuce-image-3.png" class="theimg"/>
             <img src="images/zhuce-image-2.png" class="secimg"/>
             <img src="images/zhuce-image-1.png" class="firimg"/>
         </div>
         <form action="/umi/register" method="post">
         <div class="main_right">
            <div class="main_r_up">
               <img src="images/user.png" />
               <div class="pp">注册</div>
            </div>
            <div class="sub"><p>已经注册？<a href="login.html"><span class="blue">请登录</span></a><a href="../umi" style="color:#31acfb;padding-left: 15px;">返回主页</a></p></div>  
            <div class="txt">
            <span style="letter-spacing:8px;">手机号:</span>
            <input type="text" name="phoneNum" class="phoneNum" id="inp_phoneNum" test="false" placeholder="请输入手机号码"/>
            <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
            </div>
            <div class="txt">
            <span style="letter-spacing:8px;">用户名:</span>
            <input type="text" name="username" class="phoneNum" id="inp_username" test="false" placeholder="请输入用户名" />
            <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
            </div>
            <div class="txt">
            <span style="letter-spacing:15px;">密码:</span>
            <input type="text" name="pwd" class="phoneNum" id="inp_pwd" test="false" placeholder="请输入密码"/>
            <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
            </div>
            <div class="txt">
            <span style="letter-spacing:8px;">验证码:</span>
            <input type="text" name="phoneValid" placeholder="请输入验证码" id="inp_valid" test="false" value="" />
            <a href="javascript:void(0);" class="tipTimer" smsType="mode_register" value="0" id="send">获取短信验证码</a>
            <div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div>
            </div>
            <div class="text txt0">             
               <div class="zhucebtn">确认注册</div>
               <br/><br/>
               <span style="color:red;" id="ta1_bottom_msg">${requestScope.info}</span>
            </div>
         </div>
         </form>
      </div>      
   </div>
</body>
</html>