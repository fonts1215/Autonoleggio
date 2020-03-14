
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import model.*;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u_session = (Utente) session.getAttribute("utente");
		if (u_session != null) {
			if (u_session.getEmailUser().equals("admin"))
				new AdminPage().doPost(request, response);
			else
				response.sendRedirect(request.getContextPath() + "/utente/home");
				
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailInsert = emailInsert = request.getParameter("user");
		String passInsert = passInsert = request.getParameter("pass");

		HttpSession session = request.getSession();
		Utente user = DaoFactory.getDaoFactory().getUtenteDAO().findUser(emailInsert);
		
		if (user != null) {
			if (user.getEmailUser().equals(emailInsert) && user.isCorrectPassword(passInsert)
					&& !(user.getEmailUser().equals("admin"))) {
				session.setAttribute("utente", user);
				session.setAttribute("categoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
				session.setAttribute("codice", "");
				session.setAttribute("noleggi", DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi(user));
				response.sendRedirect(request.getContextPath() + "/utente/home");
			} else if (user.getEmailUser().equals(emailInsert) && user.isCorrectPassword(passInsert)
					&& user.getEmailUser().equals("admin")) {
				session.setAttribute("utente", user);
				request.getRequestDispatcher("/AdminPage").forward(request, response);
			} else {
				response.sendRedirect("/Autonoleggio/login.jsp?errore=Unauthorized");
			}
		} else {
			response.sendRedirect("/Autonoleggio/login.jsp?errore=UtenteNonTrovato");
		}
	}

}
