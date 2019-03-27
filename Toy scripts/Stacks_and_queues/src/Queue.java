//An implementation of a queue system where last on, last off
import java.util.*;
//Use generics so every element in the queue is of the 
//same type
public class Queue<E> {
	//again use a LinkedList to represent the queue
	private LinkedList<E> queue = new LinkedList<E>();
	//we add items to the end of the queue
	public void add(E o){
		queue.addLast(o);
	}
	//We take elements form the top of the list
	public E serve(){
		return queue.pollFirst();
	}
	// implement peek to look at top of queue
	public E peek(){
		return queue.peekFirst();
	}
	//check to see if there are any elements in the queue
	public boolean hasItem(){
		return !queue.isEmpty();
	}
	//Likewise we can serve all
	public void serveAll(){
		while(!queue.isEmpty()){
			System.out.println(this.serve());
		}
	}
}
