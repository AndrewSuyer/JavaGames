package simpleMazeV1;

import java.awt.Color;

/**
 * A maze which uses the random maze template (version 1).
 * 20x20.
 * Difficulty = 2
 * 
 * @author MatzoMan
 */
public class RandomV1_20x20 extends RandomMazeV1Template {

	private static final long serialVersionUID = 1L;
	
	private static final int mazeWidth = 20;
	private static final int mazeHeight = 20;
	private static final int difficulty = 2;

	public RandomV1_20x20() {
		super(mazeWidth, mazeHeight, difficulty);
		setBackground(Color.gray);
		setVisible(true);
	}

}
