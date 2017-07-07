package it.unibo.informatica.ia.zoogenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.*;

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
	
	public static void main(String[] args) throws FileNotFoundException {
		Options options = new Options();
		
		Option problemName = new Option("p", "problem-name", true, "Provide a probleme name");
		problemName.setRequired(true);
        options.addOption(problemName);
        
        Option goals = new Option("g", "goals", true, "Provide a list of places to visit");
        goals.setRequired(true);
        options.addOption(goals);
        
        Option finalPlace = new Option("f", "final", true, "Arrival place");
        finalPlace.setRequired(true);
        options.addOption(finalPlace);
        
        Option finalPos = new Option("i", "index-arrival", true, "Index of the arrival place");
        finalPlace.setRequired(true);
        options.addOption(finalPos);
       
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
            return;
        }
        
        String inProblemName = cmd.getOptionValue("problem-name");
        String[] inGoals = cmd.getOptionValues("goals");
        String inFinalPlace = cmd.getOptionValue("final");
        int inFinalIndex = Integer.parseInt(cmd.getOptionValue("index-arrival"));
        
        List<String> listGoals = Arrays.asList(inGoals[0].split(","));
		
		boolean isPlanned = false;
		final ProblemFactory factory = new ProblemFactory();
		
		File domainFile = new File(DOMAIN_PATH + DOMAIN_NAME + PDDL_EXTENSION);
 
		do {
			String problem = "";
			
			HardMap map = new HardMap();
			
			map.setArrival(inFinalPlace, inFinalIndex);
			map.addPlacesToVisit(listGoals);
			map.generateConfiguration();
			
			problem += map.defineProblem(DOMAIN_NAME, inProblemName);
			problem += map.getObjectsSyntaxPDDL();
			problem += map.getInitializationSyntaxPDDL();
			problem += map.getGoalSyntaxPDDL();
			
			try {
				FileWriter fileWriter = new FileWriter(PROBLEM_PATH + inProblemName + PDDL_EXTENSION);
				
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(problem);
				
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			File problemFile = new File(PROBLEM_PATH + inProblemName + PDDL_EXTENSION);
			
			// Parse the domain and the problem
		    ErrorManager errorManager;
			try {
				errorManager = factory.parse(domainFile, problemFile);
				if (!errorManager.isEmpty()) {
		            errorManager.printAll();
		            System.exit(0);
				}
			} catch (IOException e1) {
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
				System.out.println(String.format("\n\nFound plan as follows:\n"));
				System.out.println(pb.toString(plan));
				isPlanned = true;
			} else {
				System.out.append(String.format("\nNo plan found, trying another configuration...\n\n"));
			}
		} while (!isPlanned);
	}
}
