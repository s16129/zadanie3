<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Konferencja</title>
	</head>
	<body>
		<form action="add" method="get">
			<label>Imię:<input type="text" name="name"/></label><br/>
			<label>Nazwisko:<input type="text" name="surname"/></label><br/>
			<label>Pracodawca:<input type="text" name="email"/></label><br/>
			<label>Adres e-mail:<input type="email" name="confirmemail"/></label><br/>
			<label>Potwierdź adres e-mail:<input type="email" name="name"/></label><br/>
			<label>Skąd się dowiedziałeś o konferencji:</label><br/>
			<label><input type="radio" name="info" value="work"/> Ogłoszenie w pracy</label><br/>
			<label><input type="radio" name="info" value="school"/> Ogłoszenie na uczelni</label><br/>
			<label><input type="radio" name="info" value="facebook"/> Facebook</label><br/>
			<label><input type="radio" name="info" value="friends"/> Znajomi</label><br/>
			<input type="submit" value="Wyślij"/>
		</form>
	</body>
</html>