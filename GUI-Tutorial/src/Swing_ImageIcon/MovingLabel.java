package Swing_ImageIcon;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MovingLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	
	private static final int MOVE_AMOUNT = 10; 				// amount to move the panel by

    public MovingLabel() {

        // create an input map for the arrow keys
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");

        // create an action map for the arrow key actions
        ActionMap actionMap = getActionMap();
        actionMap.put("moveLeft", new MoveAction(-MOVE_AMOUNT, 0));
        actionMap.put("moveRight", new MoveAction(MOVE_AMOUNT, 0));
        actionMap.put("moveUp", new MoveAction(0, -MOVE_AMOUNT));
        actionMap.put("moveDown", new MoveAction(0, MOVE_AMOUNT));

        setFocusable(true);
    }

    /**
     * Custom action for moving the panel.
     */
    private class MoveAction extends AbstractAction {
    	
		private static final long serialVersionUID = 1L;
		
		private final int dx;
        private final int dy;

        public MoveAction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // move the panel by the specified amounts
            int x = getX();
            int y = getY();
            setLocation(x + dx, y + dy);
            System.out.println("Action performed");
        }
    }
}