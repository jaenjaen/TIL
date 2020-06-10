<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% MemberVO member = (MemberVO) request.getAttribute("member"); %>
<title><%=member.getId() %> : 회원 검색</title>
</head>
<body>
<h3 align='center'><%=member.getId() %>님의 회원 정보입니다.</h3>
<hr>
<ul>
	<li>id : <%=member.getId() %></li>
	<li>이름 : <%=member.getName() %></li>
	<li>주소 : <%=member.getAddress() %></li>
</ul>
</body>
</html>