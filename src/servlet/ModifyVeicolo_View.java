package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Veicolo;

/**
 * Servlet implementation class ModifyVeicolo
 */

public class ModifyVeicolo_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String targa = request.getParameter("targa");
		Veicolo veicolo = DaoFactory.getDaoFactory().getVeicoloDAO().findVeicolo(targa);
		request.setAttribute("veicolo", veicolo);
		request.getRequestDispatcher("/WEB-INF/Modify_Veicolo.jsp").forward(request, response);
	}

}
