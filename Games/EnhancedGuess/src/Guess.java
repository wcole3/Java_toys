//Improved version of the Guessing game
//You may specify the range to guess between

import java.util.*;

public class Guess {
	static boolean playGame = true;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//First need to get the range
		int min = getRange("low");
		int max = getRange("high");
		//Once that is done start playing
		playGuess(min, max);

	}
	//Want a function to get a random number
	static int getRandom(int min, int max){
		return (int)(Math.random()*(max-min))+min;
	}
	//Want a function that queries a user entered value
	static int getGuess(int min, int max){
		System.out.println("PLease enter a value between "
				+ min+" and "+max);
		while(true){
			int guess = 0;
			
			if(!sc.hasNextInt()){
				System.out.println("Please enter a number");
				sc.nextLine();
				continue;
				
			}
			else{guess=sc.nextInt();}
			if(guess < min || guess > max){
				System.out.println("Please enter a value from "
						+ min +" to "+max);
				sc.nextLine();
				continue;
			}
			else{
				sc.nextLine();
				return guess;
			}
		}
	}
	//Now we want something to query whether to play the game
	static boolean playAgain(){
		System.out.println("Do you want to play again? (Y/N)");
		while(true){
			String entry=sc.nextLine();
			if(entry.equalsIgnoreCase("N")){
				return false;
			}
			if(entry.equalsIgnoreCase("Y")){
				return true;
			}
			else{
				System.out.println("Sorry I didn't understand that");
				continue;
			}
		}
	}
	//Now the script that will run a round
	static void playGuess(int min, int max){
		while(playGame){
			int actual = getRandom(min, max);
			System.out.println("I am thinking of a number between "
					+min+" and "+max);
			System.out.println("What do you think it is?");
			int guess = getGuess(min,max);
			if(guess==actual){
				System.out.println("You guessed correctly! It was "
						+guess);
			}
			else{
				System.out.println("Sorry the correct answer was "
						+ actual);
			}
			playGame=playAgain();
		}
	}
	//One more function to just get a number from user
	static int getRange(String pop){
		int number =0;
		System.out.println("Please enter a value for the "
				+ pop +" range limit");
		while(true){
			if(!sc.hasNextInt()){
				System.out.println("Please enter a number");
				sc.nextLine();
				continue;
			}
			else{
				number=sc.nextInt();
				sc.nextLine();
				return number;
			}
		}
	}
}
