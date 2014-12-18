package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 * 
 * ClosestAgent uses strategy of the closest object: 
 * the next object to be visited is the one in the visual field that is 
 * geographically closer to the agent.
 *
 */
public class ClosestAgent extends Agent{

	public ClosestAgent(Environment environment, int ID, String color, String shape, int coordX, int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY, sight);
		
	}

	/**
	 * Choose and go to the closest object 
	 * inside visible field of the agent
	 */
	@Override
	public void choice() {
		//search for all Objects in visual field
		search();
		
		//current the smallest distance between agent 
		//and object inside of its visible field
		double smallestDist = -1;
		Object closestObject = null;
		for (Object object : objectMemory) {
			double tmpDist = Math.sqrt(Math.pow((object.getCoordX() - this.coordX), 2) 
					+ Math.pow((object.getCoordY() - this.coordY),2));
			if(tmpDist<smallestDist){
				smallestDist=tmpDist;
				closestObject = object;
			}
		}
		
		//increase the number of all visited objects
        numOfObjects++;
        
        //check if agent already visited this object
        //and in case it didn't increase the numOfDiffObjects
        if(differentObject(closestObject))
        	numOfDiffObjects++;        
        
		moveToCoordinates(closestObject.getCoordX(), closestObject.getCoordY());
	}
}
