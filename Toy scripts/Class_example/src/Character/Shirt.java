package Character;

public class Shirt {
	private static String bodyLocation = "Torso";
	private String color;
	private int size;
	public static String getBodyLoc(){return bodyLocation;}
	public String getColor(){return color;}
	public int getSize(){return size;}
	
	Shirt(){
		color = "See-through";
		size = 0;
	}
	Shirt(String nColor){
		this();
		color=nColor;
	}
	Shirt(String nColor, int nSize){
		this(nColor);
		size=nSize;
	}

}
