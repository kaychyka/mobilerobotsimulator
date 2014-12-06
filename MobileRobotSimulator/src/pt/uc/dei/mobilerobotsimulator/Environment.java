package pt.uc.dei.mobilerobotsimulator;

import java.util.ArrayList;


/**
 * 
 * @author Karin
 *
 *This class represents the environment, which contains all of the entities.
 *
 */
public class Environment {

	private ArrayList<Entity> entitiesLocation = new ArrayList<Entity>();
	
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
	
	public void setLocation(Entity entity, int x, int y){
		
	}
}
