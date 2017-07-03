package it.unibo.zooplanner.models;

public class Nodo {
	
	private String nome;
	private boolean gol;
	private boolean partenza;
	private boolean fine;
	
	
	public Nodo() {}
	
	public Nodo(String nome,boolean gol) {
		this.nome = nome;
		this.gol = gol;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isGol() {
		return gol;
	}

	public void setGol(boolean gol) {
		this.gol = gol;
	}
	
	public boolean isPartenza() {
		return partenza;
	}

	public void setPartenza(boolean partenza) {
		this.partenza = partenza;
	}

	public boolean isFine() {
		return fine;
	}

	public void setFine(boolean fine) {
		this.fine = fine;
	}
}