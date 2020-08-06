<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find_result</title>
</head>
<body>
	<h2>++++++++ 검색 결과 ++++++++</h2>
	<table border="1px">
		<tr>
			<th>ID</th><th>NAME</th><th>MAKER</th><th>PRICE</th>
		</tr>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.maker}</td>
				<td>${product.price}</td>
			</tr> 
		</c:forEach>
	</table>
</body>
</html>