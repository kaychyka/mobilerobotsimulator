package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estevão (2011157312)
 * 
 * Entity is abstract class and super class of Agent and Object.
 * This class contains a unique identifier, a color, a geometric shape 
 * (for the sake of simplicity, only the well known geometric forms such as 
 * triangular, pentagonal, etc., are assumed), and a pair (x,y) of coordinates 
 * in the matricial environment.
 *
 */
public abstract class Entity {

	protected int ID;
	protected String color;
	protected String shape;
	protected int coordX;
	protected int coordY;

	public Entity(int ID, String color, String shape, int coordX, int coordY){
		this.ID = ID;
		this.color = color;
		this.shape = shape;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	/**
	 * @return entity's ID
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * @return entity's color
	 */
	public String getColor(){
		return color;
	}
	
	/**
	 * @return entity's shape
	 */
	public String getShape(){
		return shape;
	}
	
	/**
	 * @return entity's coordinate X
	 */
	public int getCoordX(){
		return coordX;
	}
	
	/** 
	 * @return entity's coordinate Y
	 */
	public int getCoordY(){
		return coordY;
	}

	/**
	 * method used for easier debuging
	 */
	public abstract void debug();
	
}
