package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.*;
/**
 * Servlet implementation class Categoria
 */
@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeCategoria = request.getParameter("categoria");
		System.out.println("categoria clicked: " + nomeCategoria);
		model.Categoria categoria = DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(nomeCategoria);
		List<Veicolo> veicoli = DaoFactory.getDaoFactory().getVeicoloDAO().getAutoPerCategoria(categoria);
		System.out.println("veicoli: " + veicoli);
		System.out.println("categoria: " + categoria.toString());
		request.setAttribute("veicoli", veicoli);
		request.setAttribute("categoria", categoria);
		request.getRequestDispatcher("WEB-INF/visualizzaVeicoli.jsp").forward(request, response);
	}
}
