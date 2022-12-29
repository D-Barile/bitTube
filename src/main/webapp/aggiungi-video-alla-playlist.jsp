<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/aggiungi-video-alla-playlist?id=${param.id}}" method="GET">
		<input type="number" name="id" value="${param.id}" hidden="true">
		<input type="number" name="idPlaylist" placeholder="Id della playlist">
		<input type="submit" value="Aggiungi">
	</form>
</body>
</html>