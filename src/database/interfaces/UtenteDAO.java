package database.interfaces;

import java.util.List;

import model.Utente;

public interface UtenteDAO {
	public List<Utente> getUtenti();
	public boolean addUser(Utente utente);
	public Utente findUser(String s);
	
}
