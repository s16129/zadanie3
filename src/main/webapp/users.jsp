<%@page import="repositiories.DummyUserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="domain.User,domain.UserRank,repositiories.UserRepository" %>
<% User currentUser = (User) session.getAttribute("user"); %> 
<!doctype html>
<html>
<head>
<title>Simple auth system</title>
</head>
<body>
	<h1>Simple auth system</h1>
	<p><strong>Users list</strong></p>
	<table>
		<tr>
			<th>Username</th>
			<th>E-mail password</th>
			<th>Rank</th>
			<th>Switch rank</th>
		</tr>
		
		<% DummyUserRepository userRepo = new DummyUserRepository();
		   for(User user: userRepo.getAllUsers()){
			   out.print("<tr><td>"+user.getUsername()+"</td><td>"+user.getEmail()+"</td><td>"+user.getRank().getLabel()+"</td>");
			   if(user.getRank() == UserRank.USER){
				   out.print("<td><a href='/premiumUpdate?username="+user.getUsername()+"'>Upgrade</a></td>");
			   }
			   else if(user.getRank() == UserRank.PREMIUM){
				   out.print("<td><a href='/premiumUpdate?username="+user.getUsername()+"'>Downgrade</a></td>");
			   } 
			   else {
				   out.print("<td></td>");
			   }
			   
			   out.print("</tr>");
		   }
		%>
	</table>
	<p><a href="/profile.jsp">Profile</a></p>
</body>
</html>