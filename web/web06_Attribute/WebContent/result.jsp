<%-- jsp 주석은 소스보기로 안보여짐  HTML태그는 소스보기에서 보여진다. --%>
<%-- jsp element
	1) 지시어    %@ %: container에게 알려 줄 내용 지정
	2) 스크립틀리 % %: java코드가 들어감 
	3) 출력문         %=: 출력하려는 내용 지정--%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- %내용% : Scriptely Element 로직(자바 코드)를 삽입
	ServletContext == application -->
<% 
	MemberVO member = (MemberVO) application.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인 페이지</title>
</head>
<body>

<!-- %=%는 출력문(Expression Element
	VO를 servletContext 받아와야 빨간줄 안생김 -->
	
	<h2>회원 정보를 출력합니다.</h2>
	<li>당신의 이름은 <%= member.getName() %></li>
	<li>당신의 나이는 <%= member.getAge() %></li>
	<li>당신의 주소는 <%= member.getAddr() %></li>
</body>
</html>