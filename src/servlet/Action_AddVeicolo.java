package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Veicolo;

/**
 * Servlet implementation class Action_AddVeicolo
 */
@WebServlet("/Action_AddVeicolo")
public class Action_AddVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Veicolo veicolo = null;
		boolean success = false;
		
		veicolo = new Veicolo(0.0,					//TODO Impostare capacità del serbatoio
				request.getParameter("colore"), 
				request.getParameter("marca"), 
				request.getParameter("modello"), 
				Integer.parseInt(request.getParameter("n_Posti")), 
				request.getParameter("targa"),
				DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(request.getParameter("categoria"))); //TODO Verificare il corretto funzionamento della Categoria
		
		if (veicolo != null) {
			success = DaoFactory.getDaoFactory().getVeicoloDAO().addVeicolo(veicolo);
		}
		if (success) {
			request.setAttribute("username", "admin");
			request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
			request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
			request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("WEB-INF/adminPage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("username", "admin");
			request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
			request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
			request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("WEB-INF/adminPage.jsp?errore=Errore durante l'aggiunta").forward(request, response);
		}
	}
}
