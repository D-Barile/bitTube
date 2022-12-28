package it.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.bitcamp.model.VideoDAO;

/**
 * Servlet implementation class DeleteVideoServlet
 */
@WebServlet("/elimina-video")
public class DeleteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VideoDAO dao = new VideoDAO();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			dao.delete(Integer.parseInt(req.getParameter("id")));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	
}
