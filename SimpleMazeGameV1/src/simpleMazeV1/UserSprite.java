package simpleMazeV1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Spring;

/** 
 * A panel with a circle (which represents the user sprite) that
 * can change colors when the user selects a color from the color
 * chooser panel
 * 
 * @author MatzoMan
 */
public class UserSprite extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Instance variables:
	 */
	
	/** The color of the user sprite */
	private Color spriteColor;
	/** Width of the panel in pixels (width of a single maze tile) */
	private int panelWidth;
	/** Height of the panel in pixels (height of a single maze tile) */
	private int panelHeight;
	
	private JLabel imageLabel;
	private ImageIcon largeImage;
	private ImageIcon smallImage;
	private Image lImage;
	private Image sImage;
	
	/** 
	 * creates the user sprite panel to be the size of a tile
	 * in the maze
	 * 
	 * @param width - maze tile width in pixels
	 * @param height - maze tile height in pixels
	 */
	public UserSprite(int width, int height) {
		// set values of instance variables
		this.panelWidth = width;
		this.panelHeight = height;
		largeImage = new ImageIcon("resources/WeirdBugThing.png");
		smallImage = new ImageIcon("resources/WeirdBugThing_50x50.png");
		lImage = largeImage.getImage();
		sImage = smallImage.getImage();
//		if (panelWidth == 50) {
//			imageLabel = new JLabel(smallImage);
//		}
//		if (panelWidth == 100) {
//			imageLabel = new JLabel(largeImage);
//		}
//		imageLabel.setLocation(0, 0);
//		add(imageLabel);
		// set frame properties
		setSize(width, height);
		setLayout(null);
		setVisible(true);
	}
	
	/** 
	 * Sets the color of this sprite to <Code>c</code> 
	 * 
	 * @param c - color to set the sprite to
	 */
	public void setSpriteColor(Color c) {
		spriteColor = c;
		repaint();
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(lImage, panelWidth, panelHeight, this);
	}

}
