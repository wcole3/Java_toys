//Toy program to show how to use InetAddress class

import java.net.InetAddress;
import java.util.Scanner;


public class IP_finder {

	public static void main(String[] args) {
		//Use the main loop to query the user for IP to look up
		System.out.println("Welcome to internet lookup"+"\n"+
		"Please enter a domain name to find its IP");
		Scanner sc=new Scanner(System.in);
		boolean done=false;
		while(!done){
			lookUP(sc.nextLine());
			System.out.println("Would you like to look up another?(Yes/No)");
			while(true){
				String hmm=sc.nextLine();
				if(hmm.equalsIgnoreCase("no")){
					done=true;
					break;
				}
				if(hmm.equalsIgnoreCase("yes")){
					System.out.println("Please enter a domain name");
					break;
				}
				else{
					System.out.println("Huh? Do you want to lookup another?(yes/no)");
				}
			}
		}
		System.out.println("Have a nice day!");
	}
	private static void lookUP(String name){
		try{
			InetAddress[] add = InetAddress.getAllByName(name);
			for(InetAddress e: add){
				System.out.println(e.toString());
			}
			
		}catch(Exception e){
			System.out.println("Error on lookup");
		}
		
	}
}
