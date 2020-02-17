package database;

import database.interfaces.*;

public abstract class DaoFactory {
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract UtenteDAO getUtenteDAO();
	public abstract VeicoloDAO getVeicoloDAO();
	public abstract NoleggioDAO getNoleggioDAO();
	
	public static DaoFactory getDaoFactory() {
		return new JpaDAOFactory();
	}
}
