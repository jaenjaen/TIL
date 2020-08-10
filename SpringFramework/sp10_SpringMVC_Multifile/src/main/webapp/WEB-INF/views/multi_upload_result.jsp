<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function downloadFile(filename) {
		if(confirm("다운 받으시겠습니까?")==true){
			location.href="downloadfile.do?filename="+filename;
		}
	}
</script>
</head>
<body>
	<h2>Multifile upload OK!</h2>
	<ul>
		<c:forEach items="${names}" var="name">
			<li>Upload file: <a href="javascript:downloadFile('${name}')">${name}</a></li>		
		</c:forEach>
	</ul>
</body>
</html>