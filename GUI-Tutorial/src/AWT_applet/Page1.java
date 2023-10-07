package AWT_applet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1 extends Panel {

	private static final long serialVersionUID = 1L;
	
	private static Color favoriteColor;
	
	public Page1() {
		setBounds(0, 0, 1000, 1000);
		setBackground(Color.GRAY);
		
		// Components:
		
		Label title = new Label("Welcome to the first page of this app!", Label.CENTER);
		title.setBounds(50, 75, 900, 45);
		title.setFont(new Font("SERRIF", Font.BOLD, 40));
		
		// ----- Question 1 ----- //
		
		Label question1 = new Label("What is your favorite letter?");
		question1.setBounds(25, 150, 310, 25);
		question1.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
		TextField answer1 = new TextField();
		answer1.setBounds(340, 150, 150, 25);
		answer1.setFont(new Font("SERRIF", Font.PLAIN, 15));
		
		Label restate1 = new Label();
		restate1.setBounds(35, 180, 450, 25);
		restate1.setFont(new Font("SERRIF", Font.PLAIN, 20));
		
		Button button1 = new Button("Submit");
		button1.setBounds(500, 150, 75, 25);
		button1.setFont(new Font("SERRIF", Font.PLAIN, 15));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// updates restate1 to what user inputed in answer1
				restate1.setText("Your favorite letter is " + answer1.getText().charAt(0));
				add(restate1);
			}
		});
		
		// ----- Question 2 ----- //
		
		Label question2 = new Label("What is your favorite word?");
		question2.setBounds(25, 225, 310, 25);
		question2.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
		TextField answer2 = new TextField();
		answer2.setBounds(340, 225, 150, 25);
		answer2.setFont(new Font("SERRIF", Font.PLAIN, 15));
		
		Label restate2 = new Label();
		restate2.setBounds(35,  255, 450, 25);
		restate2.setFont(new Font("SERRIF", Font.PLAIN, 20));
		
		Button button2 = new Button("Submit");
		button2.setBounds(500, 225, 75, 25);
		button2.setFont(new Font("SERRIF", Font.PLAIN, 15));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// updates restate2 to what user inpued in answer2
				restate2.setText("Your favorite word is " + answer2.getText());
				add(restate2);
			}
		});
		
		// ----- Question 3 ----- //
				
		Label question3 = new Label("What is your favorite color?");
		question3.setBounds(25, 300, 310, 25);
		question3.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
		Label restate3 = new Label();
		restate3.setBounds(300, 450, 400, 35);
		restate3.setAlignment(Label.CENTER);
		restate3.setFont(new Font("SERRIF", Font.PLAIN, 30));
		
		Button q3Red = new Button("Red");
		q3Red.setBounds(13, 350 , 100, 75);
		q3Red.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Red.setBackground(Color.RED);
		q3Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is red!");
				restate3.setForeground(Color.red);
				favoriteColor = Color.red;
			}
		});
		
		Button q3Orange = new Button("Orange");
		q3Orange.setBounds(138, 350 , 100, 75);
		q3Orange.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Orange.setBackground(Color.ORANGE);
		q3Orange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is orange!");
				restate3.setForeground(Color.orange);
				favoriteColor = Color.orange;
			}
		});
		
		Button q3Yellow = new Button("Yellow");
		q3Yellow.setBounds(263, 350 , 100, 75);
		q3Yellow.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Yellow.setBackground(Color.YELLOW);
		q3Yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is yellow!");
				restate3.setForeground(Color.yellow);
				favoriteColor = Color.yellow;
			}
		});
		
		Button q3Green = new Button("Green");
		q3Green.setBounds(388, 350 , 100, 75);
		q3Green.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Green.setBackground(Color.GREEN);
		q3Green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is green!");
				restate3.setForeground(Color.green);
				favoriteColor = Color.green;
			}
		});
		
		Button q3Blue = new Button("Blue");
		q3Blue.setBounds(513, 350 , 100, 75);
		q3Blue.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Blue.setBackground(Color.BLUE);
		q3Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is blue!");
				restate3.setForeground(Color.blue);
				favoriteColor = Color.blue;
			}
		});
		
		Button q3Purple = new Button("Magenta");
		q3Purple.setBounds(638, 350 , 100, 75);
		q3Purple.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Purple.setBackground(Color.MAGENTA);
		q3Purple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is magenta!");
				restate3.setForeground(Color.magenta);
				favoriteColor = Color.magenta;
			}
		});
		
		Button q3Pink = new Button("Pink");
		q3Pink.setBounds(763, 350 , 100, 75);
		q3Pink.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Pink.setBackground(Color.PINK);
		q3Pink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is pink!");
				restate3.setForeground(Color.pink);
				favoriteColor = Color.pink;
			}
		});
		
		Button q3Black = new Button("Black");
		q3Black.setBounds(888, 350 , 100, 75);
		q3Black.setFont(new Font("SERRIF", Font.BOLD, 15));
		q3Black.setForeground(Color.WHITE);
		q3Black.setBackground(Color.BLACK);
		q3Black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restate3.setText("Your favorite color is black!");
				restate3.setForeground(Color.black);
				favoriteColor = Color.black;
			}
		});
		
		// ----- Question 4 ----- //
		
		Label question4 = new Label("Which is your favorite picture?");
		question4.setBounds(25, 500, 500, 30);
		question4.setFont(new Font("SERRIF", Font.PLAIN, 25));
		
			// beach with a sun (Beach day)
		Canvas canvas1 = new Canvas() {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
					// the sun
				g.setColor(Color.yellow);
				g.fillOval(-40, -40, 100, 100);
					// the water
				g.setColor(Color.blue);
				g.fillPolygon(new int[] {150, 250, 250, 100}, new int[] {250, 250, 100, 100}, 4);
					// the sand
				g.setColor(Color.orange);
				g.fillPolygon(new int[] {0, 0, 150, 100}, new int[] {100, 250, 250, 100}, 4);
			}
		};
		canvas1.setBounds(75, 600, 250, 250);
		canvas1.setBackground(Color.cyan);
		canvas1.setName("Beach day");
		
			// stick figure person (Mr red)
		Canvas canvas2 = new Canvas() {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
					// the head
				g.setColor(Color.red);
				g.fillOval(100, 20, 50, 50);
					// the body
				g.drawLine(125, 70, 125, 170);
					// the legs
				g.drawLine(125, 170, 100, 200);
				g.drawLine(125, 170, 150, 200);
					// the arms
				g.drawLine(75, 120, 175, 120);
					// the eyes
				g.setColor(Color.blue);
				g.fillOval(110, 35, 10, 10);
				g.fillOval(130, 35, 10, 10);
					// the smile
				g.drawArc(110, 40, 30, 20, 225, 90);
			}
		};
		canvas2.setBounds(375, 600, 250, 250);
		canvas2.setBackground(Color.pink);
		canvas2.setName("Red man");
		
			// Poop emoji (What da poo lookin at)
		Canvas canvas3 = new Canvas() {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
				g.setColor(new Color(122, 89, 1, 255)); // RGB for brown
					// top circle
				g.fillOval(100, 50, 50, 50);
					// second row
				g.fillOval(80, 80, 50, 50);
				g.fillOval(120, 80, 50, 50);
					// third row
				g.fillOval(60, 110, 50, 50);
				g.fillOval(100, 110, 50, 50);
				g.fillOval(140, 110, 50, 50);
					// fourth row
				g.fillOval(40, 140, 50, 50);
				g.fillOval(80, 140, 50, 50);
				g.fillOval(120, 140, 50, 50);
				g.fillOval(160, 140, 50, 50);
					// fifth row
				g.fillOval(20, 170, 50, 50);
				g.fillOval(60, 170, 50, 50);
				g.fillOval(100, 170, 50, 50);
				g.fillOval(140, 170, 50, 50);
				g.fillOval(180, 170, 50, 50);
					// eyes
				g.setColor(Color.white);
				g.fillOval(80, 95, 40, 50);
				g.fillOval(130, 95, 40, 50);
				g.setColor(Color.black);
				g.fillOval(100, 120, 20, 20);
				g.fillOval(150, 120, 20, 20);
			}
		};
		canvas3.setBounds(675, 600, 250, 250);
		canvas3.setBackground(Color.yellow);
		canvas3.setName("What da poop lookin at");
		
		CheckboxGroup answer4 = new CheckboxGroup();
		Checkbox c1 = new Checkbox("Beach day", answer4, true);
		Checkbox c2 = new Checkbox("Red man", answer4, true);
		Checkbox c3 = new Checkbox("What da poo lookin at", answer4, true);
		c1.setBounds(75, 570, 250, 30);
		c1.setFont(new Font("SERRIF", Font.PLAIN, 20));
		c2.setBounds(375, 570, 250, 30);
		c2.setFont(new Font("SERRIF", Font.PLAIN, 20));
		c3.setBounds(675, 570, 250, 30);
		c3.setFont(new Font("SERRIF", Font.PLAIN, 20));
		
		// ----- Submit answers button (named uselessButton) ----- // 
		
		Button uselessButton = new Button("Submit all answers");
		uselessButton.setBounds(700, 150, 200, 125);
		uselessButton.setFont(new Font("SERRIF", Font.BOLD, 15));
		uselessButton.setBackground(Color.DARK_GRAY);
		uselessButton.setForeground(Color.BLACK);
		uselessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update user variables with inputs:
				MainFrame.user.setFavoriteLetter(answer1.getText().charAt(0));
				MainFrame.user.setFavoriteWord(answer2.getText());
				MainFrame.user.setFavoriteColor(favoriteColor);
				if (answer4.getSelectedCheckbox() == c1) {
					MainFrame.user.setFavoritePicture(canvas1);
				} if (answer4.getSelectedCheckbox() == c2) {
					MainFrame.user.setFavoritePicture(canvas2);
				} if (answer4.getSelectedCheckbox() == c3) {
					MainFrame.user.setFavoritePicture(canvas3);
				}
				System.out.println(MainFrame.user.toString());
			}
		});
		
		
		// Adding components:
		add(title);
			// question 1 things
		add(question1);
		add(answer1);
		add(button1);
			// question 2 things
		add(question2);
		add(answer2);
		add(button2);
			// question 3 things
		add(question3);
		add(q3Red);
		add(q3Orange);
		add(q3Yellow);
		add(q3Green);
		add(q3Blue);
		add(q3Purple);
		add(q3Pink);
		add(q3Black);
		add(restate3);
			// question 4 things
		add(question4);
		add(canvas1);
		add(canvas2);
		add(canvas3);
		add(c1);
		add(c2);
		add(c3);
			// useless button (submit button)
		add(uselessButton);
	}

}
