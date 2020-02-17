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
public class Delete_Veicolo_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory.getDaoFactory().getVeicoloDAO().deleteVeicolo(request.getParameter("targa"));
		
		request.setAttribute("username", "admin");
		request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
		request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
		request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
		request.getRequestDispatcher("WEB-INF/adminPage.jsp").forward(request, response);
	}

}
