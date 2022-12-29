package it.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.bitcamp.model.VideoDAO;

/**
 * Servlet implementation class AddVideoToPlaylistServlet
 */
@WebServlet("/aggiungi-video-alla-playlist")
public class AddVideoToPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VideoDAO dao = new VideoDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("aggiungi-video-alla-playlist.jsp").include(req, resp);
		dao.addVideoToPlaylist(Integer.parseInt(req.getParameter("id")), Integer.parseInt(req.getParameter("idPlaylist")));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}