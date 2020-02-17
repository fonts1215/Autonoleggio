package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veicolo database table.
 * 
 */
@Entity
@NamedQuery(name="Veicolo.findAll", query="SELECT v FROM Veicolo v")
public class Veicolo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public Veicolo(double c_Serbatorio, String colore, String marca, String modello, int n_Posti, String targa,
			Categoria categoria) {
		super();
		this.c_Serbatorio = c_Serbatorio;
		this.colore = colore;
		this.marca = marca;
		this.modello = modello;
		this.n_Posti = n_Posti;
		this.targa = targa;
		this.categoria = categoria;
	}
	

	public Veicolo(int idVeicolo, double c_Serbatorio, String colore, String marca, String modello, int n_Posti,
			String targa, Categoria categoria) {
		super();
		this.idVeicolo = idVeicolo;
		this.c_Serbatorio = c_Serbatorio;
		this.colore = colore;
		this.marca = marca;
		this.modello = modello;
		this.n_Posti = n_Posti;
		this.targa = targa;
		this.categoria = categoria;
	}


	@Id
	private int idVeicolo;

	private double c_Serbatorio;

	private String colore;

	private String marca;

	private String modello;

	private int n_Posti;

	private String targa;

	//bi-directional many-to-one association to Noleggio
	@OneToMany(mappedBy="veicolo")
	private List<Noleggio> noleggios;

	//bi-directional many-to-one association to Categoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	public Veicolo() {
	}

	public int getIdVeicolo() {
		return this.idVeicolo;
	}

	public void setIdVeicolo(int idVeicolo) {
		this.idVeicolo = idVeicolo;
	}

	public double getC_Serbatorio() {
		return this.c_Serbatorio;
	}

	public void setC_Serbatorio(double c_Serbatorio) {
		this.c_Serbatorio = c_Serbatorio;
	}

	public String getColore() {
		return this.colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getN_Posti() {
		return this.n_Posti;
	}

	public void setN_Posti(int n_Posti) {
		this.n_Posti = n_Posti;
	}

	public String getTarga() {
		return this.targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public List<Noleggio> getNoleggios() {
		return this.noleggios;
	}

	public void setNoleggios(List<Noleggio> noleggios) {
		this.noleggios = noleggios;
	}

	public Noleggio addNoleggio(Noleggio noleggio) {
		getNoleggios().add(noleggio);
		noleggio.setVeicolo(this);

		return noleggio;
	}

	public Noleggio removeNoleggio(Noleggio noleggio) {
		getNoleggios().remove(noleggio);
		noleggio.setVeicolo(null);

		return noleggio;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Veicolo [idVeicolo=" + idVeicolo + ", c_Serbatorio=" + c_Serbatorio + ", colore=" + colore + ", marca="
				+ marca + ", modello=" + modello + ", n_Posti=" + n_Posti + ", targa=" + targa + ", noleggios="
				+ noleggios + ", categoria=" + categoria + "]";
	}

	
}