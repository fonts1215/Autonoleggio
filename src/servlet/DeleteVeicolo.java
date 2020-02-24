package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;

/**
 * Servlet implementation class Delete_Veicolo
 */
@WebServlet("/Delete_Veicolo")
public class DeleteVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String targa = request.getParameter("targa");
		DaoFactory.getDaoFactory().getVeicoloDAO().deleteVeicolo(DaoFactory.getDaoFactory().getVeicoloDAO().findVeicolo(targa));
		request.setAttribute("username", "admin");
		request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
		request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
		request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
		request.getRequestDispatcher("WEB-INF/adminPage.jsp").forward(request, response);
	}
}
