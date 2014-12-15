package pt.uc.dei.mobilerobotsimulator;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 *
 */

public class Main {
	
		public static void main(String[] args){
		int id = 0, x, y, skip = 0;
		String input;
		Entity entity;
		ArrayList<Agent> agents = new ArrayList<Agent>();
		Environment environment;
		
		//Create the environment - Length
		System.out.println("Environment size X");
		Scanner inputX = new Scanner(System.in);
		x = inputX.nextInt();
		
		//Create the environment - Height
		System.out.println("Environment size Y");
		Scanner inputY = new Scanner(System.in);
		y = inputY.nextInt();		
		
		//Create the environment - The creation
		environment = new Environment(x,y);

		//Agent creation
		while(skip == 0){
			System.out.println("Agent input format: Color,Shape,X,Y,Sight");
			Scanner objectinput = new Scanner(System.in);
			input = objectinput.next();
			Scanner objectinput2 = new Scanner(input).useDelimiter("\\s*,\\s*");
			try {entity = new RandomAgent(environment, id, objectinput2.next().toLowerCase(), objectinput2.next().toLowerCase(), objectinput2.nextInt(), objectinput2.nextInt(),objectinput2.nextInt());
				environment.addEntity(entity);
				agents.add((Agent) entity);
				entity.limit();
				entity.debug();
				id++;
			} catch (NoSuchElementException e) {
				skip = 1;
				System.out.println("Moving to object creation...");
			}
		}//while
		skip = 0;
		//Object creation
		while(skip == 0){
			System.out.println("Object input format: Color,Shape,X,Y,Type");
			Scanner objectinput = new Scanner(System.in);
			input = objectinput.next();
			Scanner objectinput2 = new Scanner(input).useDelimiter("\\s*,\\s*");
			try {entity = new Object(environment, id, objectinput2.next().toLowerCase(), objectinput2.next().toLowerCase(), objectinput2.nextInt(), objectinput2.nextInt(),objectinput2.next().toLowerCase());
				environment.addEntity(entity);
				entity.limit();
				entity.debug();
				id++;
			} catch (NoSuchElementException e) {
				skip = 1;
				System.out.println("Object creation ends");
			}
		}//while
		skip = 0;
		//Object manipulation
		while(skip == 0){
			System.out.println("Input exit to terminate");
			Scanner objectinput = new Scanner(System.in);
			input = objectinput.next();
			if (input == "exit") { //terminate!!
				skip = 1;
				}
			else { //move the objects
				for (int i = 0; i < agents.size(); i++){
					agents.get(i).choice();
				}
			}
		}//while
		
	}//main
}//class
