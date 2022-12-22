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
		String sql = "SELECT id, titolo, descrizione FROM yt_playlist WHERE visibilita = 1;";
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
	</div>
	<!-- Playlist button [end] -->
	<% } %>
</div>
<!-- Sidebar [end] -->

<script>
	// Funzione AJAX
	function asyncRequestVideo(idPlaylist){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			//alert(this.responseText);
			// Visualizzo tutti gli elementi con classe classeContenitoreVideo -> display = block
			var arrayContainerVideo = document.getElementsByClassName("classeContenitoreVideo"); // Seleziono tutti i video sullo stage
			var arrayCurrentVideos = this.responseText.split("|"); // Seleziono gli ID della playlist
			arrayCurrentVideos.pop(); // Elimina l'ultimo elemento, cioè |
			
			for(var i=0; i < arrayContainerVideo.length; i++){ // Ciclo su tutti i video sullo stage
				var idVideo = arrayContainerVideo[i].id; // ID corrente del video sullo stage
				
				if(arrayCurrentVideos.includes(idVideo)){
					arrayContainerVideo[i].style.display = "block";
				}else{
					arrayContainerVideo[i].style.display = "none";
				}
			}
		}
		xhttp.open("GET", "VideoServlet?id=" + idPlaylist);
		xhttp.send();
	}
	
	function showAllVideos(){
		var arrayContainerVideo = document.getElementsByClassName("classeContenitoreVideo");
		for(var i=0; i<arrayContainerVideo.length; i++){
			arrayContainerVideo[i].style.display = "block";
		}
		// window.location.reload() Metodo alternativo
	}
	
</script>