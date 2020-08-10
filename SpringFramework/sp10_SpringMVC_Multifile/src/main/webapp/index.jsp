<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20-08-10</title>
</head>
<body>
	<h2 align="center">MultiFileUpload Test</h2><p>
	<form action="multiupload.do" method="post" enctype="multipart/form-data">
	사용자 정보: <input type="text" name="userName"/><p>
	<!-- 멀티파일은 배열로 보내야함 -->
	<input type="file" name="file[0]"><p>
	<input type="file" name="file[1]"><p>
	<input type="file" name="file[2]"><p>
	
	<input type="submit" value="멀티파일전송">
	</form>
</body>
</html>