package pt.uc.dei.mobilerobotsimulator;

import java.util.ArrayList;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estevão (2011157312)
 * 
 * Agent represents the robot. 
 * The agents move throughout the environment exploring it in order to acquire 
 * information about all the objects that populate it. To do that, agents have 
 * a memory container that allows them to store all the acquired information, 
 * i.e., a list of all the learned objects. Each agent possess also a visual field 
 * which means that an agent precepts only the objects with coordinates belonging 
 * to the space delimited by a circumference with radius equal to the visual 
 * field parameter and center in the coordinates of the agent.
 * 
 * The agents should move from object to object. At each stop in an object, 
 * the agent should obtain the list of objects present in its visual field. Given 
 * this list. The agent should chose the next object to visit by making use of 
 * one of the three strategies. That's why we have three different agents:
 * Closest Agent, Difference Agent and Random Agent.
 *
 */
public abstract class Agent extends Entity{

	//all objects visited  
	protected ArrayList<Object> objectMemory = new ArrayList<Object>(); 
	//all objects in visual field in agent's life 
	protected ArrayList<Object> visualMemory = new ArrayList<Object>();
	//all objects in current visible field
	protected ArrayList<Object> visibleObjects; // = new ArrayList<Object>();
	//the path that agent made in its life
	protected ArrayList<int[]> pathMemory = new ArrayList<int[]>();
	protected int sight;
	protected int numOfObjects;
	protected int numOfDiffObjects;
	protected int distance;
	
	public Agent(int ID, String color, String shape, int coordX, int coordY, int sight) {
		super(ID, color, shape, coordX, coordY);
		this.sight = sight;
	}
	
    /**
     * Search for all the objects in the visual field.
     * We need this method in the method choice, 
     * which is implemented in every agent separately.
     */
	protected void search(){
		visibleObjects = new ArrayList<Object>();
		for (Entity object : Environment.entitiesLocation) {
			//in case we have non-object entities
			if (object instanceof Object) {
				//the equation for looking for the points inside the radius
				//(in our case inside the agents sight)
				if(Math.abs(object.getCoordX() - this.coordX) <= (this.sight) && Math.abs(object.getCoordY() - this.coordY) <= (this.sight))
					visibleObjects.add((Object)object);
			}	
		}
		
		//add all visible objects to visible memory,
		//so we have saved all objects in visible field 
		//of the agent in its life
		visualMemory.addAll(visibleObjects);
	}
	
    /**
     * With this method we choose which object we will visit next
     * 
     * (It's implemented in subclasses, 
     * where it depends on the type of the agent)
     */
	public abstract void choice();
	
	/**
	 * Move agent to coordinates 
	 * (e.g. where is new selected object,
	 * which we picked in choice method or just to new location)
	 * 
	 * @param coordinates of next
	 */
	public void moveToCoordinates(int x, int y){
		this.coordX = x;
		this.coordY = y;
		
		int[] coor = {x,y};
		pathMemory.add(coor);
		
		//At each stop in an object, the agent should
		//obtain the list of objects present in its visual field.
		search();
	}
	
	/**
	 * Check if current visited object was already visited or not.
	 * @param obj
	 */
	public boolean differentObject(Object obj){
		for (Object object : objectMemory) {
			if(object.getID() == obj.getID())
				return false;
		}
		return true;
	}
	
	/**
     * @return objects that agent visited
     */
	public ArrayList<Object> getObjectMemory() {
		return objectMemory;
	}
	
    /**
     * @return all objects in visual field in agent's life
     */
	public ArrayList<Object> getVisualMemory() {
		return visualMemory;
	}

    /**
     * @return ArrayList of all coordinates that agent visited 
     */
	public ArrayList<int[]> getPathMemory() {
		return pathMemory;
	}

    /**
     * @return radius of agent's sight
     */
	public int getSight() {
		return sight;
	}

    /**
     * @return  list of all object inside of the current radius of visibility
     */
	public ArrayList<Object> getVisibleObjects() {
		return visibleObjects;
	}

    /**
     * @return  number of all objects that agent passed by
     */
	public int getNumOfObjects() {
		return numOfObjects;
	}

    /**
     * @return number of different objects that agent passed by
     */
	public int getNumOfDiffObjects() {
		return numOfDiffObjects;
	}

    /**
     * @return distance that agent already made
     */
	public int getDistance() {
		return distance;
	}
	
	public void debug(){
		System.out.println(ID + " " + color + " " + shape + " " + coordX + " " + coordY + " " + sight);
	}
	
}
