package simpleMazeV1;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;


/** 
 * The template (superclass) used for all mazes which are created. All mazes must 
 * complete the createMaze() method which is where the actaul maze is created (manually
 * or automatically). This class automatically implements the keyPressed() method which handles
 * user movement
 * 
 * @author MatzoMan
 */
public abstract class MazeTemplate extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Maze panel properties:
	 */
	
	/** Width if the maze panel in pixels */
	protected static final int panelWidth = 1000;
	/** Height if the maze panel in pixels */
	protected static final int panelHeight = 1000;
	
	/*
	 * Instance variables:
	 */

	/** Width of the maze in terms of maze tiles */
	protected final int mazeWidth;
	/** Height of the maze in terms of maze tiles */
	protected final int mazeHeight;
	
	/** Width of a single maze tile in pixels */
	protected final int tileWidth;
	/** Height of a single maze tile in pixels */
	protected final int tileHeight;
	
	/** The start location point in terms of maze tiles */
	protected final Point startLocation;
	/** The end location point in terms of maze tiles */
	protected final Point endLocation;
	
	/** The difficulty of the level which determines how many
	 * points the user gets for completing the level
	 */
	protected final int difficulty;
	
	/** The panel which represents the start location (red square) */
	protected JPanel startLocationPanel;
	/** The panel which represents the end location (green square) */
	protected JPanel endLocationPanel;
	
	/** The 2D array which represents the maze level (created in the <code>createMaze()</code> method).
	 * The point coordinates (in terms of maze tiles) are accesed like: <code>maze[xCoord][yCoord]</code>
	 */
	protected MazeTile[][] maze;
	
	/** OPTIONAL: a label which can be added to a maze level to indicate the level */
	protected JLabel levelIndicatorLabel;
	
	/** The panel with a circle which represents the users sprite */
	protected UserSprite userSprite;
	/** The current point location of the users sprite in terms of maze tiles */
	protected Point userSpriteLocation;
	
	
	/** 
	 * Sets all the basic properties of the panel, like setting the width and height of a
	 * single maze tile and instantiating userSprite
	 * 
	 * @apiNote Make mazeWidth and mazeHeight an even factor of 1000
	 * @param mazeWidth - the width of the maze in tiles
	 * @param mazeHeight - the height of the maze in tiles
	 * @param start - the starting location of the maze
	 * @param end - the ending location of the maze
	 * @param difficulty - difficulty of maze (how many points user earns for completing)
	 */
	public MazeTemplate(int mazeWidth, int mazeHeight, Point start, Point end, int difficulty) {
		// Setting the values of instance variables
		this.mazeWidth = mazeWidth;
		this.mazeHeight = mazeHeight;
		tileWidth =  panelWidth / mazeWidth;
		tileHeight = panelHeight / mazeHeight;
		startLocation = start;
		endLocation = end;
		this.difficulty = difficulty;
		// starting and ending panel properties:
		startLocationPanel = new JPanel();
		startLocationPanel.setBackground(Color.red);
		startLocationPanel.setSize(tileWidth, tileHeight);
		startLocationPanel.setVisible(false);
		startLocationPanel.setLayout(null);
		endLocationPanel = new JPanel();
		endLocationPanel.setBackground(Color.green);
		endLocationPanel.setSize(tileWidth, tileHeight);
		endLocationPanel.setVisible(false);
		endLocationPanel.setLayout(null);
		// creating maze
		maze = new MazeTile[mazeWidth][mazeHeight];
		userSpriteLocation = new Point(start);
		// Setting panel properties
		setSize(panelWidth, panelHeight);
		setLayout(null);
		// unfocus the panel by default (will be focused when the time comes)
		setFocusable(false);
		// Creating maze and userSprite
		createMaze();
		drawMaze();
		userSprite = new UserSprite(tileWidth, tileHeight);
		userSprite.setLocation((int) (start.getX()*tileWidth), (int) (start.getY()*tileHeight));
		add(userSprite);
		
		addKeyListener(this);
	}
	
	
	/** 
	 * Everything to do with the actual creation of the maze goes here.
	 * Be sure to instantiate all MazeTiles in maze!
	 */
	public abstract void createMaze();
	
	/** 
	 * Called whenever a key is pressed. Moves player in the desired direction
	 * if the key pressed was WASD or the arrow keys
	 */
	public void keyPressed(KeyEvent e) {
		// Finds out which key is pressed and calls move() with the direction specified
		switch (e.getKeyCode()) {
		// Arrow keys:
		case 38:	// up (north) arrow key
			move(0);
			break;
		case 39:	// right (east) arrow key
			move(1);
			break;
		case 40:	// down (south) arrow key
			move(2);
			break;
		case 37:	// left (west)  arrow key
			move(3);
			break;
		// WASD:
		case 87:	// W (north)
			move(0);
			break;
		case 68:	// D (esat)
			move(1);
			break;
		case 83:	// S (south)
			move(2);
			break;
		case 65:	// A (west)
			move(3);
			break;
		}
	}
	
	/** 
	 * Moves the userSprite in <code>direction</code> if there isnt a maze wall in 
	 * the way or the edge of the panel. Also detects if player has made it to the end
	 * of the maze
	 * 
	 * @param direction - direction of movement: 0=North, 1=East, 2=South, 3=West
	 */
	public void move(int direction) {
		// Move sprite in direction after checking if the move is valid
		switch (direction) {
		case 0:		// up
			if (isValidMove(userSpriteLocation, 0)) {
				userSpriteLocation.translate(0, -1);
				userSprite.setLocation((int) (userSpriteLocation.getX()*tileWidth), (int) (userSpriteLocation.getY()*tileHeight));
			}
			break;
		case 1:		// right
			if (isValidMove(userSpriteLocation, 1)) {
				userSpriteLocation.translate(1, 0);
				userSprite.setLocation((int) (userSpriteLocation.getX()*tileWidth), (int) (userSpriteLocation.getY()*tileHeight));
			}
			break;
		case 2:		// down
			if (isValidMove(userSpriteLocation, 2)) {
				userSpriteLocation.translate(0, 1);
				userSprite.setLocation((int) (userSpriteLocation.getX()*tileWidth), (int) (userSpriteLocation.getY()*tileHeight));
			}
			break;
		case 3:		// left
			if (isValidMove(userSpriteLocation, 3)) {
				userSpriteLocation.translate(-1, 0);
				userSprite.setLocation((int) (userSpriteLocation.getX()*tileWidth), (int) (userSpriteLocation.getY()*tileHeight));
			}
			break;
		}
		// Check if the sprite is in the ending location (end of the maze)
		if (userSpriteLocation.equals(endLocation)) {
			SimpleMazeGame.nextLevel();
		}
	}
	
	/** 
	 * Returns true if the sprite can legaly move in <code>direction</code>
	 * from the point <code>currentPoint</code>. This checks if there is a 
	 * wall in the way and if the end of the screen is in the way
	 * 
	 * @param currentLocation - current location of the sprite
	 * @param direction - the desired direction of movement
	 * @return - true if the move is valid and false if it isnt
	 */
	private boolean isValidMove(Point currentLocation, int direction) {
		/* Check if there is a wall in desired direction (ex: wallNorth)
		 * Checks if the edge of the screen is in the desired direction (ex: atTopEdge)
		 * Checks if tile in direction has a wall in the opposite direction (ex: wallAbove)
		 * 	ex: there might not be a wall north at currentLocation, but there might be a wall south in tile above
		 * 	this is surrounded in try-catch to avoid IndexOutOfBoundsException's
		 * Returns false (not valid move) if:
		 * 	theres a wall in desired direction or
		 * 	at the edge or
		 * 	tile in direction has wall in opposing direction
		 * Returns true otherwise
		 */
		switch (direction) {
		case 0:
			boolean wallNorth = maze[(int) (currentLocation.getX())] [(int) (currentLocation.getY())].isWallNorth();
			boolean atTopEdge = currentLocation.getY() == 0;
			boolean wallAbove= false;
			if (!wallNorth || !atTopEdge) {
				// checking if tile above has a wall south
				try {
					wallAbove = maze[(int) (currentLocation.getX())] [(int) (currentLocation.getY()-1)].isWallSouth();
				} catch (IndexOutOfBoundsException e) {}
			}
			return !(wallNorth || atTopEdge || wallAbove);
		case 1:
			boolean wallEast = maze[(int) (currentLocation.getX())] [(int) (currentLocation.getY())].isWallEast();
			boolean atRightEdge = currentLocation.getX() == (mazeWidth-1);
			boolean wallRight = false;
			if (!wallEast || !atRightEdge) {
				// checking if tile to the right has a wall west
				try {
					wallRight = maze[(int) (currentLocation.getX()+1)] [(int) (currentLocation.getY())].isWallWest();
				} catch (IndexOutOfBoundsException e) {}
			}
			return !(wallEast || atRightEdge || wallRight);
		case 2:
			boolean wallSouth = maze[(int) (currentLocation.getX())] [(int) (currentLocation.getY())].isWallSouth();
			boolean atBottomEdge = currentLocation.getY() == (mazeHeight-1);
			boolean wallBelow = false;
			if (!wallSouth || !atBottomEdge) {
				// checking if tile below has a wall north
				try {
					wallBelow = maze[(int) (currentLocation.getX())] [(int) (currentLocation.getY()+1)].isWallNorth();
				} catch (IndexOutOfBoundsException e) {}
			}
			return !(wallSouth || atBottomEdge || wallBelow);
		default:
			boolean wallWest = maze[(int) (currentLocation.getX())] [(int) (currentLocation.getY())].isWallWest();
			boolean atLeftEdge = currentLocation.getX() == 0;
			boolean wallLeft = false;
			if (!wallWest || !atLeftEdge) {
				// checking if tile to the left has a wall to the east
				try {
					wallLeft = maze[(int) (currentLocation.getX()-1)] [(int) (currentLocation.getY())].isWallEast();
				} catch (IndexOutOfBoundsException e) {}
			}
			return !(wallWest || atLeftEdge || wallLeft);
		}
	}
	
	/** 
	 * Draws the maze walls and starting and ending squares to the panel
	 */
	public void drawMaze() {
		/* 1. draw the start and end location panels
		 * 2. cycle through all maze tiles in maze[][]:
		 * 	make a JSeperator for the wall and sets the bounds
		 * 	to make it more visible, it is 5 pixels wide
		 */
		startLocationPanel.setBounds((int) (startLocation.getX()*tileWidth), (int) (startLocation.getY()*tileHeight), tileWidth, tileHeight);
		startLocationPanel.setVisible(true);
		add(startLocationPanel);
		endLocationPanel.setBounds((int) (endLocation.getX()*tileWidth), (int) (endLocation.getY()*tileHeight), tileWidth, tileHeight);
		endLocationPanel.setVisible(true);
		add(endLocationPanel);
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j].isWallSouth()) {
					JSeparator wall = new JSeparator(JSeparator.HORIZONTAL);
					wall.setBounds(i*tileWidth, (j+1)*tileWidth-2, tileWidth, 4);
					add(wall);
				}
				if (maze[i][j].isWallEast()) {
					JSeparator wall = new JSeparator(JSeparator.VERTICAL);
					wall.setBounds((i+1)*tileWidth-2, j*tileWidth, 4, tileHeight);
					add(wall);
				}
				if (maze[i][j].isWallNorth()) {
					JSeparator wall = new JSeparator(JSeparator.HORIZONTAL);
					wall.setBounds(i*tileWidth-2, j*tileWidth-2, tileWidth, 4);
					add(wall);
				}
				if (maze[i][j].isWallWest()) {
					JSeparator wall = new JSeparator(JSeparator.VERTICAL);
					wall.setBounds(i*tileWidth-2, j*tileWidth, 4, tileHeight);
					add(wall);
				}
			}
		}
	}
	
	/** 
	 * Calls the <code>setSpriteMethod()</code> of the userSprite which
	 * sets the color of the userSprite dot
	 * 
	 * @param c - the color to set the sprite to
	 */
	public void setSpriteColor(Color c) {
		userSprite.setSpriteColor(c);
	}
	
	/**
	 * Returns the difficutly for this maze, which determines
	 * how many points the user earns for completing it
	 * 
	 * @return - the difficulty for this maze
	 */
	public int getDifficulty() {
		return this.difficulty;
	}
	
	/** 
	 * This class handles the tiles of the maze, more specifically the location
	 * of a maze wall in relation to the tile. Contains getters and setters for
	 * for all booleans, which are true if there is a wall in that direction
	 * 
	 * @author MatzoMan
	 */
	protected class MazeTile {
		
		// Instance variables:
		private boolean wallNorth, wallEast, wallSouth, wallWest = false;
		
		/** 
		 * Creates a maze tile which specifies where a wall is relative to itself
		 * 
		 * @param north	- there is a wall north
		 * @param east - there is a wall east
		 * @param south - there is a wall south
		 * @param west - there is a wall west
		 */
		public MazeTile(boolean north, boolean east, boolean south, boolean west) {
			this.wallNorth = north;
			this.wallEast = east;
			this.wallSouth = south;
			this.wallWest = west;
		}

		public boolean isWallNorth() {
			return wallNorth;
		}

		public void setWallNorth(boolean wallNorth) {
			this.wallNorth = wallNorth;
		}

		public boolean isWallEast() {
			return wallEast;
		}

		public void setWallEast(boolean wallEast) {
			this.wallEast = wallEast;
		}

		public boolean isWallSouth() {
			return wallSouth;
		}

		public void setWallSouth(boolean wallSouth) {
			this.wallSouth = wallSouth;
		}

		public boolean isWallWest() {
			return wallWest;
		}

		public void setWallWest(boolean wallWest) {
			this.wallWest = wallWest;
		}
	}
	
	
	/*
	 * Unused methods:
	 */
	
	/** UNUSED: called whener a key is typed */
	public void keyTyped(KeyEvent e) {}
	/** UNUSED: called whener a key is released */
	public void keyReleased(KeyEvent e) {}

}
