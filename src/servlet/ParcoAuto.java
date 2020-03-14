package servlet;

import java.io.IOException;
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
import model.Veicolo;
/**
 * Servlet implementation class ParcoAuto
 */
@WebServlet("/ParcoAuto")
public class ParcoAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Veicolo> veicoli = DaoFactory.getDaoFactory().getVeicoloDAO().getAuto();
		Set<Veicolo> veicoliSet = new TreeSet<>((Veicolo o1, Veicolo o2) -> {
			int risultato = o1.getMarca().compareTo(o2.getMarca());
			if (risultato == 0) {
				risultato = o1.getModello().compareTo(o2.getModello());
			}
			return risultato;
		});
		veicoliSet.addAll(veicoli);
		
		session.setAttribute("parcoauto", veicoliSet);
		response.sendRedirect("utente/parcoauto");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
