package it.bitcamp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.bitcamp.model.Video;
import it.bitcamp.model.VideoDAO;

@WebServlet("/aggiungi")
public class AddVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Video v = new Video();
	VideoDAO dao = new VideoDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDate ld = LocalDate.of(2022, 06, 06);
		v.setTitolo(request.getParameter("titolo"));
		v.setCodice(request.getParameter("codice"));
		v.setDurata(request.getParameter("durata"));
		v.setData_inserimento(ld);
		v.setGenere(request.getParameter("genere"));
		v.setDescrizione(request.getParameter("descrizione"));
		v.setAutore(request.getParameter("autore"));
		
		dao.insert(v);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
