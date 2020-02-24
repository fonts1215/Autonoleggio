package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Categoria;
import model.Utente;

/**
 * Servlet implementation class AddCategoria
 */
@WebServlet("/AddCategoria")
public class AddCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Categoria categoria = new Categoria(request.getParameter("descrizione"), 
				request.getParameter("nomeCategoria"), Double.parseDouble(request.getParameter("t_giornaliera")),
						Double.parseDouble(request.getParameter("t_mensile")), Double.parseDouble(request.getParameter("t_settimanale")));
		
		boolean success = DaoFactory.getDaoFactory().getCategoriaDAO().addCategoria(categoria);
		if(success) {
			Utente user = DaoFactory.getDaoFactory().getUtenteDAO().findUser("admin");
			request.setAttribute("username", user);
			request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
			request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
			request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("login").forward(request, response);	
		}else {
			Utente user = DaoFactory.getDaoFactory().getUtenteDAO().findUser("admin");
			request.setAttribute("username", user);
			request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
			request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
			request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("login").forward(request, response);	
		}
	}

}
