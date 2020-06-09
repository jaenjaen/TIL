<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form data</h2>
	<form action="EL2_view.jsp" method="post">
	Id <input type='text' name='userId'><br><br>
	<strong> 좋아하는 메뉴 </strong><br><br>
	<input type='checkbox' name='menu' value='짜장면'>짜장면
	<input type='checkbox' name='menu' value='닭도리탕'>닭도리탕
	<input type='checkbox' name='menu' value='삼겹살'>삼겹살
	<input type='checkbox' name='menu' value='돈까스'>돈까스
	<input type='checkbox' name='menu' value='떡볶이'>떡볶이 
	<br><br>
	<hr>
	<input type='submit' value='DataSend'>
	</form>
</body>
</html>