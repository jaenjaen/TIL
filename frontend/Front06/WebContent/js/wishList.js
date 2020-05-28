$(function () {
	//Storage 받아오기
	var store = localStorage;
	var arr = [];
	var idx = 1001;
	var price = 0;
	//없으면 없다는 문구
	if(store.length == 0){
		$('tbody').append('<tr><td colspan=5>찜한 상품이 없습니다</td></tr>')
		$('#total p').html('주문가격: 0');
	}
	//있으면 table에 추가
	else{
		for(var i=0; i<store.length;i++){
			arr = store.getItem(String(i+idx)).split(',');
			$('tbody').append('<tr>');
			$('tbody').append('<td> <img src='+arr[0]+'></td>')
			$('tbody').append('<td id="key" value='+(i+idx)+'>'+(i+idx)+'</td>');;
			$('tbody').append('<td>'+arr[1]+'</td>');
			$('tbody').append('<td>'+arr[2]+'</td>');
			$('tbody').append('<td><button value="delete">삭제</button></td>');
			$('tbody').append('</tr>');
			price += parseInt(arr[2],10);
		}
		$('#total p').html('주문가격: '+price);
	}
	
	$('button').on('click',function(){
		var key = $(this).parent().find('#id').attr('id');
		alert(key);
	});
});