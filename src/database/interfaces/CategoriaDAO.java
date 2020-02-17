package database.interfaces;

import java.util.List;

import model.Categoria;

public interface CategoriaDAO {
	public boolean addCategoria(Categoria categoria);
	public List<Categoria> getCategorie();
	public Categoria findCategoria(String nome);
	public Categoria findCategoria(int id);
	public boolean updateCategoria(Categoria categoria, int id_categoria);
}
