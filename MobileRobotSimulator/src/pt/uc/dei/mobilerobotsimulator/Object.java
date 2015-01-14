package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * 
 * Class Object represents subclass of the abstract class Entity,
 * This class represents objects in our environment, e.q. in the interior
 * of buildings there are chairs, tables, waste bins, etc.  
 *
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 * 
 */
public class Object extends Entity{
	private String type;
	
	/**
	 * Object creator
	 * 
	 * @param environment environment where all entities are placed
	 * @param ID  ID number of the object
	 * @param color  color of the object
	 * @param shape  shape of the object
	 * @param coordX  coordinate X of object's location
	 * @param coordY  coordinate Y of object's location
	 * @param type  type of the object
	 */
	public Object(Environment environment, int ID, String color, String shape, int coordX, int coordY, String type) {
		super(environment, ID, color, shape, coordX, coordY);
		this.type = type;
	}
	
	/**
	 * @return the type of the object
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @return string with all object's data
	 */
	@Override
	public String toString() {
		return "Object: ID: "+ID + ", color: " + color + ", shape: " + shape + ", X: " + coordX + ", Y: " + coordY + ", type: " + type+"\n";
	}

}
