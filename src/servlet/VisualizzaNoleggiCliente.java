package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import model.*;

/**
 * Servlet implementation class VisualizzaNoleggiCliente
 */
@WebServlet("/VisualizzaNoleggiCliente")
public class VisualizzaNoleggiCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_utente = request.getParameter("user_email");
		Utente utente = DaoFactory.getDaoFactory().getUtenteDAO().findUser(email_utente);
		List<Noleggio> noleggi = DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi(utente);
		HttpSession session = request.getSession();
		session.setAttribute("noleggi", noleggi);
		session.setAttribute("utente_noleggi", utente);
		request.getRequestDispatcher("/WEB-INF/prenotazioniUtente.jsp").forward(request, response);
	} 

}
