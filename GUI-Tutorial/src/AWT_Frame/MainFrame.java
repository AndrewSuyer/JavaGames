package AWT_Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Tutorial link: https://www.javatpoint.com/java-awt-menuitem-and-menu

@SuppressWarnings("serial")
public class MainFrame extends Frame {
	
	MainFrame() {	// the constructor is constructing the frame and adding everything to it
		
		// ------------------------------------------------------------------------------------------------------------------------------------------------- Creating components: ----- //
		
		// Create components:
			/* setBounds(x, y, x size, y size)	<-- (x, y) is location of top right corner, x size and y size tell how far to extend out
			 * 	for lables, centers itself in y direction, alligns left in x direction
			 * setBackground() changes background color and setForground() changes text color
			 */ 
		
		// --------------------------------------------------------------------------------------------------------------------------Label----- //
		
			// Label:
		Label label1 = new Label("This is a label!", Label.CENTER);	// should add CENTER to center text in textbox
		label1.setBounds(100, 70, 100, 20);
		
			// Button:
		Button button1 = new Button("Click me!");
		button1.setBounds(100, 100, 100, 100);
		button1.addActionListener(new ActionListener() {	// creating an action listener for when button is pressed
			// ** Event happens when button is released ** //
			private int counter = 1;
			public void actionPerformed(ActionEvent e) {	
				button1.setLabel(counter + "");
				counter++;
			}
		});
		
		// ---------------------------------------------------------------------------------------------------------------------Text Field----- //
		
			// Text field (single line to type things in):
		TextField textField1 = new TextField();
		textField1.setBounds(50, 250, 200, 20);
		textField1.setText("This is a text field!");
		
			// Text area (multiple lines to type in):
		TextArea textArea1 = new TextArea(5, 5);		// numbers are for rows and columns
		textArea1.setBounds(50, 300, 200, 100);
		textArea1.setText("This is a text area!");
		
		// ----------------------------------------------------------------------------------------------------------------------Checkbox----- //
		
			// Checkbox:
		Checkbox checkbox1 = new Checkbox("I am checkbox!");
		checkbox1.setBounds(50, 425, 200, 20);
		checkbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (checkbox1.getState()) {
					checkbox1.setLabel("I have been clicked! (true)");
				} else {
					checkbox1.setLabel("I am not clicked! (false)");
				}
			}	
		});
		
		// -----------------------------------------------------------------------------------------------------------------Checkbox Group----- //
		
			// Checkbox groups (only one checkbox can be selected):
		CheckboxGroup checkboxGroup = new CheckboxGroup();
			// start by creating normal checkboxes and make them part of the checkboxGroup
		Checkbox c1 = new Checkbox("Option 1", checkboxGroup, false);
		Checkbox c2 = new Checkbox("Option 2", checkboxGroup, false);
		Checkbox c3 = new Checkbox("Option 3", checkboxGroup, false);
		c1.setBounds(50, 450, 75, 20);
		c2.setBounds(125, 450, 75, 20);
		c3.setBounds(200, 450, 75, 20);
			// add checkboxes to the frame BUT NOT the checkboxGroup
		
		// -------------------------------------------------------------------------------------------------------------------------Choice----- //
		
			// Choice (dropdown menu):
		Choice choice1 = new Choice();
		choice1.setBounds(50, 475, 200, 20);
			// add options to dropdown (first options shows by default)
		choice1.add("This is a choice!");
		choice1.add("Choose me!");
		choice1.add("No, choose me!");
		choice1.add("Dont choose them, choose me!");
		
		// ------------------------------------------------------------------------------------------------------------Menu and menu items----- //
		
			// MenuBar (thing at top of window):
		MenuBar bar = new MenuBar();
			// Menus (selectables):
		Menu menu1 = new Menu("Menu");
		Menu subMenu = new Menu("Submenu");	
			// Menu items:
		MenuItem i1 = new MenuItem("Item 1");
		MenuItem i2 = new MenuItem("Item 2");
		MenuItem i3 = new MenuItem("Item 3");
		MenuItem i4 = new MenuItem("Submenu item 1");
		MenuItem i5 = new MenuItem("Submenu item 2");
			// add menu items AND submenus to menu
		menu1.add(i1);
		menu1.add(i2);
		menu1.add(i3);
		subMenu.add(i4);
		subMenu.add(i5);
		menu1.add(subMenu);
			// add menu to menu bar
		bar.add(menu1);
			// When adding bar to frame, use setMenuBar()
		
		// -------------------------------------------------------------------------------------------------------------------------Canvas----- //
		
			// Canvas:
			// Create an anonymous innerclass with a paint method
		Canvas canvas1 = new Canvas() {
			@Override
			public void paint(Graphics g) {
				// create shapes through g
				// fillShape() creates a shaded in shape and drawShape() creates an outline of a shape
				// Dimensions in setBounds are relative to the canvas
				// Color of shape is the most recent setColor(), colors can be changed!
				g.setColor(Color.RED);
				g.drawOval(20, 20, 80, 50);
				g.setColor(Color.green);
				g.fillOval(100, 20, 80, 50);
				
					// polygon can be created with arrays:
				int[] xCoords = {20, 60, 80, 80, 50};
				int[] yCoords = {100, 100, 150, 175, 180};
				g.drawPolygon(xCoords, yCoords, 5);
				
				g.setColor(Color.magenta);
					// Text can be drawn to a canvas:
					// kinda bad because you cant set font/size :(
				g.drawString("Hello!", 100, 100);
			}
		};
		canvas1.setBounds(50, 525, 200, 200);
		canvas1.setBackground(Color.BLUE);
		
		// ------------------------------------------------------------------------------------------------------------------------------------------------- Adding components: ----- //
		
		// Add components (to the frame):
		add(label1);
		add(button1);
		add(textField1);
		add(textArea1);
		add(checkbox1);
		add(c1);
		add(c2);
		add(c3);
		add(choice1);
		setMenuBar(bar);
		add(canvas1);
		
		// Set frame properties (this. is implied):
		setSize(300, 800);
		setTitle("This is the title!");
		setBackground(Color.gray);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {		// makes frame close when pressing X
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		MainFrame frame = new MainFrame();

	}

}
