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

function showMoreInformation(codice){
	let status = document.getElementById("desc_state_" + codice);
	let descrizione = document.getElementById("desc_" + codice);
	let descrizioneCompleta = document.getElementById("desc_long_" + codice);
	let descrizioneBreve = document.getElementById("desc_short_" + codice);
	if(status.value == 0){
		// Inserisco la descrizione lunga
		descrizione.innerHTML = descrizioneCompleta.value;
		// Aggiorno lo stato
		status.value = 1; // Stato descrizione lunga
	}else{
		// Inserisco la descrizione breve
		descrizione.innerHTML = descrizioneBreve.value;
		// Aggiorno lo stato
		status.value = 0; // Stato descrizione breve
	}
}

function myFunction(){
	document.getElementById("myDropdown").classList.toggle("show")
}

window.onclick = function(event){
	if(!event.target.matches('.dropbtn')){
		var dropdowns = document.getElementsByClassName("dropdown-content");
		var i;
		for(i = 0; i < dropdowns.length; i++){
			var openDropdown= dropdowns[i];
			if(openDropdown.classList.contains('show')){
				openDropdown.classList.remove('show');
			}
		}
	}
}
