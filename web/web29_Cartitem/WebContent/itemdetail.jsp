<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${item.name}의 정보</title>
<style type="text/css">
	#bar{ width: 80%; background-color: orange; padding: 5px; margin:0 auto; text-align:right;}
	#fDesc{ width: 80%; margin: 20px auto;}
	#imgPlace{ width: 70%; float: left; text-align:center;}
	img{width:40%}
	#descPlace{	width: 20%; float: left;}
	footer{ clear:both; text-align:center;}
</style>
</head>
<body>
	<h2 align='center'>${item.name}의 정보</h2>
	<div id='bar'>
		조회수:${item.count}&nbsp;&nbsp;
		<a href="#">장바구니 담기</a>
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