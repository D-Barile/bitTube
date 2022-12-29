package it.bitcamp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.bitcamp.model.Video;
import it.bitcamp.model.VideoDAO;

/**
 * Servlet implementation class UpdateVideoServlet
 */
@WebServlet("/update-video")
public class UpdateVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VideoDAO dao = new VideoDAO();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Video video = new Video();
			video = dao.getById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("video", video);
			req.getRequestDispatcher("aggiorna-video.jsp").forward(req, resp);
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
			Video v = new Video();
			v.setTitolo(req.getParameter("titolo"));
			v.setCodice(req.getParameter("codice"));
			v.setDurata(req.getParameter("durata"));
			v.setGenere(req.getParameter("genere"));
			v.setDescrizione(req.getParameter("descrizione"));
			v.setAutore(req.getParameter("autore"));
			v.setId(Integer.parseInt(req.getParameter("id")));
			
			dao.updateTitolo(v);
			dao.updateCodice(v);
			dao.updateDurata(v);
			dao.updateGenere(v);
			dao.updateDescrizione(v);
			dao.updateAutore(v);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	
}
