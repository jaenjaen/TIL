
$(function () {
	//Storage 받아오기
	var store = localStorage;
	var arr = [];
	var price = 0;
	//없으면 없다는 문구
	if(store.length == 0){
		$('tbody').append('<tr><td colspan=5>찜한 상품이 없습니다</td></tr>')
		$('#total p').html('주문가격: 0');
	}
	//있으면 table에 추가
	else{
		for(var i=0; i<store.length;i++){
			arr = store.getItem(store.key(i)).split(',');
			$('tbody').append('<tr>');
			$('tbody').append('<td> <img src='+arr[0]+'></td>')
			$('tbody').append('<td id="key" value='+store.key(i)+'>'+store.key(i)+'</td>');;
			$('tbody').append('<td>'+arr[1]+'</td>');
			$('tbody').append('<td>'+arr[2]+'</td>');
			$('tbody').append('<td><button value="delete">삭제</button></td>');
			$('tbody').append('</tr>');
			price += parseInt(arr[2],10);
		}
		$('#total p').html('주문가격: '+price);
	}
	
	$('button').on('click',function(){
		var key =$(this).parent().prev().prev().prev().html();
		if(confirm($(this).parent().prev().prev().html()
				+"가 찜리스트에서 삭제됩니다")){
			alert('영화가 삭제되었습니다.');
			store.removeItem(key);
			location.reload();
		}
		else{
			alert('삭제가 취소되었습니다.');
			return false;
		}
	});
});