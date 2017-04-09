<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.LoanApplication,domain.Person,service.LoanService" %>
<!doctype html>
<html>
<head>
<title>Pożyczki u Bronka</title>
</head>
<body>
	
		<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session" />
		<jsp:useBean id="loan" class="domain.LoanApplication" scope="session" />
		<jsp:useBean id="person" class="domain.Person" scope="session" />
		<jsp:useBean id="loanService" class="service.LoanService" scope="application" />
		
		<jsp:setProperty property="*" name="person" />
		
		<%
			loan.setParameters(parameters);
			loan.setPerson(person);
			loanService.add(loan);
		%>
		
		<ul>
		<%
			for(LoanApplication loanApplication: loanService.getAll()){
		%>
		<li>Wniosek:<%= loanApplication.getNumber()+" Osoba: "+ loanApplication.getPerson().getSurname() + " Kwota: " + loanApplication.getParameters().getAmount() %></li>
		<%
			}
		%>
		</ul>

</body>
</html>