<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 서블릿에서 session에 정보를 무조건 바인딩 해야하는 로직
	 1. 로그인
	 2. 수정된 정보
	 :로그인 된 상태에서 하기 때문에 session.getAttribute로 받아올 수 있음 이걸 미리 뿌려놔야함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>Update Member Form</h2>
	<form action='UpdateServlet' method='post'>
		ID: <input type='text' name='id' value='${vo.id}' readonly="readonly"> <br/>
		Password: <input type='password' name='password' value='${vo.password}'><br/>
		이름: <input type='text' name='name' value='${vo.name}'><br/>
		주소: <input type='text' name='address' value='${vo.address}'><br/>
		<input type="submit" value="정보수정">
	</form>

</body>
</html>