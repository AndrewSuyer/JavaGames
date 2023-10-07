package Swing_applet;

import javax.swing.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final int SCREEN_WIDTH = 1000;
	private static final int SCREEN_HEIGHT = 1000;
	private static final String APP_TITLE = "Swing applet";
	
	// Page panels:
	private static Page1 page1;
	
	public MainFrame() {
		
		// setting frame properties:
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(APP_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// Instantiating page panels and setting their location:
		page1 = new Page1();
		page1.setLocation(0, 0);
		
		// adding components to frame:
		add(page1);
		
		// setting frame visibility to true:
		setVisible(true);
		
	}

}
