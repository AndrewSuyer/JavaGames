package AWT_panel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MainPanel extends Frame {
	
	static Panel centerPanel;
	Label label1 = new Label("I am a label in the panel!", Label.CENTER);
	Button button1 = new Button("Click me!");
	
	MainPanel() {
			// Setup of the frame go here
		setSize(600, 600); 	
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("I am the frame!");
		
		addWindowListener(new WindowAdapter() {		// makes frame close when pressing X
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public void createPanel() {	// adding the components to the panel here
		centerPanel = new Panel();
		centerPanel.setBackground(Color.GRAY);
		centerPanel.setBounds(50, 50, 500, 500);
		
			// create components:
		label1.setBounds(150, 50, 200, 50);
		button1.setBounds(200, 150, 100, 100);
		
		centerPanel.add(label1);
		centerPanel.add(button1);
		
		centerPanel.setVisible(true);	// if there are multiple panels, can set which one is visible
	}

	public static void main(String[] args) {
		
		MainPanel frame = new MainPanel();
		frame.createPanel();
		frame.add(centerPanel);	// adding panel to the frame here

	}

}
