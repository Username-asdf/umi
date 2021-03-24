$(document).ready(function () {
	var height=$(document).height();
	$('.main').css('height',height);
})
$(function(){
	function testContentPhoneNum(){
		var test = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
		var thisval = $("#c_phoneNum");
		if(thisval.val()===""){
			thisval.next().html("手机号不能为空") ;
			thisval.attr("test","false");
			return false;
		}
		if(!test.test(thisval.val())){
			thisval.next().html("请输入正确的手机号");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().html("");
		thisval.attr("test","true");
	}
	$("#c_phoneNum").blur(testContentPhoneNum);
	function testContentPwd(){
		var thisval = $("input[name='pwd']");
		if(thisval.val()===""){
			thisval.next().html("密码不能为空");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().html("");
		thisval.attr("test","true");
	}
	$("input[name='pwd']").blur(testContentPwd);
	function testContentvalid(){
		var thisval = $("input[name='validCode']");
		if(thisval.val()===""){
			thisval.next().next().html("验证码不能为空");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().next().html("");
		thisval.attr("test","true");
	}
	$("input[name='validCode']").blur(testContentvalid);
	$(".xiayibu").click(function(){
		//检测各个输入框
		testContentPhoneNum();
		testContentPwd();
		testContentvalid();
		if($("input[name='phoneNum']").attr("test")==="true"&&
				$("input[name='pwd']").attr("test")==="true"&&
				$("input[name='validCode']").attr("test")==="true"){
			$("form").submit();
		}
	});
	
	$("#header-right").hover(function(){
		$(this)[0].style.color="red";
	});
	$("#header-right").mouseleave(function(){
		$(this)[0].style.color="#ccc";
	});
	$("#header-right").click(function(){
		$("#full")[0].style.display = "none";
	});
	$("#findpwd").click(function(){
		$("#full")[0].style.display = "block";
	});
	function testTkPhoneNum(){
		var test = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
		var thisval = $("#tk_phoneNum");
		if(thisval.val()===""){
			thisval.next().html("手机号不能为空") ;
			thisval.attr("test","false");
			return false;
		}
		if(!test.test(thisval.val())){
			thisval.next().html("请输入正确的手机号");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().html("");
		thisval.attr("test","true");
	}
	$("#tk_phoneNum").blur(testTkPhoneNum);
	$("#send").click(function(){
		var thisval = $("#send");
		var inp_phone = $("#tk_phoneNum");
		//检测手机号是否为空
		testTkPhoneNum();
		if(inp_phone.attr("test")==="false"){
			return false;
		}
		var test = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
		if(!test.test(inp_phone.val())){
			inp_phone.next().html("请输入正确的手机号");
			inp_phone.attr("test","false");
			return false;
		}
		
		var reSendTime = 60;
		thisval.attr("value","60秒后重发");
		thisval.attr("disabled","true");
		setInterval(function(){
			reSendTime--;
			thisval.attr("value",reSendTime+"秒后重发");
			thisval.attr("disabled",true);
			if(reSendTime<=0){
				thisval.attr("value","发送验证码");
				thisval.attr("disabled",false);
				return;
			}
		},1000);
		var phoneNum = inp_phone.val();
		var type = thisval.attr("smsType");
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
	function testTkValid(){
		var thisval = $("#tk_vaild");
		if(thisval.val()===""){
			thisval.next().next().html("验证码不能为空");
			thisval.attr("test","false");
			return false;
		}
		thisval.next().next().html("");
		thisval.attr("test","true");
	}
	$("#tk_vaild").blur(testTkValid);
	$("#ta1_td_inp_next").click(function(){
		//检测输入框
		testTkPhoneNum();
		testTkValid();
		
		if($("#tk_phoneNum").attr("test")==="true"&&
				$("#tk_vaild").attr("test")==="true"){
			$("#ta1_td_inp_next").attr("disabled",true);
			var phoneNum = $("#tk_phoneNum").val();
			var vaild = $("#tk_vaild").val();
			$.post("/umi/findPwd",{"phoneNum":phoneNum,"phoneValid":vaild},function(data){
				var span_msg = $("#ta1_bottom_msg");
				if(data==="true"){
					//TODO 弹框内容替换为输入新密码
					$(".tankuang_content")[0].innerHTML = nexttk;
					nextUpdPwd();
				}else if(data==="invaild"){
					span_msg[0].style.color = "red";
					span_msg.html("验证码已过期");
				}else{
					span_msg[0].style.color = "red";
					span_msg.html("验证码错误");
				}
				$("#ta1_td_inp_next").attr("disabled",false);
			});
		}
	});
	//$(".tankuang_content")[0].innerHTML = nexttk;
	
	
});

var nexttk = '<table id="ta1"><tr><td class="ta1_left">新密码:</td><td class="ta1_right"><input type="password" test="false" id="tk_pwd" maxlength="16" placeholder="请输入新密码" value="" /><div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div></td></tr><tr><td class="ta1_left">重复密码:</td><td class="ta1_right"><input type="password" test="false" id="tk_repwd" maxlength="16" placeholder="请重复输入密码" value="" /><div style="padding-left:5px;display:inline-block;height:25px;width:50px;font-size:10px;color:red;"></div></td</tr><tr><td colspan="2"  class="ta1_td_next"><input type="button" name="" id="ta1_td_inp_submit" value="确定" /></td></tr></table>';
var initTemp = false;
function testTkpwd(){
	var thisval = $("#tk_pwd");
	var pwdRegex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z]).{8,30}');
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
function testTkrepwd(){
	var thisval = $("#tk_repwd");
	if(thisval.val()!==$("#tk_pwd").val()){
		thisval.next().html("两次密码不一致");
		thisval.attr("test","false");
		return false;
	}
	thisval.next().html("");
	thisval.attr("test","true");
}
function nextUpdPwd(){
	if(!initTemp){
		$("#tk_pwd").blur(testTkpwd);
		$("#tk_repwd").blur(testTkrepwd);
		$("#ta1_td_inp_submit").click(function(){
			//检测输入框
			testTkpwd();
			testTkrepwd();
			
			if($("#tk_pwd").attr("test")==="true"&&
					$("#tk_repwd").attr("test")==="true"){
				
				$(this).attr("disabled",true);
				var pwd = $("#tk_pwd").val();
				$.post("/umi/findUpdPwd",{"newPwd":pwd},function(data){
					if(data==="true"){
						alert("修改密码成功");
					}else{
						alert("修改密码失败，请稍后再试");
					}
					$(".full")[0].style.display = "none";
				});
			}
			 
		});
	}
}