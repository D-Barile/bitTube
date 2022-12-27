package it.bitcamp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String email = "prova@gmail.com";
	private final String password = "prova";
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramEmail = req.getParameter("email");
		String paramPassword = req.getParameter("password");
		
		if(email.equals(paramEmail) && password.equals(paramPassword)) {
			// Autenticazione corretta
			HttpSession oldSession = req.getSession(false);
			if(oldSession != null) {
				oldSession.invalidate(); // Invalida la sessione se esiste
			}
			HttpSession currentSession = req.getSession(); // Crea una nuova sessione
				currentSession.setAttribute("email", paramEmail);
				currentSession.setMaxInactiveInterval(5*60); // 5 minuti di inattività massima
				resp.sendRedirect("index.jsp");
		} else {
			resp.getWriter().append("Email o password errate!");
			resp.setHeader("refresh", "2; index.jsp");
		}
	}
}
