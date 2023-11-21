<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String data = (String)request.getAttribute( "data" );
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Hello WEB-INF/views/form_ok.jsp

<br /><hr /><br />

data : <%= data %>

</body>
</html>