<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.shiro.subject.Subject" %>
<%@page import="org.apache.shiro.SecurityUtils" %>
<%@page import="com.yy.core.bean.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Subject sb =  SecurityUtils.getSubject();
	UserInfo ui = (UserInfo) sb.getPrincipal();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HEAD</title>
</head>
<body>
<div class="top_box">
    <div class="top_nav">
	<span>当前登录账号：<%=ui.getUsername() %></span>
	<span><a class="exit_login"  href="/ticket/updateUserInfo">修改信息</a></span>
	<span class="exit_login" onclick="logout"><a class="exit_login" href="logout">退出登录</a></span>
	</div>
	<div class="clearfix"></div>
</div>
</body>
</html>