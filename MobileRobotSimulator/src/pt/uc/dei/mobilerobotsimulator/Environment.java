package pt.uc.dei.mobilerobotsimulator;

import java.util.ArrayList;


/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estevão (2011157312)
 *
 * This class represents the environment, which is a 2D matrix and
 * contains all of the entities.
 *
 */
public class Environment {

	protected static ArrayList<Entity> entitiesLocation = new ArrayList<Entity>();
	
	/**
	 * 
	 * With this method we check the location of the entity.
	 * 
	 * @param ent - Entity for which we need the location
	 * @return location of the entity
	 */
	public int[] getLocation(Entity ent){
		int[] location = new int[2];
		for (Entity entity : entitiesLocation) {
			if(entity.getID() == ent.getID()){
				location[0] = entity.getCoordX();
				location[1] = entity.getCoordY();
			}
		}
		return location;
	}
	
	/**
	 * 
	 * @param entity - Entity of which location we want to change/set
	 * @param x - Coordinate x of the entity
	 * @param y - Coordinate y of the entity
	 */
	public void setLocation(Entity entity, int x, int y){
		//TODO
	}
	
	public void addEntity(Entity entity){
		entitiesLocation.add(entity);
	}
}
