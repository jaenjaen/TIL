<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.num1 == '1'}">
			<h2>반갑습니다!</h2>
		</c:when>
		<c:when test="${param.num1 == '2'}">
			<h2>처음 뵙겠습니다.</h2>
		</c:when>
		<c:when test="${param.num1 == '3'}">
			<h2>또 오셨네요</h2>
		</c:when>
		<c:otherwise> <h2>회원가입 하시겠습니까?</h2> </c:otherwise>
	</c:choose>
</body>
</html>