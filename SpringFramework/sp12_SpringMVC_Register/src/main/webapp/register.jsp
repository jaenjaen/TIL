<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var obj;
		$("#id").keyup(function(){
			var id = $(this).val();
			
			if($(this).val().length<4 || $(this).val().length>8){
				$('#checkSpace').html("아이디는 최소 4자이상, 최대 8자 이하 글자만 가능합니다.").css("color","red"); 
			}
			else{
				$.ajax({
					type:"post",
					url:"idcheck.do",
					data:"id="+id,
					//응답
					success:function(result){
						obj = JSON.parse(result);
						if (obj.flag == true){
							$('#checkSpace').html("존재하는 아이디입니다.").css("color","red");
							}
						else{
							$('#checkSpace').html("사용가능한 아이디입니다.").css("color","green");}
						}//~callback
				});//~ajax
			}//~else
		});//~keyup
		
		$('#subminBtn').click(function() {
			if(obj.flag == true){
				alert("사용할 수 없는 아이디 입니다.");
				return false;
			}
			confirm("가입 하시겠습니까?");
		})//~click
	});

</script>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
<form action="register.do" name="registerForm">
ID : <input type="text" name="id" id="id" required="required">
<div id="checkSpace"></div>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input id="subminBtn" type="submit" value="member register">
</form>
</body>
</html>























