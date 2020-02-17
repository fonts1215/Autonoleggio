package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the noleggio database table.
 * 
 */
@Entity
@NamedQuery(name="Noleggio.findAll", query="SELECT n FROM Noleggio n")
public class Noleggio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Noleggio(double amountRental, Date startRental, Date stopRental, Utente utente,
			Veicolo veicolo) {
		super();
		this.amountRental = amountRental;
		this.startRental = startRental;
		this.stopRental = stopRental;
		this.utente = utente;
		this.veicolo = veicolo;
	}

	@Id
	private int idRental;

	private double amountRental;

	@Temporal(TemporalType.DATE)
	private Date startRental;

	@Temporal(TemporalType.DATE)
	private Date stopRental;

	//bi-directional many-to-one association to Utente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private Utente utente;

	//bi-directional many-to-one association to Veicolo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idVeicolo")
	private Veicolo veicolo;

	public Noleggio() {
	}

	public int getIdRental() {
		return this.idRental;
	}

	public void setIdRental(int idRental) {
		this.idRental = idRental;
	}

	public double getAmountRental() {
		return this.amountRental;
	}

	public void setAmountRental(double amountRental) {
		this.amountRental = amountRental;
	}

	public Date getStartRental() {
		return this.startRental;
	}

	public void setStartRental(Date startRental) {
		this.startRental = startRental;
	}

	public Date getStopRental() {
		return this.stopRental;
	}

	public void setStopRental(Date stopRental) {
		this.stopRental = stopRental;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Veicolo getVeicolo() {
		return this.veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	@Override
	public String toString() {
		return "Noleggio [idRental=" + idRental + ", amountRental=" + amountRental + ", startRental=" + startRental
				+ ", stopRental=" + stopRental + ", utente=" + utente + ", veicolo=" + veicolo + "]";
	}

	public Noleggio(int idRental, double amountRental, Date startRental, Date stopRental, Utente utente,
			Veicolo veicolo) {
		super();
		this.idRental = idRental;
		this.amountRental = amountRental;
		this.startRental = startRental;
		this.stopRental = stopRental;
		this.utente = utente;
		this.veicolo = veicolo;
	}
	
		
}