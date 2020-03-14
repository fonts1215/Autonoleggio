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
import model.Noleggio;
import model.Utente;

@WebServlet("/DeletePrenotazione")
public class DeletePrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Noleggio noleggio = DaoFactory.getDaoFactory().getNoleggioDAO().findNoleggio(Integer.parseInt(request.getParameter("noleggio")));
		JpaDAOFactory.getDaoFactory().getNoleggioDAO().deleteNoleggio(noleggio);
		Utente utente = (Utente) session.getAttribute("utente");
		session.setAttribute("noleggi", DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi(utente));	
		response.sendRedirect(request.getContextPath()+"/utente/home");
	}
}
