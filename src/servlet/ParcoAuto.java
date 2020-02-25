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
import model.Veicolo;

/**
 * Servlet implementation class ParcoAuto
 */
@WebServlet("/ParcoAuto")
public class ParcoAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Veicolo> veicoli = DaoFactory.getDaoFactory().getVeicoloDAO().getAuto(); 
		if(session.getAttribute("parcoauto") == null)
			session.setAttribute("parcoauto", veicoli);
		request.getRequestDispatcher("/WEB-INF/parcoAuto.jsp").forward(request, response);
	}

}
