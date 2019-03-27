//This will be a toy program to use the String objects and some
//Stringbuilder objects

import java.util.*;

//The goal is to take an input string and remove bad words
//by replacing the vowels in the bad words with asterisk
public class profanity_filter {

	public static void main(String[] args) {
		
		//first get string from user
		Scanner s = new Scanner(System.in);
		System.out.println("Hello, what would you like to tell Will?");
		//the Stringbuilder acts like a string with some more methods
		//Here you get the message from the user
		StringBuilder input= new StringBuilder(s.nextLine());
		//After you have the message, clean it up
		input=findBadWords(input);
		System.out.println("Hey Will, the user has the following message for you:");
		System.out.println(input);
		s.close();
		
	}
	//What are the bad words you are worried about?
	//If you ever need to add words, just put them in here
	static private  String[] nonoWords = {"fuck", "shit", "cunt", "bitch", "cock", "ass","bastard"};
	
	
	//need a method to parse a strong for bad words
	static StringBuilder findBadWords(StringBuilder t){
		String[] words = t.toString().split("\\s+");
		StringBuilder output = new StringBuilder();
		int tag=0;
		for(int i=0; i<words.length; i++){
			for(int j=0; j<nonoWords.length; j++){
				if(words[i].equalsIgnoreCase(nonoWords[j])){
					output.append(replaceVowels(words[i]));
					output.append(' ');
					break;
				}
				else{
					tag++;}
			}
			if(tag==nonoWords.length){
				output.append(words[i]);
				output.append(' ');}
		}
		return output;
	}
	
	//Need a function to  take a word and replace vowels with *
	static String replaceVowels(String t){
		StringBuilder c = new StringBuilder(t);
		for(int i=0; i<t.length();i++){
			char s=t.charAt(i);
			if( (s=='a')||(s=='e')||(s=='i')||(s=='o')||(s=='u')||
				(s=='A')||(s=='E')||(s=='I')||(s=='O')||(s=='U')){
				
				c.setCharAt(i, '*');	
			}
		}
		return c.toString();
	}
}
