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
 * Servlet implementation class ModifyVeicolo
 */
@WebServlet("/ModifyVeicolo")
public class ModifyVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyVeicolo() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("myTest" + request.getParameter("id_veicolo"));
		int id_veicolo = Integer.parseInt(request.getParameter("id_veicolo"));
		int categoria = Integer.parseInt(request.getParameter("categoria"));

		Veicolo newVeicolo = new Veicolo(id_veicolo , 0.0, // TODO Impostare capacità del serbatoio
				request.getParameter("colore"), request.getParameter("marca"), request.getParameter("modello"),
				Integer.parseInt(request.getParameter("n_Posti")), request.getParameter("targa"),
				DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(categoria)); // TODO
																
		DaoFactory.getDaoFactory().getVeicoloDAO().updateVeicolo(newVeicolo);
		
		request.setAttribute("username", "admin");
		request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
		request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
		request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
		request.getRequestDispatcher("WEB-INF/adminPage.jsp").forward(request, response);
	}
}
