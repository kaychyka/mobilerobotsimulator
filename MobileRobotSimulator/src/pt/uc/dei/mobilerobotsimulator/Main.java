package pt.uc.dei.mobilerobotsimulator;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
( *
 */

public class Main {
	
	/**
	 * It generates all Enviroment, Agents and Objects, based on File objects.txt
	 * @param agents
	 */
	public static String generateEnviroment(ArrayList<Agent> agents, String fileName){
		int id = 0, x, y, skip = 0;
		Entity entity;
		Environment environment;
		
		try{
			File f = new File(fileName);
			FileReader fr = new FileReader(f);
	        BufferedReader br = new BufferedReader(fr);
	        String[] enviromentSize = br.readLine().split(",");
	        
	        try{
				//Create the environment - Length
		        x = Integer.parseInt(enviromentSize[0]);
				System.out.println("Environment size X: "+x);
		//		Scanner inputX = new Scanner(System.in);
		//		x = inputX.nextInt();
				
				
				//Create the environment - Height
		        y = Integer.parseInt(enviromentSize[1]);
				System.out.println("Environment size Y: "+y);
		//		Scanner inputY = new Scanner(System.in);
		//		y = inputY.nextInt();		
				
				//Create the environment - The creation
				environment = new Environment(x,y);
		
				//Agent creation
				while(skip == 0){
		//			System.out.println("Agent input format: Color,Shape,X,Y,Sight");
		//			Scanner objectinput = new Scanner(System.in);
		//			input = objectinput.next();
		//			Scanner objectinput2 = new Scanner(input).useDelimiter("\\s*,\\s*");
		//			try {entity = new RandomAgent(environment, id, objectinput2.next().toLowerCase(), objectinput2.next().toLowerCase(), objectinput2.nextInt(), objectinput2.nextInt(),objectinput2.nextInt());
					String[] agentData = br.readLine().split(",");
					if(agentData.length > 1){
						if(Integer.parseInt(agentData[0])==0){
							try {entity = new RandomAgent(environment, id, agentData[1].toLowerCase(), agentData[2].toLowerCase(), Integer.parseInt(agentData[3]), Integer.parseInt(agentData[4]), Integer.parseInt(agentData[5]));	
								environment.addEntity(entity);
								agents.add((Agent) entity);
								entity.limit();
								entity.debug();
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
								entity.debug();
								id++;
							} catch (NoSuchElementException e) {
								skip = 1;
								System.out.println("Moving to object creation...");
							}
						}else if(Integer.parseInt(agentData[0])==2){
							try {entity = new RandomAgent(environment, id, agentData[1].toLowerCase(), agentData[2].toLowerCase(), Integer.parseInt(agentData[3]), Integer.parseInt(agentData[4]), Integer.parseInt(agentData[5]));	
								environment.addEntity(entity);
								agents.add((Agent) entity);
								entity.limit();
								entity.debug();
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
	//				System.out.println("Object input format: Color,Shape,X,Y,Type");
	//				Scanner objectinput = new Scanner(System.in);
	//				input = objectinput.next();
	//				Scanner objectinput2 = new Scanner(input).useDelimiter("\\s*,\\s*");
	//				try {entity = new Object(environment, id, objectinput2.next().toLowerCase(), objectinput2.next().toLowerCase(), objectinput2.nextInt(), objectinput2.nextInt(),objectinput2.next().toLowerCase());
					String[] objectData = br.readLine().split(",");
					if(objectData.length > 1){
						try {entity = new Object(environment, id, objectData[0].toLowerCase(), objectData[1].toLowerCase(), Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]), objectData[4].toLowerCase());	
							environment.addEntity(entity);
							entity.limit();
							entity.debug();
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
	        }catch (Exception e){
	        	return "You chose wrong file";
	        }
		} catch (IOException e ){
			
		}
		return null;
	}
	
	/**
	 * it moves the agent, or in case "mem" it prints the memories of agent
	 * or in case of "exit" the program stops
	 * @param agents
	 */
	public static String returnData(ArrayList<Agent> agents, int moves){
		String memoryData = "";
		int skip = 0;
		String input;
		
		//move agents 10 - times
		for (int i = 0; i < moves; i++) {
			for (int j = 0; j < agents.size(); j++){
				agents.get(j).choice();	
				agents.get(j).search();
			}
		}
//		while(skip == 0){
//			System.out.println("Input exit to terminate, input mem to view memory");
//			Scanner objectinput = new Scanner(System.in);
//			input = objectinput.nextLine();
//			if (input.equals("exit")) { //terminate!!
//				skip = 1;
//				}
//			else if (input.equals("mem")){
			for (int i = 0; i < agents.size(); i++){
				//agent details
				memoryData += "Agent: "+agents.get(i).toString()+"\n";
				//object
//				System.out.print("Object memory: ");
				memoryData += "Object memory: ";
				for (int j = 0; j < agents.get(i).getObjectMemory().size(); j++){
//					System.out.print(agents.get(i).getObjectMemory().get(j).getID() + ", ");
					memoryData += agents.get(i).getObjectMemory().get(j).getID() + ", ";
				}
//					System.out.println();
				memoryData += "\n";
				//visual
//					System.out.print("Visual memory: ");
				memoryData += "Visual memory: ";
				for (int j = 0; j < agents.get(i).getVisualMemory().size(); j++){
//					System.out.print(agents.get(i).getVisualMemory().get(j).getID() + ", ");
					memoryData += agents.get(i).getVisualMemory().get(j).getID() + ", ";
				}
//					System.out.println();
				memoryData += "\n";
				//path
//					System.out.print("Path memory: ");
				memoryData += "Path memory: ";
				for (int j = 0; j < agents.get(i).getPathMemory().size(); j++){
//					System.out.print("["+agents.get(i).getPathMemory().get(j)[0] + "," + agents.get(i).getPathMemory().get(j)[1] + "], ");
					memoryData += "["+agents.get(i).getPathMemory().get(j)[0] + "," + agents.get(i).getPathMemory().get(j)[1] + "], ";
				}
//				System.out.println();
				memoryData += "\n";
				//visible objects
				System.out.print("Visible objects: ");
				for (int j = 0; j < agents.get(i).getVisibleObjects().size(); j++){
//					System.out.print(agents.get(i).getVisibleObjects().get(j).getID() + ", ");
					memoryData += agents.get(i).getVisibleObjects().get(j).getID() + ", ";
				}
//				System.out.println();
				memoryData += "\nDistance: "+agents.get(i).getDistance();
//				System.out.print("Distance: "+agents.get(i).getDistance());
//				System.out.println("\n");
				memoryData += "\n\n";
				
			}	
				
//			} else { //move the objects
//				for (int i = 0; i < agents.size(); i++){
//					agents.get(i).choice();	
//					agents.get(i).search();
//				}
//			}
//		}//while
		return memoryData;
	}
	
	public static void main(String[] args){
		ArrayList<Agent> agents = new ArrayList<Agent>();
		
		generateEnviroment(agents, "objects.txt");
		
		System.out.print(returnData(agents, 10));
		
		
	}//main
}//class
