package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estevão (2011157312)
 * 
 * Class Object represents subclass of the abstract class Entity,
 * This class represents objects in our environment, e.q. in the interior
 * of buildings there are chairs, tables, waste bins, etc.  
 *
 */
public class Object extends Entity{
	private String type;
	
	public Object(int ID, String color, String shape, int coordX, int coordY, String type) {
		super(ID, color, shape, coordX, coordY);
		this.type = type;
	}
	
	/**
	 * @return the type of the object
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * method used for easier debuging
	 */
	public void debug(){
		System.out.println(ID + " " + color + " " + shape + " " + coordX + " " + coordY + " " + type);
	}

}
