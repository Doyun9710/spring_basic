<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Hello WEB-INF/views/form.jsp

<br /><hr /><br />

<form action="./form_ok.do" method="post" enctype="multipart/form-data">
	Data <input type="text" name="data" /><br /><br />
	File <input type="file" name="upload" /><br /><br />
	<input type="submit" value="전송" /><br /><br />
</form>

<br /><hr /><br />

<!-- Multi Files 선택 가능 -->
<form action="./form_ok.do" method="post" enctype="multipart/form-data">
	File <input type="file" name="upload" multiple="multiple" /><br /><br />
	<input type="submit" value="전송" /><br /><br />
</form>

<br /><hr /><br />

<form action="./form_ok.do" method="post" enctype="multipart/form-data">
	File 1 <input type="file" name="upload1" /><br /><br />
	File 2 <input type="file" name="upload2" /><br /><br />
	File 3 <input type="file" name="upload3" /><br /><br />
	<input type="submit" value="전송" /><br /><br />
</form>

</body>
</html>