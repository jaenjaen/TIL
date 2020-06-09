<%@page import="servelt.model.user.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOUT</title>
<c:choose>
	<c:when test="${vo!=null}">
		session.invalidate();
		<script>
			alert("LogOut!!");
			location.href="login.html";
		</script>
	</c:when>
	<c:otherwise>
		<b><a href='login.html'>로그인하기</a></b>
	</c:otherwise>
</c:choose>
</head>
<body>
</body>
</html>