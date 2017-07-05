package it.unibo.zooplanner.models;


public class Arco {
	private final String NOT_VISITED = "not-visitedEdge";
	
	private Nodo n1;
    private Nodo n2;
    private String tipo;
    
    public Arco() {}
    
    public Arco(String tipo, Nodo n1, Nodo n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.setTipo(tipo);
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
		
		return;
	}
	
	public String getNotazione() {
		String notazione = "";
		notazione += "(" + tipo + " " + n1.getNome() + " " + n2.getNome() + ") ";
		notazione += "(" + tipo + " " + n2.getNome() + " " + n1.getNome() + ")";
		
		return notazione;
	}
	
	public String getStatoIniziale() {
		String stato_iniziale = "";
		stato_iniziale += "(" + NOT_VISITED + " " + n1.getNome() + " " + n2.getNome() + ") ";
		stato_iniziale += "(" + NOT_VISITED + " " + n2.getNome() + " " + n1.getNome() + ")";
		
		return stato_iniziale;
	}
}

