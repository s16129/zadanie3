<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Simple auth system</title>
</head>
<body>
	<h1>Simple auth system</h1>
	<form action="login" method="post">
		<label for="username">Username</label>
		<input type="text" name="username" id="username"><br/>
		<label for="password">Password</label>
		<input type="password" name="password" id="password"><br/>
		<input type="submit" value="Log in">
	</form>
	<p><a href="/register.jsp">Register</a></p>
</body>
</html>