package main;

import java.util.Random;

import main.Map.CellValue;
import main.Warship.CurrentState;

public class Battleship {
	
	private static int mapSize = 10;		// Recomended: 10, Minimum: 5
	private int numberOfHits = 0;
	private int numberOfSinks = 0;			// stores how many ships user sunk
	
		// Map and warships:
	Map map = new Map(mapSize);
	Warship carrier = new Carrier();
	Warship battler = new Battler();
	Warship destroyer = new Destroyer();
	Warship submarine = new Submarine();
	Warship patrol = new Patrol();
		// User input things:
	Location locationOfMissileStrike;
	Random random = new Random();
	
	
	public Battleship() {
		spawnShips();
	}
	
	public void spawnShips() {
		// makes ships 
		carrier.newSetLocation();
		battler.newSetLocation();
		destroyer.newSetLocation();
		submarine.newSetLocation();
		patrol.newSetLocation();
	}
	
		//* MAY NOT BE USED *//
	public void randomMissileStrike() {
		// generates a random location for a missile strike:
		int row = random.nextInt(11);
		int col = random.nextInt(11);
		locationOfMissileStrike = new Location(row, col);
	}
	
	public String missileStrike(String location) {
			// gets missile strike location from the user:
		locationOfMissileStrike = new Location(location);
		
			// checks if any of the ships got hit:
		boolean shipGotHit = false;
		boolean shipGotSunk = false;
		if ((carrier.shipGotHit(locationOfMissileStrike)) && (shipGotHit == false)) {
			shipGotHit = true;
		}
		if ((battler.shipGotHit(locationOfMissileStrike)) && (shipGotHit == false)) {
			shipGotHit = true;
		}
		if ((destroyer.shipGotHit(locationOfMissileStrike)) && (shipGotHit == false)) {
			shipGotHit = true;
		}
		if ((submarine.shipGotHit(locationOfMissileStrike)) && (shipGotHit == false)) {
			shipGotHit = true;
		}
		if ((patrol.shipGotHit(locationOfMissileStrike)) && (shipGotHit == false)) {
			shipGotHit = true;
		}
			// checks if a ship has been sunk:
		shipGotSunk = shipGotSunk();
			
			// if a ship got hit, sets cell value at location to hit, otherwise, cell value becomes miss
		if (shipGotHit) {
			map.setCellValue(locationOfMissileStrike, CellValue.HIT);
			if (shipGotSunk) {
				numberOfSinks++;
				return "Sink!";
			} else {
				numberOfHits++;
				return "Hit";
			}
		} else {
			map.setCellValue(locationOfMissileStrike, CellValue.MISS);
			return "Miss!";
		}
		
	}
	
	public boolean shipGotSunk() {
		// returns true if a ship has been sunk
		// checks each ships current state
		boolean gotSunk = false;
		if (carrier.getCurrentState() == CurrentState.SUNK)
			gotSunk = true;
		if (battler.getCurrentState() == CurrentState.SUNK)
			gotSunk = true;
		if (destroyer.getCurrentState() == CurrentState.SUNK)
			gotSunk = true;
		if (submarine.getCurrentState() == CurrentState.SUNK)
			gotSunk = true;
		if (patrol.getCurrentState() == CurrentState.SUNK)
			gotSunk = true;
		return gotSunk;
	}

	public int getNumberOfSinks() {
		// returns numberOfSinks:
		return this.numberOfSinks;
	}
	
	public int score() {
		// returns the amount of points the user got
		// hit = 1pt, sink = 3pts
		return numberOfHits + numberOfSinks*3;
	}
}
