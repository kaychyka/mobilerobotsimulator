package pt.uc.dei.mobilerobotsimulator;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Karin Pi�kur (2014190802) and Pedro de Oliveira Estev�o (2011157312)
 *
 */
public class Main {

	public static void main(String[] args){
		int id = 0, x, y, skip = 0;
		String input;
		Environment environment;
		Entity entity;
		
		//Create the environment - Length
		System.out.println("Environment size X");
		Scanner inputX = new Scanner(System.in);
		x = inputX.nextInt();
		
		//Create the environment - Height
		System.out.println("Environment size Y");
		Scanner inputY = new Scanner(System.in);
		y = inputY.nextInt();		
		
		//Create the environment - The creation
		environment = new Environment();

		//Agent creation
		while(skip == 0){
			System.out.print("Agent input format: Color,Shape,X,Y,Sight");
			Scanner objectinput = new Scanner(System.in);
			input = objectinput.next();
			Scanner objectinput2 = new Scanner(input).useDelimiter("\\s*,\\s*");
			try {entity = new RandomAgent(id, objectinput2.next().toLowerCase(), objectinput2.next().toLowerCase(), objectinput2.nextInt(), objectinput2.nextInt(),objectinput2.nextInt());
				environment.addEntity(entity);
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
			System.out.println("Agent input format: Color,Shape,X,Y,Type");
			Scanner objectinput = new Scanner(System.in);
			input = objectinput.next();
			Scanner objectinput2 = new Scanner(input).useDelimiter("\\s*,\\s*");
			try {entity = new Object(id, objectinput2.next().toLowerCase(), objectinput2.next().toLowerCase(), objectinput2.nextInt(), objectinput2.nextInt(),objectinput2.next().toLowerCase());
				environment.addEntity(entity);
				entity.debug();
				id++;
			} catch (NoSuchElementException e) {
				skip = 1;
				System.out.println("Object creation ends");
			}
		}//while
		
	}//main
}//class
