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
 * Servlet implementation class ModifyCategoria_View
 */
@WebServlet("/ModifyCategoria_View")
public class ModifyCategoria_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		System.out.println(id_categoria);
		Categoria categoria = DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(id_categoria);
		System.out.println("Categoria trovata: " + categoria);
		request.setAttribute("categoria", categoria);
		request.getRequestDispatcher("/WEB-INF/modify_category.jsp").forward(request, response); 
	}
}
