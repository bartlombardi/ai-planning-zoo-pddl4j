package it.unibo.zooplanner.models;

public class Arco {

	private Nodo n1;
    private Nodo n2;
    private String tipo;

    
    public Arco() {}
    
    
    public Arco(String tipo,Nodo n1, Nodo n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.setTipo(tipo);
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void Stampa() {
		System.out.println(tipo + " "+ n1.getNome() + " "+ n2.getNome() );
	}
}

