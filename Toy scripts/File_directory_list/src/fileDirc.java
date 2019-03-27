import java.io.*;
import java.util.Scanner;

public class fileDirc {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to file direcotry lister");
		do{
			System.out.println("Please enter a file path");
			String path = in.nextLine();
			//create a file object from path
			File dir = new File(path);
			//make sure it is a directory and it exists
			if(!dir.isDirectory() || !dir.exists()){
				System.out.println("Sorry, that directory is not valid");
			}
			else{
				//list the directory tree
				System.out.println("The directory tree for "+dir.getPath()+" is: ");
				listDir(dir, " ");
			}
			
		}while(askAgain());
		

	}
	static void listDir(File dir, String indent){
		File[] files=dir.listFiles();
		for(File f : files){
			//for each valid directory print out its name
			if(f.isDirectory()){
				System.out.println(indent+f.getName());
				listDir(f,indent+" ");
			}
			
		}
	}
	public static boolean askAgain(){
		while(true){
			System.out.println("Would you like to enter another location? (y/n)");
			String ans = in.nextLine();
			if(ans.equalsIgnoreCase("y")){
				return true;
			}
			else if(ans.equalsIgnoreCase("n")){
				return false;
			}
			else{
				System.out.println("What?");
			}
			
		}
	}	
}
