package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import database.DaoFactory;


@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("utente");
		session.setAttribute("dbUtenti", DaoFactory.getDaoFactory().getUtenteDAO().getUtenti());
		session.setAttribute("dbVeicoli", DaoFactory.getDaoFactory().getVeicoloDAO().getAuto());
		session.setAttribute("dbCategoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
		request.getRequestDispatcher("/WEB-INF/adminPage.jsp").forward(request, response);
	}

}
