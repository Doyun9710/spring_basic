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
	out.println( "form_ok.jsp" );
%>

<br /><hr /><br />

data : <%= (String)request.getAttribute( "data" ) %>

</body>
</html>