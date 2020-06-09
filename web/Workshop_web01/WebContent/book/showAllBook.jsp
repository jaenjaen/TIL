<%@page import="java.util.ArrayList"%>
<%@page import="servelt.model.book.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소장 도서 목록</title>
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
			<% ArrayList<BookVo> books = (ArrayList<BookVo>) request.getAttribute("books");
				for(BookVo book:books){
			%>
			<tr>
				<td><%=book.getIsbn()%></td>
				<td><%=book.getTitle()%></td>
				<td><%=book.getCatalogue()%></td>
				<td><%=book.getNation()%></td>
				<td><%=book.getPublish_date()%></td>
				<td><%=book.getPublisher()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrice()+book.getCurrency()%></td>
				<td><%=book.getDesc()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>