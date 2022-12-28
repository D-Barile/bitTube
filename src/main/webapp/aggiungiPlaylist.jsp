<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/aggiungi-playlist" method="POST">
		<input type="text" name="titolo" placeholder="Titolo">
		<input type="text" name="descrizione" placeholder="Descrizione">
		<input type="number" name="visibilita" placeholder="0 Privata / 1 Pubblica">
		<input type="submit" value="Aggiungi">
	</form>

</body>
</html>