package pt.uc.dei.mobilerobotsimulator;

import java.util.Random;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estevão (2011157312)
 *
 * RandomAgent uses random strategy: 
 * the next object to be visited is chosen randomly from the list of
 * objects in the visual field.
 * 
 */
public class RandomAgent extends Agent {

	public RandomAgent(int ID, String color, String shape, int coordX,
			int coordY, int sight) {
		super(ID, color, shape, coordX, coordY, sight);
	}

	/**
	 * Choose and go to one random object inside visible field
	 */
	@Override
	public void choice() {
		search();
		
		Random rnd = new Random();
		int index = rnd.nextInt(visibleObjects.size());
        Object selectedObject = visibleObjects.get(index);
        
        moveToCoordinates(selectedObject.getCoordX(), selectedObject.coordY);
	}

}
