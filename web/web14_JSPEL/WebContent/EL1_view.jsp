<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- EL 
     attribute에 바인딩 된 값을 찾아오는 로직을 태그로 바꾼 기술
       변수명이 아닌 객체를 바인딩한 이름이 사용된다. request+Scope.바인딩한이름
       똑같은 이름으로 바인딩 되어도 request->session->application
       만약 없으면 EL은 출력하지 않음 nullpoint안떨어짐 (해당 라인만 출력안함)
       연산도 가능 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Attribute에 바인딩 값을 받아오겠습니다.</h2>
	<b>1~50까지 합산 결과 값 </b>
	<%= request.getAttribute("result") %>
	<hr><p/>
	<b>1~50까지 합산 결과 값  EL로 받아오기</b>
	${requestScope.result} <br>
	${sessionScope.result} <br>
	${result}<br>
	${loveya }<br>
	${result+1000}
	
</body>
</html>