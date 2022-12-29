package it.bitcamp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VideoDAO {

	Connection conn;

	public VideoDAO() {
		this.conn = ConnectionManager.getInstance().getConn();
	}
	
	public void insert(Video v) {
		String sql = "INSERT INTO yt_video VALUES(null, '" + v.getTitolo() + "', '" + v.getCodice() + "', '" + v.getDurata() + "', '" + v.getData_inserimento() + "', '" + v.getGenere() + "', '" + v.getDescrizione() + "', '" + v.getAutore() + "');";
		int risultato = 0;
		try {
			Statement stmt = this.conn.createStatement();
			risultato = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM yt_video WHERE id =" + id + ";";
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Video getById(int id) {
		Video v = new Video();
		String sql = "SELECT * FROM yt_video WHERE id=" + id + ";";
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			v.setId(rs.getInt("id"));
			v.setTitolo(rs.getString("titolo"));
			v.setCodice(rs.getString("codice"));
			v.setDurata(rs.getString("durata"));
			v.setDescrizione(rs.getString("descrizione"));
			v.setAutore(rs.getString("autore"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	
	public void addVideoToPlaylist(int idVideo, int idPlaylist) {
		String sql = "INSERT INTO yt_playlist_manager VALUES(" + idVideo + "," + idPlaylist + ");";
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeVideoFromPlaylist(int idVideo, int idPlaylist) {
		String sql = "DELETE FROM yt_playlist_manager WHERE id_video = " + idVideo + " AND " + "id_playlist = " + idPlaylist + ";";
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
