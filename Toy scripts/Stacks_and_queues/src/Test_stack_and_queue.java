//This is a toy class to test the functionality of our stack and queue
//classes.


public class Test_stack_and_queue {

	public static void main(String[] args) {
		// lets play with the stack first
		System.out.println("Playing with a stack...");
		Stack<Card> q=new Stack<Card>();
		q.push(new Card("Angry Pug", 10,1));
		q.push(new Card("Leash", 5,2));
		q.push(new Card("Scissors",1,1));
		//now peek to check what is on top
		System.out.println(q.peek());
		//now serve once
		System.out.println(q.pop());
		//then serve the rest
		q.popAll();
		
		//now the queue
		System.out.println("Now lets plays with a queue...");
		Queue<Customer> s= new Queue<Customer>();
		s.add(new Customer("Will","Cole"));
		s.add(new Customer("Luke", "Bertels"));
		s.add(new Customer("Michael", "Jacobs"));
		//Check who is first
		System.out.println(s.peek());
		//then serve first
		System.out.println(s.serve());
		//then serve everyone else
		s.serveAll();
		
		
	}
	//Want some custom classes for the stack and queue classes to play with
	static class Card {
		String name;
		int power; int life;
		Card(String name, int power, int life){
			this.name=name; this.power=power;this.life=life;
		}
		public String toString(){
			return this.name;
		}
	}
	//more relevant for the queue
	static class Customer{
		String firstName; String lastName;
		Customer(String fName, String lName){
			this.firstName=fName; this.lastName=lName;
		}
		public String toString(){
			return this.firstName +" "+this.lastName;
		}
	}
}
