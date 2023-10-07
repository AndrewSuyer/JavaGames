package Swing_applet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.crypto.URIReferenceException;

public class Page1 extends PagePanel {

	private static final long serialVersionUID = 1L;
	
	// ---------- Components ---------- //
	// NAMING CONVENTION: actionType# 
	// action is something like "question", Type is the type of component, # = question number 
	
		// Progress bar
	private byte questionsAnswered = 0;
	private byte numberOfQuestions = 0;
	JProgressBar progressBar;
		// Title
	private JLabel titleLabel;
		// Question 1
	private JLabel questionLabel1;
	private JTextField answerField1;
	private char favoriteLetter1;
	private JButton submitButton1;
	private JSeparator separator1;
		// Question 2
	private JLabel questionLabel2;
	private JLabel figureImage2;		// This label will contain an ImageIcon (basically will be an image)
	private JSlider answerSlider2;
	private byte levelOfLiking2;
	private JButton submitButton2;
		// A table
	private JTable productTable;
	private Object[] colValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private Object[][] productValues = new Object[13][13];
	
	

	
	public Page1() {
		super();
		setBackground(Color.LIGHT_GRAY);
		
		// ----- Progress bar ----- //
		
		// Vertical progress bar
		// Value is updated when user submits an answer (by clicking a submit button)
		progressBar = new JProgressBar(JProgressBar.VERTICAL);
		progressBar.setValue(0);
		progressBar.setString("Question progress");
		progressBar.setFont(new Font("SERIF", Font.BOLD, 20));
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.gray);
		progressBar.setBounds(875, 100, 50, 300);
		
		// ----- Title ----- //
		
		titleLabel = new JLabel("Welcome to the first page of my app!", JLabel.CENTER);
		titleLabel.setFont(new Font("SERIF", Font.BOLD, 40));
		titleLabel.setBounds(50, 25, 900, 50);
		
		// ----- Question 1 ----- //
		
		questionLabel1 = new JLabel("What is your favorite letter?", JLabel.LEFT);
		questionLabel1.setFont(new Font("SERIF", Font.PLAIN, 30));
		questionLabel1.setBounds(25, 100, 350, 35);
		numberOfQuestions++;
		
		answerField1 = new JTextField();
		answerField1.setFont(new Font("SERIF", Font.PLAIN, 20));
		answerField1.setBounds(375, 110, 200, 25);
		answerField1.setToolTipText("Enter your favorite letter here");
		
		submitButton1 = new JButton("Submit");
		submitButton1.setFont(new Font("SERIF", Font.TRUETYPE_FONT, 20));
		submitButton1.setBounds(580, 110, 100, 25);
		submitButton1.addActionListener(new ActionListener() {
			private byte numberOfClicks = 0;
			public void actionPerformed(ActionEvent e) {
				numberOfClicks++;
				// Sets favoriteLetter1 to the first letter of the string that the user inputted
				try {
					favoriteLetter1 = answerField1.getText().charAt(0);
				} catch (IndexOutOfBoundsException OOB) {
					// If user doesnt input somthing, prints warning and decriments number of clicks (this click doesnt count)
					System.out.println("You must enter a value before submitting!");
					numberOfClicks--;
				}
				// Checks if this is the first click
				if (numberOfClicks == 1) {
					progressBar.setValue((int) (100.0 / numberOfQuestions + questionsAnswered * 100.0 / numberOfQuestions));
					questionsAnswered++;
				}
			}
		});
		
		separator1 = new JSeparator(JSeparator.HORIZONTAL);
		separator1.setBackground(Color.BLACK);
		separator1.setBounds(25, 155, 700, 1);
		
		// ----- Question 2 ----- //
		
		questionLabel2 = new JLabel("On a scale from 1-10, how much do you like the picture below?", JLabel.LEFT);
		questionLabel2.setFont(new Font("SERIF", Font.PLAIN, 25));
		questionLabel2.setBounds(25, 175, 650, 30);
		numberOfQuestions++;
		
		ImageIcon img = new ImageIcon (new ImageIcon("E:\\\\PlatformGame\\\\SuperMarioBrosTigerBlock.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		figureImage2 = new JLabel(img); 	// ------------- Adding an image to a panel here! Have to use \\\\ since "\\" = \ for strings
		// "C:\\\\GamingEclipseWorkspace\\\\GUI-Tutorial\\\\surpriseEmoji.png"
		// "D:\\\\Gimp\\\\poopSprite2.png"
		figureImage2.setBounds(25, 250, 222, 227);									// image is centered on label
		figureImage2.setToolTipText("Do you like me?");
		
		answerSlider2 = new JSlider(JSlider.HORIZONTAL);
		answerSlider2.setMinimum(0);
		answerSlider2.setMaximum(10);
		answerSlider2.setValue(5);
		answerSlider2.setMajorTickSpacing(1);
		answerSlider2.setPaintTicks(true);
		answerSlider2.setPaintLabels(true);
		answerSlider2.setBackground(Color.LIGHT_GRAY);
		answerSlider2.setForeground(Color.BLACK);
		answerSlider2.setBounds(300, 250, 350, 50);
		answerSlider2.setToolTipText("Use the slider to select a rating");
		
		submitButton2 = new JButton("Submit");
		submitButton2.setFont(new Font("SERIF", Font.PLAIN, 20));
		submitButton2.setBounds(675, 250, 100, 25);
		submitButton2.addActionListener(new ActionListener() {
			private byte numberOfClicks = 0;
			public void actionPerformed(ActionEvent e) {
				// sets levelOfLiking2 to the value of the slider
				levelOfLiking2 = (byte) (answerSlider2.getValue());
				
				numberOfClicks++;
				// Checks if this is the first click
				if (numberOfClicks == 1) {
					progressBar.setValue((int) (100.0 / numberOfQuestions + questionsAnswered * 100.0 / numberOfQuestions));
					questionsAnswered++;
				}
			}
		});
		
		// ----- Multiplication table ----- //
		
		// making 2D array for multiplicaiton table
		for (short i = 0; i < productValues.length; i++) {
			for (short j = 0; j < productValues[i].length; j++) {
				productValues[i][j] = (short) (i * j);
			}
		}
		// Instantiating table
		productTable = new JTable(productValues, colValues);
		productTable.setBounds(50, 500, 400, 400); //-------------------------------------------------------------------------------------- lEFT OFF HERE!
		
		
		// adding components to panel:
		add(progressBar);
		add(titleLabel);
		add(questionLabel1);
		add(answerField1);
		add(submitButton1);
		add(separator1);
		// ----- //
		add(questionLabel2);
		add(figureImage2);
		add(answerSlider2);
		add(submitButton2);
		// ----- //
		add(productTable);
		
		
		setVisible(true);
	}
	
	

}
