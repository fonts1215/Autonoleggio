package database.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DaoFactory;
import database.JdbcDAOFactory;
import database.interfaces.*;
import model.*;

public class JdbcVeicoloDAO implements VeicoloDAO {
	private static JdbcVeicoloDAO instance = null;
	private CategoriaDAO categoria = new JdbcDAOFactory().getCategoriaDAO();
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
	
	private JdbcVeicoloDAO() {
		
	}
	
	public static JdbcVeicoloDAO getInstance() {
		if(instance == null) {
			instance = new JdbcVeicoloDAO();
		}
		return instance;
	}

	@Override
	public List<Veicolo> getAutoPerCategoria(Categoria categoria) {
		List<Veicolo> veicoli = new ArrayList<Veicolo>();
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + VEICOLI + " WHERE " + CATEGORIA + "= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, categoria.getId());
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				String marca = set.getString(set.findColumn(MARCA));
				long categoriaa = set.getLong(set.findColumn(CATEGORIA));
				String modello = set.getString(set.findColumn(MODELLO));
				String targa = set.getString(set.findColumn(TARGA));
				String colore = set.getString(set.findColumn(COLORE));
				int n_Posti = set.getInt(set.findColumn(N_POSTI));
				Categoria c = this.categoria.findCategoria((int)categoriaa);
				Veicolo veicolo = new Veicolo(targa, c.getNome(), categoriaa, marca, modello, n_Posti, colore);
				veicoli.add(veicolo);
			}
			return veicoli;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Veicolo> getAuto() {
		List<Veicolo> veicoli = new ArrayList<Veicolo>();
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + VEICOLI;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int id_veicolo = set.getInt(set.findColumn(IDVEICOLO));
				String marca = set.getString(set.findColumn(MARCA));
				long categoriaa = set.getLong(set.findColumn(CATEGORIA));
				String modello = set.getString(set.findColumn(MODELLO));
				String targa = set.getString(set.findColumn(TARGA));
				String colore = set.getString(set.findColumn(COLORE));
				int n_Posti = set.getInt(set.findColumn(N_POSTI));
				Categoria c = this.categoria.findCategoria((int)categoriaa);
				Veicolo veicolo = new Veicolo(id_veicolo, targa, c.getNome(), categoriaa, marca, modello, n_Posti, colore);
				veicoli.add(veicolo);
			}
			return veicoli;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addVeicolo(Veicolo veicolo) {
		try (Connection connection = JdbcDAOFactory.getConnection()) {			
			Categoria categoria = this.categoria.findCategoria(veicolo.getNome_categoria());
			String sql = "INSERT INTO " + VEICOLI + "("
					+ TARGA + ","
					+ MARCA + ","
					+ MODELLO + ","
					+ N_POSTI + ","
					+ C_SERBATOIO + ","
					+ COLORE + ","
					+ CATEGORIA + ") VALUES(?,?,?,?,?,?,?)"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, veicolo.getTarga());
			statement.setString(2, veicolo.getMarca());
			statement.setString(3, veicolo.getModello());
			statement.setInt(4, veicolo.getN_Posti());
			statement.setFloat(5, 0.0f);
			statement.setString(6, veicolo.getColore());
			statement.setInt(7, categoria.getId());
			return statement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Veicolo findVeicolo(String t) {
		Veicolo veicolo = null;
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + VEICOLI + " WHERE " + TARGA + "=?	";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int id_veicolo = set.getInt(set.findColumn(IDVEICOLO));
				String marca = set.getString(set.findColumn(MARCA));
				long categoria = set.getLong(set.findColumn(CATEGORIA));
				String modello = set.getString(set.findColumn(MODELLO));
				String targa = set.getString(set.findColumn(TARGA));
				String colore = set.getString(set.findColumn(COLORE));
				int n_Posti = set.getInt(set.findColumn(N_POSTI));
				Categoria c = this.categoria.findCategoria((int)categoria);
				veicolo = new Veicolo(id_veicolo, targa, c.getNome(), categoria, marca, modello, n_Posti, colore);
			}
			return veicolo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return veicolo;
	}

	@Override
	public boolean updateVeicolo(Veicolo veicolo, int idVeicolo, int categoria) {
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "UPDATE " + VEICOLI 
					+ " SET " + MARCA + " = ? ,"
					+ " " + CATEGORIA + " = ? ,"
					+ " " + MODELLO + " = ? ,"
					+ " " + TARGA + " = ? ,"
					+ " " + COLORE + " = ? ,"
					+ " " + IDVEICOLO + " = ? ,"
					+ " " + N_POSTI + " = ? WHERE " + IDVEICOLO + " = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, veicolo.getMarca());
			preparedStatement.setLong(2, categoria);
			preparedStatement.setString(3, veicolo.getModello());
			preparedStatement.setString(4, veicolo.getTarga());
			preparedStatement.setString(5, veicolo.getColore());
			preparedStatement.setInt(6, idVeicolo);
			preparedStatement.setInt(7, veicolo.getN_Posti());
			preparedStatement.setInt(8, idVeicolo);
			return preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteVeicolo(String targa) {
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "DELETE FROM " + VEICOLI 
					+ " WHERE " + TARGA + " = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, targa);
			return preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
