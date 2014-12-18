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

	protected static ArrayList<Entity> entitiesLocation = new ArrayList<Entity>();
	private int sizeX;
	private int sizeY;
	
	public Environment(int sizeX, int sizeY){
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * Add entity in the environment
	 * @param entity - entity which is added to environment
	 */
	public void addEntity(Entity entity){
		entitiesLocation.add(entity);
	}
	
	/**
	 * @return size X of the environment
	 */
	public int getSizeX(){
		return this.sizeX;
	}
	
	/** 
	 * @return size Y of the environment
	 */
	public int getSizeY(){
		return this.sizeY;
	}
	
}
