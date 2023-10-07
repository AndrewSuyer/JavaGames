package AWT_dialog;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGui {
	
	// A dialog is a special type of frame that can only be closed
	
	MainGui() {
		frame = new Frame("Where");
		frame.setSize(300, 300);
		
		dialog = new Dialog(frame, "This is a dialog");
		
			// set dialog properties
		dialog.setSize(300, 300);
		dialog.setVisible(true);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		
		label.setBounds(50, 5, 100, 100);
		dialog.add(label);
		
		dialog.addWindowListener(new WindowAdapter() {		// makes dialog close when pressing X <------------------ no it doesnt
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
			}
		});
	}
	
	Frame frame;
	Dialog dialog;
	Label label = new Label("Im a component", Label.CENTER);
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		MainGui user = new MainGui();
		
	}

}
