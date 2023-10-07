package main;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BattleshipGUI extends Frame {

	private static final long serialVersionUID = 1L;
	
	public BattleshipGUI() {
		// add game panel
		GamePanel panel = new GamePanel();
		
		setSize(1280, 720);
		setTitle("Battleship");
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		
		add(panel);
		
		addWindowListener(new WindowAdapter() {		// makes frame close when pressing X
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

}
