package Swing_applet;

import javax.swing.JPanel;

public abstract class PagePanel extends JPanel {
	
	// Superclass for all pages for the applet
	// All page panel types will by 1000x1000 pixels

	private static final long serialVersionUID = 1L;
	
	private static final int PANEL_WIDTH = 1000;
	private static final int PANEL_HEIGHT = 1000;
	
	public PagePanel() {
		this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		this.setLayout(null);
	}

}
