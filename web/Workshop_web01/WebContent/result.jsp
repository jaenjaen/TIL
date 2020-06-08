<%@page import="servelt.model.book.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>결과 페이지</h2>
	<h3><%=request.getParameter("title")%>가 정상적으로 저장 되었습니다.</h3>
	<footer>
		<a href='book/Book.html'>추가 등록</a>
		<a href='#'>도서 목록</a>
	</footer>
</body>
</html>