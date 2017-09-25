<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>统计票数</title>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" type="text/css" href="css/statistics.css" />
<script type="text/javascript" src="jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="jquery/laydate/laydate.dev.js"></script>
<script type="text/javascript">
function searchData()
{
	var param = "startTime=";
	if($("#startTime").val()!=null)
	{
		param += $("#startTime").val();
	}
	if($("#endTime").val()!=null)
	{
		param +="&endTime=" + $("#endTime").val();
	}
	var htmlobj=$.ajax({url:"order/findStatistics",
		  dataType:'json',
		  data:param+"&number="+Math.random(),
		  type:"get",
		  timeout:1000,
		  async:false});
	if(htmlobj.responseJSON != null){
	  $("#singleNum").html(htmlobj.responseJSON.singleNum);
	  $("#singleNumPrivilege").html(htmlobj.responseJSON.singleNumPrivilege);
	  $("#doubleNum").html(htmlobj.responseJSON.doubleNum);
	  $("#doubleNumPrivilege").html(htmlobj.responseJSON.doubleNumPrivilege);
	  $("#username").html("【"+htmlobj.responseJSON.username+"】");
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
	
<div class="search_box">
	<div class="search">
		<a href="" class="logo"><img src="image/logo.png"></a>
	</div>
	<div class="clearfix"></div>
</div>
<%@include file="menu.jsp" %> 
	
<div class="main">
<div class="title"><h1>出票情况统计</h1></div>
<div class="clear"></div>
<div class="search2">
<form action="" id="search_form2" method="get">
 <div style="padding-left:15px;">
   <li style="line-height:20px; height:60px;">&nbsp;开始时间<input id='startTime' class='input' type='text' name='startTime'/></li>
   <div class="clear"></div>
   <li style="line-height:20px; height:80px;">&nbsp;结束时间<input id='endTime' class='input' type='text'  name='endTime'/></li>
   <div class="clear"></div>
   <li>
   <input type="button" class="btn2" value="搜索" onclick="searchData()"></li>
 </div>
</form>
<div class="table">
   <div class="list2 ">
   <ul>
	 <li style=" height:100px; line-height:24px;"><h1><label id="username"></label>总出票数：</h1>
	 <h2>单程票数：<label id="singleNum">0</label> <br />
	 	单程优票数：<label id="singleNumPrivilege">0</label><br />
	 	双程票数：<label id="doubleNum">0</label><br />
	 	双程优票数：<label id="doubleNumPrivilege">0</label></h2></li>
   </ul>
   <div class="clear"></div>
   </div>
</div>
</div>
<div class="clear"></div>
</div>
<script type="text/javascript">
        laydate({
            elem: '#startTime'
        });
        laydate({
            elem: '#endTime'
        });
    </script>
</body>
</html>
    