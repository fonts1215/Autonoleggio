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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			request.getRequestDispatcher("/WEB-INF/adminPage.jsp?event=success").forward(request, response);	
		}else {
			Utente user = DaoFactory.getDaoFactory().getUtenteDAO().findUser("admin");
			request.setAttribute("username", user);
			request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
			request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
			request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("/WEB-INF/adminPage.jsp?event=success").forward(request, response);	
		}
	}

}
