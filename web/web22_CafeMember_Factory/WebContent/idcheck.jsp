<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <c:choose>
	<c:when test="${flag == false}}">
		<script>
			document.body.style.background=orange;
		</script>
		<h4>${param.id}</h4>
		<h2 align='center'><font color='blue'>사용가능</font></h2>
		<button type="button" onclick="location.href='register.jsp?id=${param.id}'">확인</button>
	</c:when>
	<c:otherwise>
		<h2 align='center'><font color='blue'>사용불가</font></h2>
	</c:otherwise>
</c:choose> --%>

<script type="text/javascript">
	function closeWindow(result) {
		//확인 버튼 누르면 이곳으로 옴 
		//원래 회원 가입 폼으로 제어
		var op = window.opener.document.registerForm;
		if(result=='true'){//아이디 사용X
			op.id.value = "";
			op.id.focus();
		}else{ //아이디 사용 가능
			op.id.readOnly=true;
			op.password.focus();
		}
		
		self.close();
	}
</script>
</head>
<body bgcolor = 'orange'>
	<c:set var='message' value='해당 ID를 사용할 수 없음'/>
	<c:if test="${!flag}">
		<h2>${!flag}</h2>
		<c:set var ='message' value='해당 ID를 사용할 수 있음!'/>
	</c:if>
	
	${param.id}<br>
	${message}<br>
	<input type='button' value='확인' onclick="closeWindow('${flag}')">
</body>
</html>