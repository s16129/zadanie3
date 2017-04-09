<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Simple auth system</title>
</head>
<body>
	<h1>Simple auth system</h1>
	<form action="register" method="post">
		<label for="username">Username</label>
		<input type="text" name="username" id="username"><br/>
		<label for="password">Password</label>
		<input type="password" name="password" id="password"><br/>
		<label for="confirm_password">Confirm</label>
		<input type="password" name="confirm_password" id="confirm_password"><br/>
		<label for="email">Email</label>
		<input type="email" name="email" id="email"><br/>
		<input type="submit" value="Register">
	</form>
	<p><a href="/index.jsp">Log in</a></p>
</body>
</html>