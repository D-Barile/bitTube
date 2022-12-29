package it.bitcamp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlaylistDAO {

	Connection conn;

	public PlaylistDAO() {
		this.conn = ConnectionManager.getInstance().getConn();
	}
	
	public void insert(Playlist p) {
		String sql = "INSERT INTO yt_playlist VALUES(null, '" + p.getTitolo() + "', '" + p.getDescrizione() + "', " + p.getVisibilita() + ");";
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM yt_playlist WHERE id =" + id + ";";
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Playlist getById(int id) {
		Playlist p = new Playlist();
		String sql = "SELECT * FROM yt_playlist WHERE id =" + id + ";";
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			p.setId(rs.getInt("id"));
			p.setTitolo(rs.getString("titolo"));
			p.setDescrizione(rs.getString("descrizione"));
			p.setVisibilita(rs.getInt("visibilita"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void updateTitolo(Playlist p) {
		String sql = "UPDATE yt_playlist SET titolo = '" + p.getTitolo() + "' WHERE id = '" + p.getId() + "';";
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDescrizione(Playlist p) {
		String sql = "UPDATE yt_playlist SET descrizione = '" + p.getDescrizione() + "' WHERE id = '" + p.getId() + "';";
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateVisibilita(Playlist p) {
		String sql = "UPDATE yt_playlist SET visibilita = '" + p.getVisibilita() + "' WHERE id = '" + p.getId() + "';";
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
