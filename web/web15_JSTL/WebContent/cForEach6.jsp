<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] arr ={"떡볶이","튀김세트","순대","김밥","오뎅","탕수육","돈까스"};
	request.setAttribute("arr", arr);
%>
	
	<jsp:forward page="cForEach6_view.jsp"/>	
</body>
</html>