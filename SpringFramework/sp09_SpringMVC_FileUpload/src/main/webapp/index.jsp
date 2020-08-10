<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Single Upload File Test</h2>
	
	<!-- *****
		 file upload form 작성시 주의사항
		 무조건 Form Tag를 이용해야한다.
		 A Tag는 사용 못함. (get방식 사용 못하니까)
		 전송방식은 반드시 post로 한다. -> 단순히 스트링 값을 넘기는 것이 아니라  MultipartFile 객체를 넘기는 것
		 form에 속성으로 action, method 말고도 enctype="multipart/form-data"를 넣어야함
		 MultipartFile? 파일 업로드의 핵심 라이브러리이기 때문에 빈 설정문서에 등록해야한다. (사진의 경로,속성들을 모두 가지고 있음)-->
		 
	<form action="fileupload.do" method="post" enctype="multipart/form-data">
		사용자명: <input type="text" name="userName"><P>
		<input type="file" name="uploadFile"><p>
		<input type="submit" value="파일업로드">
	</form>
	
	<!-- 보통은 여기까지 작성하고 바로 Controller 작성으로 넘어가는 것이 일반적
		  하지만 fileupload로직은 Controller 작성으로 넘어가기 전에 
		  VO작성을 하고 넘어가야함
		  VO작성? VO가 뭔지 정확한 이해 필요
		  폼에있는 모든정보를 다 날리기 때문(사진의 특성, 경로(Multipart File)뿐 아니라 Form값도-->
	<a href="fileupload.do"> 좋은생각 좋은 아침 POST~ </a>
</body>
</html>