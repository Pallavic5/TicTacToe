package com.bridgelabz.tictactoe;

/*
 * TicTacToe Player challenge computer.
 */
import java.util.Scanner;

/*
 * Create a TicTacToe Game Class
 * Create method for every use case and call that method from main method. 
 */
public class TicTacToeGame {
	// initialize char type array of size 10 to create a empty board.
	static char[] boardArray = new char[10];
	static char player, computer;
	static Scanner scanner = new Scanner(System.in);

	/*
	 * UC - 1 As a player would like to start fresh by creating a tictactoe board.
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

	/*
	 * UC - 2 Ability to allow the player to choose a letter X or O Create a method
	 * to allow player to input X or O and call from main
	 * 
	 */
	public static void chooseLetter() {
		System.out.println("\nEnter Your Choice 'X' or 'Y' : ");
		char choice = scanner.next().charAt(0); // enter character
		// condition for determine player and computer letter to play the game.
		if (choice == 'X') {
			player = 'X';
			System.out.println("Player choose 'X' ");
			computer = 'O';
			System.out.println("Computer choose 'O' ");
		} else if (choice == 'Y') {
			player = 'O';
			System.out.println("Player choose 'O' ");
			computer = 'X';
			System.out.println("Computer choose 'X' ");
		} else {
			System.out.println("Invalid Choice...");
		}
		scanner.close();
	}
	/*
	 * UC-3 Player would like to see the board so player can choose the valid cells
	 * to make move during turn. create method showBoard to display the current
	 * Board.
	 */
	public static void showBoard() {
		System.out.println();
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
		chooseLetter();
		showBoard();
	}
}
