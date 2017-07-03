package it.unibo.zooplanner.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import it.unibo.zooplanner.models.Arco;
import it.unibo.zooplanner.models.Nodo;

public class Mappa {

	public static void AssociaGabbia(Nodo[] e,List<String> gabbie){
		Random rand = new Random();
		
		for(int k=0 ; k<e.length; k++) {
			int value = rand.nextInt(gabbie.size());
			
			e[k] = new Nodo(gabbie.get(value),true,false,false);
			gabbie.remove(value);
		}
	}
	
	public static void Associa(Nodo[] e,List<String> gabbie){
		
		for(int k=0 ; k<e.length; k++) {
			// prova per schema mappa
			// OK: schema corretto
			
			e[k] = new Nodo(gabbie.get(0),true,false,false);
			gabbie.remove(0);
			
		}
	}
	
	
	public static void main(String[] args) {
		
		List<Nodo> nodi = new ArrayList<Nodo>();
		List<Arco> archi = new ArrayList<Arco>();
		List<String> gabbie = new ArrayList<String>();
		
		gabbie.addAll(Arrays.asList("entrata","lama","bar","orsi","leoni","coccodrilli","elefanti","tigri","scimmie", "picnic", "uccelli", "mammiferi", "rettili"));
		
		
		Nodo[] e = new Nodo[13];
		
		Nodo[] t = new Nodo[10];
		Nodo[] i = new Nodo[2];
		
		for(int k=0 ; k<t.length; k++) {
			t[k] = new Nodo("t"+k,false,false,false);
		}
		
		for(int k=0 ; k<i.length; k++) {
			i[k] = new Nodo("i"+k,false,false,false);
		}
		
		Mappa.AssociaGabbia(e, gabbie);
		//Mappa.Associa(e, gabbie);
		archi.add(new Arco("erba",t[0],e[0]));
		archi.add(new Arco("erba",t[0],t[1]));
		archi.add(new Arco("sentiero",t[0],e[2]));
		archi.add(new Arco("erba",t[1],e[1]));
		archi.add(new Arco("sentiero",t[1],e[6]));
		archi.add(new Arco("erba",t[2],e[3]));
		archi.add(new Arco("sentiero",t[2],e[4]));
		archi.add(new Arco("sentiero",t[2],e[0]));
		archi.add(new Arco("sentiero",t[2],t[3]));
		archi.add(new Arco("sentiero",t[3],e[4]));
		archi.add(new Arco("erba",t[3],e[5]));
		archi.add(new Arco("sentiero",t[3],t[5]));
		archi.add(new Arco("sentiero",t[3],t[4]));
		archi.add(new Arco("erba",t[4],e[8]));
		archi.add(new Arco("sentiero",t[4],i[0]));
		archi.add(new Arco("erba",t[5],e[7]));
		archi.add(new Arco("sentiero",t[6],t[5]));
		archi.add(new Arco("sentiero",t[6],t[7]));
		archi.add(new Arco("sentiero",t[6],t[9]));
		archi.add(new Arco("sentiero",t[7],t[8]));
		archi.add(new Arco("sentiero",t[7],t[9]));
		archi.add(new Arco("erba",t[8],e[11]));
		archi.add(new Arco("sentiero",t[8],i[1]));
		archi.add(new Arco("erba",t[9],e[12]));
		archi.add(new Arco("sentiero",i[0],i[1]));
		archi.add(new Arco("sentiero",i[0],e[6]));
		archi.add(new Arco("sentiero",i[0],e[2]));
		archi.add(new Arco("erba",i[1],e[10]));
		archi.add(new Arco("sentiero",i[1],e[9]));
		
		
		for(Arco a: archi) {
			a.Stampa();
		}
		
	}

}
