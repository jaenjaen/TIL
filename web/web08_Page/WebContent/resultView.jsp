<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String id = (String)request.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>조회한 id의 정보</h2>
이름: 이재은<br>
아이디:<%=id%><br>
주소:서울시<br>
</body>
</html>