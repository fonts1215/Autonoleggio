package servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Utente;
import utils.Utils;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailInsert = request.getParameter("email");
		if (DaoFactory.getDaoFactory().getUtenteDAO().findUser(emailInsert) == null) {

			Utente utente = new Utente(Date.valueOf(LocalDate.parse(request.getParameter("nascita"))),
					request.getParameter("email"), request.getParameter("nome"), request.getParameter("password"),
					request.getParameter("cognome"));

			if (utente != null) {
				if(Utils.isAdult(utente.getBirthdateUser())) {
					DaoFactory.getDaoFactory().getUtenteDAO().addUser(utente);
					response.sendRedirect("/Autonoleggio/login.jsp?errore=utenteCreato");
				}else {
					response.sendRedirect("/Autonoleggio/login.jsp?errore=utenteMinorenne");
				}
			}
		} else {
			response.sendRedirect("/Autonoleggio/login.jsp?errore=UsernameUsed");
		}
	}
}
