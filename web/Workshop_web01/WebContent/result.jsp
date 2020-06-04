<%@page import="book.model.BookVo"%>
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
	<% 
		BookVo book = (BookVo)request.getAttribute("book");
		System.out.println(book.toString());
	%>
	<h2>결과 페이지</h2>
	<h3><%=book.getTitle()%>가 정상적으로 저장 되었습니다.</h3>
	<p>도서번호: <%=book.getTitle()%><br>
	도서종류: <%=book.getKinds()%><br>
	저자: <%=book.getWriter()%><br></p>
	<footer>
		<a href='book.html'>추가 등록</a>
		<a href='#'>도서 목록</a>
	</footer>
</body>
</html>