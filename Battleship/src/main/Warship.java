package main;

import java.util.ArrayList;
import java.util.Random;

public abstract class Warship {
	
	private int size;					// size of warship
	private Location[] location;		// location of warship (array of locations)
	private CurrentState currentState;
	private int numberOfHits = 0;		// number of hits the warship has
	private static ArrayList<Location> occupiedLocations = new ArrayList<>();	// the locations that are already occupied by a ship
	Random random = new Random();
	
	public Warship(int size) {
		// instantiates the array which will store ship locations
		// also sets current state to floating
		this.size = size;
		this.location = new Location[size];
		setCurrentState(CurrentState.FLOATING);
	}
	
		// [UNUSED] sets a random location for each ship
	public void setLocation() {
			// choosing random location that hasnt already been chosen:
		Location theLocation;
		int row;
		int col;
		do {
			row = random.nextInt(11);
			col = random.nextInt(11);
			theLocation = new Location(row, col);
		} while (!occupiedLocations.contains(theLocation));
			// chooses direction away from nearest wall, 1 = up, 2 = down, 3 = right, 4 = left
			// checks if a ship occupies a location in the direction that the ship wants to go
			// if it does, it re-choses a direction
		int direction;
		boolean containsTheLocation = false;
		do {
			if (row <= 5) {		// close to the top
				if (col <= 5) {		// close to left
					direction = 3;		// right
					containsTheLocation = containsTheLocation(theLocation, this.size, direction);
				} else {
					direction = 2;		// down
					containsTheLocation = containsTheLocation(theLocation, this.size, direction);
				}	
			} else {			// close to the bottom
				if (col >= 5) {		// close to right
					direction = 4;		// left
					containsTheLocation = containsTheLocation(theLocation, this.size, direction);
				} else { 
					direction = 1;		// up
					containsTheLocation = containsTheLocation(theLocation, this.size, direction);
				}
			} 
		} while (containsTheLocation);
	}
	
	public void newSetLocation() {
		/* 1. Choose a semi random location (called theLocation) which is far enought away from the borders of the play area
		 * 2. Check theLocation, as well as the locations size away in all directions against occupiedLocations
		 * 3. Choose which direction to extend towards based on where no other ships are
		 * 4. 	If all directions have a location of another ship, choose a new random location for theLocation
		 * 5. Set all values for location based on chosen direction, also add those locations in occupiedLocations
		 * 
		 * Direction (i): 0 = up, 1 = down, 2 = right, 3 = left
		 */
		Location theLocation = Location.getRandomLocation(size);
		int row = theLocation.getRowInt();
		int col = theLocation.getCol();
			// cheking if ship occupies spaces in each direction:
		boolean shipUp = containsTheLocation(theLocation, this.size, 1);
		boolean shipDown = containsTheLocation(theLocation, this.size, 2);
		boolean shipRight = containsTheLocation(theLocation, this.size, 3);
		boolean shipLeft = containsTheLocation(theLocation, this.size, 4);
			// choosing the direction to extend towards and filling in locations in that direction:
		if (!shipUp) {
			for (int i = 0; i < size; i++) {
				location[i] = new Location(row+i, col);
				occupiedLocations.add(location[i]);
			}
		} else if (!shipDown) {
			for (int i = 0; i < size; i++) {
				location[i] = new Location(row-i, col);
				occupiedLocations.add(location[i]);
			}
		} else if (!shipRight) {
			for (int i = 0; i < size; i++) {
				location[i] = new Location(row, col+i);
				occupiedLocations.add(location[i]);
			}
		} else if (!shipLeft) {
			for (int i = 0; i < size; i++) {
				location[i] = new Location(row, col-i);
				occupiedLocations.add(location[i]);
			}
		} else {	// 4: ships occupies all locations, choose new location
			newSetLocation();
		}
	}
	
		// returns true if the location c, as well as locations near it, are occupied by other ships
	private static boolean containsTheLocation(Location c, int shipSize, int direction) {
		boolean b = false;
		int currentRow = c.getRowInt();
		int currentCol = c.getCol();
		Location currentLocation = c;
		for (int i = 0; i < shipSize; i++) {
			switch (direction) {
			case 1:
				currentLocation = new Location(currentRow+i, currentCol);
				b = occupiedLocations.contains(currentLocation);
				break;
			case 2:
				currentLocation = new Location(currentRow-i, currentCol);
				b = occupiedLocations.contains(currentLocation);
				break;
			case 3:
				currentLocation = new Location(currentRow, currentCol+i);
				b = occupiedLocations.contains(currentLocation);
				break;
			case 4:
				currentLocation = new Location(currentRow, currentCol-i);
				b = occupiedLocations.contains(currentLocation);
				break;
			}
		}
		return b;
	}
	
	
	public boolean shipGotHit(Location l) {
		// returns true if ship got hit
		// adds 1 to the ships number of hits
		// also checks if ship has been hit enough to be sunk
		boolean containsLocation = false;
		for (Location i: location) {
			if (i.getLocation().equals(l.getLocation())) {
				containsLocation = true;
				numberOfHits++;
			}
		}
		if (numberOfHits == size) {
			currentState = CurrentState.SUNK;
		}
		return containsLocation;
	}
	
	public void setCurrentState(CurrentState state) {
		this.currentState = state;
	}
	
	public CurrentState getCurrentState() {
		return this.currentState;
	}
	
	enum CurrentState {
		// If a ship is sunk, changes from FLOATING to SUNK
		// When a ship is sunk, it should no longer listen for actions
		FLOATING,
		SUNK;
		
	}
	

}
