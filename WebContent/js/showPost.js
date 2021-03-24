$(function(){
	$(".more").mouseleave(function(){
		$(this).attr("hidden",true);
	});
	$(".report-button").hover(function(){
		$(this)[0].style.color = "#1890ff";
		$(this)[0].style.background = "#CCC";
	});
	$(".report-button").mouseleave(function(){
		$(this)[0].style.color = "";
		$(this)[0].style.background = "";
	});
	$(".comment-ope-zan").hover(function(){
		var value = $(this).attr("value");
		if(value==0){
			$(this).attr("src","/umi/images/zan2.png");
		}
	});
	$(".comment-ope-zan").mouseleave(function(){
		var value = $(this).attr("value");
		if(value==0){
			$(this).attr("src","/umi/images/zan1.png");
		}
	});
	$(".comment-ope-zan").click(function(){
		if(!login){
			alert("请先登录！");
			return;
		}
		
		var postval = $(this).attr("postval");
		if(postval==="1"){
			return false;
		}
		var value = $(this).attr("value");
		var selfValue = $(this);
		//
		var commId = $(this).parent().parent().parent().parent().attr("commid");
		
		if(value==0){
			var next = $(this).next().next();
			if(next.attr("value")==1){
				next.attr("value",0);
				next.attr("src","/umi/images/cai1.png");
				next.next().html(Number(next.next().html())-1);
			}
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uclNum",{"type":1,"commId":commId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/zan3.png");
					selfValue.next("span").html(Number(num)+1);
					selfValue.attr("value",1);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}else{
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uclNum",{"type":0,"commId":commId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/zan1.png");
					selfValue.next("span").html(Number(num)-1);
					selfValue.attr("value",0);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}
	});
	$(".comment-ope-cai").hover(function(){
		var value = $(this).attr("value");
		if(value==0){
		$(this).attr("src","/umi/images/cai2.png");
		}
	});
	$(".comment-ope-cai").mouseleave(function(){
		var value = $(this).attr("value");
		if(value==0){
		$(this).attr("src","/umi/images/cai1.png");
		}
	});
	$(".comment-ope-cai").click(function(){
		if(!login){
			alert("请先登录！");
			return;
		}
		
		var postval = $(this).attr("postval");
		if(postval==="1"){
			return false;
		}
		var value = $(this).attr("value");
		var selfValue = $(this);
		//
		var commId = $(this).parent().parent().parent().parent().attr("commid");
		
		if(value==0){
			var prev = $(this).prev().prev();
			var prevalue = prev.attr("value");
			if(prevalue==1){
				prev.attr("value",0);
				prev.next().html(Number(prev.next().html())-1)
				prev.attr("src","/umi/images/zan1.png");
			}
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uchNum",{"type":1,"commId":commId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/cai3.png");
					selfValue.next("span").html(Number(num)+1);
					selfValue.attr("value",1);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}else{
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uchNum",{"type":0,"commId":commId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/cai1.png");
					selfValue.next("span").html(Number(num)-1);
					selfValue.attr("value",0);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}
	});
	$(".comment-ope-more").hover(function(){
		$(this).attr("src","/umi/images/a1.png");
	});
	$(".comment-ope-more").mouseleave(function(){
		$(this).attr("src","/umi/images/a.png");
	});
	$(".comment-ope-more").click(function(){
		$(this).next().attr("hidden",false);
	});
	$(".reply").hover(function(){
		$(this)[0].style.color = "#1890ff";
		$(this)[0].style.background = "#CCC";
	});
	$(".reply").mouseleave(function(){
		$(this)[0].style.color = "";
		$(this)[0].style.background = "";
	});
	$(".reply").click(function(){
		var value = $("#comment3").attr("id");
		if(value==null){
			var username = $(this).parent().parent().parent().parent().attr("username");
			$(this).parent().parent().parent().parent().after('<tr id="comment3"><td></td><td class="white"><div id="kindeditor"><textarea class="kindedito" id="kindedito2" name="post" rows="10" cols="94" >@'+username+':</textarea></div><div style="text-align: right; padding-right: 20px;padding-top: 20px;"><input type="button" class="comment-submit" name="" onclick="kindedito2(this)" id="comment-submit" value="发布评论" /></div></td></tr>');
		KindEditor.ready(function(K) {
      editor2 = K.create('#kindedito2', {
      allowImageUpload : true,
      items : [
           'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic',
   　　　　 'underline', 'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright',
  　　　　  'insertorderedlist', 'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
        uploadJson : "/umi/upload",
        fileManagerJson : '/umi/showUpload',
        allowFileManager : true
      });
		
    });
		}else{
			$("#comment3").replaceWith("");
		}
		
	});
	
	$(".report-button").click(function(){
		if(!login){
			alert("请先登录！");
			return;
		}
		
		var postval = $(this).attr("postval");
		if(postval==="1"){
			return false;
		}
		
		var commId = $(this).parent().parent().parent().parent().parent().attr("commid");
		
		var val = $(this).attr("value");
		if(val==="0"){
			var conf = confirm("要举报这个评论吗？");
			if(conf){
				$.post("/umi/commReport",{"commId":commId},function(data){
					if(data==="true"){
						alert("举报已成功提交！");
					}else{
						alert("您已经举报过了！");
					}
				});
			}
		}else{
			var conf = confirm("要删除这个评论吗？");
			if(conf){
				$.post("/umi/delComm",{"commId":commId},function(data){
					if(data==="true"){
						alert("成功删除评论！");
						location.href = location.href;
					}else{
						alert("请稍后再试！");
					}
				});
			}
		}
		
	});
	
	//板块赞，踩，举报
	$("#postLike").click(function(){
		var value = $(this).attr("value");
		var selfValue = $(this);
		
		if(value==0){
			var next = $(this).next().next();
			if(next.attr("value")==1){
				next.attr("value",0);
				next.attr("src","/umi/images/cai1.png");
				next.next().html(Number(next.next().html())-1);
			}
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uplNum",{"type":1,"postId":postId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/zan3.png");
					selfValue.next("span").html(Number(num)+1);
					selfValue.attr("value",1);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}else{
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uplNum",{"type":0,"postId":postId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/zan1.png");
					selfValue.next("span").html(Number(num)-1);
					selfValue.attr("value",0);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}
	});
	$("#postHate").click(function(){
		var value = $(this).attr("value");
		var selfValue = $(this);
		//
		if(value==0){
			var prev = $(this).prev().prev();
			var prevalue = prev.attr("value");
			if(prevalue==1){
				prev.attr("value",0);
				prev.next().html(Number(prev.next().html())-1)
				prev.attr("src","/umi/images/zan1.png");
			}
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uphNum",{"type":1,"postId":postId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/cai3.png");
					selfValue.next("span").html(Number(num)+1);
					selfValue.attr("value",1);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}else{
			var num = $(this).next("span").html();
			
			//
			$.post("/umi/uphNum",{"type":0,"postId":postId},function(data){
				if(data==="true"){
					selfValue.attr("src","/umi/images/cai1.png");
					selfValue.next("span").html(Number(num)-1);
					selfValue.attr("value",0);
				}else if(data==="noLogin"){
					alert("请先登录！");
				}else{
					alert("请稍后再试！");
				}
			});
		}	
	});
	$("#post-report-btn").click(function(){
		if(!login){
			alert("请先登录！");
			return;
		}
	
		var val = $(this).attr("value");
		if(val==="0"){
			var conf = confirm("要举报这个板块吗？");
			if(conf){
				$.post("/umi/postReport",{"postId":postId},function(data){
					if(data==="true"){
						alert("举报已成功提交！");
					}else{
						alert("您已经举报过了！");
					}
				});
			}
		}else{
			var conf = confirm("要删除这个板块吗？");
			if(conf){
				$.post("/umi/delPassPost",{"postId":postId},function(data){
					if(data==="true"){
						alert("删除成功！");
						location.href = "/umi/index";
					}else{
						alert("请稍后再试！");
					}
				});
			}
		}
		
	});
});


function kindedito1(ele){
	if(!login){
		alert("请先登录！");
		return;
	}
	
	$(ele).attr("value","正在提交...");
	$(ele).attr("disabled",true);
	var setTime = setTimeout(function(){
		alert("发布评论失败，请稍后再试！");
		$(ele).attr("value","发布评论");
		$(ele).attr("disabled",false);
	},5000);
	var ehtml = editor1.html();
	$.post("/umi/comment",{"comm":ehtml,"fkCommId":0,"postId":postId},function(data){
		if(data==="true"){
			alert("发布评论成功！");
			location.href = location.href;
		}else{
			alert("发布评论失败，请稍后再试！");
		}
		clearTimeout(setTime);
		$(ele).attr("value","发布评论");
		$(ele).attr("disabled",false);
	});
}
function kindedito2(ele){
	if(!login){
		alert("请先登录！");
		return;
	}
	
	$(ele).attr("value","正在提交...");
	$(ele).attr("disabled",true);
	var setTime = setTimeout(function(){
		alert("发布评论失败，请稍后再试！");
		$(ele).attr("value","发布评论");
		$(ele).attr("disabled",false);
	},5000);
	var fkCommId = $(ele).parent().parent().parent().prev().attr("commid");
	var ehtml = editor2.html();
	
	$.post("/umi/comment",{"comm":ehtml,"fkCommId":fkCommId,"postId":postId},function(data){
		if(data==="true"){
			alert("发布评论成功！");
			location.href = location.href;
		}else{
			alert("发布评论失败，请稍后再试！");
		}
		clearTimeout(setTime);
		$(ele).attr("value","发布评论");
		$(ele).attr("disabled",false);
	});
}
