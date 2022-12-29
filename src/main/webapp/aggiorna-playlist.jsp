<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/aggiorna-playlist?id=${param.id}" method="POST">
		<input type="text" name="titolo" value="${playlist.titolo}">
		<input type="text" name="descrizione" value="${playlist.descrizione}">
		<input type="text" name="visibilita" value="${playlist.visibilita}">
		<input type="submit" value="Aggiorna">
	</form>
</body>
</html>