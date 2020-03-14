package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import database.JpaDAOFactory;
import model.Veicolo;
import utils.Utils;

@WebServlet("/SearchVeicolo")
public class SearchVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Date dataInizio = null;
		Date dataFine = null;
		try{
			dataInizio = Date.valueOf(request.getParameter("dataInizio"));
			dataFine = Date.valueOf(request.getParameter("dataFine"));
		}
		catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
		
		if(Utils.validateDataNoleggio(dataInizio, dataFine)) {
			if(dataInizio != null && dataFine!= null) {
				int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
				List<Veicolo> veicolos = JpaDAOFactory.getDaoFactory().getVeicoloDAO().getVeicoliDisponibili(dataInizio, dataFine, DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(id_categoria));
				
				Set<Veicolo> veicoliSet = new TreeSet<>((Veicolo o1, Veicolo o2) -> {
					int risultato = o1.getMarca().compareTo(o2.getMarca());
					if (risultato == 0) {
						risultato = o1.getModello().compareTo(o2.getModello());
					}
					return risultato;
				});
				veicoliSet.addAll(veicolos);
				
				session.setAttribute("veicoliDisponibili", veicoliSet);
				session.setAttribute("dataInizio", dataInizio);
				session.setAttribute("dataFine", dataFine);
				response.sendRedirect("utente/searchveicolo");
			}
		}
		else {
			response.sendRedirect("utente/home");
		}
		
		
	}
}
