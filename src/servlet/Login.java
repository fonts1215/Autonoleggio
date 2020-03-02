
package servlet;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import model.*;

@WebServlet("/login")
public class Login extends HttpServlet{  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Utente u_session = (Utente) session.getAttribute("utente");
		if(u_session != null) {
			if(u_session.getEmailUser().equals("admin"))
				new AdminPage().doPost(request, response);
			else 
				new ClientPage().doPost(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String emailInsert = null;
		String passInsert = null;
		String emailFromCookie = null;
		String passFromCookie = null;
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("email"))
				emailFromCookie = c.getValue();
			if(c.getName().equals("password"))
				passFromCookie = c.getValue();			
		}
		
		if(DaoFactory.getDaoFactory().getUtenteDAO().findUser(emailFromCookie) != null) {
			emailInsert = emailFromCookie;
			passInsert = passFromCookie;
		}
		else {
			emailInsert = request.getParameter("user");
			passInsert = request.getParameter("pass");
		}
		
		HttpSession session = request.getSession();
		Utente user = DaoFactory.getDaoFactory().getUtenteDAO().findUser(emailInsert);
		if(user != null) {
			Cookie cookie = new Cookie("email", user.getEmailUser());
			Cookie cookie2 = new Cookie("password", user.getPasswordUser());
			cookie.setMaxAge(3600);
			cookie2.setMaxAge(3600);
			response.addCookie(cookie);
			response.addCookie(cookie2);
			if(user.getEmailUser().equals(emailInsert) && user.isCorrectPassword(passInsert) && !(user.getEmailUser().equals("admin"))) {
				session.setAttribute("utente", user);
				request.getRequestDispatcher("/ClientPage").forward(request, response);
			}
			else if(user.getEmailUser().equals(emailInsert) && user.isCorrectPassword(passInsert) && user.getEmailUser().equals("admin")){
				session.setAttribute("utente", user);
				request.getRequestDispatcher("/AdminPage").forward(request, response);
			}
			else {
				response.sendRedirect("/Autonoleggio/login.jsp?errore=Unauthorized");
			}
		}
		else {
			response.sendRedirect("/Autonoleggio/login.jsp?errore=UtenteNonTrovato");
		}			
	} 

}
