package it.bitcamp.model;

import java.sql.Connection;
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
	
}
