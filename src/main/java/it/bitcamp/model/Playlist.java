package it.bitcamp.model;

public class Playlist {

	private int id;
	private String titolo;
	private String descrizione;
	private int visibilita;
	
	public Playlist() {
		
	}

	public Playlist(int id, String titolo, String descrizione, int visibilita) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.visibilita = visibilita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getVisibilita() {
		return visibilita;
	}

	public void setVisibilita(int visibilita) {
		this.visibilita = visibilita;
	}
	
	
	
}
