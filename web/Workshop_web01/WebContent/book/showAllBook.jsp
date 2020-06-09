<%@page import="java.util.ArrayList"%>
<%@page import="servelt.model.book.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소장 도서 목록</title>
<style>
	table{
    	border: 1px solid black;
    	border-collapse: collapse;
    }
	table td{
  	  border: 1px solid black;
    }
</style>
</head>
<body>
	<h2>소유하고 있는 도서 목록입니다.</h2>
	<table>
		<thead>
			<tr>
				<th>isbn</th> <th>제 목</th> 
				<th>종 류</th> <th>발행국가</th>
				<th>발행일</th> <th>출판사</th>
				<th>작 가</th> <th>가격</th>
				<th>설명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.isbn}</td>
					<td>${book.title}</t/d>
					<td>${book.catalogue}</td>
					<td>${book.nation}</td>
					<td>${book.publish_date}</td>
					<td>${book.publisher}</td>
					<td>${book.author}</td>
					<td>${book.price}${book.currency}</td>
					<td>${book.desc}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>