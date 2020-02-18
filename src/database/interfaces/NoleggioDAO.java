package database.interfaces;

import java.util.List;

import model.*;

public interface NoleggioDAO {
	public void inserisciNoleggio(Noleggio noleggio);
	public List<Noleggio> getNoleggi(Utente utente);
}
