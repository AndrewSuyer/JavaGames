package simpleMazeV1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;

/**
 * The SECOND level of the maze!
 * 10x10 tiles.
 * 
 * @author MatzoMan
 */
public class Level2 extends MazeTemplate {

	private static final long serialVersionUID = 1L;
	
	/*
	 * This maze properties:
	 */
	
	private static final int mazeWidth = 10;
	private static final int mazeHeight = 10;
	private static final Point startPoint = new Point(0, 0);
	private static final Point endPoint = new Point(9, 9);
	private static final int difficulty = 1;

	public Level2() {
		super(mazeWidth, mazeHeight, startPoint, endPoint, difficulty);
		setBackground(Color.gray);
		
		levelIndicatorLabel = new JLabel("Level 2");
		levelIndicatorLabel.setFont(new Font("SERIF", Font.BOLD, 75));
		levelIndicatorLabel.setForeground(Color.green);
		levelIndicatorLabel.setBounds(30, 350, 300, 90);
		add(levelIndicatorLabel);
		
		setVisible(true);
	}

	@Override
	public void createMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				
				// set all tiles to no wall
				maze[i][j] = new MazeTile(false, false, false, false);	// no wall
				
				if (j==0 && i<=2) {
					// top left 3
					maze[i][j].setWallSouth(true);	// wall bottom
				} else if (j<=2 && i==3) {
					if (j==0) {
						// (3, 0)
					maze[i][j].setWallEast(true);	// wall east
					}
					if (j==1) {
						// (3, 1)
						maze[i][j].setWallEast(true);	// wall east and west
						maze[i][j].setWallWest(true);
					}
					if (j==2) {
						// (3, 2)
						maze[i][j].setWallWest(true);	// wall south and west
						maze[i][j].setWallSouth(true);
					}
				} else if (j==2 && i>=4 && i<=6) {
					// j=2 from 4 <= i <= 6
					maze[i][j].setWallNorth(true);	// wall north and south
					maze[i][j].setWallSouth(true);
				} else if (i==7 && j>=2 && j<=5) {
					if (j==2) {
						// (7, 2)
						maze[i][j].setWallNorth(true);	// wall north and east
						maze[i][j].setWallEast(true);
					}
					if (j==3 || j==4) {
						// (7, 3) (7, 4)
						maze[i][j].setWallEast(true);	// wall east and west
						maze[i][j].setWallWest(true);
					}
					if (j==5) {
						maze[i][j].setWallSouth(true);	// wall south and west
						maze[i][j].setWallEast(true);
					}
				} else if (j==5 && i>=2 && i<=6) {
					// j=5 from 2 <= i <= 6
					maze[i][j].setWallSouth(true);	// wall north and south
					maze[i][j].setWallNorth(true);
				} else if (i==1 && j>=5 && j<=8) {
					// i=5 from 5 <= j <= 8
					if (j==5) {
						// (1, 5)
						maze[i][j].setWallNorth(true);	// wall north and west
						maze[i][j].setWallWest(true);
					}
					if (j==6 || j==7) {
						// (1, 6) and (1, 7)
						maze[i][j].setWallEast(true);	// wall east and west
						maze[i][j].setWallWest(true);
					}
					if (j==8) {
						// (1, 8)
						maze[i][j].setWallSouth(true);	// wall south and west
						maze[i][j].setWallWest(true);
					}
				} else if (j==8 && i>=2 && i<=3) {
					// j=8 from 2 <= i <= 3
					maze[i][j].setWallSouth(true);	// wall north and south
					maze[i][j].setWallNorth(true);
				} else if (i==4 && (j==8 || j==9)) {
					// (4, 8) and (4, 9)
					if (j==8) {
						maze[i][j].setWallNorth(true);	// wall north and east
						maze[i][j].setWallEast(true);	
					}
					if (j==9) {
						maze[i][j].setWallWest(true);	// wall west
					}
				} else if (j==9 && i>=5) {
					// j=9 from 5 <= i <= 9
					maze[i][j].setWallNorth(true);	// wall north
				}
			}
		}
	}

}
