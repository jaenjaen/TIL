<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit Total List 1.</title>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script>
 	$(function{
		
	})//~ready
 </script>
</head>
<body>
	<h2 align='center'>Fruit Total List 1.</h2>
	<table align='center'>
		<tr>
			<c:forEach items="${list}" var="item">
				<td>
					<a href="itemdetail.do?id=${item.itemNumber}">
						<img src="${item.url}" border='3px' width='150px' height='150px'/></a><br>
						상품명 : ${item.name}<br>
						가  격  : ${item.price}원
				</td>
			</c:forEach>
		</tr>
	</table>
	<div id='fruitView'></div>
</body>
</html>