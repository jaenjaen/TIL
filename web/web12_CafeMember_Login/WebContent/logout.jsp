<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOUT</title>
<%
	MemberVO vo = (MemberVO) session.getAttribute("vo");
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
	<a href='index.html'>홈으로</a>
</body>
</html>