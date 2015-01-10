package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Pi�kur (2014190802) and Pedro de Oliveira Est�v�o (2011157312)
 * 
 * This agent uses strategy of the maximum difference to the objects stored in memory: 
 * this strategy allows the agent to select as the next point of view the object 
 * that is more different to the objects in memory. The algorithm involves the 
 * comparison of each object in the visual field with each object in memory. 
 *
 */
public class DifferenceAgent extends Agent {

	public DifferenceAgent(Environment environment, int ID, String color, String shape, int coordX,
			int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY, sight);
	}

	@Override
	public void choice() {
		if (visibleObjects.size() > 0) {
			Object mostDifferent = visibleObjects.get(0);
			int diffs = -1;
			for (Object visualObject : visibleObjects) {
				for (Object object : objectMemory) {
					int currentDiffs = compareObjects(visualObject, object);
					if(currentDiffs > diffs){
						mostDifferent = visualObject;
						diffs = currentDiffs;
					}
				}
			}
						
			//add object to memory
			objectMemory.add(mostDifferent);
			
			//increase the number of all visited objects
	        numOfObjects++;
	        
	        //check if agent already visited this object
	        //and in case it didn't increase the numOfDiffObjects
	        if(differentObject(mostDifferent))
	        	numOfDiffObjects++;        
	        
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
