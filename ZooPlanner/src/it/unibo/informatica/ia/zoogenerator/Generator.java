package it.unibo.informatica.ia.zoogenerator;

import java.io.File;
import java.io.IOException;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.hsp.HSP;
import fr.uga.pddl4j.util.Plan;

public class Generator {
	private static final String DOMAIN_PATH = "domain/";
	private static final String DOMAIN_NAME = "zoo";
	private static final String PROBLEM_PATH = "problems/";
	private static final String PDDL_EXTENSION = ".pddl";

	public static void main(String[] args) {
		boolean isPlanned = false;
		final ProblemFactory factory = new ProblemFactory();
		
		File domainFile = new File(DOMAIN_PATH + DOMAIN_NAME + PDDL_EXTENSION);
		
		
		do {
			// Only to see if it works
			File problemFile = new File(PROBLEM_PATH + "p1.pddl");
			
			
			// Parse the domain and the problem
		    ErrorManager errorManager;
			try {
				errorManager = factory.parse(domainFile, problemFile);
				if (!errorManager.isEmpty()) {
		            errorManager.printAll();
		            System.exit(0);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			// Encode and simplify the planning problem in a compact representation
			final CodedProblem pb = factory.encode();
			if (!pb.isSolvable()) {
				System.out.println("\nGoal can be simplified to FALSE. No search will solve it");
				System.exit(0);
			}
			
			// Create the planner
			final HSP planner = new HSP();
			  
			// Search for a solution plan
			final Plan plan = planner.search(pb);
			if (plan != null) {
				System.out.println(String.format("%nFound plan as follows:%n%n"));
				System.out.println(pb.toString(plan));
				isPlanned = true;
			} else {
				System.out.append(String.format("%nNo plan found, trying another configuration...%n%n"));
			}
		} while (!isPlanned);

	}

}
