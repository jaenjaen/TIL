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
	int sum=0;
	for(int cnt=0; cnt<=50;cnt++){
		sum += cnt;
	}
	
	request.setAttribute("result", new Integer(sum));
	session.setAttribute("result","세션");
	
	request.getRequestDispatcher("EL1_view.jsp").forward(request, response);
%>
</body>
</html>