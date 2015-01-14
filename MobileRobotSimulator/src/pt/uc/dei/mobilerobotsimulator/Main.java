package pt.uc.dei.mobilerobotsimulator;

import java.util.*;
import java.io.*;

/**
 * 
 * Main class includes methods for generating environment and for saving data
 * into files.
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 *
 */

public class Main {
	
	/**
	 * It generates all Environment, Agents and Objects, based on data in file
	 * @param agents empty list of agents, where agents are added after creation
	 * @param fileName the name of the file, which we includes data for creation
	 * 						environment, agents and objects	 * 					
	 * @return null if everything was okay, or error message if something went wrong,
	 * 					e.g. wrong file
	 */
	public static int[] generateEnviroment(ArrayList<Agent> agents, String fileName){
		int id = 0, x, y, skip = 0;
		Entity entity;
		Environment environment;
		int[] dimen = null;
		
		try{
			File f = new File(fileName);
			FileReader fr = new FileReader(f);
	        BufferedReader br = new BufferedReader(fr);
	        String[] enviromentSize = br.readLine().split(",");
	        
	        try{
	        	dimen = new int[2];
				//Create the environment - Length
		        x = Integer.parseInt(enviromentSize[0]);
				dimen[0] = x;
		        System.out.println("Environment size X: "+x);				
				
				//Create the environment - Height
		        y = Integer.parseInt(enviromentSize[1]);
		        dimen[1]=y;
				System.out.println("Environment size Y: "+y);
				
				//Create the environment - The creation
				environment = new Environment(x,y);
		
				//Agent creation
				while(skip == 0){
					String[] agentData = br.readLine().split(",");
					if(agentData.length > 1){
						if(Integer.parseInt(agentData[0])==0){
							try {entity = new RandomAgent(environment, id, agentData[1].toLowerCase(), agentData[2].toLowerCase(), Integer.parseInt(agentData[3]), Integer.parseInt(agentData[4]), Integer.parseInt(agentData[5]));	
								environment.addEntity(entity);
								agents.add((Agent) entity);
								entity.limit();
								id++;
							} catch (NoSuchElementException e) {
								skip = 1;
								System.out.println("Moving to object creation...");
							}
						}else if(Integer.parseInt(agentData[0])==1){
							try {entity = new ClosestAgent(environment, id, agentData[1].toLowerCase(), agentData[2].toLowerCase(), Integer.parseInt(agentData[3]), Integer.parseInt(agentData[4]), Integer.parseInt(agentData[5]));	
								environment.addEntity(entity);
								agents.add((Agent) entity);
								entity.limit();
								id++;
							} catch (NoSuchElementException e) {
								skip = 1;
								System.out.println("Moving to object creation...");
							}
						}else if(Integer.parseInt(agentData[0])==2){
							try {entity = new DifferenceAgent(environment, id, agentData[1].toLowerCase(), agentData[2].toLowerCase(), Integer.parseInt(agentData[3]), Integer.parseInt(agentData[4]), Integer.parseInt(agentData[5]));	
								environment.addEntity(entity);
								agents.add((Agent) entity);
								entity.limit();
								id++;
							} catch (NoSuchElementException e) {
								skip = 1;
								System.out.println("Moving to object creation...");
							}
						}
					} else {
						skip = 1;
						System.out.println("Moving to object creation...");
					}
				}//while
				skip = 0;
				
				//Object creation
				while(skip == 0){
					String[] objectData = br.readLine().split(",");
					if(objectData.length > 1){
						try {entity = new Object(environment, id, objectData[0].toLowerCase(), objectData[1].toLowerCase(), Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]), objectData[4].toLowerCase());	
							environment.addEntity(entity);
							entity.limit();
//							entity.debug();
							id++;
						} catch (NoSuchElementException e) {
							skip = 1;
							System.out.println("Object creation ends");
						}
					} else {
						skip = 1;
						System.out.println("Object creation ends");
					}
				}//while
				skip = 0;
				//Object manipulation
				for (int i = 0; i < agents.size(); i++){ //add initial positions to memory
					agents.get(i).search();
				}

		        br.close();
	        }catch (Exception e){
	        	br.close();
	        	return null;
	        }
		} catch (IOException e ){
			return null;
		}
		
		return dimen;
	}
	
	/**
	 * Moves the agents in environment and return memory data of agents
	 * @param agents list of all agents
	 * @param moves number of agents' moves
	 * @param folderName the name of the folder where we want to create files with data
	 * @return memory data of agents
	 */
	public static String returnData(ArrayList<Agent> agents, int moves, String folderName){
		String memoryData = "";
		
		//move agents
		for (int i = 0; i < moves; i++) {
			for (int j = 0; j < agents.size(); j++){
				agents.get(j).choice();	
				agents.get(j).search();
			}
		}
		
		//print memory data
		for (int i = 0; i < agents.size(); i++){
			//agent details
			memoryData += agents.get(i).toString();
			memoryData += "--------------------------------------------------------------\n";
			//object			
			memoryData += "Visited objects memory: ";
			for (int j = 0; j < agents.get(i).getVisitedObjectMemory().size(); j++){
				memoryData += agents.get(i).getVisitedObjectMemory().get(j).getID() + ", ";
			}
			memoryData += "\n";

			//visual
			memoryData += "Learned objects memory: ";
			for (int j = 0; j < agents.get(i).getLearnedObjectsMemory().size(); j++){
				memoryData += agents.get(i).getLearnedObjectsMemory().get(j).getID() + ", ";
			}

			memoryData += "\n";
			
			//path
			memoryData += "Path memory: ";
			for (int j = 0; j < agents.get(i).getPathMemory().size(); j++){
				memoryData += "["+agents.get(i).getPathMemory().get(j)[0] + "," + agents.get(i).getPathMemory().get(j)[1] + "], ";
			}
			
			memoryData += "\n";
			
			//visible objects
			memoryData += "Visible objects: ";
			for (int j = 0; j < agents.get(i).getVisibleObjects().size(); j++){
				memoryData += agents.get(i).getVisibleObjects().get(j).getID() + ", ";
			}

			memoryData += "\nDistance: "+agents.get(i).getDistance();
			memoryData += "\n\n";
			
		}	

		try{
			File newFile = new File(folderName+"\\memoryData.txt");
			FileWriter fw = new FileWriter(newFile);
	        PrintWriter ps = new PrintWriter(fw);
	        ps.write(memoryData);
	        ps.close();
		}catch (IOException e){
			
		}
        
		//print agents' perceptions into file
		agentsPerceptions(agents, folderName);
		
		//print agents' step sequence into file
		agentsStepSequence(agents, folderName);
		
		//print agents' final statistic into file
		agentsStatistic(agents, folderName);
		
		return memoryData;
	}
	
	/**
	 * Prints agents' statistic into file
	 * 
	 * @param agents list of all agents
	 * @param folderName the name of the folder where we want to create file with data
	 */
	public static void agentsStatistic(ArrayList<Agent> agents, String folderName){
		String statistic = "";
		
		for (Agent agent : agents) {
			statistic += agent.toString();
			statistic += "--------------------------------------------------------------\n";
			
			statistic += "Distance: "+agent.getDistance()+"\n";
			statistic += "Number of objects learned: "+agent.getNumOfObjects()+"\n";
			statistic += "Number of different objects learned: "+agent.getNumOfDiffObjects()+"\n";
			statistic += "\n";
		}
		
		try{
			File newFile = new File(folderName+ File.separator+ "finalStatistics.txt");
			FileWriter fw = new FileWriter(newFile);
	        PrintWriter ps = new PrintWriter(fw);
	        ps.write(statistic);
	        ps.close();
		}catch (IOException e){
			
		}
			
	}
	
	/**
	 * Prints agents' perceptions into file
	 * 
	 * @param agents list of all agents
	 * @param folderName  the name of the folder where we want to create file with data
	 */
	public static void agentsPerceptions(ArrayList<Agent> agents, String folderName){
		String perceptions = "";
		
		for (Agent agent : agents) {
			perceptions += agent.toString();
			perceptions += "--------------------------------------------------------------\n";
			for (Object object : agent.getLearnedObjectsMemory()) {
				perceptions += object.toString();
			}
			perceptions += "\n";
		}
		
		try{
			File newFile = new File(folderName+ File.separator+ "perceptions.txt");
			FileWriter fw = new FileWriter(newFile);
	        PrintWriter ps = new PrintWriter(fw);
	        ps.write(perceptions);
	        ps.close();
		}catch (IOException e){
			
		}
	}
	
	/**
	 * Prints agents' step sequence into file
	 * 
	 * @param agents  list of all agents
	 * @param folderName  the name of the folder where we want to create file with data
	 */
	public static void agentsStepSequence(ArrayList<Agent> agents, String folderName){
		String stepSequence = "";
		
		for (Agent agent : agents) {
			stepSequence += agent.toString();
			stepSequence += "--------------------------------------------------------------\n";
			for (int[] path : agent.getPathMemory()) {
				stepSequence += "["+path[0] + "," + path[1]+"]\n";
			}
			stepSequence += "\n";
		}
		
		try{
			File newFile = new File(folderName + File.separator+ "stepSequence.txt");
			FileWriter fw = new FileWriter(newFile);
	        PrintWriter ps = new PrintWriter(fw);
	        ps.write(stepSequence);
	        ps.close();
		}catch (IOException e){
			
		}
	}

}//class
