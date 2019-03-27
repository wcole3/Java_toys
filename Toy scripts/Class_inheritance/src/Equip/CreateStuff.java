package Equip;

public class CreateStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tunic t= new Tunic(10, "Rare", "green", "Mighty Robe");
		System.out.println("The tunic is called '"+t.getName()+"'");
		System.out.println("The tunic has health "+t.getHealth());
		System.out.println("The tunic is a "+t.getRare());
		System.out.println("The tunic is " +t.getColor());
		System.out.println("Where is the tunic worn?");
		t.whereWorn();
		System.out.println("Is the tunic worn right now?\n" +t.isWorn());
		if(!t.isWorn()){t.putOn();}
		System.out.println("Is the tunic worn right now?\n" +t.isWorn());
		System.out.println("Is the tunic broken? "+t.isBroken(t.getHealth()));
		System.out.println("The tunic has health "+t.getHealth());
		t.setHealth(t.takeHit(t.getHealth(), 5));
		System.out.println("Is the tunic broken? "+t.isBroken(t.getHealth()));
		System.out.println("The tunic has health "+t.getHealth());
		t.setHealth(t.takeHit(t.getHealth(), 5));
		System.out.println("Is the tunic broken? "+t.isBroken(t.getHealth()));
		System.out.println("The tunic has health "+t.getHealth());
		Tunic w=new Tunic(30,"Uncommon", "Super Tunic");
		w.getInfo();
		Tunic x=new Tunic(25, "Common");
		x.getInfo();
		//The follwoing is an example of using a lambda expression
		//We have to provide one implementation of the abstract method getHealth
		hat h = ()->{System.out.println("Hello");};
		h.getHealth();
		//We can also use any default methods
		h.test();
		
	}

}
