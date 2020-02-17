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

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nascita"));

		String emailInsert = request.getParameter("email");
		if (DaoFactory.getDaoFactory().getUtenteDAO().findUser(emailInsert) == null) {

			Utente utente = new Utente(Date.valueOf(LocalDate.parse(request.getParameter("nascita"))),
					request.getParameter("email"), request.getParameter("nome"), request.getParameter("password"),
					request.getParameter("cognome"));

			if (utente != null) {
				System.out.println("aggiungo");
				DaoFactory.getDaoFactory().getUtenteDAO().addUser(utente);
				System.out.println(utente.toString());
				response.sendRedirect("/Autonoleggio/login.jsp?errore=utenteCreato");
			}
		} else {
			response.sendRedirect("/Autonoleggio/login.jsp?errore=UsernameUsed");
		}
	}
}
