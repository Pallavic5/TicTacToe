package com.bridgelabz.tictactoe;
/*
 * Create a TicTacToe Game Class
 * Create method for every use case and call that method from main. 
 */
public class TicTacToeGame {
	// initialize char type array of size 10 to create a empty board.
	static char[] boardArray = new char[10];

	/*UC - 1 As a player would like to start fresh by creating a tictactoe board.
	 * Assign empty space to each element. 0th index is ignored to make it user
	 * friendly.
	 */
	public static void printBoard() {
		for (int i = 1; i < boardArray.length; i++) {
			boardArray[i] = ' ';
		}
		System.out.println(boardArray[1] + " | " + boardArray[2] + " | " + boardArray[3]);
		System.out.println("----------");
		System.out.println(boardArray[4] + " | " + boardArray[5] + " | " + boardArray[6]);
		System.out.println("----------");
		System.out.println(boardArray[7] + " | " + boardArray[8] + " | " + boardArray[9]);
	}

	// Main method
	public static void main(String[] args) {
		System.out.println("Welcome To TicTacToe Game Program.\n");
		// calling methods
		printBoard();
	}
}
