<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random,domain.LoanApplication,java.util.Date" %>
<!doctype html>
<html>
<head>
<title>Pożyczki u Bronka</title>
</head>
<body>
	
		<%! private Random generator = new Random(); %>
		<%
			String number = "" + generator.nextInt();
		%>
		<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
		<jsp:setProperty property="number" name="loan" value="<%= number %>" />
		<jsp:setProperty property="date" name="loan" value="<%= new Date() %>" />
		
	<p>
		Wygenerowany numer wniosku: <%= loan.getNumber() %>
	</p>
	<p>
		Data wygenerowania: <%= loan.getDate() %>
	</p>
	
	<form action="person.jsp" method="get">
		<label for="amount">Wnioskowana kwota: </label>
		<input type="number" name="amount" id="amount"><br/>
		<label for="installmentCount">Ilość rat: </label>
		<input type="number" name="installmentCount" id="installmentCount"><br/>
		<input type="submit" value="Następny krok">
	</form>
</body>
</html>