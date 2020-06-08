<%@page import="servelt.model.user.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOUT</title>
<%
	UserVo vo = (UserVo) session.getAttribute("vo");
	if(vo==null){
%>
	<b><a href='login.html'>로그인 페이지로 이동</a></b>
<%
	}else{
		session.invalidate();
	}
%>

<script>
	function logoutpopup() {
		alert("LogOut!!");
	}
</script>
</head>
<body onload="return logoutpopup()">
	<b>로그아웃 되었습니다.</b><br>
	<a href='login.html'>로그인하기</a>
</body>
</html>