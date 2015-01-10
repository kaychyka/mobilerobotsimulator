package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 * 
 * This agent uses strategy of the maximum difference to the objects stored in memory: 
 * this strategy allows the agent to select as the next point of view the object 
 * that is more different to the objects in memory. The algorithm involves the 
 * comparison of each object in the visual field with each object in memory. 
 *
 */
public class DifferenceAgent extends Agent {

	/**
	 * Difference agent's creator
	 * 
	 * @param environment - environment where all entities are placed
	 * @param ID - ID number of the agent
	 * @param color - color of the agent
	 * @param shape - shape of the agent
	 * @param coordX - coordinate X of first agent's location
	 * @param coordY - coordinate Y of first agent's location
	 * @param sight - radius sight of the agent
	 */
	public DifferenceAgent(Environment environment, int ID, String color, String shape, int coordX,
			int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY, sight);
	}

	@Override
	public void choice() {
		if (visibleObjects.size() > 0) {
			Object mostDifferent = visibleObjects.get(0);
			int diffs = -1;
			for (Object visibleObject : visibleObjects) {
				for (Object object : visitedObjectsMemory) {
					int currentDiffs = compareObjects(visibleObject, object);
					if(currentDiffs > diffs){
						mostDifferent = visibleObject;
						diffs = currentDiffs;
					}
				}
			}

			//increase the number of all visited objects
	        numOfObjects++;
	        
	        //check if agent already visited this object
	        //and in case it didn't increase the numOfDiffObjects
	        if(differentObject(mostDifferent))
	        	numOfDiffObjects++;        
	        		
			//add object to memory
			visitedObjectsMemory.add(mostDifferent);
			
			moveToCoordinates(mostDifferent.getCoordX(), mostDifferent.getCoordY());
		} else {
			moveToRandomCoordinates();
		}
	}
	
	/**
	 * Compares numbers of differences between two objects
	 * 
	 * @param firstObject - first object we want to compare with second one
	 * @param newObject - second object we want to compare with first one
	 * @return number of differences between two objects
	 */
	private int compareObjects(Object firstObject, Object secondObject){
		int differences = 0;
		
		if(!firstObject.getColor().equals(secondObject.getColor())){
			differences++;
		}
		
		if(!firstObject.getShape().equals(secondObject.getShape())){
			differences++;
		}
		
		if(!firstObject.getType().equals(secondObject.getType())){
			differences++;
		}
		
		return differences;
	}
}
