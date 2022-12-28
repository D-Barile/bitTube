<%@ page import = "java.sql.*" %>

<!-- Sidebar [init] -->
<div class="row">
	<!-- Playlist button [init] -->
	<div class="col-12 mb-3">
		<button type="button" class="btn btn-light w-100" onClick="showAllVideos();">
			<i class="fa fa-home" aria-hidden="true"></i>
			Home
		</button>
	</div>
	<!-- Playlist button [end] -->
	<%
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bittube", "root", "0810");
		String sql = "";
		
		String email = null;
		if(session.getAttribute("email") == null){
			sql = "SELECT id, titolo, descrizione FROM yt_playlist WHERE visibilita = 1;";
		} else{
			email = (String)session.getAttribute("email");
			sql = "SELECT id, titolo, descrizione FROM yt_playlist";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rsPlaylist = ps.executeQuery();
		
		int id = 0;
		String titolo = "";
		String descrizione = "";
		
		while(rsPlaylist.next()){
			id = rsPlaylist.getInt("id");
			titolo = rsPlaylist.getString("titolo");
			descrizione = rsPlaylist.getString("descrizione");
	%>
	<!-- Playlist button [init] -->
	<div class="col-12 mb-3">
		<button type="button" class="btn btn-light w-100" onClick="asyncRequestVideo('<%= id %>');">
			<i class="fa fa-music" aria-hidden="true"></i>
			<%= titolo %>
		</button>
		<%
			if(session.getAttribute("email") != null){
		%>
				<a href="${pageContext.servletContext.contextPath}/elimina-playlist?id=<%= id %>" style="margin-left: 50%;"> <i class="fa fa-trash" aria-hidden="true"></i></a>
		<%
			} 
		%>
	</div>
	<!-- Playlist button [end] -->
	<% } %>
	<%
		if(session.getAttribute("email") != null){
	%>
	<button type="button" class="btn btn-light w-100">
		<a href="aggiungiPlaylist.jsp">Aggiungi una playlist</a>
	</button>
	<% } %>
</div>
<!-- Sidebar [end] -->