<%@page import="servelt.model.book.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과페이지</title>
<style>
	body{
		text-align: center;
	}
	footer{
		background-color: #CDD4D2;
		padding: 10px 0;
		
		
	}
</style>
</head>

<body>
	<c:choose>
		<c:when test="${vo != null}">
			<h2>결과 페이지</h2>
			<h3>${param.title}가 정상적으로 저장 되었습니다.</h3>
			<footer>
				<a href='book/book.jsp'>추가 등록</a>
				<a href='front.do?command=booklist'>도서 목록</a>
			</footer>
		</c:when>
		<c:otherwise>
			<h2>로그인 하십시오</h2>
			<a href='login.jsp'>로그인 페이지로</a>
		</c:otherwise>
	</c:choose>
</body>
</html>