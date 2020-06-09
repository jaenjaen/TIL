<!-- 
1. 라이브러리 추가 .. standard.jar, jstl.jar
2. taglib 속성을 지정 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- c:set 변수를 지정 -->
<!-- num1이라는 변수를 선언. 여기 7이라는 값 할당 -->
<c:set var='num' value='7'/>
<c:set var='num2' value='9'/>

<!-- multiple 변수 선언 num1*num2 할당 -->
<c:set var='multiple' value='${num*num2}'/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<b>${num}과 ${num2}의 곱은 ${multiple}입니다</b>
</body>
</html>