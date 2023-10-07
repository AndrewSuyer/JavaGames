package Swing_Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	// Swing components tutorial: https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		
		// ------------------------------------------------------------------------------- Frame properties ----- //
		
		// these should be at the top:
		
		setSize(500, 1000);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Swing Frame!");
		
		
		
		// ---------------------------------------------------------------------------- Creating components ----- //
		
		// Most things are the same as AWT
		
		// ----- Labels ----- //
		
		JLabel label1 = new JLabel("This is a label", JLabel.LEFT);
		label1.setFont(new Font("Serrif", Font.BOLD, 35));
		label1.setBounds(50, 50, 300, 40);
		
		// ----- Buttons ----- //
		
		JButton button1 = new JButton("Click me!");
		button1.setBounds(50, 125, 200, 200);
		button1.setFont(new Font("Serrif", Font.PLAIN, 30));
		button1.addActionListener(new ActionListener() {
			private int counter = 1;
			// Method is called when button is released
			public void actionPerformed(ActionEvent e) {
				button1.setText(counter + "");
				counter++;
			}
		});
		
		// ----- Sliders ----- //
		
		JSlider slider1 = new JSlider(JSlider.HORIZONTAL);
		slider1.setBounds(50, 350, 400, 50);
		// set min and max values of slider
		slider1.setMinimum(0);
		slider1.setMaximum(50);
		// set initial value of slider
		slider1.setValue(10);
		// set major (big) tick spacing
		slider1.setMajorTickSpacing(10);
		// set minor (small) tick spacing
		slider1.setMinorTickSpacing(1);
		// set paint ticks true so tick marks are visible
		slider1.setPaintTicks(true);
		// set paint labels true so major labels are visible
		//slider1.setPaintLabels(true);
		
		
		// ----- Password field ----- //
		
		// Password field is a text field that hides what the user is typing
		
		//JPasswordField pass1 = new JPasswordField(10);
		//pass1.setLocation(50, 400);
		
		// ------------------------------------------------------------------------ Add components to frame ----- //
		
		add(label1);
		add(button1);
		add(slider1);
		//add(pass1);
		
		// SET VISIBLE TRUE AT END!
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		
	}

}
