package database.interfaces;

import java.util.List;

import model.*;

public interface NoleggioDAO {
	public List<Noleggio> getNoleggi();
	public void inserisciNoleggio(Noleggio noleggio);
	public List<Noleggio> getNoleggi(Utente utente);
	public Noleggio findNoleggio(int idRental);
	public int deleteNoleggio(Noleggio noleggio);
	public int noleggiMese();
	public double fatturatoMensile();
}
