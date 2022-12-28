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
 * Servlet implementation class AddPlaylistServlet
 */
@WebServlet("/aggiungi-playlist")
public class AddPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Playlist p = new Playlist();
	PlaylistDAO dao = new PlaylistDAO();
       
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			p.setTitolo(req.getParameter("titolo"));
			p.setDescrizione(req.getParameter("descrizione"));
			p.setVisibilita(Integer.parseInt(req.getParameter("visibilita")));
			
			dao.insert(p);
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	
}
