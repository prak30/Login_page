<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<h1 style="color:red">REGISTRATION PAGE</h1>
	<form action="registration" method="post">
		Enter firstName:<input type="text" name="fname"><br>
		Enter lastName:<input type ="text" name="lname"><br>
		Enter username: <input type="text" name="uname"><br>
		Enter password: <input type="password" name="pass"><br>
		Reenter password:<input type="password" name="pass"><br>
		<input type="submit" value="register">
	
	</form>
</body>
</html>