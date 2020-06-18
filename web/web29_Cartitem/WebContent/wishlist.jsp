<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<meta charset="UTF-8">
<title>장바구니</title>
<style type="text/css">
	body{ padding: 10px;}
	table{ width:80%; margin: 0 auto;}
	thead{ background-color:orange; color:white;}
	tbody{ text-align: center;}
	.atag{ margin: 0 auto; width:80%; text-align:right;}
	footer{ margin: 0 auto; width:80%; background-color: orange; color:white; text-align: right}
	img{width:100px; height: 100px;}
	.up{background: url("img/up.png")no-repeat; width: 20px; height: 20px; background-size: 100%; background-position: center; border: none;}
	.down{background: url( "img/down.png" ) no-repeat; width: 20px; height: 20px; background-size: 100%; background-position: center; border: none;}
	
</style>
<script>
	$(function() {
		var storage = window.localStorage;
		var num = 1;
		var arr = [];
		var price = 0;
		//Storage 받아오기
		if(storage){
			//localStorage가 비었으면
			if(storage.length==0){
				$("#list").append("<tr><td colspan='6'> 장바구니에 아이템이 없습니다.</td></tr>");
				$("#pricePlace").html("0");
			}
			//안비었으면
			else{
				for(i=0; i<storage.length; i++){
					arr = storage.getItem(storage.key(i)).split(','); // key셋 받아와서 돌려야됨 수정!
					$("#list").append("<tr><input class='key' type='hidden' vlaue="+storage.key(i)+">");
					$("#list").append("<td>"+(num++)+"</td>"); // 상품번호
					$("#list").append("<td><img src="+arr[0]+"></td>"); // 이미지
					$("#list").append("<td>"+arr[1]+"</td>"); // 상품명
					$("#list").append("<td class='price'>"+arr[2]+"</td>"); // 상품가격
					$("#list").append("<td><button class='up'></button><br><span class='amount'>"
							+parseInt(arr[3])+"</span><br><button class='down'></button></td>"); // 수량(버튼 추가)
					$("#list").append("<td><input type='checkbox' name='delchecked'></td></tr>");
					$("#pricePlace").html(price += (parseInt(arr[2])*parseInt(arr[3])));
				}
			}
		}
		//없으면 없다는 문구
		else{
			alert("장바구니 기능을 지원하지 않습니다.");
			$("#ilist").append("<tr><td colspan='6'> 장바구니에 아이템이 없습니다.</td></tr>");
			$("#pricePlace").html("0");
		}
		
		
		//삭제
		$('#del').click(function() {
			/* //체크 되어있으면
			var name;
			var checkcnt = $("input:checkbox[name= delchecked]:checked").length;
			if (checkcnt == 0){
				alert("삭제할 제품을 선택해주세요.");
			}
			// 이름 확인해서 알러트
			 $('input:checkbox[name="delchecked"]').each(function() {
			     if(this.checked){ //값 비교
			        ..tkrwp
			      } */
			 });
			//지우기
		})//~del click
		
		//수량추가 or 삭제
		$('.up').on('click',function(){
			var amount = $(this).parent().find($(".amount"));
			var quan = parseInt(amount.text())+1
			var total = $("#pricePlace").text();
			var price = parseInt($(this).parent().prev().text());
			
			amount.text(quan);
			$("#pricePlace").text(parseInt(total)+price);
			
		});//~up
		
		$('.down').on('click',function(){
			var amount = $(this).parent().find($(".amount"));
			var quan = parseInt(amount.text())-1;
			var total = $("#pricePlace").text();
			var price = parseInt($(this).parent().prev().text());
			
			if(quan==0){
				return false;
			}
			amount.text(quan);
			$("#pricePlace").text(parseInt(total)-price);
		});//~down
		
		
	})//~ready
</script>
</head>
<body>
	<h2 align='center'>장바구니</h2>
	<div class='atag'><a href='itemlist.do'>쇼핑 계속하기</a></div>
	
	<table>
		<thead>
			<tr>
				<th> 번호 </th> <th> 상품 이미지 </th> <th> 상품명 </th> <th> 상품가격 </th> <th> 수량 </th> <th><button id='del'>삭제</button></th>
			</tr>
		</thead>
		<tbody id='list'>
		</tbody>
	</table>
	
	<footer>
		총 결제 금액: <span id='pricePlace'></span>원
	</footer>
</body>
</html>