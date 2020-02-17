package database.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.JdbcDAOFactory;
import database.interfaces.UtenteDAO;
import model.Utente;

public class JdbcUtenteDAO implements UtenteDAO {
	private static JdbcUtenteDAO instance = null;
	
	// TABELLA UTENTI
	private final static String UTENTI = "utenti";
	private final static String ID_USER = "idUser";
	private final static String EMAIL_USER = "emailUser";
	private final static String PASSWORD_USER = "passwordUser";
	private final static String NAME_USER = "nameUser";
	private final static String SURNAME_USER = "surnameUser";
	private final static String BIRTHDATE_USER = "birthdateUser";
	
	private JdbcUtenteDAO() {
		
	}
	
	public static JdbcUtenteDAO getInstance() {
		if(instance == null) {
			instance = new JdbcUtenteDAO();
		}
		return instance;
	}

	@Override
	public List<Utente> getUtenti() {
		List<Utente> utenti = new ArrayList<Utente>();
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + UTENTI;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				String email = set.getString(set.findColumn(EMAIL_USER));
				String nome = set.getString(set.findColumn(NAME_USER));
				String cognome = set.getString(set.findColumn(SURNAME_USER));
				LocalDate dataDiNascita = set.getDate(set.findColumn(BIRTHDATE_USER)).toLocalDate();

				Utente utente = new Utente(email, "", nome, cognome, dataDiNascita);
				utenti.add(utente);
			}
			return utenti;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(Utente utente, String password) {
		try (Connection connection = JdbcDAOFactory.getConnection()) { 
			String sql = "INSERT INTO " + UTENTI + "("
					+ EMAIL_USER + ","
					+ PASSWORD_USER + ","
					+ NAME_USER + ","
					+ SURNAME_USER + ","
					+ BIRTHDATE_USER + ") VALUES(?,?,?,?,?)"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, utente.getEmail());
			statement.setString(2, password);
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setDate(5, Date.valueOf(utente.getDataDiNascita()));
			return statement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Utente findUser(String s) {
		Utente utente = null;
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + UTENTI + " WHERE emailUser=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int id = set.getInt(set.findColumn(ID_USER));
				String email = set.getString(set.findColumn(EMAIL_USER));
				String password = set.getString(set.findColumn(PASSWORD_USER));
				String nome = set.getString(set.findColumn(NAME_USER));
				String cognome = set.getString(set.findColumn(SURNAME_USER));
				LocalDate dataDiNascita = set.getDate(set.findColumn(BIRTHDATE_USER)).toLocalDate();
				utente = new Utente(id, email, password, nome, cognome, dataDiNascita);
			}
			return utente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}
	
	
}
