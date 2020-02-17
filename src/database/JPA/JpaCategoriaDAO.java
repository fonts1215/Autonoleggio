package database.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import database.JpaDAOFactory;
import database.interfaces.CategoriaDAO;
import model.Categoria;

public class JpaCategoriaDAO implements CategoriaDAO{
	private static JpaCategoriaDAO instance = null;
	
	private final static String CATEGORIE = "categorie";
	private final static String IDCATEGORIA = "idCategoria";
	private final static String T_GIORNALIERA = "t_giornaliera";
	private final static String T_SETTIMANALE = "t_settimanale";
	private final static String T_MENSILE = "t_mensile";
	private final static String NOME_CATEGORIA = "nomeCategoria";
	private final static String DESCRIZIONE = "descrizione";
	
	private JpaCategoriaDAO() {
		
	}
	
	public static JpaCategoriaDAO getInstance() {
		if(instance == null) {
			instance = new JpaCategoriaDAO();
		}
		return instance;
	}

	@Override
	public boolean addCategoria(Categoria categoria) {
		EntityManager manager = JpaDAOFactory.getManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(categoria); //TODO impostare eccezione specifica
		transaction.commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> getCategorie() {
		EntityManager manager = JpaDAOFactory.getManager();
		return manager.createNamedQuery("Categoria.findAll").getResultList();
	}

	@Override
	public Categoria findCategoria(String nome) {
		Query query = JpaDAOFactory.getManager().createQuery("SELECT c FROM Categoria c WHERE c.nomeCategoria like :para1");
		query.setParameter("para1", nome);
		Categoria c = null;
		try {
			c = (Categoria) query.getSingleResult();
		} catch (NoResultException e) {}
		return c;
	}

	@Override
	public Categoria findCategoria(int id) {
		Query query = JpaDAOFactory.getManager().createQuery("SELECT c FROM Categoria c WHERE c.idcategoria like :para1");
		query.setParameter("para1", id);
		Categoria c = null;
		try {
			c = (Categoria) query.getSingleResult();
		} catch (NoResultException e) {}
		return c;
	}

	@Override
	public boolean updateCategoria(Categoria categoria, int id_categoria) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
