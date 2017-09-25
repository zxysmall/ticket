<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="org.apache.shiro.subject.Subject" %>
<%@page import="org.apache.shiro.SecurityUtils" %>
<%@page import="com.yy.core.bean.UserInfo" %>
<%@page import="com.yy.ticket.content.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Subject sb2 =  SecurityUtils.getSubject();
	UserInfo ui2 = (UserInfo) sb2.getPrincipal();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
</head>
<body>
<div class="ticket_box">
	<div class="ticket">
		<div class="ticket_column">
			<a href="" class="main_column">后台管理</a>
			<ul class="cloumn_box">
	<%if(ui2.getRoleList().size() == 0 || BusiContent.TICKET.equals(ui2.getRoleList().get(0).getRole())) {%>
			<c:choose>
				<c:when test="${menu eq 'allOrder' }">
					<li class="column current">
					     <a href="/ticket/allOrder">
					         <img src="/ticket/image/c3.png">
					         <p class="column_text">所有订票详情</p>
					      </a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="column">
					     <a href="/ticket/allOrder">
					         <img src="/ticket/image/c3.png">
					         <p class="column_text">所有订票详情</p>
					      </a>
					</li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${menu eq 'alreadyExistsOrder' }">
					<li class="column current">
					      <a href="/ticket/alreadyExistsOrder">
					          <img src="/ticket/image/c1.png">
					          <p class="column_text">我已出的票</p>
					      </a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="column">
					      <a href="/ticket/alreadyExistsOrder">
					          <img src="/ticket/image/c1.png">
					          <p class="column_text">我已出的票</p>
					      </a>
					</li>
			    </c:otherwise>
			</c:choose>
	<%};
	if(ui2.getRoleList().size() == 0 || BusiContent.TICKET_AGENT.equals(ui2.getRoleList().get(0).getRole())) {%>
			<c:choose>
				<c:when test="${menu eq 'addOrderInfo' }">
					<li class="column current">
					      <a href="/ticket/addOrderInfo">
					          <img src="/ticket/image/c6.png">
					          <p class="column_text">添加订单信息</p>
					      </a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="column">
					      <a href="/ticket/addOrderInfo">
					          <img src="/ticket/image/c6.png">
					          <p class="column_text">添加订单信息</p>
					      </a>
					</li>
				</c:otherwise>
			</c:choose>	
	<%}%>
	<% if(ui2.getRoleList().size() == 0 || BusiContent.TICKET.equals(ui2.getRoleList().get(0).getRole())) {%>
			<c:choose>
				<c:when test="${menu eq 'statistics' }">
					<li class="column current">
					      <a href="/ticket/statistics">
					          <img src="/ticket/image/c2.png">
					          <p class="column_text">出票情况</p>
					      </a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="column">
					      <a href="/ticket/statistics">
					          <img src="/ticket/image/c2.png">
					          <p class="column_text">出票情况</p>
					      </a>
					</li>
				</c:otherwise>
			</c:choose>
			<% if(BusiContent.ADMIN.equals(ui2.getUsername())) {%>
			<c:choose>
				<c:when test="${menu eq 'addUserInfo' }">
					<li class="column current">
					     <a href="/ticket/addUserInfo">
					         <img src="/ticket/image/c5.png">
					         <p class="column_text">添加售票员</p>
					     </a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="column">
					     <a href="/ticket/addUserInfo">
					         <img src="/ticket/image/c5.png">
					         <p class="column_text">添加售票员</p>
					     </a>
					</li>
				</c:otherwise>
			</c:choose>
			<%} %>
			<c:choose>
				<c:when test="${menu eq 'updateUserInfo' }">
					<li class="column current">
					     <a href="/ticket/updateUserInfo">
					         <img src="/ticket/image/c4.png">
					         <p class="column_text">修改信息</p>
					     </a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="column">
					     <a href="/ticket/updateUserInfo">
					         <img src="/ticket/image/c4.png">
					         <p class="column_text">修改信息</p>
					     </a>
					</li>
				</c:otherwise>
				</c:choose>
	<%} %>
				<div class="clearfix"></div>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>	
</body>
</html>