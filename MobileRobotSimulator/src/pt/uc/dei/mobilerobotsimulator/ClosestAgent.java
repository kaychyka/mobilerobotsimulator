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

	/**
	 * Closest agent's creator
	 * 
	 * @param environment - environment where all entities are placed
	 * @param ID - ID number of the agent
	 * @param color - color of the agent
	 * @param shape - shape of the agent
	 * @param coordX - coordinate X of first agent's location
	 * @param coordY - coordinate Y of first agent's location
	 * @param sight - radius sight of the agent
	 */
	public ClosestAgent(Environment environment, int ID, String color, String shape, int coordX, int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY, sight);	
	}

	/**
	 * Choose and go to the closest object 
	 * inside visible field of the agent
	 */
	@Override
	public void choice() {
		//current the smallest distance between agent 
		//and object inside of its visible field
		double smallestDist = -1;
		Object closestObject = null;
		if (visibleObjects.size() > 0) {
			closestObject = visibleObjects.get(0);
			for (Object object : visibleObjects) {
				double tmpDist = Math.sqrt(Math.pow((object.getCoordX() - this.coordX), 2) 
						+ Math.pow((object.getCoordY() - this.coordY),2));
				if(tmpDist<smallestDist){
					smallestDist=tmpDist;
					closestObject = object;
				}
			}
			
			//add object to memory
			visitedObjectsMemory.add(closestObject);
			
			moveToCoordinates(closestObject.getCoordX(), closestObject.getCoordY());
		} else {
			moveToRandomCoordinates();
		}
	}
}
