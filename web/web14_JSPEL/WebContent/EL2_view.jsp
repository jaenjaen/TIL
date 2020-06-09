<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>1.jsp 기본 태그로 받아오기</b>
	<%=request.getParameter("userId") %><br><br>
	
	<b>2. EL로 받아오기</b>
	${param.userId}<br>
	<hr><br>
	<b>1.jsp기본 태그로 받아오기</b>
	<%
	 String[] menus = request.getParameterValues("menu");
	for(String menu:menus){
	%>
	<%=menu%>
	<%}%><br><br>
	
	<b>2.EL로 받아오기</b>
	${paramValues.menu[0]}
	${paramValues.menu[1]}
	${paramValues.menu[2]}
	${paramValues.menu[3]}
	${paramValues.menu[4]}
</body>
</html>