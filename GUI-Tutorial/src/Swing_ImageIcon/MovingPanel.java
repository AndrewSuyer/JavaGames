package Swing_ImageIcon;

import javax.swing.*;
import java.awt.event.*;

public class MovingPanel extends JLabel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dx = 0;
    private int dy = 0;
    private int speed = 100; // pixels per second
    private Timer timer;

    public MovingPanel(String text) {
        super(text);
        setSize(100, 50);
        setFocusable(true);
        
        setOpaque(false);
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "moveLeft");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "stopLeft");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "moveRight");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "stopRight");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "moveUp");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "stopUp");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "moveDown");
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "stopDown");
        
        ActionMap actionMap = getActionMap();
        actionMap.put("moveLeft", new MoveAction(-speed, 0));
        actionMap.put("stopLeft", new MoveAction(0, 0));
        actionMap.put("moveRight", new MoveAction(speed, 0));
        actionMap.put("stopRight", new MoveAction(0, 0));
        actionMap.put("moveUp", new MoveAction(0, -speed));
        actionMap.put("stopUp", new MoveAction(0, 0));
        actionMap.put("moveDown", new MoveAction(0, speed));
        actionMap.put("stopDown", new MoveAction(0, 0));
        
        timer = new Timer(33, new ActionListener() { 					// 30 fps
            public void actionPerformed(ActionEvent e) {
                setLocation(getX() + dx, getY() + dy);
            }
        });
        timer.start();
    }

    private class MoveAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private int dx;
        private int dy;

        public MoveAction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public void actionPerformed(ActionEvent e) {
            MovingPanel.this.dx = dx;
            MovingPanel.this.dy = dy;
        }
    }
}
