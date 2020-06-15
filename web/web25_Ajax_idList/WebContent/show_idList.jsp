<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<script>
	var xhr;
	function startRequest(){
		var mid = document.getElementById("memberId").value;
		alert(mid);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get","find.do?id="+mid);
		xhr.send(null);
	}
	function callback() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				document.getElementById("resultView").innerHTML
				="<font color = green size=5>"+xhr.responseText+"</font>";
			}
		}
	}
</script>
</head>
<body>
<h2> List Information </h2>
<h4> 리스트에서 특정 아이디를 선택해주세요. </h4>
<select id="memberId" onchange="startRequest()">
	<option value="">---id choice---</option>
	<c:forEach items="${list}" var="member">
		<option>${member.id}</option>
	</c:forEach>
</select>
<span id='resultView'></span>
</body>
</html>