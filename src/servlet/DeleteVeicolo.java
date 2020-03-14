package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import model.Utente;

/**
 * Servlet implementation class Delete_Veicolo
 */
public class DeleteVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String targa = request.getParameter("targa");
		HttpSession session = request.getSession();
		DaoFactory.getDaoFactory().getVeicoloDAO().deleteVeicolo(DaoFactory.getDaoFactory().getVeicoloDAO().findVeicolo(targa));
		Utente utente = (Utente) session.getAttribute("utente");
		session.setAttribute("noleggi", DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi(utente));		
		response.sendRedirect(request.getContextPath()+"/utente/home");
	}
}
	