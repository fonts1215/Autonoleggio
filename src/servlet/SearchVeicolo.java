package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import database.JpaDAOFactory;
import model.Veicolo;

@WebServlet("/SearchVeicolo")
public class SearchVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date dataInizio = Date.valueOf(request.getParameter("dataInizio"));
		Date dataFine = null;
		try {
			dataFine = Date.valueOf(request.getParameter("dataFine"));
		}catch (IllegalArgumentException e) {}
		
		if(dataInizio != null && dataFine!= null) {
			int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
			List<Veicolo> veicolos = JpaDAOFactory.getDaoFactory().getVeicoloDAO().getVeicoliDisponibili(dataInizio, dataFine, DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(id_categoria));
			request.setAttribute("utente", JpaDAOFactory.getDaoFactory().getUtenteDAO().findUser(request.getParameter("email_utente")));
			request.setAttribute("veicoli", veicolos);
			request.setAttribute("dataInizio", dataInizio);
			request.setAttribute("dataFine", dataFine);
			request.setAttribute("caterogie", JpaDAOFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("/WEB-INF/veicoliPrenotabili.jsp").forward(request, response);
		}else if(dataInizio != null && dataFine == null) {
			int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
			List<Veicolo> veicolos = JpaDAOFactory.getDaoFactory().getVeicoloDAO().getVeicoliDisponibili(dataInizio, DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(id_categoria));
			request.setAttribute("utente", JpaDAOFactory.getDaoFactory().getUtenteDAO().findUser(request.getParameter("email_utente")));
			request.setAttribute("veicoli", veicolos);
			request.setAttribute("dataInizio", dataInizio);
			request.setAttribute("dataFine", dataFine);
			request.getRequestDispatcher("/WEB-INF/veicoliPrenotabili.jsp").forward(request, response);
		}
	}
}
