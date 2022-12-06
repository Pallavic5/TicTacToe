package com.bridgelabz.tictactoe;
import java.util.Random;
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
	static int locationForPlayGame;
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
	}
	/*
	 * UC-3 Player would like to see the board so player can choose the valid cells
	 * to make move during turn. create method showBoard to display the current
	 * Board.
	 */
	public static void showBoard() {
		System.out.println();
		System.out.println("Display the Current Board to player for make move during turn.\n");
		System.out.println(boardArray[1] + " | " + boardArray[2] + " | " + boardArray[3]);
		System.out.println("----------");
		System.out.println(boardArray[4] + " | " + boardArray[5] + " | " + boardArray[6]);
		System.out.println("----------");
		System.out.println(boardArray[7] + " | " + boardArray[8] + " | " + boardArray[9]);
	}
	/*
	 * UC-4 Ability for user to make a move to a desired location in the board
	 */
	public static void playerMakeMove() {
		//Select the index from 1 to 9 to make the move.
		System.out.println("\nWhere would you like to play? (1 - 9)");
		locationForPlayGame = scanner.nextInt();
		if (locationForPlayGame < 10 && locationForPlayGame > 0) {
			boardArray[locationForPlayGame] = player;
			showBoard();
			checkFreeSpace();
			playerMakeMove();
		} else {
			System.out.println("Invalid Location.");
		}
	}
	/*
	 * UC - 5 Check for the free space before making the desired move
	 * Extend UC-5 to check if the free space is available for the move
	 * In case available make the move.
	 */
	public static void checkFreeSpace() {
		//initialize variables
		int numberOfFreeSpaces = 0;
		boolean isSpaceAvailable = false;
		//traversing the board using for loop
		for(int i = 1; i < boardArray.length; i++) {
			//condition for check free space available or not in board.
			if((boardArray[i] == ' ')) {
				isSpaceAvailable = true;
				//increement
				numberOfFreeSpaces++;	
			}
		}
		if(isSpaceAvailable == false) {
			System.out.println("Board is full.");
			System.exit(0);
		}else {
			System.out.println("Free space is available. You have " + numberOfFreeSpaces + "moves left");
		}
	}
	/*
	 * UC-6 Check who plays first
	 * Use Random to determine Heads or Tails and assign accordingly who starts first,
	 * the computer or the user.
	 */
	public static void checkWhoPlayFirst() {
		int toss = (int) Math.floor(Math.random() + 1.5);	//It gives random value between 1 to 2
		System.out.println("Random Number: " + toss);
		System.out.println("\nSelect coin 1 for Heads and 2 for Tails");
		int coinSelect = scanner.nextInt();
		if(coinSelect == toss) {
			System.out.println("Player won the toss. Player plays first.\n");
		}else {
			System.out.println("Computer won the toss. Computer plays first.\n");
		}
	}
	/*
	 * UC-7 Player would expect the Tic Tac Toe App to determine after every
	 * move the winner or the tie or change the turn
	 */
	public static void winner() {
		//Here check all the side of board.
		if((boardArray[1] == player && boardArray[2] == player && boardArray[3] == player 
				|| boardArray[4] == player && boardArray[5] == player && boardArray[6] == player 
				|| boardArray[7] == player && boardArray[8] == player && boardArray[9] == player 
				|| boardArray[1] == player && boardArray[5] == player && boardArray[9] == player 
				|| boardArray[3] == player && boardArray[5] == player && boardArray[7] == player 
				|| boardArray[1] == player && boardArray[4] == player && boardArray[7] == player 
				|| boardArray[2] == player && boardArray[5] == player && boardArray[8] == player 
				|| boardArray[3] == player && boardArray[6] == player && boardArray[9] == player )) {
			showBoard();
			System.out.println("Player won the game.");
			System.exit(0);
		}
	}
	/*
	 * UC - 8 Computer getting its turn would like the computer to play like me.
	 */
	public static void computerTurn() {
		int computerMove;
		//infinite loop
		while(true) {
			computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
			if(boardArray[computerMove] == ' ') {
				break;
			}
		}
		System.out.println("Computer select: " + computerMove);
		boardArray[computerMove] = computer;
	}
	// Main method
	public static void main(String[] args) {
		System.out.println("Welcome To TicTacToe Game Program.\n");
		// calling methods
		checkWhoPlayFirst();
		printBoard();
		chooseLetter();
		//infinite loop
		while(true) {
			playerMakeMove();
			computerTurn();
			showBoard();
			checkFreeSpace();
			winner();
		}	
	}
}
