//Toy program to automatically connect and access the BARTserver
//remember that the server must be running when this program runs!
import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
	//set port to known value
	static int port = 4321;
	
	public static void main(String[] args) {
		//First connect to server
		Socket s= new Socket();
		s=getServer();
		try{
			String quote;
			Scanner in = new Scanner(s.getInputStream());
			PrintStream out=new PrintStream(s.getOutputStream());
			//now need to interact with the server
			//first clear the scanner from the server's prompt
			in.nextLine();
			//tell server you want a quote
			out.println("y");
			//get the quote
			quote=in.nextLine();
			for(int i=0; i<10;i++){
				System.out.println(quote);
			}
			in.nextLine();
			out.println("n");
			in.close();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	//Want a method to connect the client to the server
	private static Socket getServer(){
		//ask for the server name (normally localhost)
		System.out.println("Please enter the host name");
		Scanner sc=new Scanner(System.in);
		Socket s =new Socket();
		while(true){
			try{
				InetAddress host=InetAddress.getByName(sc.nextLine());
				s.connect(new InetSocketAddress(host,port));
				return s;
			}catch(UnknownHostException e){
				System.out.println("Host does not exist");
			}catch(IOException e){
				System.out.println("Could not connect to host");
			}
		}
	}
}
