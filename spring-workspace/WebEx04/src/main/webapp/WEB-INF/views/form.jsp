<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Hello WEB-INF/views/form.jsp

<br /><br />

<form action="./form_ok.do" method="GET">
������ <input type="text" name="data" />
<input type="submit" value="����" />
</form>

<form action="./form_ok.do" method="POST">
������ <input type="text" name="data" />
<input type="submit" value="����" />
</form>

</body>
</html>