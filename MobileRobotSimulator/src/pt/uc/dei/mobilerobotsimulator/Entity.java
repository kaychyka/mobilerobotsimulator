package pt.uc.dei.mobilerobotsimulator;

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
	
	public int getID(){
		return ID;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getShape(){
		return shape;
	}
	
	public int getCoordX(){
		return coordX;
	}
	
	public int getCoordY(){
		return coordY;
	}
	
}
