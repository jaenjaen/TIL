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
	body{
	text-align:center;
	}
	table{
		width:100%;
    }
	table td{
  	  border: 1px solid black;
    }
    table thead{
        background-color: gray;
    	color: white;
    }
    form{
   		text-align: right;
    }
</style>
</head>
<body>
	<c:choose>
		<c:when test="${vo != null}">
			<h2>소유하고 있는 도서 목록입니다.</h2>
			<form action ='front.do' method='post'>
				<input type="hidden" name="command" value='search'>
				<select name='sort'>
					<option value='all'>전체</option>
					<option value='title'>도서명</option>
					<option value='publisher'>출판사</option>
					<option value='price'>가격</option>
				</select>
				<input type='text' name='word'>
				<input type="submit" value='검색'>
			</form>
			<br>
			<table>
				<thead>
					<tr>
						<th>isbn</th> <th>도서명</th> 
						<th>도서분류</th> <th>저자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${books}" var="book">
						<tr>
							<td>${book.isbn}</td>
							<td>${book.title}</t/d>
							<td>${book.catalogue}</td>
							<td>${book.author}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="book/book.jsp" align='center'>도서 등록</a>
		</c:when>
		<c:otherwise>
		<h2>로그인 하십시오</h2>
		<a href='login.jsp'>로그인 페이지로</a>
		</c:otherwise>
	</c:choose>
	
</body>
</html>