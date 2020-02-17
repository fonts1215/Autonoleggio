
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Utente;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;		//distingue in maniera univoca la classe
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
		//response.getWriter().append("doGet()-Served at: ").append(request.getContextPath());
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailInsert = request.getParameter("user");
		String passInsert = request.getParameter("pass");
		Utente user = DaoFactory.getDaoFactory().getUtenteDAO().findUser(emailInsert);	
		if(user != null) {
			if(user.getEmailUser().equals(emailInsert) && user.isCorrectPassword(passInsert) && !(user.getEmailUser().equals("admin"))) {
				request.setAttribute("username", user);
				request.setAttribute("categoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
				request.getRequestDispatcher("/WEB-INF/clientPage.jsp").forward(request, response);
			}
			else if(user.getEmailUser().equals(emailInsert) && user.isCorrectPassword(passInsert) && user.getEmailUser().equals("admin")){
				request.setAttribute("username", user);
				request.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
				request.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
				request.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
				request.getRequestDispatcher("/WEB-INF/adminPage.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("/Autonoleggio/login.jsp?errore=Unauthorized");
			}
		}
		else {
			response.sendRedirect("/Autonoleggio/login.jsp?errore=UtenteNonTrovato");
		}			
	} 
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}	
