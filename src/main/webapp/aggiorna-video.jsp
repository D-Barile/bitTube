<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiorna video</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/update-video?id=${param.id}" method="POST">
		<input type="text" name="titolo" value="${video.titolo}">
		<input type="text" name="codice" value="${video.codice}">
		<input type="text" name="durata" value="${video.durata}">
		<input type="text" name="genere" value="${video.genere}">
		<input type="text" name="descrizione" value="${video.descrizione}">
		<input type="text" name="autore" value="${video.autore}">
		<input type="submit" value="Aggiorna">
	</form>
</body>
</html>