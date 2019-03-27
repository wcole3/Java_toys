//This is a toy program to show given your choice of chess piece
//what the legal moves on a chess board are, given a starting
//position

//For reference the labels on a chess board are 
//  1 2 3 4 5 6 7 8
//h - - - - - - - -
//g - - - - - - - -
//f - - - - - - - -
//e - - - - - - - -
//d - - - - - - - -
//c - - - - - - - -
//b - - - - - - - -
//a - - - - - - - -

import java.util.*;

public class Chess_moves {

	public static void main(String[] args) {
		// First give the user some info
		System.out.println("Welcome to the Chess Move program");
		System.out.println("This program will tell you where a piece on a chess board can move.\n");
		Scanner s=new Scanner(System.in);
		int[][] legalMoves=getPieceName(s);
		Pos pieceLoc=getPieceLoc(s);
		printBoard(pieceLoc, getLegalArray(pieceLoc,legalMoves));
		s.close();
		
	}
	//Need a method that queries a response from the user
	static public int[][] getPieceName(Scanner s){
		System.out.println("What piece do you have?\n");
		while(true){
			int[][] legalMoves= getLegalMoves(s.nextLine());
			if(1<legalMoves.length){
				return legalMoves;
			}
			else{
				System.out.println("Please enter a valid chess piece...");
			}
		}
	}
	//Likewise I want a function that queries the user for a board position
	static public Pos getPieceLoc(Scanner s){
		System.out.println("Where on the board is your piece (i.e. 'a3')?\n");
		while(true){
			Pos pieceLoc = charToPos(s.nextLine());
			if(pieceLoc.x<0||pieceLoc.x>7||pieceLoc.y<0||pieceLoc.y>7){
				System.out.println("Please enter a location on the board...");
			}
			else{return pieceLoc;}
		}
	}
	
	//need a method that returns an array of the legal moves for a given chess piece
	static public int[][] getLegalMoves(String piece){
	
		if(piece.equalsIgnoreCase("pawn")){
			int[][] legal = {{0,1},{0,-1}};
			return legal;
		}
		if(piece.equalsIgnoreCase("rook")){
			int[][] legal =new int[32][2];
			//first do vertical moves
			for(int i=1; i<9;i++){
				int j=(i-1)*4;
				legal[j][0]=0;
				legal[j][1]=i;
				legal[j+1][0]=0;
				legal[j+1][1]=-i;
				legal[j+2][0]=i;
				legal[j+2][1]=0;
				legal[j+3][0]=-i;
				legal[j+3][1]=0;
			}
			return legal;
		}
		if(piece.equalsIgnoreCase("knight")){
			int[][] legal = {{2,1},
					         {2,-1},
					         {-2,1},
					         {-2,-1},
					         {1,2},
					         {1,-2},
					         {-1,2},
					         {-1,-2}};
			return legal;
		}
		
		if(piece.equalsIgnoreCase("bishop")){
			int[][] legal=new int[32][2];
			for(int i=1; i<9;i++){
				int j=(i-1)*4;
				legal[j][0]=i;
				legal[j][1]=i;
				legal[j+1][0]=-i;
				legal[j+1][1]=i;
				legal[j+2][0]=i;
				legal[j+2][1]=-i;
				legal[j+3][0]=-i;
				legal[j+3][1]=-i;
			}
			return legal;
		}
		//I know there is an error here but I am going to wait until I have a graphical 
		//output for debugging: 07/10
		if(piece.equalsIgnoreCase("queen")){
			int[][] legal=new int[64][2];
			int k=0;
			for(int i=1;i<9;i++){
				//First horizontal
				legal[k][0]=i; legal[k][1]=0; k++;
				legal[k][0]=-i; legal[k][1]=0; k++;
				//then vertical
				legal[k][0]=0; legal[k][1]=i; k++;
				legal[k][0]=0; legal[k][1]=-i; k++;
				//now diagonal
				legal[k][0]=i; legal[k][1]=i; k++;
				legal[k][0]=-i; legal[k][1]=i; k++;
				legal[k][0]=i; legal[k][1]=-i; k++;
				legal[k][0]=-i; legal[k][1]=-i; k++;
			}
			//now horizontal moves
			
			return legal;
		}
		if(piece.equalsIgnoreCase("king")){
			int[][] legal ={{1,0},{-1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,-1}};
			return legal;
		}
		else{
			int[][] legal={{0,0}};
			return legal;
		}
			
	}
	//Now want a method to take a string board position and convert to 
	//a Pos variable
	static public Pos charToPos(String input){
		int x=-1;
		int y=-1;
		if(input.charAt(0)=='a'){y=7;}
		if(input.charAt(0)=='b'){y=6;}
		if(input.charAt(0)=='c'){y=5;}
		if(input.charAt(0)=='d'){y=4;}
		if(input.charAt(0)=='e'){y=3;}
		if(input.charAt(0)=='f'){y=2;}
		if(input.charAt(0)=='g'){y=1;}
		if(input.charAt(0)=='h'){y=0;}
		x=Character.getNumericValue(input.charAt(1))-1;
		Pos output=new Chess_moves.Pos(x,y);
		return output;
	}
	//Want a method that takes the piece's location and the legal moves
	//and returns a Pos array of the board locations the piece can move
	static public int[][] getLegalArray(Pos piece, int[][] legal){
		int[][] output = new int[legal.length][legal[0].length];
		for(int i=0; i<legal.length;i++){
			output[i][0]=piece.x+legal[i][0];
			output[i][1]=piece.y+legal[i][1];
		}
		return output;
	}
	
	
	//Now there needs to be a method to print out the board 
	//given the piece's position and its legal moves
	static public void printBoard(Pos piece, int[][] legal){
		String[][] board= new String[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				for(int[] x:legal){
					if(x[0]==j && x[1]==i){
						board[i][j]="O";
						break;
					}
					if(piece.x==j && piece.y==i){
						board[i][j]="X";
					}
					else{board[i][j]="-";}
				}
			}
		}
		//This for loop output the graphical chess board
		for(String[] s : board){
			for(String b:s){
				System.out.print(b+' ');
			}
			System.out.print('\n');
		}
		System.out.println("The piece is represented by an 'X'");
		System.out.println("The location available for movement are shown as an 'O'");
	}
	
	//first want a inner class to define a pieces position on the board
	static public class Pos {
		int x;
		int y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
