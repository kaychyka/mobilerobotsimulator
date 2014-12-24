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

	public DifferenceAgent(Environment environment, int ID, String color, String shape, int coordX,
			int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY, sight);
	}

	@Override
	public void choice() {
		if (visibleObjects.size() > 0) {
			Object differentObject = null;
			for (Object object : objectMemory) {
				
			}
			
			//add object to memory
			objectMemory.add(differentObject);
			
			//increase the number of all visited objects
	        numOfObjects++;
	        
	        //check if agent already visited this object
	        //and in case it didn't increase the numOfDiffObjects
	        if(differentObject(differentObject))
	        	numOfDiffObjects++;        
	        
			moveToCoordinates(differentObject.getCoordX(), differentObject.getCoordY());
		} else {
			moveToRandomCoordinates();
		}
	}

	private void compareObjects(Object oldObject, Object newObject){
		
	}
}
