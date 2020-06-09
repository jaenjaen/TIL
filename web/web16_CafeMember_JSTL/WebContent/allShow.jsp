<%@page import="java.util.List"%>
<%@page import="servlet.model.MemberVO"%>
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
	<c:if test="${param.id != null}">
		<h2>r${param.id}님이 회원으로 등록하셨습니다.</h2>
	</c:if>
	<hr>
	<h2>전체 카페 회원 명단</h2>
	<table>
		<tr>
			<th>아이디</th> <th>이름</th> <th>주소</th>
		</tr>
		<c:forEach items="${members}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.address}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
</body>
</html>