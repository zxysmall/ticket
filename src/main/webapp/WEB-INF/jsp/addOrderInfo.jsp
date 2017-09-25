<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加订单信息</title>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<%@include  file="commen.jsp" %>
<script type="text/javascript" src="/ticket/js/validata.js" ></script>
<script src="/ticket/js/validata.submithander.js" type="text/javascript"></script>

</head>
<body>
<%@include file="head.jsp" %>
	
<div class="search_box">
	<div class="search">
		<a href="" class="logo"><img src="/ticket/image/logo.png"></a>
	</div>
	<div class="clearfix"></div>
</div>
<%@include file="menu.jsp" %>
	
<div class="main">
<div class="title"><h1>添加订单</h1></div>
<div class="clear"></div>
<div class="table">
   <div class="list2 ">
   <form  class="cmsform"  id="commentForm" method="post" action="/ticket/order/save">
   <ul>
   <li><h1><label for="ticketPerson">取票人姓名</label><em class="error">*</em>：</h1><h2>
   <input name="ticketPerson" type="text" class="input" id="ticketPerson" required>
   </h2></li>
   <li><h1><label for="ticketPersonIdentity">身份证</label><em class="error">*</em>：</h1><h2>
   <input name="ticketPersonIdentity" type="text" class="input" id="ticketPersonIdentity" required>
   </h2></li>
   <li><h1><label for="ticketPersonPhone">取票人电话</label><em class="error">*</em>：</h1><h2>
   <input name="ticketPersonPhone" type="text" class="input" id="ticketPersonPhone" required>
   </h2></li>
   <li><h1>单票数：</h1><h2><input name="singleNum" type="text" class="input" id="singleNum"></h2></li>
   <li><h1>单优票数：</h1><h2> <input name="singleNumPrivilege" type="text" class="input" id="singleNumPrivilege"></h2></li>
   <li><h1>双票数：</h1><h2><input name="doubleNum" type="text" class="input" id="doubleNum"></h2></li>
   <li><h1>双优票数：</h1><h2><input name="doubleNumPrivilege" type="text" class="input" id="doubleNumPrivilege"></h2></li>
  

   <li><h1>&nbsp;</h1><h2><input name="submit" type="submit" class="btn" value="确定提交"></h2></li>
   </ul>
   </form>
   <div class="clear"></div>
   </div>
       <div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
</body>
</html>
