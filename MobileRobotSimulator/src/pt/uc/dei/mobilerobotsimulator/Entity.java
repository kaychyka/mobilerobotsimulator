package pt.uc.dei.mobilerobotsimulator;

/**
 * 
 * @author Karin Piškur (2014190802) and Pedro de Oliveira Estêvão (2011157312)
 * 
 * Entity is abstract class and super class of Agent and Object.
 * This class contains a unique identifier, a color, a geometric shape 
 * (for the sake of simplicity, only the well known geometric forms such as 
 * triangular, pentagonal, etc., are assumed), and a pair (x,y) of coordinates 
 * in the matrix environment.
 *
 */
public abstract class Entity {

	protected int ID;
	protected String color;
	protected String shape;
	protected int coordX;
	protected int coordY;
	protected Environment environment;

	public Entity(Environment environment, int ID, String color, String shape, int coordX, int coordY){
		this.ID = ID;
		this.color = color;
		this.shape = shape;
		this.coordX = coordX;
		this.coordY = coordY;
		this.environment = environment;
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
	
	public void limit(){
		this.coordX = Math.min(this.coordX, environment.getSizeX());
		this.coordY = Math.min(this.coordY, environment.getSizeY());
		this.coordX = Math.max(this.coordX, 0);
		this.coordY = Math.max(this.coordY, 0);
	}
	
}
