<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>

<!-- 비동기로하면 input박스만 다시 새로고침됨 -->

<script type="text/javascript">
	$(function () {
		$('input[type=button]').click(function() {
			window.open("IdcheckServlet?id="+$('#id').val(),"","width=300,height=200,top=100,left=400");
		});//click
	});
</script>

</head>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
	<form action="RGS" name="registerForm" >
ID : <input type="text" name="id" id='id' required="required">
	 <input type="button" value="중복확인"><br><br>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input type="submit" value="member register">
	</form>
</body>
</html>























