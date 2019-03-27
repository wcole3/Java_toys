package Equip;

public class Tunic extends Chestpiece{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private String name;
	private String color;
	public String getColor(){return color;}
	public String getName(){return name;}
	public void getInfo(){
		System.out.println(this.getHealth());
		System.out.println(this.getRare());
		System.out.println(this.getColor());
		System.out.println(this.getName());
	}
	public Tunic(int nHealth, String nRare, String nColor, String nName){
		super(nHealth, nRare);
		color=nColor;
		name=nName;
	}
	public Tunic(int nHealth, String nRare, String nName){
		super(nHealth, nRare);
		name=nName;
		color="Black";
	}
	public Tunic(int nHealth, String nRare){
		super(nHealth,nRare);
		name="Common Tunic";
		color="Black";
	}
	
	
}
