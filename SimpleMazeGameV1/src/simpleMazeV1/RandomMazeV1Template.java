package simpleMazeV1;

import java.awt.Point;
import java.util.ArrayList;

/**
 * The template for a randomly generating maze. This is the first version
 * of a randomly generating maze. Start point is top left and end point is bottom right
 * The algorith is better when the maze is bigger!
 * 
 * @author MatzoMan
 */
public abstract class RandomMazeV1Template extends MazeTemplate {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Properties of this type of maze:
	 * Things not mentioned here can be customized
	 */
	
	/** The starting point of all mazes of the type RandomMazeV1Template */
	private static final Point startPoint = new Point(0, 0);	// starting and ending points must be this
	
	/** The randomly generated path for the maze */
	protected ArrayList<Point> mazePath;
	
	/**
	 * Constructor for a randomly generating maze (version 1)
	 * 
	 * @param mazeWidth - the width of the maze in tiles
	 * @param mazeHeight - the height of the maze in tiles
	 * @param difficulty - difficulty of maze (how many points user earns for completing)
	 */
	public RandomMazeV1Template(int mazeWidth, int mazeHeight, int difficulty) {
		super(mazeWidth, mazeHeight, startPoint, new Point(mazeWidth - 1, mazeHeight - 1), difficulty);
	}
	
	/**
	 * Creates the maze path using an algorithm which randomly generates the path
	 */
	private void createPath() {
		
		boolean atBottomRow = false;	// becomes true if path creater is at the bottom row
		int currentCol = 0;				// current column (x) of path creater
		int currentRow = 0;				// current row (y) of the path creater
		
		do {
			// left and right path drawing
			
			if ((int) (Math.random() * 2) == 1) {								// right direction
				int HDist = (int) (Math.random() * (mazeWidth - currentCol));	// random distance [0, movable distance from right border]
				for (int i = currentCol; i < (currentCol + HDist); i++) {		// repeat for columns HDist to the right, but not including the last one
					mazePath.add(new Point(i, currentRow));
				}
				currentCol += HDist;
			} else {															// left direction
				int HDist = (int) (Math.random() * (currentCol + 1));			// random distance [0, movable distance from left border]
				for (int i = currentCol; i > (currentCol - HDist); i--) {		// repeat for columns HDist to the left, but not including the last one
					mazePath.add(new Point(i, currentRow));
				}
				currentCol -= HDist;
			}
			
			// downward pathing
			
			int VDist = (int) (Math.random() * (mazeHeight - currentRow - 1) + 1);	// random distance [1, movable distance from bottom border]
			for (int i = currentRow; i < (currentRow + VDist); i++) {				// repeats for rows VDist down, but not including the last one
				mazePath.add(new Point(currentCol, i));
			}
			currentRow += VDist;
			
			// check if at the bottom row yet
			atBottomRow = (currentRow == (mazeHeight - 1));
			
		} while (!atBottomRow);
		
		// Bottom row from current point to end point
		
		for (int i = currentCol; i <= (mazeWidth - 1); i++) {		// repeats for all columns from the current up to (and including) the tile right before the wall border
			mazePath.add(new Point(i, currentRow));
		}
		
	}
	
	public void createMaze() {
		
		mazePath = new ArrayList<>();
		
		createPath();
		
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = new MazeTile(false, false, true, true);
			}
		}
		
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				
				// random variables which determine where walls go
				boolean south = ((int) (Math.random() * 2) == 1);
				boolean west = ((int) (Math.random() * 2) == 1);
				boolean east = ((int) (Math.random() * 2) == 1);
				
				try {
					if (mazePath.contains(new Point(i, j))) {						// part of the path
						
						if (mazePath.contains(new Point(i+1, j))) {					// contains point to the right
							maze[i][j].setWallEast(false);
							maze[i+1][j].setWallWest(false);
							maze[i][j].setWallSouth(south);
						}
						if (mazePath.contains(new Point(i-1, j))) {					// contains point to the left
							maze[i][j].setWallWest(false);
							maze[i-1][j].setWallEast(false);
							maze[i][j].setWallSouth(south);
						}
						if (mazePath.contains(new Point(i, j+1))) {					// contains point below
							maze[i][j].setWallSouth(false);
							maze[i][j+1].setWallNorth(false);
							maze[i][j].setWallWest(west);
							maze[i][j].setWallEast(east);
						} 
					} else {														// not part of the path
						maze[i][j].setWallSouth(south);
						maze[i][j].setWallWest(west);
					}
				} catch (IndexOutOfBoundsException e) {}
				
				
			}
		}
	}

}
