<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${vo!=null}">
		<b>${vo.name}님 로그인 성공!</b>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인부터 해주세요!");
			location.href="login.html";
		</script>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Login 결과</title>
</head>
<body>
<h2>Login Information...</h2>
Login Id : <b>${vo.id}</b> <br>
Login 이름 : <b>${vo.name}</b> <br>
Login 주소 : <b>${vo.password}</b> <br>
JSESSION ID VALUE <b><%=session.getId() %></b> <br>
<hr>
<a href='logout.jsp'>Log OUT</a>&nbsp;
<a href='index.html'>INDEX</a>
</body>
</html>