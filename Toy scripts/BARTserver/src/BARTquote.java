//Class that contains and returns a random funny quote
import java.util.*;
public class BARTquote {
	//First need a array to contain the quotes
	ArrayList<String> q=new ArrayList();
	public BARTquote(){
		//Only populate the array if we need the class
		q.add("I will not waste chalk");
		q.add("I will not skateboard in the halls");
		q.add("I will not burp in class");
		q.add("I will not instigate a revolt");
		q.add("It's potato, not potatoe");
		q.add("I will not encourage others to fly");
		q.add("I will not fake seizures");
		q.add("I am not a dentist");
		q.add("I will not sell land in Florida");
		q.add("I will not aim for the head");
	}
	public String getQuote(){
		int rand=(int)(Math.random()*q.size());
		return q.get(rand);
	}
	
}
