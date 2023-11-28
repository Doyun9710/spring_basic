<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Hello WEB-INF/views/mail.jsp

<br /><hr /><br />

<form action="./mail_ok.do" method="post" enctype="multipart/form-data">
	Data <input type="text" name="data" /><br /><br />
	File <input type="file" name="upload" /><br /><br />
	<input type="submit" value="전송" /><br /><br />
</form>

</body>
</html>