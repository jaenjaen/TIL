function checkAge() {
		var age = document.ageForm.age.value;
		
		if (age==""){
			alert("나이를 입력하여 주십시오");
			} else if (isNaN(age)){
				alert("숫자로 입력하여 주십시오");
			} else if (age>=19){
				alert("성인입니다 입장가능");
			} else {alert("19세 미만은 입장 불가능 합니다.")}
		reset();
	}
	
	function reset() {
		document.ageForm.age.value =" ";
		document.ageForm.age.focus();
	}