package Equip;
/**Class for general chestpieces
 * 
 * @author wcole
 *
 */
abstract class Chestpiece implements Wearable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private int health;
	private String rarity;
	private boolean equipped;
	private static String equipSlot = "Chest";
	
	public int getHealth(){
		return health;
	}
	public void setHealth(int nHealth){
		this.health=nHealth;
	}
	public String getRare(){
		return rarity;
	}
	public boolean isWorn(){
		return equipped;
	}
	public void putOn(){
		this.equipped = true;
	}
	public void whereWorn(){
		System.out.println("This object is worn on the "+equipSlot);
	}
	Chestpiece(){
		health=0;
		rarity="No info";
		equipped=false;
	}
	Chestpiece(int nHealth){
		this();
		health=nHealth;
		rarity="Common";
		equipped=false;
	}
	Chestpiece(int nHealth, String nRare){
		this(nHealth);
		rarity=nRare;
		equipped=false;
	}
	
}
