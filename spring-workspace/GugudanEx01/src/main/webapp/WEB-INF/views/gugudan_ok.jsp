<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute( "result" );
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
gugudan_ok.jsp
<br /><br />
<%--=(String)request.getAttribute( "result" ) --%>
<%= result %>
</body>
</html>