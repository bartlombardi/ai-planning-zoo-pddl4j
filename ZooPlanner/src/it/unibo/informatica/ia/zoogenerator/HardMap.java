package it.unibo.informatica.ia.zoogenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class HardMap {
	private static final String shadow = "shadow";
	private static final String road = "road";
	private static final String camelroad = "camelroad";
	private static final String initiaRoadPredicate = "able-to-walk";
	private static final String initiaCameroadPredicate = "able-to-ride";
	
	private List<Node> nodes;
	private List<Edge> edges;
	private List<String> places;
	private List<String> goals;
	
	private String arrival;
	private int arrivalPlace;
	
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
									"reptile", "wc"));
		
		// Add entrance initial state node
		nodes.add(new Node("entrance", true, false));
		
		// Add road nodes
		for (int i = 1; i <= 10; i++) {
			Node node = new Node("n" + i, false, false);
			nodes.add(node);
		}
		
		if (!places.remove(arrival)) {
			throw new java.lang.RuntimeException("ERROR: Arrival is not present in places list");
		}
		
		// Place locations randomly
		Random rand = new Random();	
		int placesLen = this.places.size();
		int nodesLen = this.nodes.size();
		
		System.out.print("Placing animal cages randomly:");
		for (int i = 0; i < placesLen + 1; i++) {
			if (nodesLen + i != this.arrivalPlace) {
				int place = rand.nextInt(places.size());
				
				Node node = new Node(places.get(place), false, false);
				nodes.add(node);
				
				int position = nodesLen + i;
				System.out.print("\n\tn" + position + " becomes\t" + places.get(place));
				
				places.remove(place);
			}
			else {
				Node node = new Node(arrival, false, true);
				nodes.add(node);
			}
		}
		
		// Add finish state node
		// nodes.add(new Node("wc", false, true));
		
		edges.add(new Edge(nodes.get(0), nodes.get(1), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(1), nodes.get(2), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(2), nodes.get(11), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(3), nodes.get(13), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(4), nodes.get(14), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(7), nodes.get(18), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(8), nodes.get(19), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(9), nodes.get(20), shadow, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(10), nodes.get(21), shadow, initiaRoadPredicate));
		
		edges.add(new Edge(nodes.get(0), nodes.get(3), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(1), nodes.get(12), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(2), nodes.get(16), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(3), nodes.get(4), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(3), nodes.get(15), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(4), nodes.get(5), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(4), nodes.get(7), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(5), nodes.get(15), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(5), nodes.get(17), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(6), nodes.get(7), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(6), nodes.get(16), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(8), nodes.get(9), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(8), nodes.get(22), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(9), nodes.get(10), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(9), nodes.get(17), road, initiaRoadPredicate));
		edges.add(new Edge(nodes.get(10), nodes.get(17), road, initiaRoadPredicate));
		
		edges.add(new Edge(nodes.get(6), nodes.get(8), camelroad, initiaCameroadPredicate));
		edges.add(new Edge(nodes.get(6), nodes.get(12), camelroad, initiaCameroadPredicate));
		
		return;
	}
	
	public void addPlacesToVisit(List<String> places) {
		this.goals = places;
		
		return;
	}
	
	public void setArrival(String arrival, int place) {
		this.arrival = arrival;
		this.arrivalPlace = place;
		
		return;
	}
	
	public String getFinalName() {
		String finalName = "";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			if (this.nodes.get(i).isFinalNode())
				finalName = this.nodes.get(i).getName();
		}
		
		return finalName;
	}
	
	public String defineProblem(String problemName, String domainName) {
		String problemDef = "(define (problem " + problemName + ")" +
							"\n(:domain " + domainName + ")\n";
		
		return problemDef;
	}
	
	public String getObjectsSyntaxPDDL() {
		String objects = "(:objects visitor camel1 camel2 camel3";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			objects += " " + this.nodes.get(i).getName();
		}
		
		objects += ")\n";
		
		return objects;
	}
	
	public String getInitializationSyntaxPDDL() {
		String initSyntax = "(:init\n" + 
							"\t(visitor visitor)\n" + 
							"\t(mobile visitor)\n" + 
							"\t(able-to-climb visitor)\n" + 
							"\t(camel camel1)\n" + 
							"\t(camel camel2)\n" + 
							"\t(camel camel3)\n" +
							"\n\t(at visitor entrance)\n" + 
							"\t(at camel1 bar)\n" + 
							"\t(at camel2 n5)\n" + 
							"\t(at camel3 n7)\n";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			initSyntax += "\n\t(to-discover " + this.nodes.get(i).getName() + ")";
		}
		
		initSyntax += "\n";
		
		for (int i = 0; i < this.edges.size(); i++) {
			initSyntax += "\n\t" + this.edges.get(i).getInitialStatePDDL();
		}
		
		initSyntax += ")\n";
		
		return initSyntax;
	}
	
	public String getGoalSyntaxPDDL() {
		String goalSyntax = "(:goal (and\n";
		
		for (int i = 0; i < this.goals.size(); i++) {
			goalSyntax += "\t" + "(not (to-discover " + this.goals.get(i) + "))\n";
		}
		
		goalSyntax += "\t(at visitor " + this.getFinalName() + ")))\n)";
		
		return goalSyntax;
	}
}
