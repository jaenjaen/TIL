<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}
a {
	margin: 10px;
}

</style>
</head>
<body>
<%@ include file="header.jsp" %>

<h1> 메인 페이지 </h1>
<p/>

<p/>
	<h4> <a href="showReg.do">핸드폰 등록</a>  </h4>
	<h4> <a href="showPlist.do">핸드폰 목록</a></h4>
	<c:choose>
		<c:when test="${empty vo}">
			<h4> <a href="Login.jsp">로그인</a></h4>
		</c:when>
	</c:choose>
</body>
</html>