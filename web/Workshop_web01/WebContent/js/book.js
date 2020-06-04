function check() {
	var form = document.Frm;
	
	if((form.isbn1.value)==''||(form.isbn2.value)==''||(form.isbn2.value)==''){
		alert("도서 번호를 입력해주세요.");
		form.isbn1.focus();
		return false;
	} 
	
	if(parseInt(form.isbn1.value)>9999 && parseInt(form.isbn1.value)<1000 ){
		alert("첫번째 자리는 4자리 입력하여 주세요");
		form.isbn1.focus();
		return false;
	}else if(parseInt(form.isbn2.value)>999 && parseInt(form.isbn2.value)<100 ){
		alert("두번째 자리는 3자리 입력하여 주세요");
		form.isbn2.focus();
		return false;
	}else if(parseInt(form.isbn3.value)>999 && parseInt(form.isbn3.value)<100 ){
		alert("세번째 자리는 3자리 입력하여 주세요");
		form.isbn3.focus();
		return false;
	}
	
	if((form.title.value)==''){
		alert("도서 제목을 입력해주세요.");
		form.title.focus();
		return false;
	}
	
	if((form.kinds.value)=="종류"){
		alert("책의 종류를 선택해주세요");
		form.kinds.focus();
		return false;
	}
	
	if((form.writer.value)==''){
		alert("저자를 입력해주세요.");
		form.writer.focus();
		return false;
	}

}