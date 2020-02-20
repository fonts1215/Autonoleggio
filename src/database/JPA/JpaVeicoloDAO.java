package database.JPA;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import database.JpaDAOFactory;
import database.interfaces.VeicoloDAO;
import model.*;

public class JpaVeicoloDAO implements VeicoloDAO{
	private static JpaVeicoloDAO instance = null;
	// TABELLA VEICOLI
	private final static String VEICOLI = "veicoli";
	private final static String IDVEICOLO = "idVeicolo";
	private final static String TARGA = "targa";
	private final static String MARCA = "marca";
	private final static String MODELLO = "modello";
	private final static String N_POSTI = "n_Posti";
	private final static String C_SERBATOIO = "c_Serbatoio";
	private final static String COLORE = "colore";
	private final static String CATEGORIA = "idCatogoriaVeicolo";
	
	private JpaVeicoloDAO() {
		
	}
	
	public static JpaVeicoloDAO getInstance() {
		if(instance == null) {
			instance = new JpaVeicoloDAO();
		}
		return instance;
	}

	@Override
	public List<Veicolo> getAutoPerCategoria(Categoria categoria) {
		List<Veicolo> veicolos = null;
		Query query = JpaDAOFactory.getManager().createQuery("SELECT v FROM Veicolo v WHERE v.categoria = :para");
		query.setParameter("para", categoria);
		try {
			veicolos = query.getResultList();
		} catch (NoResultException e) {}
		return veicolos;		
	}

	@Override
	public List<Veicolo> getAuto() {
		EntityManager manager = JpaDAOFactory.getManager();
		return manager.createNamedQuery("Veicolo.findAll").getResultList();
	}

	@Override
	public boolean addVeicolo(Veicolo veicolo) {
		EntityManager manager = JpaDAOFactory.getManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(veicolo); //TODO impostare eccezione specifica
		transaction.commit();
		return true;
	}

	@Override
	public Veicolo findVeicolo(String t) {
		Query query = JpaDAOFactory.getManager().createQuery("SELECT v FROM Veicolo v WHERE v.targa like :para1");
		query.setParameter("para1", t);
		Veicolo v = null;
		try {
			v = (Veicolo) query.getSingleResult();
		} catch (NoResultException e) {}
		return v;
	}

	@Override
	public boolean updateVeicolo(Veicolo veicolo, int idVeicolo, int categoria) {
		EntityManager manager = JpaDAOFactory.getManager();
		manager.merge(null);
		return false;	
	}
	
	@Override
	public void updateVeicolo(Veicolo veicolo) {
		EntityManager manager = JpaDAOFactory.getManager();
		manager.getTransaction().begin();
		manager.merge(veicolo);
		manager.getTransaction().commit(); //TODO manage exception 
		//return true;	
	}

	@Override
	public boolean deleteVeicolo(String targa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Veicolo> getVeicoliDisponibili(Date inzio, Date fine, Categoria categoria) { //IL PARAMETRO DATE DEVE ESSERE DEL TIPO YYYY-MM-DD
		System.out.println("inzio" + inzio);
		System.out.println("fine" + fine);
		Query query = JpaDAOFactory.getManager()
				.createNativeQuery("SELECT * FROM veicolo WHERE idVeicolo NOT IN(SELECT idVeicolo FROM noleggio WHERE ? >= noleggio.startRental and ? <= noleggio.stopRental) AND idcategoria = ?", Veicolo.class);
		query.setParameter(2, inzio.toString()); 
		query.setParameter(1, fine.toString());
		query.setParameter(3, categoria.getIdcategoria());	
		return query.getResultList();
	}
	
	@Override
	public List<Veicolo> getVeicoliDisponibili(Date inzio, Categoria categoria) { //IL PARAMETRO DATE DEVE ESSERE DEL TIPO YYYY-MM-DD
		System.out.println("inzio" + inzio);
		Query query = JpaDAOFactory.getManager()
				.createNativeQuery("SELECT * FROM veicolo WHERE idVeicolo NOT IN(SELECT idVeicolo FROM noleggio WHERE ? <= noleggio.stopRental) AND idcategoria = ?", Veicolo.class);
		query.setParameter(1, inzio.toString());
		query.setParameter(2, categoria.getIdcategoria());	
		return query.getResultList();
	}
	
	
	
}
