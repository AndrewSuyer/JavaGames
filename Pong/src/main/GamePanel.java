package main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	
	static int ballCollisionCounter;
	static int difficulty;
	
	
		// instances of class will be assigned values in methods
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score; // example: created in constructor
	Scanner in;
	
	
	@SuppressWarnings("static-access")
	GamePanel() {
			// this keyword refers to object being created
		setDifficutly();
		newBall();
		newPaddles();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		try { // gives the user a second to click out of the console
			gameThread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gameThread.start();
	}
	
	public void setDifficutly() {
		in = new Scanner(System.in);
		System.out.println("Enter difficulty level (1, 2, or 3): ");
		difficulty = in.nextInt();
	}
	
	public void newBall() {
		random = new Random(); // to make ball start at a random y location
		ball = new Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER, difficulty);
	}
	
	public void newPaddles() {
		 paddle1 = new Paddle(0, (GAME_HEIGHT)/2 - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);							// creates paddle for left side
		 paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT)/2 - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2); 	// creates paddle for right side
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	public void move() { // makes paddle movements smoother, also allows both sides to move at the same time
		// this method is called during the game loop
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() {
		
		// bounces ball off top and bottom window edges (makes it go in the opposity x and y direction)
		if (ball.y <= 0)
			ball.setYDirection(-ball.yVelocity);
		if (ball.y >= GAME_HEIGHT - BALL_DIAMETER)
			ball.setYDirection(-ball.yVelocity);
		
		// bounces ball off paddles (intersect method from rectangle class)
		if (ball.intersects(paddle1)) { // paddle1
			ballCollisionCounter++;
			ball.xVelocity = Math.abs(ball.xVelocity);
			if (ballCollisionCounter == 3) { // increases velocity after 5 collisions
				ballCollisionCounter = 0;
				ball.xVelocity++;
				if (ball.yVelocity > 0)
					ball.yVelocity++;
				else
					ball.yVelocity--;	
			}
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if (ball.intersects(paddle2)) { // paddle 2
			ballCollisionCounter++;
			ball.xVelocity = Math.abs(ball.xVelocity);
			if (ballCollisionCounter == 5) { // increases velocity after 5 collisions
				ballCollisionCounter = 0;
				ball.xVelocity++;
				if (ball.yVelocity > 0)
					ball.yVelocity++;
				else
					ball.yVelocity--;
			}
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		// gives a player a point and creates new paddles and ball
		if (ball.x <= 0) { // player 2
			score.player2++;
			newPaddles();
			newBall();
		}
		if (ball.x >= GAME_WIDTH - BALL_DIAMETER) { // player 1
			score.player1++;
			newPaddles();
			newBall();
		}
		
		// stops paddles from going off the window
		if (paddle1.y <= 0)
			paddle1.y=0;
		if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
		if (paddle2.y <= 0)
			paddle2.y=0;
		if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
	}
	
	public void run() { // activated when gameThread.start() is called in the constructor (uses Runnable interface)
		//game loop:
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	public class AL extends KeyAdapter { // (Action Listener) handles key inputs 
		
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}

}
