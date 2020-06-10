<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% MemberVO vo = (MemberVO)session.getAttribute("vo"); 
   if(vo==null){
%>
	<h3>로그인이 필요합니다.</h3>
	<a href="login.html">로그인 페이지로 이동</a>
<%}%>
<head>
<meta charset="UTF-8">
<title>Login 결과</title>
</head>
<body>
<h2>Login Information...</h2>
Login Id : <b><%=vo.getId() %></b> <br>
Login 이름 : <b><%=vo.getName() %></b> <br>
Login 주소 : <b><%=vo.getPassword() %></b> <br>
JSESSION ID VALUE <b><%=session.getId() %></b> <br>
<hr>
<a href='logout.jsp'>Log OUT</a>&nbsp;
<a href='index.html'>INDEX</a>
</body>
</html>