package database.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import database.DaoFactory;
import database.JpaDAOFactory;
import database.interfaces.NoleggioDAO;
import model.Noleggio;

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
}
