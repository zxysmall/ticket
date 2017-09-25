<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>已出的票</title>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
function searchData(opt)
{
	 var param = "status=0&searchId=";
		if($("#search_id").val()!=null)
		{
			param += $("#search_id").val();
		}
	 	if(opt != null || opt != '')
 		{
 			if(opt=='nextPage') param += "&pageNum=" + (parseInt($("#pageNum").val()) + 1);
 			if(opt=='proPage') param += "&pageNum=" + (parseInt($("#pageNum").val()) - 1);
 			if(opt=='lastPage') param += "&pageNum="+$("#pages").val();
 		}
	var htmlobj=$.ajax({url:"order/findAll",
		  dataType:'json',
		  data:param+"&number="+Math.random(),
		  type:"get",
		  timeout:1000,
		  async:false});
	  $("#datagride").html("");
	  $.each(htmlobj.responseJSON.list,function (index, item) { 
	     //循环获取数据 
	     var data = htmlobj.responseJSON.list[index];
	     var id = data.id; 
	     var date = data.date; 
	     var time = data.time; 
	     var ticketPerson = data.ticketPerson; 
	     var ticketPersonIdentity = data.ticketPersonIdentity; 
	     var singleNum = data.singleNum; 
	     var singleNumPrivilege = data.singleNumPrivilege; 
	     var doubleNum = data.doubleNum; 
	     var doubleNumPrivilege = data.doubleNumPrivilege; 
	     var status = data.status; 
	     var ticketNumlabel = data.ticketNumlabel; 
	     var htmlLabel = $("#datagride").html() +
		 "<li><h1 style=\"line-height:17px;\">"+date+"<br/>"+ "<span style=\"color:#bbbbbb;\">" +time+ "</span></h1>"+
		 "<h2>"+ticketPerson+"[" +ticketPersonIdentity+ "]</h2>"+
		 "<h4>"+ticketNumlabel+"</h4>";
		 if(status == 0)
			 htmlLabel += "<h3>已出</h3></li>";
		 else
			 htmlLabel += "<h3><a href=\"#\" onclick=\"toCreateTicketNum("+id+")\">出票</a></h3></li>";
			 
	     $("#datagride").html(htmlLabel); 
	    });
	  $("#total").html("共"+htmlobj.responseJSON.total+"条");
	  $("#pageindex").html(htmlobj.responseJSON.pageNum +"/"+ htmlobj.responseJSON.pages );
	  $("#pageNum").val(htmlobj.responseJSON.pageNum);
	  $("#pages").val(htmlobj.responseJSON.pages);
	  if(htmlobj.responseJSON.pageNum == htmlobj.responseJSON.pages)
	  {
		  $("#nextPage").removeAttr('onclick');//去掉a标签中的onclick事件
		  $("#lastPage").removeAttr('onclick');//去掉a标签中的onclick事件
	  }else{
		  $('#nextPage').attr('onclick',"searchData('nextPage')");
		  $('#lastPage').attr('onclick',"searchData('lastPage')");
	  }
	  if(htmlobj.responseJSON.pageNum == 1)
	  {
		  $("#proPage").removeAttr('onclick');//去掉a标签中的onclick事件
	  }else{
		  $('#proPage').attr('onclick',"searchData('proPage')");
	  }
};

$(document).ready(function(){
	searchData();
  $("#search_img").click(function(){
	  searchData()
  });
});
</script>
</head>
<body>
<%@include file="head.jsp" %>

<form action="">
	<div class="search_box">
		<div class="search">
			<a class="logo"><img src="image/logo.png"></a>
			<input id="search_id" value="" placeholder= "请输入身份证后四位" type="text">
			<a class="search_btn"><img id="search_img" src="image/search_icon.png"></a>
		</div>
		<div class="clearfix"></div>
	</div>
</form>	
<%@include file="menu.jsp" %>
<div class="ticket_list">
	<div class="list_box">
	<div class="title"><h1>订票信息</h1></div>
	<div class="clear"></div>
	<div class="table">
		<div class="list " id="orderList">
		      <div class="tit"><li><h1>日期</h1><h2>姓名</h2><h4>票数</h4><h3>操作</h3></li></div>
		   <ul id="datagride">
		   </ul>
		   <div class="clear"></div>
		   <div class="clear20"></div>
		   <div class='pagesBox'>
		   	   <input id="pageNum" type="hidden" value="1"/>
		   	   <input id="pages" type="hidden" value="" />
			   <span class='all' id="total">**</span>
			   <span class='pageindex' id="pageindex">**</span>
			   <a id="proPage" href="#" onclick="searchData('proPage')">上一页</a>
			   <a id="nextPage" href="#" onclick="searchData('nextPage')">下一页</a>
			   <a id="lastPage" href='#' onclick="searchData('lastPage')">尾页</a>
		   </div>
		   
		</div>
	</div>
	<div class="clear"></div>
	</div>
</div>
<div class="clearfix"></div>
</body>
</html>