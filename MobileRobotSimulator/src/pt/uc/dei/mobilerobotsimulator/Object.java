package pt.uc.dei.mobilerobotsimulator;

public class Object extends Entity{
	private String type;
	
	public Object(int ID, String color, String shape, int coordX, int coordY, String type) {
		super(ID, color, shape, coordX, coordY);
		this.type = type;
	}
	

	public String getType() {
		return type;
	}


}
