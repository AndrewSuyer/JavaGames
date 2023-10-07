package simpleMazeV1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;

/** 
 * The FIRST level of the maze game! 
 * 10x10 tiles.
 * 
 * @author MatzoMan
 */
public class Level1 extends MazeTemplate {

	private static final long serialVersionUID = 1L;
	
	/*
	 * This mazes properties:
	 */
	
	private static final int mazeWidth = 10;
	private static final int mazeHeight = 10;
	private static final Point startPoint = new Point(0, 0);
	private static final Point endPoint = new Point(9, 9);
	private static final int difficulty = 1;

	public Level1() {
		super(mazeWidth, mazeHeight, startPoint, endPoint, difficulty);
		setBackground(Color.gray);
		
		levelIndicatorLabel = new JLabel("Level 1");
		levelIndicatorLabel.setFont(new Font("SERIF", Font.BOLD, 75));
		levelIndicatorLabel.setForeground(Color.green);
		levelIndicatorLabel.setBounds(30, 500, 300, 90);
		add(levelIndicatorLabel);
		
		setVisible(true);
	}

	@Override
	public void createMaze() {
		/* This maze starts at the top left, goes right until column 5,
		 * goes down to the bottom, then goes right until the bottom right
		 * where the maze ends
		 */
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if ((j==0) && (i<5)) {
					// top row from column 0 - 4 (inlusive)
					maze[i][j] = new MazeTile(false, false, true, false);	// wall south
				} else if (i==5) {
					// 5th column
					if (j==0) {
						// (5, 0)
						maze[i][j] = new MazeTile(false, true, false, false);	// wall east
					} else if (j==9) {
						// (5, 9)
						maze[i][j] = new MazeTile(false, false, false, true);	// wall west
					} else {
						maze[i][j] = new MazeTile(false, true, false, true);	// wall east and west
					}
				} else if ((j==9) && (i>5)) {
					// bottom row for colums 6-9 (inclusive)
					maze[i][j] = new MazeTile(true, false, false, false);	// wall north
				} else {
					maze[i][j] = new MazeTile(false, false, false, false);	// no walls
				}
			}
		}
	}

}
