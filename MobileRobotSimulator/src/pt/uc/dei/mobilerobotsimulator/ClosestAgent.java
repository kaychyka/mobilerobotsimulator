package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estevão (2011157312)
 * 
 * ClosestAgent uses strategy of the closest object: 
 * the next object to be visited is the one in the visual field that is 
 * geographically closer to the agent.
 *
 */
public class ClosestAgent extends Agent{

	public ClosestAgent(int ID, String color, String shape, int coordX, int coordY, int sight) {
		super(ID, color, shape, coordX, coordY, sight);
	}

	/**
	 * Choose and go to the closest object 
	 * inside visible field of the agent
	 */
	@Override
	public void choice() {
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
		
		moveToCoordinates(closestObject.getCoordX(), closestObject.getCoordY());
	}

}
