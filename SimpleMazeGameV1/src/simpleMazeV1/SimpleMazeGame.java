package simpleMazeV1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


/** 
 * This is a simple maze game. As the user, you get to choose what color your sprite is. You will
 * progress through a series of levels which I have created (and maybe one day, this program will create
 * mazes on its own). I hope you enjoy playing my game! 
 * 
 * Link to google doc blueprint: <a href=https://docs.google.com/document/d/1l8hMfwmAy1huQWyPBk-FNR0Uw62t2R7lIzv6bRLC8v8/edit#heading=h.s62j40o4hppd> here</a>
 * which also contains drawings of all the maze levels
 * 
 * @author MatzoMan
 */
public class SimpleMazeGame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Frame properties:
	 */
	
	/** Width of the screen (frame) in pixels */
	public static final int screenWidth = 1600;
	/** Height of the screen (frame) in pixels */
	public static final int screenHeight = 1200;
	/** Title of the window (frame) */
	private static String title = "Maze game!";
	
	/*
	 * Frame components:
	 */
	
	/** stores the current maze level (to be used in <code>nextLevel()</code> */
	public static int currentLevel = 1;
	/** Button which allows user to start moving (starting the game) */
	private static JButton startButton;
	/** Panel for choosing the color of the user sprite */
	private static SpriteColorChooser spriteColorChooser;
	/** Label which points out the color choosing panel */
	private static JLabel colorChooserLabel;
	/** Label which displays the users current score */
	private static JLabel scoreLabel;
	/** Current score the user has */
	private static int score = 0;
	/** Password field for user to access dev mode */
	private static JPasswordField passField;
	/** Password for user to access dev mode */
	private final static String devModePassword = "poopytime";
	/** Button to submit passField to access dev mode */
	private static JButton devModeButton;
	/** Button to cycle to the next level if dev mode is enabled */
	private static JButton nextLevelButton;
	
	/*
	 * Maze level instances:
	 * Static because maze levels are predefined. If there was multiple
	 * instances of this class, they would all have the same levels
	 */
	
	private static Level1 mazeLevel1;
	private static Level2 mazeLevel2;
	private static RandomV1_20x20 mazeLevel3;
	private static RandomV1_20x20 mazeLevel4;
	private static RandomV1_20x20 mazeLevel5;
	
	/** 
	 * Displays the maze frame of the next level by 
	 * removing the current one and adding the next one. Also
	 * updates <code>currentLevel</code> to the new current level.
	 * Also updates <code>scoreLabel</code> to the users current score
	 */
	public static void nextLevel() {
		currentLevel++;
		/* Sets current mazes visibility to false
		 * Updates the score based in the current mazes difficulty
		 * Updates the score label to the current score
		 */
		switch (currentLevel) {
		case 2:
			mazeLevel1.setFocusable(false);
			mazeLevel1.setVisible(false);
			score += mazeLevel1.getDifficulty();
			mazeLevel2.setVisible(true);
			mazeLevel2.setFocusable(true);
			mazeLevel2.requestFocus();
			break;
		case 3:
			mazeLevel2.setFocusable(false);
			mazeLevel2.setVisible(false);
			score += mazeLevel2.getDifficulty();
			mazeLevel3.setVisible(true);
			mazeLevel3.setFocusable(true);
			mazeLevel3.requestFocus();
			break;
		case 4:
			mazeLevel3.setFocusable(false);
			mazeLevel3.setVisible(false);
			score += mazeLevel3.getDifficulty();
			mazeLevel4.setVisible(true);
			mazeLevel4.setFocusable(true);
			mazeLevel4.requestFocus();
			break;
		case 5:
			mazeLevel4.setFocusable(false);
			mazeLevel4.setVisible(false);
			score += mazeLevel4.getDifficulty();
			mazeLevel5.setVisible(true);
			mazeLevel5.setFocusable(true);
			mazeLevel5.requestFocus();
		}
		// update score and score label:
		scoreLabel.setText("Score: " + score);
	}
	
	
	/** 
	 * Creates the frame and adds all of the levels, as well as adding other GUI components
	 */
	public SimpleMazeGame() {
		// frame properties
		setSize(screenWidth, screenHeight);
		setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// First level
		mazeLevel1 = new Level1();
		mazeLevel1.setLocation(50, 50);
		add(mazeLevel1);
		
		// Second level
		mazeLevel2 = new Level2();
		mazeLevel2.setLocation(50, 50);
		mazeLevel2.setVisible(false);
		add(mazeLevel2);
		
		// Third level
		mazeLevel3 = new RandomV1_20x20();
		mazeLevel3.setLocation(50, 50);
		mazeLevel3.setVisible(false);
		add(mazeLevel3);
		
		// Fourth level
		mazeLevel4 = new RandomV1_20x20();
		mazeLevel4.setLocation(50, 50);
		mazeLevel4.setVisible(false);
		add(mazeLevel4);
		
		// Fifth level
		mazeLevel5 = new RandomV1_20x20();
		mazeLevel5.setLocation(50, 50);
		mazeLevel5.setVisible(false);
		add(mazeLevel5);
		
		
		// Frame items:
		startButton = new JButton("Start");
		startButton.setFont(new Font("SERIF", Font.BOLD, 50));
		startButton.setFocusable(false);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// makes level 1 focused
				mazeLevel1.setFocusable(true);
				mazeLevel1.requestFocus();
				// removes focus from dev mode password field
				passField.setFocusable(false);
			}
		});
		startButton.setBounds(1100, 50, 400, 100);
		startButton.setVisible(false);
		add(startButton);
		
		spriteColorChooser = new SpriteColorChooser();
		spriteColorChooser.setLocation(1150, 200);
		spriteColorChooser.setFocusable(false);
		add(spriteColorChooser);
		
		colorChooserLabel = new JLabel("Choose the color for your sprite", JLabel.CENTER);
		colorChooserLabel.setFont(new Font("SERIF", Font.BOLD, 30));
		colorChooserLabel.setBounds(1075, 525, 450,  50);
		add(colorChooserLabel);
		
		scoreLabel = new JLabel("Score: 0", JLabel.CENTER);
		scoreLabel.setFont(new Font("SERIF", Font.BOLD, 75));
		scoreLabel.setBounds(1075, 600, 450,  90);
		add(scoreLabel);
		
		passField = new JPasswordField();
		passField.setFocusable(true);
		passField.setBounds(1075, 750, 200,  30);
		add(passField);
		
		devModeButton = new JButton("Dev mode");
		devModeButton.setFocusable(false);
		devModeButton.setBounds(1300, 750, 100,  30);
		devModeButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// enables dev mode if the password is correct
				if (passField.getText().equals(devModePassword)) {
					passField.setFocusable(false);
					enableDevMode();
				}
			}
			
		});
		add(devModeButton);
		
		setVisible(true);
	}
	
	/** 
	 * UNUSED: Prompts the user to choose a color for their sprite. Calls
	 * the setSpriteColor() method for all mazePanels which set the
	 * color of the sprite
	 */
	public void setSpriteColor() {
		// Asking user for color
		Scanner in = new Scanner(System.in);
		System.out.println("What color do you want your sprite to be?");
		System.out.println("1: red, 2: orange, 3: yellow");
		System.out.println("4: green, 5: blue, 6: cyan");
		System.out.println("7: magenta, 8: pink, 9: black");
		int choice = in.nextInt();
		in.close();
		// Call setSpriteColor() on all maze panels 
		// Note: default is black (if user doesnt choose a number 1-9)
		Color colorChoice;
		switch (choice) {
		case 1:
			colorChoice = Color.red;
			break;
		case 2: 
			colorChoice = Color.orange;
			break;
		case 3:
			colorChoice = Color.yellow;
			break;
		case 4:
			colorChoice = Color.green;
			break;
		case 5:
			colorChoice = Color.blue;
			break;
		case 6:
			colorChoice = Color.cyan;
			break;
		case 7: 
			colorChoice = Color.magenta;
			break;
		case 8:
			colorChoice = Color.pink;
			break;
		default:
			colorChoice = Color.black;
			break;
		}
		// Having all maze panels set there sprite color
		mazeLevel1.setSpriteColor(colorChoice);
		mazeLevel2.setSpriteColor(colorChoice);
		mazeLevel3.setSpriteColor(colorChoice);
		mazeLevel4.setSpriteColor(colorChoice);
		mazeLevel5.setSpriteColor(colorChoice);
	}
	
	/** 
	 * Sets the sprite color to a specified color <code>c</code> by
	 * calling the <code>setSpriteColor()</code> method for all maze 
	 * panels
	 * 
	 * @param c - the color to set the srite to
	 */
	public void setSpriteColor(Color c) {
		// Having all maze panels set there sprite color
		mazeLevel1.setSpriteColor(c);
		mazeLevel2.setSpriteColor(c);
		mazeLevel3.setSpriteColor(c);
		mazeLevel4.setSpriteColor(c);
		mazeLevel5.setSpriteColor(c);
	}
	
	/**
	 * Enables dev mode, which allows user to navigate to the next level
	 * via a button
	 */
	private void enableDevMode() {
		System.out.println("Dev mode activated");
		nextLevelButton = new JButton("Next level");
		nextLevelButton.setFocusable(false);
		nextLevelButton.repaint();
		nextLevelButton.setBounds(1450, 750, 100,  30);
		nextLevelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// displays the next level of the maze
				nextLevel();
			}
			
		});
		add(nextLevelButton);
	}

	public static void main(String[] args) {
		
		// Creates the frame and starts the game!
		new SimpleMazeGame();
		
		/** TODO
		 * - figure out image for UserSprite
		 * - add a timer 
		 * - BUG: color chooser makes sprite into square until user moves it
		 * - Randomly generating maze (in notes)
		 * - make maze path generator more turny and less straight
		 */
		
	}
	
	/** 
	 * A panel of 9 buttons to choose color for the user sprite. The possible
	 * colors are shown as the name of the buttons on the fourth real line
	 * of the class
	 * 
	 * @author MatzoMan
	 */
	public class SpriteColorChooser extends JPanel implements ActionListener {
		
		private static final long serialVersionUID = 1L;

		/*
		 * Panel properties:
		 */
		
		/** Width of the sprite color chooser panel in pixels */
		private static final int PANEL_WIDTH = 300;
		/** Height of the sprite color chooser panel in pixels */
		private static final int PANEL_HEIGHT = 300;
		
		/** Button which is used to choose this color */
		private JButton red, orange, yellow, green, blue, cyan, magenta, pink, black;
		
		/** 
		 * Creates a color chooser panel with 9 possible colors to choose frome
		 */
		public SpriteColorChooser() {
			setSize(PANEL_WIDTH, PANEL_HEIGHT);
			setLayout(null);
			setFocusable(false);
			
			red = new JButton();
			red.setBackground(Color.red);
			red.addActionListener(this);
			red.setBounds(0,  0,  100,  100);
			red.setFocusable(false);
			add(red);
			
			orange = new JButton();
			orange.setBackground(Color.orange);
			orange.addActionListener(this);
			orange.setBounds(100,  0,  100,  100);
			orange.setFocusable(false);
			add(orange);
			
			yellow = new JButton();
			yellow.setBackground(Color.yellow);
			yellow.addActionListener(this);
			yellow.setBounds(200,  0,  100,  100);
			yellow.setFocusable(false);
			add(yellow);
			
			green = new JButton();
			green.setBackground(Color.green);
			green.addActionListener(this);
			green.setBounds(0,  100,  100,  100);
			green.setFocusable(false);
			add(green);
			
			blue = new JButton();
			blue.setBackground(Color.blue);
			blue.addActionListener(this);
			blue.setBounds(100,  100,  100,  100);
			blue.setFocusable(false);
			add(blue);
			
			cyan = new JButton();
			cyan.setBackground(Color.cyan);
			cyan.addActionListener(this);
			cyan.setBounds(200,  100,  100,  100);
			cyan.setFocusable(false);
			add(cyan);
			
			magenta = new JButton();
			magenta.setBackground(Color.magenta);
			magenta.addActionListener(this);
			magenta.setBounds(0,  200,  100,  100);
			magenta.setFocusable(false);
			add(magenta);
			
			pink = new JButton();
			pink.setBackground(Color.pink);
			pink.addActionListener(this);
			pink.setBounds(100,  200,  100,  100);
			pink.setFocusable(false);
			add(pink);
			
			black = new JButton();
			black.setBackground(Color.black);
			black.addActionListener(this);
			black.setBounds(200,  200,  100,  100);
			black.setFocusable(false);
			add(black);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// finds out which button was pressed (stored in currentColor)
			Color currentColor = null;
			if (e.getSource() == red) {
				currentColor = Color.red;
			}
			if (e.getSource() == orange) {
				currentColor = Color.orange;
			}
			if (e.getSource() == yellow) {
				currentColor = Color.orange;
			}
			if (e.getSource() == green) {
				currentColor = Color.green;
			}
			if (e.getSource() == blue) {
				currentColor = Color.blue;
			}
			if (e.getSource() == cyan) {
				currentColor = Color.cyan;
			}
			if (e.getSource() == magenta) {
				currentColor = Color.magenta;
			}
			if (e.getSource() == pink) {
				currentColor = Color.pink;
			}
			if (e.getSource() == black) {
				currentColor = Color.black;
			}
			// set the srite color to the chosen color
			setSpriteColor(currentColor);
			// makes the start button visible (only matters for first color chosen)
			startButton.setVisible(true);
		}
	}
}
