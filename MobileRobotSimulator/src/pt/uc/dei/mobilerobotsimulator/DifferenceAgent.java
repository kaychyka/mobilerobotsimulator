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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void choice() {
		// TODO Auto-generated method stub

	}

}
