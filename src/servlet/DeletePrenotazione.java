package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import database.JpaDAOFactory;
import model.Noleggio;

@WebServlet("/DeletePrenotazione")
public class DeletePrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noleggio noleggio = DaoFactory.getDaoFactory().getNoleggioDAO().findNoleggio(Integer.parseInt(request.getParameter("noleggio")));
		JpaDAOFactory.getDaoFactory().getNoleggioDAO().deleteNoleggio(noleggio);
		request.getRequestDispatcher("ClientPage").forward(request, response);
	}

}
