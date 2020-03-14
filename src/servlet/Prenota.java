package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DaoFactory;
import database.JpaDAOFactory;
import model.*;
import utils.Utils;

/**
 * Servlet implementation class Prenota
 */
@WebServlet("/Prenota")
public class Prenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String targa_veicolo = request.getParameter("targa_veicolo");
		//TODO sulla verità della targa se corrisponde con i dati attesi
		
		Date dataInizio =  (Date) session.getAttribute("dataInizio");  //data inzio e data fine
		Date dataFine =  (Date) session.getAttribute("dataFine");
		Utente utente = (Utente) session.getAttribute("utente");
		
		
		Veicolo veicolo = JpaDAOFactory.getDaoFactory().getVeicoloDAO().findVeicolo(targa_veicolo);
		Noleggio noleggio = new Noleggio(Utils.calcolaAmount(veicolo, dataInizio, dataFine), dataInizio, dataFine, utente, veicolo); 
		try{
			JpaDAOFactory.getDaoFactory().getNoleggioDAO().inserisciNoleggio(noleggio);
			session.setAttribute("codice", "prenotazioneEffettuata");
			session.setAttribute("noleggi", DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi(utente));
			session.removeAttribute("dataFine");
			session.removeAttribute("dataInizio");
			response.sendRedirect(request.getContextPath()+"/utente/home");
		}catch (Exception e) {
			request.setAttribute("risultato", "errore");
		}
	}
}
