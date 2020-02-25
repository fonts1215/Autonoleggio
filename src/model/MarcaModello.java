package model;

public class MarcaModello {
	private String marca;
	private String modello;
	
	public MarcaModello(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}
	
	@Override
	public String toString() {
		return "MarcaModello [marca=" + marca + ", modello=" + modello + "]";
	}
	
}
