package it.bitcamp.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
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
			System.out.print("Email o password errate");
		}
			
	}
}
