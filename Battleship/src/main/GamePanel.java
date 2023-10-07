package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	private Button[][] buttons = new Button[10][10];
	private Battleship game;
	private Location location;

	
	public GamePanel() {
		setBounds(0, 0, 1280, 720);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		game = new Battleship();
		
		createButtons();
		addButtons();
	}
	
	private void createButtons() {
		// instantiates button, sets bounds
		// also adds action listener which calls missile strike method at location of button
		// i is like the x coordinate, j is like the y coordinate
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new Button();
				buttons[i][j].setBackground(Color.GRAY);
				buttons[i][j].setBounds(i*50 + 50, j*50 + 50, 50, 50);
				
				buttons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(e.getSource());
					}
					
				});
			}
		}
	}
	
		// adds all buttons to the panel
	private void addButtons() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				add(buttons[i][j]);
			}
		}
	}
	
	
}
