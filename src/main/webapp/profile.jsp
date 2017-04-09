<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="domain.User,domain.UserRank" %>
<% User currentUser = (User) session.getAttribute("user"); %> 
<!doctype html>
<html>
<head>
<title>Simple auth system</title>
</head>
<body>
	<h1>Simple auth system</h1>
	<p><strong>You're logged in</strong></p>
	<table>
		<tr>
			<th>Username</th>
			<td><%= currentUser.getUsername() %></td>
		</tr>
		<tr>
			<th>E-mail address</th>
			<td><%= currentUser.getEmail() %></td>
		</tr>
		<tr>
			<th>Rank in the system</th>
			<td><%= currentUser.getRank().getLabel() %></td>
		</tr>
	</table>
	<% if(currentUser.getRank() == UserRank.ADMIN || currentUser.getRank() == UserRank.PREMIUM){
		out.print("<p><a href='/premium.jsp'>Premium site</a></p>");
	}
	if(currentUser.getRank() == UserRank.ADMIN){
		out.print("<p><a href='/users.jsp'>Users list</a></p>");
	}
	%>
	<p><a href="/logout">Quit session</a></p>
</body>
</html>