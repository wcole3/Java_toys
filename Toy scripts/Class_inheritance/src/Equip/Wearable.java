package Equip;

public interface Wearable {
	//want a interface for anything that would be wearable in a game
	boolean isWorn();
	int getHealth();
	String getRare();
	void putOn();
	void setHealth(int nHealth);
	void whereWorn();
	default int takeHit(int health, int hit){
		int nHealth;
		nHealth= health-hit;
		return nHealth;
	}
	default boolean isBroken(int health){
		if(health <= 0){return true;}
		else{return false;}
	}
	
}
