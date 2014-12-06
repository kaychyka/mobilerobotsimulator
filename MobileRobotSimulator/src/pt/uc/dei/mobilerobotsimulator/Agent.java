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
	
	protected void search(){
		//TODO: implement this method
	}
	
	public abstract void choice();
	
	
	public ArrayList<Object> getObjectMemory() {
		return objectMemory;
	}
	
	public ArrayList<Object> getVisualMemory() {
		return visualMemory;
	}

	public ArrayList<int[]> getPathMemory() {
		return pathMemory;
	}

	public int getSight() {
		return sight;
	}

	public ArrayList<Object> getVisibleObjects() {
		return visibleObjects;
	}

	public int getNumOfObjects() {
		return numOfObjects;
	}

	public int getNumOfDiffObjects() {
		return numOfDiffObjects;
	}

	public int getDistance() {
		return distance;
	}
}
