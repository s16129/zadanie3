<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random,domain.LoanApplication,java.util.Date" %>
<!doctype html>
<html>
<head>
<title>Pożyczki u Bronka</title>
</head>
<body>
	
		<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session" />
		<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
		
		<jsp:setProperty property="*" name="parameters" />
		
		<p>
			Numer wniosku: ${loan.number}
		</p>
		<p>
			Wnioskowana kwota: ${parameters.amount}
		</p>
		
		<form action="success.jsp" method="get">
			<label for="firstName">Imię: </label>
			<input type="text" name="firstName" id="firstName"><br/>
			<label for="surname">Nazwisko: </label>
			<input type="text" name="surname" id="surname"><br/>
			<label for="pesel">Nr pesel: </label>
			<input type="text" name="pesel" id="pesel"><br/>
			<input type="submit" value="Następny krok">
		</form>
		

</body>
</html>