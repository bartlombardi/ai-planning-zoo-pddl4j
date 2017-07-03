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
		
		archi.add(new Arco("erba",t[1],e[1]));
		archi.add(new Arco("erba",t[1],t[2]));
		archi.add(new Arco("sentiero",t[1],e[3]));
		archi.add(new Arco("erba",t[2],e[2]));
		archi.add(new Arco("sentiero",t[2],e[7]));
		archi.add(new Arco("erba",t[3],e[4]));
		archi.add(new Arco("sentiero",t[3],e[5]));
		archi.add(new Arco("sentiero",t[3],e[1]));
		archi.add(new Arco("sentiero",t[3],t[4]));
		archi.add(new Arco("sentiero",t[4],e[5]));
		archi.add(new Arco("erba",t[4],e[6]));
		archi.add(new Arco("sentiero",t[4],t[6]));
		archi.add(new Arco("sentiero",t[4],t[5]));
		archi.add(new Arco("erba",t[5],e[9]));
		archi.add(new Arco("sentiero",t[5],i[1]));
		archi.add(new Arco("erba",t[6],e[8]));
		archi.add(new Arco("sentiero",t[7],t[6]));
		archi.add(new Arco("sentiero",t[7],t[8]));
		archi.add(new Arco("sentiero",t[7],t[10]));
		archi.add(new Arco("sentiero",t[8],t[9]));
		archi.add(new Arco("sentiero",t[8],t[10]));
		archi.add(new Arco("erba",t[9],e[12]));
		archi.add(new Arco("sentiero",t[9],i[2]));
		archi.add(new Arco("erba",t[1],e[13]));
		archi.add(new Arco("sentiero",i[1],i[2]));
		archi.add(new Arco("sentiero",i[1],e[7]));
		archi.add(new Arco("sentiero",i[1],e[3]));
		archi.add(new Arco("erba",i[2],e[11]));
		archi.add(new Arco("sentiero",i[2],e[10]));

		/*archi.add(new Arco("erba",t1,e1)); archi.add(new Arco("erba",e1,t1));
		archi.add(new Arco("erba",t1,t2)); archi.add(new Arco("erba",t2,t1));
		archi.add(new Arco("sentiero",t1,e3)); archi.add(new Arco("sentiero",e3,t1));
		archi.add(new Arco("erba",t2,e2)); archi.add(new Arco("erba",e2,t2));
		archi.add(new Arco("sentiero",t2,e7)); archi.add(new Arco("sentiero",e7,t2));
		archi.add(new Arco("erba",t3,e4)); archi.add(new Arco("erba",e4,t3));
		archi.add(new Arco("sentiero",t3,e5)); archi.add(new Arco("sentiero",e5,t3));
		archi.add(new Arco("sentiero",t3,e1)); archi.add(new Arco("sentiero",e1,t3));
		archi.add(new Arco("sentiero",t3,t4)); archi.add(new Arco("sentiero",t4,t3));
		archi.add(new Arco("sentiero",t4,e5)); archi.add(new Arco("sentiero",e5,t4));
		archi.add(new Arco("erba",t4,e6)); archi.add(new Arco("erba",e6,t4));
		archi.add(new Arco("sentiero",t4,t6)); archi.add(new Arco("sentiero",t6,t4));
		archi.add(new Arco("sentiero",t4,t5)); archi.add(new Arco("sentiero",t5,t4));
		archi.add(new Arco("erba",t5,e9)); archi.add(new Arco("erba",e9,t5));
		archi.add(new Arco("sentiero",t5,i1)); archi.add(new Arco("sentiero",i1,t5));
		archi.add(new Arco("erba",t6,e8)); archi.add(new Arco("erba",e8,t6));
		archi.add(new Arco("sentiero",t7,t6)); archi.add(new Arco("sentiero",t6,t7));
		archi.add(new Arco("sentiero",t7,t8)); archi.add(new Arco("sentiero",t8,t7));
		archi.add(new Arco("sentiero",t7,t10)); archi.add(new Arco("sentiero",t1, t7));
		archi.add(new Arco("sentiero",t8,t9)); archi.add(new Arco("sentiero",t9,t8));
		archi.add(new Arco("sentiero",t8,t10)); archi.add(new Arco("sentiero",t1, t8));
		archi.add(new Arco("erba",t9,e12)); archi.add(new Arco("erba",e1, t9));
		archi.add(new Arco("sentiero",t9,i2)); archi.add(new Arco("sentiero",i2,t9));
		archi.add(new Arco("erba",t1, e13)); archi.add(new Arco("erba",e1, t10));
		archi.add(new Arco("sentiero",i1,i2)); archi.add(new Arco("sentiero",i2,i1));
		archi.add(new Arco("sentiero",i1,e7)); archi.add(new Arco("sentiero",e7,i1));
		archi.add(new Arco("sentiero",i1,e3)); archi.add(new Arco("sentiero",e3,i1));
		archi.add(new Arco("erba",i2,e11)); archi.add(new Arco("erba",e1, i2));
		archi.add(new Arco("sentiero",i2,e10)); archi.add(new Arco("sentiero",e1, i2)); */
	}

}
