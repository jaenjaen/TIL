<%@page import="servelt.model.user.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.name}님이 로그인하셨습니다.</title>
</head>
<body align='center'>
	<h2>${vo.name}님이 로그인 되었습니다!</h2>
	<a href='book/book.jsp'>도서 등록</a><br>
	<a href='front.do?command=booklist'>도서 리스트</a><br>
	<a href='front.do?command=logout'>로그아웃</a><br>
</body>
</html>