package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import database.JpaDAOFactory;
import model.Utente;

/**
 * Servlet implementation class ClientPage
 */
@WebServlet("/ClientPage")
public class ClientPage extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente user = (Utente) session.getAttribute("utente");
		session.setAttribute("utente", user);
		session.setAttribute("categoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
		session.setAttribute("codice", "");
		session.setAttribute("noleggi", DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi(user));
		request.getRequestDispatcher("/WEB-INF/clientPage.jsp").forward(request, response);
	}
}
