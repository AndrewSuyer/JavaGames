package main;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	
	int id;
	int yVelocity;
	int speed = 10;
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) { // x, y position. w, h size, id for paddle (1 or 2)
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT); // from Rectangle class
		this.id = id;
	}
	
	public void keyPressed(KeyEvent e) {
		// switch / case statements:
		//	if statement is what goes in switch()
		//	cases are the possible things the if are == to
		//	id == 1, or id == 2
		switch (id) {
		case 1:	// movement for the left paddle
			if (e.getKeyCode() == KeyEvent.VK_W) { 
				setYDirection(-speed);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		case 2:	// movement for the right paddle
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move();
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch (id) {
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
				move();
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
			}
			break;
		}
	}
	public void setYDirection(int yDirection) { // padles will only move up and down
		yVelocity = yDirection;
	}
	public void move() {
		y += yVelocity;
	}
	public void draw(Graphics g) {
		if (id == 1)
			g.setColor(Color.blue);
		else 
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

}
