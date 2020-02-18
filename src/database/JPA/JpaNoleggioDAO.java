package database.JPA;

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

	@Override
	public void inserisciNoleggio(Noleggio noleggio) {
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
		} catch (NoResultException e) {}
		return noleggi;
	}
}
