package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date birthdateUser;

	private String emailUser;

	@Id
	private int idUser;

	private String nameUser;

	private String passwordUser;

	private String surnameUser;

	//bi-directional many-to-one association to Noleggio
	@OneToMany(mappedBy="utente")
	private List<Noleggio> noleggios;
	

	public Utente(Date birthdateUser, String emailUser, String nameUser, String passwordUser,
			String surnameUser) {
		super();
		this.birthdateUser = birthdateUser;
		this.emailUser = emailUser;
		this.nameUser = nameUser;
		this.passwordUser = passwordUser;
		this.surnameUser = surnameUser;
	}

	public Utente() {
	}

	public Date getBirthdateUser() {
		return this.birthdateUser;
	}

	public void setBirthdateUser(Date birthdateUser) {
		this.birthdateUser = birthdateUser;
	}

	public String getEmailUser() {
		return this.emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getSurnameUser() {
		return this.surnameUser;
	}

	public void setSurnameUser(String surnameUser) {
		this.surnameUser = surnameUser;
	}

	public List<Noleggio> getNoleggios() {
		return this.noleggios;
	}

	public void setNoleggios(List<Noleggio> noleggios) {
		this.noleggios = noleggios;
	}

	public Noleggio addNoleggio(Noleggio noleggio) {
		getNoleggios().add(noleggio);
		noleggio.setUtente(this);

		return noleggio;
	}

	public Noleggio removeNoleggio(Noleggio noleggio) {
		getNoleggios().remove(noleggio);
		noleggio.setUtente(null);

		return noleggio;
	}

	public boolean isCorrectPassword(String p) {
		return p.equals(this.passwordUser);
	}
}