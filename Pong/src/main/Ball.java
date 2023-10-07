package main;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	
	Random random;
	int xVelocity;
	int yVelocity;
	int speedMultiplier = 0;
	
	Ball(int x, int y, int width, int height, int difficulty) {
		super(x, y, width, height); // from Rectangle class
		
		// sets difficulty (speed of the ball)
		setDifficulty(difficulty);
		
		// sets random x direction
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0)
			randomXDirection --;
		setXDirection(randomXDirection * speedMultiplier);
		
		// sets random y direction
		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)
			randomYDirection --;
		setYDirection(randomYDirection * speedMultiplier);
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) { 
		yVelocity = randomYDirection;
	}
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
	
	public void setDifficulty(int d) {
		speedMultiplier = d * 2;
	}

}
