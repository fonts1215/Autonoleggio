package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String email_utente = request.getParameter("email_utente");
		String targa_veicolo = request.getParameter("targa_veicolo");
		
		Date dataInizio =  Utils.dateFromString(request.getParameter("dataInizio"));  //data inzio e data fine
		Date dataFine =  Utils.dateFromString(request.getParameter("dataFine"));
		
		//Date dataFine = Date.valueOf(request.getParameter("dataFine"));
		Veicolo veicolo = JpaDAOFactory.getDaoFactory().getVeicoloDAO().findVeicolo(targa_veicolo);
		Utente utente = JpaDAOFactory.getDaoFactory().getUtenteDAO().findUser(email_utente);
		Noleggio noleggio = new Noleggio((dataFine.compareTo(dataInizio))*veicolo.getCategoria().getTGiornaliera() , dataInizio, dataFine, utente, veicolo); //TODO gestire la scelta giornaliera-mensile-settimanale
		try{
			JpaDAOFactory.getDaoFactory().getNoleggioDAO().inserisciNoleggio(noleggio);
			request.setAttribute("risultato", "prenotazioneEffettuata");
			request.setAttribute("username", utente);
			request.setAttribute("categoria", DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie());
			request.getRequestDispatcher("ClientPage").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("risultato", "errore");
		}
	}

}
