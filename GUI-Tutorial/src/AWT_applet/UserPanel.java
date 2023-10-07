package AWT_applet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public UserPanel() {
		setBounds(0, 0, 1000, 1000);
		setBackground(Color.gray);
		setLayout(null);
		
		Label label1 = new Label("Please enter some information about yourself", Label.CENTER);
		label1.setBounds(50, 100, 900, 45);
		label1.setFont(new Font("SERRIF", Font.BOLD, 40));
		
		// ----- Name ----- //
		
		Label namePrompt = new Label("Name:");
		namePrompt.setBounds(50, 250, 100, 30);
		namePrompt.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
		TextField nameAnswer = new TextField();
		nameAnswer.setBounds(150, 250, 150, 30);
		nameAnswer.setFont(new Font("SERRIF", Font.PLAIN, 20));
		
		// ----- Username ----- //
		
		Label usernamePrompt = new Label("Username:");
		usernamePrompt.setBounds(50, 350, 150, 30);
		usernamePrompt.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
		TextField usernameAnswer = new TextField();
		usernameAnswer.setBounds(200, 350, 150, 30);
		usernameAnswer.setFont(new Font("SERRIF", Font.PLAIN, 20));
		
		// ----- Password ----- //
		
		Label passwordPromt = new Label("Password:");
		passwordPromt.setBounds(50, 450, 150, 30);
		passwordPromt.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
		TextField passwordAnswer = new TextField();
		passwordAnswer.setBounds(200, 450, 150, 30);
		passwordAnswer.setFont(new Font("SERRIF", Font.PLAIN, 20));
		
		// ----- Submit button and warning label ----- //
		
		Label warningLabel = new Label("Please complete all fields!", Label.CENTER);
		warningLabel.setBounds(400, 460, 600, 30);
		warningLabel.setFont(new Font("SERRIF", Font.PLAIN, 25));
		warningLabel.setForeground(Color.RED);
		
		Button submit = new Button("Submit");
		submit.setBounds(600, 250, 200, 200);
		submit.setFont(new Font("SERRIF", Font.BOLD, 30));
		submit.setBackground(Color.LIGHT_GRAY);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if all text fields have inputs:
				// If not, ask user to complete fields. If they do, instantiate user object, add menu bar to frame, and tell user to proceed
				if ((nameAnswer.getText().equals("")) || (usernameAnswer.getText().equals("")) || (passwordAnswer.getText().equals("")))
					add(warningLabel);
				else {
					MainFrame.user = new User(nameAnswer.getText(), usernameAnswer.getText(), passwordAnswer.getText());
					MainFrame.enableMenuBar();
					warningLabel.setText("You may now proceed to other pages!");
					warningLabel.setForeground(Color.green);
					add(warningLabel);
				}
			}	
		});
		
		
		add(label1);
		add(namePrompt);
		add(nameAnswer);
		add(usernamePrompt);
		add(usernameAnswer);
		add(passwordPromt);
		add(passwordAnswer);
		add(submit);
	}

}
