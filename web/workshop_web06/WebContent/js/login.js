$(function() {
	$('#loginFrm').submit(function(event) {
		var id = $('#loginFrm [name=id]');
		var pass = $('#loginFrm [name=pass]');
		
		// id check
		if(id.val()==""){
			alert("id를 입력해주세요");
			id.focus();
			event.preventDefault();
		}
		
		//pass check
		else if(pass.val()==""){
			alert("비밀번호를 입력해주세요");
			pass.focus();
			event.preventDefault();
		}
	});//~submit
});