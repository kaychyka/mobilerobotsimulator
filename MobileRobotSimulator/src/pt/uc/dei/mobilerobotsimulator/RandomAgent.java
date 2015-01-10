package pt.uc.dei.mobilerobotsimulator;

import java.util.Random;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 *
 * RandomAgent uses random strategy: 
 * the next object to be visited is chosen randomly from the list of
 * objects in the visual field.
 * 
 */
public class RandomAgent extends Agent {

	public RandomAgent(Environment environment, int ID, String color, String shape, int coordX,
			int coordY, int sight) {
		super(environment, ID, color, shape, coordX, coordY, sight);
	}

	/**
	 * Choose and go to one random object inside visible field
	 */
	@Override
	public void choice() {
		Random rnd = new Random();
		if (visibleObjects.size() > 0) {
			int index = rnd.nextInt(visibleObjects.size());
			Object selectedObject = visibleObjects.get(index);
        
			//add object to memory
			objectMemory.add(selectedObject);
        
			//increase the number of all visited objects
			numOfObjects++;
        
			//check if agent already visited this object
			//and in case it didn't increase the numOfDiffObjects
			if(differentObject(selectedObject))
				numOfDiffObjects++;
        
			moveToCoordinates(selectedObject.getCoordX(), selectedObject.getCoordY());
		}
		else {
			moveToRandomCoordinates();
		}
		
	}

}
