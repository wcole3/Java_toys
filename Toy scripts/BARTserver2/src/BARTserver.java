//This will be a server program similar to BART server 1.0 but this 
//one can run multiple instances and handle multiple connections

import java.util.*;
import java.net.*;
import java.io.*;

public class BARTserver {
	//defined connection port
	static int port=4321;
	
	public static void main(String[] args) {
		// use threads to run the server
		System.out.println("Welcome to BART server 2.0");
		System.out.println("Please connect to port 4321");
		//inside the while loop we will create threads
		try{
			ServerSocket ss=new ServerSocket(port);
			while(true){
				
				Socket s=new Socket();
				s=ss.accept();
				Thread t=new Thread(new ClientConn(s));
				t.start();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//want a custom class to set up a connection to a client
	//must implement runnable
	static public class ClientConn implements Runnable{
		Socket s;
		ClientConn(Socket s){
			this.s=s;
		}
		public void run(){
			try{
				Scanner in= new Scanner(s.getInputStream());
				PrintStream out=new PrintStream(s.getOutputStream());
				System.out.println("Connected to "+s.getLocalAddress().toString());
				while(true){
					out.println("Would you like a quote? (y/n)");
					String resp=in.nextLine();
					if(resp.equalsIgnoreCase("y")){
						System.out.println("Serving "+s.getLocalAddress().toString());
						BARTquote q=new BARTquote();
						out.println(q.getQuote());
					}
					else if(resp.equalsIgnoreCase("n")){
						System.out.println("Disconnected from "+s.getLocalAddress().toString());
						s.close(); in.close(); out.close();
						break;
					}
					else{
						out.println("Huh?");
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
