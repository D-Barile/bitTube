<%@ page import = "java.sql.*" %>

<div class="container-fluid">
	<div class="row">
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
			
			while(rs.next()){
				id = rs.getInt("id");
				titolo = rs.getString("titolo");
				codice = rs.getString("codice");
				durata = rs.getString("durata");
				genere = rs.getString("genere");
				descrizione = rs.getString("descrizione");
//				descrizione = descrizione.replaceAll("'", "\\\\'");
				descrizioneCompleta = descrizione;
				if(descrizione.length() > 80){
					descrizione = descrizione.substring(0, 80) + "...";
				}
				autore = rs.getString("autore");
		%>
		<!-- Singolo video [init] -->
		<div id="container_video_<%= id %>" class="col-3 classeContenitoreVideo">
			<jsp:include page="single-video.jsp" >
				<jsp:param value="<%= id %>" name="id"/>
				<jsp:param value="<%= titolo %>" name="titolo" />
				<jsp:param value="<%= codice %>" name="codice" />
				<jsp:param value="<%= durata %>" name="durata" />
				<jsp:param value="<%= genere %>" name="genere" />
				<jsp:param value="<%= descrizione %>" name="descrizione" />
				<jsp:param value="<%= descrizioneCompleta %>" name="descrizioneCompleta" />
				<jsp:param value="<%= autore %>" name="autore" />
			</jsp:include>
		</div>
		<!-- Singolo video [end] -->
		<%
			}
		%>
	</div>
</div>