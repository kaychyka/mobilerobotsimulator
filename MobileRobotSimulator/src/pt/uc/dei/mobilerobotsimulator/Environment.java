package pt.uc.dei.mobilerobotsimulator;

import java.util.ArrayList;


/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 *
 * This class represents the environment, which is a 2D matrix and
 * contains all of the entities.
 *
 */
public class Environment {

	/**
	 * List of all entities in environment
	 */
	protected static ArrayList<Entity> entities = new ArrayList<Entity>();
	private int sizeX;
	private int sizeY;
	
	/**
	 * Environment creator
	 * 
	 * @param sizeX - length of environment
	 * @param sizeY - width of environment
	 */
	public Environment(int sizeX, int sizeY){
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * 
	 * @return all entities in environment
	 */
	public static ArrayList<Entity> getEntities() {
		return entities;
	}

	
	/**
	 * Add entity in the environment
	 * 
	 * @param entity - entity which is added to environment
	 */
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	
	/**
	 * @return size X (length) of the environment
	 */
	public int getSizeX(){
		return this.sizeX;
	}
	
	/** 
	 * @return size Y (width) of the environment
	 */
	public int getSizeY(){
		return this.sizeY;
	}
	
}
