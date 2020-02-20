package database.interfaces;

import java.util.Date;
import java.util.List;

import model.Categoria;
import model.Veicolo;

public interface VeicoloDAO {
	public List<Veicolo> getAutoPerCategoria(Categoria categoria);
	public List<Veicolo> getAuto();
	public boolean addVeicolo(Veicolo veicolo);
	public Veicolo findVeicolo(String t);
	public void updateVeicolo(Veicolo veicolo);
	public boolean updateVeicolo(Veicolo veicolo, int idVeicolo, int categoria);
	public boolean deleteVeicolo(String targa);
	public List<Veicolo> getVeicoliDisponibili(Date inzio, Date fine, Categoria categoria);
	public List<Veicolo> getVeicoliDisponibili(Date inzio, Categoria categoria);
}
