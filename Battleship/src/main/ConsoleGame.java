package main;

import java.util.Scanner;

public class ConsoleGame {
	
	// Code for the game to be played in the console goes here
	
	Scanner in = new Scanner(System.in);
	Battleship game;
	
	public ConsoleGame() {
		
		System.out.print("Welcome to battleship! How many guesses would you like? (~30 is recomended): ");
		int numberOfGuesses = in.nextInt();
		
		game = new Battleship();
		
		System.out.println("The ships have set sail! You must guess their location in the form LETTER+number");
		System.out.println("The letters (rows) range from A - J and the numbers range from 0 - 9");
		
			// Game loop - cycles numberOfGuesses times
		for (int i = 0; i < numberOfGuesses; i++) {
				// gets user to input location, checks and prints if location is hit or a miss:
			System.out.print("Enter a location: ");
			System.out.println(game.missileStrike(in.next()));
		}
		
		System.out.println("Well done. You sunk " + game.getNumberOfSinks() + " ships. Your score is " + game.score());
		
		
	}

}
