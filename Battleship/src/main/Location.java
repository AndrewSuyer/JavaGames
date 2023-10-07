package main;

import java.util.Random;

public class Location {
	
		// instance variables:
	private char row;			// A - J
	private int col;			// 0 - 9 
	private String location;
	
	static Random random = new Random();
	
		// sets location with input being char and int
	public Location(char row, int col) {
		this.row = row;
		this.col = col;
		this.location = row + "" + col;
	}
	
		// sets location with input being int and int
	public Location(int row, int col) {
		this.row = (char) (row + 65);
		this.col = col;
		this.location = (char) (row + 65) + "" + col;
	}
	
		// sets location with input being String
	public Location(String location) {
		this.location = location;
		this.row = location.charAt(0);
		this.col = (int) location.charAt(1) - 48;	// <------- fix what happens when 10 is the col (cant take 2 things)	
	}
	
		// returns a semi random location, one that is far enought away from a borders of the grid:
	public static Location getRandomLocation(int distFromBorder) {
		int row = random.nextInt(11 - distFromBorder) + distFromBorder/2;
		int col = random.nextInt(11 - distFromBorder) + distFromBorder/2;
		return new Location(row, col);
	}
	
	public void setLocation(char row, int col) {
		this.location = row + "" + col;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public char getRowChar() {
		return this.row;
	}
	
	public int getRowInt() {
		return (int) (this.row - 65);
	}
	
	public int getCol() {
		return this.col;
	}

}
