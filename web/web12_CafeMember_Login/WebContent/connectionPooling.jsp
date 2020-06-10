<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1.Resource Factory를 WAS에 바인딩: 제품을 이름으로 등록(META-INF/Context.xml)
     2.Resource Factory(DataSource)를 하나 받아옴  -->
<%
	Connection conn = null;
	
	Context ic = new InitialContext();
	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
	out.println("DataSource...lookup");
	
	conn = ds.getConnection();
	out.println("Connection Rent OK!");
%>
</body>
</html>