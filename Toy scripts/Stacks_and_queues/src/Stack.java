//Class implementing a Stack
//for a stack the run is last on, first off
import java.util.*;
//Want to use generics so that every element in the 
//stack is of the same type
public class Stack<E> {
	private LinkedList<E> stack = new LinkedList<E>();
	//to add something to the list we 'push' it
	public void push(E o){
		stack.addFirst(o);
	}
	//to remove something from the list we 'pop' is
	public E pop(){
		return stack.poll();
	}
	//If you just want to look at the first element we 'peek'
	public E peek(){
		return stack.peek();
	}
	//Want to check if there are elements
	public boolean hasItem(){
		return !stack.isEmpty();
	}
	//finally a method to pop all elements in the stack
	public void popAll(){
		while(!stack.isEmpty()){
			System.out.println(this.pop());
		}
	}
}
