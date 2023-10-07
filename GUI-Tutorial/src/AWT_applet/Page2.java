package AWT_applet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Page2 extends Panel {

	private static final long serialVersionUID = 1L;
	
	public Page2() {
		setBounds(0, 0, 1000, 1000);
		setBackground(Color.DARK_GRAY);
		
		Label label1 = new Label("Try to draw your favorite picture with your favorite color!", Label.CENTER);
		label1.setBounds(25, 75, 950, 40);
		label1.setFont(new Font("SERIFF", Font.BOLD, 35));
		
		// ----- Canvas for user to draw on ----- //
		
		Canvas canvas = new Canvas() {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
				
			}
		};
		canvas.setBounds(50, 125, 900, 850);
		canvas.setBackground(Color.WHITE);
		canvas.addMouseListener(new MouseListener() {
			// Paints dot where user clicks
			@Override
			public void mouseClicked(MouseEvent e) {
				Graphics g = canvas.getGraphics();
				g.setColor(MainFrame.user.getFavoriteColor());
				
				// get current location of mouse:
				int x = e.getX();
				int y = e.getY();
				
				// draw oval where mouse is clicked
				g.fillOval(x, y, 20, 20);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		canvas.addMouseMotionListener(new MouseMotionListener() {
			// draws line where user drags
			@Override
			public void mouseDragged(MouseEvent e) {
				Graphics g = canvas.getGraphics();
				g.setColor(MainFrame.user.getFavoriteColor());
				
				// get current location of mouse:
				int x = e.getX();
				int y = e.getY();
				
				// draw oval where mouse is clicked
				g.fillOval(x, y, 10, 10);
			}

			@Override
			public void mouseMoved(MouseEvent e) {}
			
		});
		
		// adding components
		add(label1);
		add(canvas);
	}

}
