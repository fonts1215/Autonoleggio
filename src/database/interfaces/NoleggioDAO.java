package database.interfaces;

import java.util.List;

import model.*;

public interface NoleggioDAO {
	public void inserisciNoleggio(Noleggio noleggio);
	public List<Noleggio> getNoleggi(Utente utente);
	public Noleggio findNoleggio(int idRental);
	public int deleteNoleggio(Noleggio noleggio);
}
