package pt.uc.dei.mobilerobotsimulator;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
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
 * @author Karin Pi�kur (2014190802) and Pedro de Oliveira Est�v�o (2011157312)
 * 
 */
public abstract class Agent extends Entity{

	/**
	 * All visited objects  
	 */
	protected ArrayList<Object> visitedObjectsMemory = new ArrayList<Object>(); 
	/**
	 * All objects in visual field in agent's life 
	 */
	protected ArrayList<Object> learnedObjectsMemory = new ArrayList<Object>();
	/**
	 * All objects in current visible field
	 */
	protected ArrayList<Object> visibleObjects;
	/**
	 * The path that agent made in its life
	 */
	protected ArrayList<int[]> pathMemory = new ArrayList<int[]>();
	
	protected int sight;
	protected int numOfObjects;
	protected int numOfDiffObjects;
	protected double distance;
	
	/**
	 * Agent's creator
	 * 
	 * @param environment the environment where all entities are placed
	 * @param ID ID number of the agent
	 * @param color color of the agent
	 * @param shape shape of the agent
	 * @param coordX coordinate X of first agent's location
	 * @param coordY coordinate Y of first agent's location
	 * @param sight radius sight of the agent
	 */
	public Agent(Environment environment, int ID, String color, String shape, int coordX, int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY);
		this.sight = sight;
	}
	
    /**
     * Search for all the objects in the visual field.
     * We need this method in the method choice, 
     * which is implemented in every agent separately.
     */
	protected void search(){
		visibleObjects = new ArrayList<Object>();
		for (Entity object : Environment.entities) {
			//in case we have non-object entities
			if (object instanceof Object) {
				//the equation for looking for the points inside the radius
				//(in our case inside the agents sight)
				if(Math.abs(object.getCoordX() - this.coordX) <= (this.sight) && Math.abs(object.getCoordY() - this.coordY) <= (this.sight)
						&& ((object.getCoordX() != this.coordX) || (object.getCoordY() != this.coordY))){
					visibleObjects.add((Object)object);
					
					//increase the number of all objects in visual field
			        numOfObjects++;
			        
			        //check if the object has been seen before
			        if(differentObject((Object)object))
			        	numOfDiffObjects++; 
				}
			}	
		}  
        
		//add all visible objects to visible memory,
		//so we have saved all objects in visible field 
		//of the agent in its life
		learnedObjectsMemory.addAll(visibleObjects);
		
		//add the position to path memory
		int[] coor = {this.coordX,this.coordY};
		pathMemory.add(coor);
		
	}
	
	/**
	 * Increase the distance with a distance from old to new location
	 * 
	 * @param oldX old coordinate X of the agent
	 * @param oldY old coordinate Y of the agent
	 * @param newX new coordinate X of the agent
	 * @param newY new coordinate X of the agent
	 */
	private void increaseDistance(int oldX, int oldY, int newX, int newY){
		double dist = Math.sqrt(Math.pow((oldX - newX), 2) + Math.pow((oldY - newY),2));
		distance += dist;
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
	 * @param x coordinate x of next agent's position 
	 * @param y coordinate y of next agent's position
	 */
	public void moveToCoordinates(int x, int y){
		int oldX = this.coordX;
		int oldY = this.coordY;
		System.out.print("Agent " + this.ID + " moving from " + oldX + "," + oldY);
		
		this.coordX = x;
		this.coordY = y;
		
		System.out.println(" to " + this.coordX + "," + this.coordY);
		
		increaseDistance(oldX, oldY, this.coordX, this.coordY);
	}
	
	/**
	 * Move agent to random coordinates 
	 */
	public void moveToRandomCoordinates(){
		Random rnd = new Random();
		int oldX = this.coordX;
		int oldY = this.coordY;
		System.out.print("Agent " + this.ID + " randomly moving from " + oldX + "," + oldY);
		
		this.coordX += (-sight) + rnd.nextInt(sight*2 + 1);
		this.coordY += (-sight) + rnd.nextInt(sight*2 + 1);
		limit();
		
		System.out.println(" to " + this.coordX + "," + this.coordY);
		
		increaseDistance(oldX, oldY, this.coordX, this.coordY);
	}
	
	/**
	 * Check if current visited object was already visited or not.
	 * 
	 * @param obj object we want to check
	 * @return true if the object is different, wasn't visited yet
	 * @return false if the object was already visited
	 */
	public boolean differentObject(Object obj){
		for (Object object : learnedObjectsMemory) {
			if(object.getID() == obj.getID()){
				return false;
			}
		}
		return true;
	}
	
	/**
     * @return objects that agent visited
     */
	public ArrayList<Object> getVisitedObjectMemory() {
		return visitedObjectsMemory;
	}
	
    /**
     * @return all objects in visual field in agent's life
     */
	public ArrayList<Object> getLearnedObjectsMemory() {
		return learnedObjectsMemory;
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
	public double getDistance() {
		return distance;
	}
	
	/**
	 * @return string with all agent's data
	 */
	@Override
	public String toString() {
		return "Agent: ID: "+ ID + ", color: " + color + ", shape: " + shape + ", X: " + coordX + ", Y: " + coordY + ", sight: " + sight+"\n";
	}
	
}
