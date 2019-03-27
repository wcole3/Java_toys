//Toy program to omplement a server program that can be queried from terminal
//user "telnet localhost port##" to talk to program
//The program output here will tell us who is connect and what they are doing

import java.util.*;
import java.io.*;
import java.net.*;

public class BARTserver {

	public static void main(String[] args) {
		// First establish a port number and get a BARTquote object
		int port=4321;
		BARTquote q=new BARTquote();
		try{
			//create a server socket to connect to the outside
			ServerSocket ss =new ServerSocket(port);
			//connect to the server
			Socket s= new Socket();
			//connect socket to server
			s=ss.accept();
			//Print statement to tell if we are connected
			System.out.println("Connected to "+s.getInetAddress().toString());
			
			
			//get input/output streams for client
			Scanner in =new Scanner(s.getInputStream());
			PrintStream out=new PrintStream(s.getOutputStream());
			while(true){
				out.println("Would you like a funny quote? (Y/N)");
				String response=in.nextLine();
				if(response.equalsIgnoreCase("n")){
					System.out.println("Disconnected from "+s.getInetAddress().toString());
					s.close();
					in.close();
					break;
				}
				else if(response.equalsIgnoreCase("y")){
					System.out.println("Serving "+s.getInetAddress().toString());
					out.println(q.getQuote());
				}
				else{
					out.println("Huh?");
				}
				
			}
			ss.close();
			System.out.println("Have a nice day!");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
