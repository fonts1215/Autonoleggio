package database.JPA;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import database.DaoFactory;
import database.JpaDAOFactory;
import database.interfaces.NoleggioDAO;
import model.Noleggio;
import model.Utente;
import model.Veicolo;
import utils.Utils;

public class JpaNoleggioDAO implements NoleggioDAO {
	private static JpaNoleggioDAO instance = null;

	private JpaNoleggioDAO() {

	}

	public static JpaNoleggioDAO getInstance() {
		if (instance == null) {
			instance = new JpaNoleggioDAO();
		}
		return instance;
	}
	
	public List<Noleggio> getNoleggi() {
		EntityManager manager = JpaDAOFactory.getManager();
		return manager.createNamedQuery("Noleggio.findAll").getResultList();
	}

	@Override
	public void inserisciNoleggio(Noleggio noleggio) {
		System.out.println("noleggio da inserire:  " + noleggio);
		EntityManager manager = JpaDAOFactory.getManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(noleggio); // TODO impostare eccezione specifica
		transaction.commit();
	}

	@Override
	public List<Noleggio> getNoleggi(Utente utente) {
		List<Noleggio> noleggi = null;
		Query query = JpaDAOFactory.getManager().createQuery("SELECT n FROM Noleggio n WHERE n.utente = :para");
		query.setParameter("para", utente);
		try {
			noleggi = query.getResultList();
		} catch (NoResultException e) {
		}
		return noleggi;
	}

	@Override
	public Noleggio findNoleggio(int idRental) {
		Query query = JpaDAOFactory.getManager().createQuery("SELECT n FROM Noleggio n WHERE n.idRental like :para1");
		query.setParameter("para1", idRental);
		Noleggio n = null;
		try {
			n = (Noleggio) query.getSingleResult();
		} catch (NoResultException e) {
		}
		return n;
	}

	@Override
	public int deleteNoleggio(Noleggio noleggio) {
		if (noleggio != null) {
			if (!Utils.isGreaterThanToday(noleggio.getStartRental())) {
				EntityManager manager = JpaDAOFactory.getManager();
				manager.getTransaction().begin();
				Noleggio asd = manager.merge(noleggio);
				manager.remove(asd);
				manager.getTransaction().commit();
				return 1;
			} else {
				return 0;
			}
		}
		else
			return 0;
	}

	@Override
	public int noleggiMese() {
		LocalDate now = LocalDate.now();
		int mese = now.getMonthValue();
		List<Noleggio> noleggi = getNoleggi();
		
		return 0;
	}

	@Override
	public double fatturatoMensile() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
