package it.unibo.informatica.ia.zoogenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class HardMap {	
	private List<Node> nodes;
	private List<Edge> edges;
	private List<String> places;
	private List<String> goals;
	
	public HardMap() {
		return;
	}
		
	public void generateConfiguration() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		this.places = new ArrayList<String>();
		
		places.addAll(Arrays.asList("lama", "bar", 
									"bear", "lion",
									"eleph", "croc",
									"tiger", "monkey",
									"bird", "smammal", 
									"reptile"));
		
		// Add entrance initial state node
		nodes.add(new Node("entrance", true, false));
		
		// Add road nodes
		for (int i = 1; i < 10; i++) {
			Node node = new Node("n" + i, false, false);
			nodes.add(node);
		}
		
		// Add fini state node
		nodes.add(new Node("wc", false, true));
		
		// Place locations randomly
		Random rand = new Random();		
		for (int i = 0; i < places.size(); i++) {
			int place = rand.nextInt(places.size());
			
			Node node = new Node(places.get(place), false, false);
			nodes.add(node);
			
			places.remove(place);
		}
		
		/*
		 * HERE ADD EDGE CONNECTIONS
		 * 
		 */
		
		return;
	}
	
	public void addPlacesToVisit(List<String> places) {
		this.goals = places;
		
		return;
	}
	
	public String getFinalName() {
		String finalName = "";
		
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).isFinalNode())
				finalName = nodes.get(i).getName();
		}
		
		return finalName;
	}
	
	public String getGoalSyntaxPDDL() {
		String goalSyntax = "(:init (and\n";
		
		for (int i = 0; i < this.goals.size(); i++) {
			goalSyntax += "(not (to-discover" + this.goals.get(i) + "))\n";
		}
		
		goalSyntax += "(at visitor " + this.getFinalName() + ")))";
		
		return goalSyntax;
	}
}
