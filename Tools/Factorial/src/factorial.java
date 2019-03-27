import java.util.*;

public class factorial {

	public static void main(String[] args) {
		// toy program to test recursion
		Boolean run=true;
		Scanner in= new Scanner(System.in);
		
		while(run){
			System.out.println("What number would you like to find the factorial of?");
			int numb = in.nextInt();
			int answer = getFact(numb);
			System.out.println("The value of "+numb+"! is: "+answer);
			
			while(true){
				System.out.println("Do you want to try another? (y/n)");
				String resp=in.next();
				if(resp.equalsIgnoreCase("n")){
					run=false;
					break;
				}
				else if(resp.equalsIgnoreCase("y")){
					break;
				}
				else{
					System.out.println("Huh?");
				}
			}
		}
		in.close();
	}
	
	static public int getFact(int number){
		if(number == 0){
			int ans=1;
			return ans;
		}
		return number*getFact(number-1);
		
	}
}

