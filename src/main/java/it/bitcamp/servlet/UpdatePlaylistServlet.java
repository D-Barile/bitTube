package it.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.bitcamp.model.Playlist;
import it.bitcamp.model.PlaylistDAO;

/**
 * Servlet implementation class UpdatePlaylistServlet
 */
@WebServlet("/aggiorna-playlist")
public class UpdatePlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PlaylistDAO dao = new PlaylistDAO();
       
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Playlist playlist = new Playlist();
			playlist = dao.getById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("playlist", playlist);
			req.getRequestDispatcher("aggiorna-playlist.jsp").forward(req, resp);
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Playlist p = new Playlist();
			p.setId(Integer.parseInt(req.getParameter("id")));
			p.setTitolo(req.getParameter("titolo"));
			p.setDescrizione(req.getParameter("descrizione"));
			p.setVisibilita(Integer.parseInt(req.getParameter("visibilita")));
			
			dao.updateTitolo(p);
			dao.updateDescrizione(p);
			dao.updateVisibilita(p);
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	
}
