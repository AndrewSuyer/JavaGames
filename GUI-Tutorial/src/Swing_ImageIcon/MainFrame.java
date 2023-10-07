package Swing_ImageIcon;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	public MainFrame () {
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Image on the screen tutorial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
//		setAlwaysOnTop(true);
		
		JPanel panel = new JPanel(null);
		panel.setSize(getWidth(), getHeight());
		panel.setLocation(0, 0);
		panel.setBackground(Color.cyan);
		panel.setLayout(null);
		setContentPane(panel);
		
		// ----- Creating an image icon ----- //
		
		ImageIcon icon = new ImageIcon("D:\\\\Gimp\\\\SuperMarioBrosTigerBlock.png");				// put the file location of the image as argument, use "\\" for \
		JLabel iconLabel = new JLabel();															// create label for the image so it can be added to the panel
		iconLabel.setLocation(100, 100);															// set desired location for image label

		// Scaling the image:
		icon = new ImageIcon(icon.getImage().getScaledInstance(icon.getIconWidth() * 3, icon.getIconHeight() * 3, Image.SCALE_SMOOTH));		// Replace 3 with scale factor
		
		iconLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
		iconLabel.setIcon(icon);
		
		panel.add(iconLabel);															// Add label to the panel
		
		// ----- Creating a moving sprite label ----- //
		
		setFocusable(true);
		panel.setFocusable(true);
		
		MovingLabel sprite = new MovingLabel();
		sprite.setIcon(icon);
		sprite.setSize(getWidth(), getHeight());
		panel.add(sprite);
		
//		MovingPanel sprite2 = new MovingPanel("SPRITE");
//		panel.add(sprite2);
//		sprite2.requestFocus();
		
		setVisible(true);
	}
	



	public static void main (String[] args) {
		new MainFrame();
	}

}
