package it.bitcamp.model;

import java.sql.Date;
import java.time.LocalDate;

public class Video {

	private int id;
	private String titolo;
	private String codice;
	private String durata;
	private LocalDate data_inserimento;
	private String genere;
	private String descrizione;
	private String autore;
	
	public Video() {
		
	}

	public Video(int id, String titolo, String codice, String durata, LocalDate data_inserimento, String genere,
			String descrizione, String autore) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.codice = codice;
		this.durata = durata;
		this.data_inserimento = data_inserimento;
		this.genere = genere;
		this.descrizione = descrizione;
		this.autore = autore;
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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public LocalDate getData_inserimento() {
		return data_inserimento;
	}

	public void setData_inserimento(LocalDate data_inserimento) {
		this.data_inserimento = data_inserimento;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}
	
}
