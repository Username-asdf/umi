$(function(){
	$("#search").click(function(){
		var condition = $("#condition").val();
		location.href = "/umi/search?condition="+condition;
		//$.post("/umi/search",{"condition":condition});
	});
});