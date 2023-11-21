<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello WEB-INF/views/form.jsp

<br /><br />

<form action="./form_ok.do" method="GET">
데이터 <input type="text" name="data" />
<input type="submit" value="전송" />
</form>

<form action="./form_ok.do" method="POST">
데이터 <input type="text" name="data" />
<input type="submit" value="전송" />
</form>

</body>
</html>