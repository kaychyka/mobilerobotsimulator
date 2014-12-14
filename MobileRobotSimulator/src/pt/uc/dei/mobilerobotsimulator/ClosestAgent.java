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

	public ClosestAgent(int ID, String color, String shape, int coordX,
			int coordY, int sight) {
		super(ID, color, shape, coordX, coordY, sight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void choice() {
		// TODO Auto-generated method stub
		
	}

}
