<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${item.name}의 정보</title>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style type="text/css">
	#bar{ width: 80%; background-color: orange; padding: 5px; margin:0 auto; text-align:right;}
	#fDesc{ width: 80%; margin: 20px auto;}
	#imgPlace{ width: 70%; float: left; text-align:center;}
	img{width:40%}
	#descPlace{	width: 20%; float: left;}
	footer{ clear:both; text-align:center;}
</style>
<script>
	$(function() {
		$('#wishlist').click(function(){
			var key = 0;
			var vals= [];
			
			key = ${item.itemNumber};
			vals.push("${item.url}");
			vals.push("${item.name}");
			vals.push(${item.price});
			
			if(window.localStorage){
				//alert(key);
				 if(localStorage.getItem(key)){
					alert("이미 리스트에 존재하는 아이템입니다.");
					}
				else{
					localStorage.setItem(key,vals);
					alert("${item.name} 가(이) 장바구니  추가 되었습니다.");
				}
			}//~localstorage
			else{
				alert("본 환경은 장바구니를 지원하지 않습니다.");
			}
		});//~click
	})//~ready
</script>
</head>

<body>
	<h2 align='center'>${item.name}의 정보</h2>
	<div id='bar'>
		조회수:${item.count}&nbsp;&nbsp;
		<a id='wishlist' href='#'>장바구니 담기</a>
	</div>
	<div id="fDesc">
		<div id='imgPlace'><img src="${item.url}"></div>
		<div id='descPlace'>
			종류: ${item.name}<br><br>
			가격: ${item.price}
			<p>
				설명: ${item.desc}
			</p>
		</div>
	</div>
	<footer><a href='cookie.do?id=${item.itemNumber}'>상품보기</a></footer>
</body>
</html>