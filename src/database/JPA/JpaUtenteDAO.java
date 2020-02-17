package database.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import database.JpaDAOFactory;
import database.interfaces.UtenteDAO;
import model.Categoria;
import model.Utente;

public class JpaUtenteDAO implements UtenteDAO{
	private static JpaUtenteDAO instance = null;
	
	// TABELLA UTENTI
	private final static String UTENTI = "utenti";
	private final static String ID_USER = "idUser";
	private final static String EMAIL_USER = "emailUser";
	private final static String PASSWORD_USER = "passwordUser";
	private final static String NAME_USER = "nameUser";
	private final static String SURNAME_USER = "surnameUser";
	private final static String BIRTHDATE_USER = "birthdateUser";
	
	private JpaUtenteDAO() {
		
	}
	
	public static JpaUtenteDAO getInstance() {
		if(instance == null) {
			instance = new JpaUtenteDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> getUtenti() {
		EntityManager manager = JpaDAOFactory.getManager();
		return manager.createNamedQuery("Utente.findAll").getResultList();
	}

	@Override
	public boolean addUser(Utente utente) {
		EntityManager manager = JpaDAOFactory.getManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(utente); //TODO impostare eccezione specifica
		transaction.commit();
		return true;
	}

	@Override
	public Utente findUser(String s) {
		Query query = JpaDAOFactory.getManager().createQuery("SELECT u FROM Utente u WHERE u.emailUser like :para1");
		query.setParameter("para1", s);
		Utente u = null;
		try {
			u = (Utente) query.getSingleResult();
		} catch (NoResultException e) {}
		return u;
	}

}
