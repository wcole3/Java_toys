//Guessing game toy program
//Guess a number between 1 and 10

import java.util.Scanner;

public class GuessingGame {
	static boolean playGame = true;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//now we want to play the game
		System.out.println("Hello to the Guessing Game (TM)");
		do{
			int guess =0;
			System.out.print("Please guess a number between 1 and 10\n");
			while(sc.hasNext()){
				if(!sc.hasNextInt())
				{
					sc.nextLine();
					System.out.println("Try Again\nPlease enter a number\n");
					continue;
				}
				else{
					guess=sc.nextInt();
					sc.nextLine();
				}
				if(guess <=0 || guess>10)
				{
					System.out.println("Try again\nPlease enter a positive number less than 10\n");
					continue;
				}
				else{break;}
			}
			//if it makes it through that we play
			//Choose random and cast to int
			int actual = (int)(Math.random()*10)+1;
			if(actual!=guess)
			{
				System.out.println("Sorry you guessed "+guess+", "
						+ "the answer was "+actual+"\n");
			}
			else
			{
				System.out.println("You guessed correct! The number was "
						+actual+"\n");
			}
			System.out.println("Would you like to play again? (Y/N)\n");
			String playAgain = sc.nextLine();
			if(playAgain.equalsIgnoreCase("n"))
			{
				playGame=false;
			}
			else{continue;}
		}while(playGame);
		System.out.println("Thanks for playing, sucker :P");
	}

}
