package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database.JPA.*;
import database.interfaces.*;

public class JpaDAOFactory extends DaoFactory {
	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return JpaCategoriaDAO.getInstance();
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		// TODO Auto-generated method stub
		return JpaUtenteDAO.getInstance();
	}

	@Override
	public VeicoloDAO getVeicoloDAO() {
		// TODO Auto-generated method stub
		return JpaVeicoloDAO.getInstance();
	}
	
	@Override
	public NoleggioDAO getNoleggioDAO() {
		// TODO Auto-generated method stub
		return JpaNoleggioDAO.getInstance();
	}

	public static EntityManager getManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Autonoleggio");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
}
