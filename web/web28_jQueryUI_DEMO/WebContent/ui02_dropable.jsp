<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Droppable - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  #closet { 
  	width:500px;
  	float:left;
  	margin-left:10px;
  	margin-top:10px;
  }
  #cart { 
	  width: 500px;
	  float: left; 
	  margin-left: 10px;
	  margin-top:10px;
  };
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    /* $( "#draggable" ).draggable();
    $( "#droppable" ).droppable({
      drop: function( event, ui ) {
        $( this ),
          .addClass( "ui-state-highlight" )
          .find( "p" )
            .html( "Dropped!" );
      }
    }); */
    
    $('#catalog').accordion({
    	heightStyle:'content'
    });
    $('#catalog li').draggable({
    	helper:'clone', // 복사본을 만들어 draggable
    	appendTo:'#cart'
    });
    
    $('#cart ol').droppable({
    	drop: function( event, ui ) {
    		$(this).find('.placeholder').remove();
    		var uidrag = ui.draggable.text();
    		
    		$(this).append('<li>'+uidrag+'</li>');
    	}
    });
  } );
  </script>
</head>
<body>
 	<div id='closet'>
 		<h2 class='ui-widget-header' >카탈로그</h2>
 		
 		<!-- 드래그 하는 대상들 -->
 		<div id='catalog'>
 			<h2><a href="#">상의류</a></h2>
 			<div>
 				<ul>
 					<li>블라우스</li>
 					<li>폴라티</li>
 					<li>반팔</li>
 					<li>아노락</li>
 				</ul>
 			</div>
 			
 			<h2><a href="#">하의류</a></h2>
 			<div>
 				<ul>
 					<li>반바지</li>
 					<li>치마</li>
 					<li>와이드팬츠</li>
 					<li>스키니진</li>
 					<li>청바지</li>
 				</ul>
 			</div>
 			
 			<h2><a href="#">악세서리</a></h2>
 			<div>
 				<ul>
 					<li>가방</li>
 					<li>반지</li>
 					<li>지갑</li>
 					<li>목걸이</li>
 					<li>귀걸이</li>
 					<li>신발</li>
 					<li>모자</li>
 				</ul>
 			</div>
 		</div>
 	</div>
 	
 	<!-- dropable -->
 	<div id='cart'>
 		<h2 class='ui-widget-header'>Cloth cart</h2>
 		<ol class='ui-widget-content'>
 			<li class='placeholder'>Drop Here!</li>
 		</ol>
 	</div>
</body>
</html>