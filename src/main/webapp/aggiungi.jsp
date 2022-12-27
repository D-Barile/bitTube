<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi un video</title>
</head>
<body>
		<%
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bittube", "root", "0810");
			String sql = "SELECT id, titolo, codice, durata, genere, descrizione, autore FROM yt_video;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int id = 0;
			String titolo = "";
			String codice = "";
			String durata = "";
			String genere = "";
			String descrizione = "";
			String descrizioneCompleta = "";
			String autore = "";

		%>
	<form action="${pageContext.request.contextPath}/aggiungi" method="POST">
		<input type="text" name="titolo" placeholder="Titolo">
		<input type="text" name="codice" placeholder="Codice">
		<input type="text" name="durata" placeholder="Durata">
		<input type="datetime" name="data_inserimento" placeholder="Data">
		<input type="text" name="genere" placeholder="Genere">
		<input type="text" name="descrizione" placeholder="Descrizione">
		<input type="text" name="autore" placeholder="Autore">
		<input type="submit" value="Aggiungi">
	</form>
</body>
</html>