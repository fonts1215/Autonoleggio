package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	public Categoria(String descrizione, String nomeCategoria, double tGiornaliera, double tMensile,
			double tSettimanale) {
		super();
		this.descrizione = descrizione;
		this.nomeCategoria = nomeCategoria;
		this.tGiornaliera = tGiornaliera;
		this.tMensile = tMensile;
		this.tSettimanale = tSettimanale;
	}

	@Id
	private int idcategoria;

	private String descrizione;

	private String nomeCategoria;

	@Column(name="t_giornaliera")
	private double tGiornaliera;

	@Column(name="t_mensile")
	private double tMensile;

	@Column(name="t_settimanale")
	private double tSettimanale;

	//bi-directional many-to-one association to Veicolo
	@OneToMany(mappedBy="categoria")
	private List<Veicolo> veicolos;

	public Categoria() {
	}

	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public double getTGiornaliera() {
		return this.tGiornaliera;
	}

	public void setTGiornaliera(double tGiornaliera) {
		this.tGiornaliera = tGiornaliera;
	}

	public double getTMensile() {
		return this.tMensile;
	}

	public void setTMensile(double tMensile) {
		this.tMensile = tMensile;
	}

	public double getTSettimanale() {
		return this.tSettimanale;
	}

	public void setTSettimanale(double tSettimanale) {
		this.tSettimanale = tSettimanale;
	}

	public List<Veicolo> getVeicolos() {
		return this.veicolos;
	}

	public void setVeicolos(List<Veicolo> veicolos) {
		this.veicolos = veicolos;
	}

	public Veicolo addVeicolo(Veicolo veicolo) {
		getVeicolos().add(veicolo);
		veicolo.setCategoria(this);

		return veicolo;
	}

	public Veicolo removeVeicolo(Veicolo veicolo) {
		getVeicolos().remove(veicolo);
		veicolo.setCategoria(null);

		return veicolo;
	}

	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", descrizione=" + descrizione + ", nomeCategoria="
				+ nomeCategoria + ", tGiornaliera=" + tGiornaliera + ", tMensile=" + tMensile + ", tSettimanale="
				+ tSettimanale + ", veicolos=" + veicolos + "]";
	}
	
	

}