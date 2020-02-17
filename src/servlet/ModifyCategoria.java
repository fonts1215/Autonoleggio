package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Categoria;

/**
 * Servlet implementation class ModifyCategoria
 */
@WebServlet("/ModifyCategoria")
public class ModifyCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Categoria categoria = new Categoria(request.getParameter("descrizione"), 
				request.getParameter("nomeCategoria"), Double.parseDouble(request.getParameter("t_giornaliera")),
						Double.parseDouble(request.getParameter("t_mensile")), Double.parseDouble(request.getParameter("t_settimanale")));
		
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		DaoFactory.getDaoFactory().getCategoriaDAO().updateCategoria(categoria, id_categoria);
		request.setAttribute("username", "admin");
		request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
		request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
		request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
		request.getRequestDispatcher("WEB-INF/adminPage.jsp").forward(request, response);
	}
}
