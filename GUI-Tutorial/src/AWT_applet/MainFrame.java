package AWT_applet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
	
	private static final long serialVersionUID = 1L;

	static MenuBar menuBar = new MenuBar();
	Menu pageSelector = new Menu("Page");
		// user login panel:
	static UserPanel userPanel = new UserPanel();;
	
		// Pages and menu for page:
	static Page1 page1Panel = new Page1();
	MenuItem page1 = new MenuItem("Page 1");
	static Page2 page2Panel = new Page2();
	MenuItem page2 = new MenuItem("Page 2");
	
		// the actual frame:
	static MainFrame frame;
		// the user:
	public static User user;
	
	
	
	MainFrame() {
		// Setup of the frame
		setSize(1000, 1000); 	
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("AWT_applet");
		
		// start by displaying the user panel
		add(userPanel);
		
		
		// Menu items for pages
		// REMEMBER: add remove() to removeAllPanels() whenever a new page is made
		page1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllPanels();
				add(page1Panel);
			}
		});
		page2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllPanels();
				add(page2Panel);
			}
		});
		
		// Add menu items (pages) to page menu
		pageSelector.add(page1);
		pageSelector.add(page2);
		
		// menu bar setup
		menuBar.add(pageSelector);
		
		// makes frame close when pressing X
		addWindowListener(new WindowAdapter() {		
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	private void removeAllPanels() {
		remove(userPanel);
		remove(page1Panel);
		remove(page2Panel);
	}
	
	public static void enableMenuBar() {
		frame.setMenuBar(menuBar);
	}
	
	
	public static void main(String[] args) {
		
		frame = new MainFrame();
		
		// TODO: make page2 a canvas that can be drawn on
	}

}
