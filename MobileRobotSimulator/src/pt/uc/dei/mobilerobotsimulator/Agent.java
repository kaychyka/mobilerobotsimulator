package pt.uc.dei.mobilerobotsimulator;

import java.util.ArrayList;

public abstract class Agent extends Entity{

	protected ArrayList<Object> objectMemory = new ArrayList<Object>(); 
	protected ArrayList<Object> visualMemory = new ArrayList<Object>();
	protected ArrayList<int[]> pathMemory = new ArrayList<int[]>();
	protected int sight;
	protected ArrayList<Object> visibleObjects = new ArrayList<Object>();
	protected int numOfObjects;
	protected int numOfDiffObjects;
	protected int distance;
	
	public Agent(int ID, String color, String shape, int coordX, int coordY, int sight) {
		super(ID, color, shape, coordX, coordY);
		this.sight = sight;
	}
	
    /**
     * Search the object we want to visit next
     * @param obj - object we want to find/visit
     * @return coordinates of the object
     */
	protected int[] search(Object obj){
            //TODO: implement this method
            return null;
	}
	
    /**
     * With this method we choose which object we will visit next
     * 
     * (It's implemented in subclasses, 
     * where it depends on the type of the agent)
     */
	public abstract void choice();
	
	/**
     * 
     * @return objects that agent visited or passed by
     */
	public ArrayList<Object> getObjectMemory() {
		return objectMemory;
	}
	
    /**
     * 
     * @return objects that agent can see inside the sight
     */
	public ArrayList<Object> getVisualMemory() {
		return visualMemory;
	}

    /**
     * 
     * @return ArrayList of all coordinates that agent visited 
     */
	public ArrayList<int[]> getPathMemory() {
		return pathMemory;
	}

    /**
     * 
     * @return radius of agent's sight
     */
	public int getSight() {
		return sight;
	}

    /**
     * 
     * @return  list of all object inside the radius of visibility
     */
	public ArrayList<Object> getVisibleObjects() {
		return visibleObjects;
	}

    /**
     * 
     * @return  number of all objects that agent passed by
     */
	public int getNumOfObjects() {
		return numOfObjects;
	}

    /**
     * 
     * @return number of different objects that agent passed by
     */
	public int getNumOfDiffObjects() {
		return numOfDiffObjects;
	}

    /**
     * 
     * @return distance that agent already made
     */
	public int getDistance() {
		return distance;
	}
	
	public void debug(){
		System.out.println(ID + " " + color + " " + shape + " " + coordX + " " + coordY + " " + sight);
	}
	
}
