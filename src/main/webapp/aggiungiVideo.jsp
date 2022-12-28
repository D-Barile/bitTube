<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi un video</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/aggiungi" method="POST">
		<input type="text" name="titolo" placeholder="Titolo">
		<input type="text" name="codice" placeholder="Codice">
		<input type="text" name="durata" placeholder="00:00:00">
		<input type="datetime" name="data_inserimento" placeholder="yyyy-MM-dd 00:00:00">
		<input type="text" name="genere" placeholder="Genere">
		<input type="text" name="descrizione" placeholder="Descrizione">
		<input type="text" name="autore" placeholder="Autore">
		<input type="submit" value="Aggiungi">
	</form>
</body>
</html>