//toy program using streams to play with list output
import java.util.*;
public class TestStream {

	public static void main(String[] args) {
		//First create a list of spells
		LinkedList<Spell> spellBook= new LinkedList<Spell>();
		//Lets learn some spells
		spellBook.add(new Spell("Fireball",Spell.SpellType.fire, 10));
		spellBook.add(new Spell("Ice Spike", Spell.SpellType.ice,7));
		spellBook.add(new Spell("Shock",Spell.SpellType.air,5));
		spellBook.add(new Spell("Rock Wall",Spell.SpellType.earth,0));
		//now use stream to do things
		spellBook.stream().forEach(s->System.out.println(s));
		//can use a parallel stream to show randomness
		spellBook.parallelStream().forEach(s->System.out.println(s));
		spellBook.parallelStream().forEachOrdered(s->System.out.println(s));
	}
	//Just a toy class to feed into list
	static class Spell{
		String name;
		public enum SpellType {fire, ice, air, earth}
		SpellType sType;
		int power;
		Spell(String sName, SpellType sType, int sPower){
			this.name=sName; this.sType=sType;this.power=sPower; 
		}
		public String toString(){
			return this.name;
		}
	}
}
