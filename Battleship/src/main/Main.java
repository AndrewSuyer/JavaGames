package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* TODO:
		 * 	Add screen which shows ship locations (debugScreen for debug purposes)
		 * 
		 * Potential Bugs:
		 * 	If user attacks the same location twice, ship will incriment numberOfHits, may give false CurrentState.SUNK
		 * 	All ships are places vertically, add randomness to newSpawnShips()
		 * 	Possible error in ship placing technique, may be overlapping, got 2 hits and 2 sinks 
		 */	
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("How would you like to play this game? 1. Console, 2. GUI: ");
		int choice = in.nextInt();
		if (choice == 1) {
			ConsoleGame consoleGame = new ConsoleGame();
		} if (choice == 2) {
			BattleshipGUI GUIgame = new BattleshipGUI();
		}
		
		
		
	}

}
