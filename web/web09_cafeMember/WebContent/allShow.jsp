<%@page import="java.util.List"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getParameter("id")!=null){
			out.println(request.getParameter("id")+"님이 회원으로 등록하셨습니다.");
		}
	%>
	<hr>
	<h2>전체 카페 회원 명단</h2>
	<table>
		<tr>
			<th>번호</th> <th>아이디</th> <th>이름</th> <th>주소</th>
		</tr>
	<% 
		List<MemberVO> list = (List<MemberVO>)request.getAttribute("members");
		for(int i=0 ;i<list.size() ;i++){
	%>
		<tr>
		<td><%=i+1 %></td> <td><%=list.get(i).getId()%></td>
		<td><%=list.get(i).getName()%></td> <td><%=list.get(i).getAddress()%></td>
		</tr>
		
	<%
		}
	%>
	</table>
	<hr>
</body>
</html>