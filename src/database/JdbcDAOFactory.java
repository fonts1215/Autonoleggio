package database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import database.JDBC.JdbcCategoriaDAO;
import database.JDBC.JdbcUtenteDAO;
import database.JDBC.JdbcVeicoloDAO;
import database.interfaces.CategoriaDAO;
import database.interfaces.UtenteDAO;
import database.interfaces.VeicoloDAO;

public class JdbcDAOFactory extends DaoFactory{

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return JdbcCategoriaDAO.getInstance();
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		// TODO Auto-generated method stub
		return JdbcUtenteDAO.getInstance();
	}

	@Override
	public VeicoloDAO getVeicoloDAO() {
		// TODO Auto-generated method stub
		return JdbcVeicoloDAO.getInstance();
	}
	
	public static Connection getConnection() throws SQLException {
		try {
			DataSource source = InitialContext.doLookup("java:comp/env/jdbc/autonoleggio");
			return source.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
