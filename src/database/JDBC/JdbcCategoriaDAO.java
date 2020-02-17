package database.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcDAOFactory;
import database.interfaces.CategoriaDAO;
import model.deprecate.Categoria;

public class JdbcCategoriaDAO implements CategoriaDAO{
	private static JdbcCategoriaDAO instance = null;
	
	private final static String CATEGORIE = "categorie";
	private final static String IDCATEGORIA = "idCategoria";
	private final static String T_GIORNALIERA = "t_giornaliera";
	private final static String T_SETTIMANALE = "t_settimanale";
	private final static String T_MENSILE = "t_mensile";
	private final static String NOME_CATEGORIA = "nomeCategoria";
	private final static String DESCRIZIONE = "descrizione";
	
	private JdbcCategoriaDAO() {
		
	}
	
	public static JdbcCategoriaDAO getInstance() {
		if(instance == null) {
			instance = new JdbcCategoriaDAO();
		}
		return instance;
	}
	
	@Override
	public boolean addCategoria(Categoria categoria) {
		try (Connection connection = JdbcDAOFactory.getConnection()) { 
			String sql = "INSERT INTO " + CATEGORIE + "("
					+ NOME_CATEGORIA + ","
					+ T_GIORNALIERA + ","
					+ T_SETTIMANALE + ","
					+ T_MENSILE + ","
					+ DESCRIZIONE + ") VALUES(?,?,?,?,?)"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoria.getNome());
			statement.setDouble(2, categoria.getT_giornaliera());
			statement.setDouble(3, categoria.getT_settimanale());
			statement.setDouble(4, categoria.getT_mensile());
			statement.setString(5, categoria.getDescrizione());
			return statement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Categoria> getCategorie() {
		List<Categoria> categorie = new ArrayList<Categoria>();
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + CATEGORIE;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				String nome_categoria = set.getString(set.findColumn(NOME_CATEGORIA));
				double t_giornaliera = set.getDouble(set.findColumn(T_GIORNALIERA));
				double t_settimanale = set.getDouble(set.findColumn(T_SETTIMANALE));
				double t_mensile = set.getDouble(set.findColumn(T_MENSILE));
				String descrizione = set.getString(set.findColumn(DESCRIZIONE));

				Categoria categoria = new Categoria(nome_categoria, t_giornaliera, t_settimanale, t_mensile, descrizione);
				categorie.add(categoria);
			}
			return categorie;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categoria findCategoria(String nome) {
		Categoria categoria = null;
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + CATEGORIE + " WHERE nomeCategoria=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int id = set.getInt(set.findColumn(IDCATEGORIA));
				double t_g = set.getDouble(set.findColumn(T_GIORNALIERA));
				double t_s = set.getDouble(set.findColumn(T_SETTIMANALE));
				double t_m = set.getDouble(set.findColumn(T_MENSILE));
				String nomeCategoria = set.getString(set.findColumn(NOME_CATEGORIA));
				String descrizione = set.getString(set.findColumn(DESCRIZIONE));						
				categoria = new Categoria(id, nomeCategoria, t_g, t_s, t_m, descrizione);
			}
			return categoria;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public Categoria findCategoria(int id) {
		Categoria categoria = null;
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "SELECT * FROM " + CATEGORIE + " WHERE idCategoria=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int id1 = set.getInt(set.findColumn(IDCATEGORIA));
				double t_g = set.getDouble(set.findColumn(T_GIORNALIERA));
				double t_s = set.getDouble(set.findColumn(T_SETTIMANALE));
				double t_m = set.getDouble(set.findColumn(T_MENSILE));
				String nomeCategoria = set.getString(set.findColumn(NOME_CATEGORIA));
				String descrizione = set.getString(set.findColumn(DESCRIZIONE));						
				categoria = new Categoria(id1, nomeCategoria, t_g, t_s, t_m, descrizione);
			}
			return categoria;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public boolean updateCategoria(Categoria categoria, int id_categoria) {
		try (Connection connection = JdbcDAOFactory.getConnection()) {
			String sql = "UPDATE " + CATEGORIE 
					+ " SET " + NOME_CATEGORIA + " = ? ,"
					+ " " + T_GIORNALIERA + " = ? ,"
					+ " " + T_SETTIMANALE + " = ? ,"
					+ " " + T_MENSILE + " = ? ,"
					+ " " + DESCRIZIONE + " = ? WHERE " + IDCATEGORIA + " = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoria.getNome());
			statement.setDouble(2, categoria.getT_giornaliera());
			statement.setDouble(3, categoria.getT_settimanale());
			statement.setDouble(4, categoria.getT_mensile());
			statement.setString(5, categoria.getDescrizione());
			statement.setInt(6, id_categoria);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
}
