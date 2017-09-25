<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>编辑用户信息</title>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<%@include  file="commen.jsp" %>
<script type="text/javascript" src="/ticket/js/userinfo.validata.js"></script>
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
<div class="title"><h1>修改信息</h1></div>
<div class="clear"></div>
<div class="table">
   <div class="list2 ">
   <form name="userForm" method="post" id="commentForm" action="/ticket/user/update">
   <label>${msg}</label>
   <ul>
   <li><h1>用户名：</h1><h2><input name="userInfo.username" type="text" class="input" id="username" value="${userInfo.username}" maxlength="20" readonly><span style="color:#ff0000;">&nbsp;*</span></h2></li>
   <li><h1>昵称：</h1><h2><input name="userInfo.name" type="text" class="input" id="name" value="${userInfo.name}" maxlength="30" readonly><span style="color:#ff0000;">&nbsp;*</span></h2></li>
   <li><h1>新密码：</h1><h2><input name="newpassword" type="password" class="input" id="newpassword" maxlength="30"></h2></li>
   <li><h1>确认密码：</h1><h2><input name="checkpassword" type="password" class="input" id="checkpassword" maxlength="30"></h2></li>
   <c:if test="${userInfoDetail.gender=='male' }">
	   	<li><h1>性别：</h1><h2><input name="userInfoDetail.gender" value="male" type="radio"  style="border:0 " checked="checked">先生&nbsp;&nbsp;&nbsp;
							 <input name="userInfoDetail.gender" value="woman" type="radio" style="border:0 ">女士</h2></li>
   </c:if>
   <c:if test="${userInfoDetail.gender!='male' }">
	   	<li><h1>性别：</h1><h2><input name="userInfoDetail.gender" value="male" type="radio"  style="border:0 " >先生&nbsp;&nbsp;&nbsp;
							 <input name="userInfoDetail.gender" value="woman" type="radio" style="border:0 " checked="checked">女士</h2></li>
   </c:if>
	
   <li><h1>电子邮箱：</h1><h2><input name="userInfoDetail.email" type="text" class="input" id="userInfoDetail.email" value="${userInfoDetail.email}" maxlength="40"></h2></li>
   <li><h1>联系电话：</h1><h2><input name="userInfoDetail.contactNumber" type="text" class="input" id="userInfoDetail.contactNumber" value="${userInfoDetail.contactNumber }" maxlength="30"></h2></li>
   <li><h1>手机：</h1><h2><input name="userInfoDetail.mobilePhone" type="text" class="input" id="userInfoDetail.mobilePhone" value="${userInfoDetail.mobilePhone }" maxlength="30"></h2></li>
   <li><h1>QQ：</h1><h2><input name="userInfoDetail.qq" type="text" class="input" id="userInfoDetail.qq" value="${userInfoDetail.qq }" maxlength="30"></h2></li>

   <li><h1>&nbsp;</h1><h2><input name="submit" type="submit" class="btn" value="确定提交">
			<input type="hidden" name="userInfo.uid" value="${userInfo.uid}"></h2></li>
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
