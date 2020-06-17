<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/flick/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <!-- bs라이브러리가 가장 나중에 와야한다. -->
  <script>
	  $( function() {
	    $( "#accordion" ).accordion({
	    	//컨텐츠 사이즈에 맞게 Accordion의 높이 조절
	    	heightStyle:'content' //default - fill
	    });
	    
	    $("#accordion h3").click(function() {
			var text = $(this).text();//html()도 됨
			//alert(text);
			
			
			if(text == 'IT Education Subject'){
				$.ajax({
					type:'post',
					url:'front.do',
					data:'command=subject',
					
					
					success:function(data){
						$('#subject').html(data);
					}//~callback
				});//~ajax
			}
			else{ //IT Association의 경우
				$.ajax({
					type:'post',
					url:'front.do',
					data:'command=company',
					
					
					success:function(data){
						$('#company').html(data);
					}//~callback
				});//~ajax
			}
			
		})//~h3 click
	    
		$('#createSection').click(function() {
			var footercontent = "<h3>How to Get</h3> <div>서울 특별시 서초구 서초1동 효령로 335</div>";
			$(this).remove();
			
			//동적으로 아코디언을 만들 때는 'destroy'옵션으로 완벽하게 삭제한 다음 다시 생성
			$('#accordion').append(footercontent).accordion('destroy').accordion({
				heightStyle:'content'
			});
			
		});//~createSection click
		
	  } ); //~ready
  </script>
</head>
<body>
 
	<div id="accordion">
	  <h3>Encore Academy Introduction</h3>
	  <div>
	    플레이 데이타의 새로운 교육 프로그램을 소개합니다.<br>
	     아래 섹션에서 이수할 교육과목을 확인하시기 바랍니다.
	  </div>
	  <h3>IT Education Subject</h3>
	  <div id = 'subject'>
	   
	  </div>
	  <h3>IT Association</h3>
	  <div id = 'company'>
	   
	  </div>
	</div>
	
	<hr>
	
	<input type='button' value='Create Section Addction' id='createSection'>
</body>
</html>