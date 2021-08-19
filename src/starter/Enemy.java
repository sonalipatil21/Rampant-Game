package starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

public class Enemy {
	private RandomGenerator rgen;
	private int lives;
	private int spawnLocation;
	private enum type {SKIN,SKIN2};
	
	
	public GImage foe;
	int spawnZone;
	double velocity;
	
	private int upperBound;
	private int lowerBound;
	private int originalX;
	private int originalY;
	
	public Enemy(int X, int Y) {

		//foe = new GRect(X, Y, 20, 20);
		//foe.setFillColor(Color.GREEN);
		//foe.setFilled(true);
		foe = new GImage("Bird.png", X, Y);
		foe.setSize(40, 20);
		lives = 2;
		rgen = new RandomGenerator();
		velocity  = 5;
		originalX = X;
		originalY = Y;
	}	
	
	public int getSpawnLocation() {
		return spawnLocation;
	}
	
	public void setSpawnLocation(int SL) {
		spawnLocation = SL;
		setBounds(SL);
	}
	
	private void setBounds(int SL) {
		
		switch (SL) {
		case 0:
			upperBound = 360;
			lowerBound = 270;
			break;
		case 1:
			upperBound = 270;
			lowerBound = 180;
			break;
		case 2:
			upperBound = 180;
			lowerBound = 90;
			break;
		case 3:
			upperBound = 90;
			lowerBound = 0;
			break;
		}	
	}
	
	public void takeDamage() {
		lives = lives - 1;
		foe.setImage("lost1LifeBird.png");
		foe.setSize(40, 20);
		if (isDead()) {
			foe.setVisible(false);
		}
	}
	
	public boolean isDead() {
		return (lives <= 0);
	}
	
	public void makeDead() {
		lives = 0;
	}
	
	public void boundCheck() {
		if (foe.getX() < 0 || foe.getX()+foe.getWidth() > 820 || foe.getY() < 0 || foe.getY()+foe.getHeight() > 720) {
			System.out.println("Edge Triggered");
			foe.setLocation(originalX,originalY);
		}
	}
	
	public void setVelocity(int levelNum) {
		velocity = rgen.nextDouble(0.8,1.0)+levelNum;
	}
	
	public void move() {  //Movement for enemy
		rgen = new RandomGenerator();
		switch (spawnLocation) {
		case 0:
			foe.movePolar(velocity,rgen.nextInt(lowerBound,upperBound));
			break;
		case 1:
			foe.movePolar(velocity,rgen.nextInt(lowerBound,upperBound));
			break;
		case 2:
			foe.movePolar(velocity,rgen.nextInt(lowerBound,upperBound));
			break;
		case 3:
			foe.movePolar(velocity,rgen.nextInt(lowerBound,upperBound));
			break;
		}
		
		boundCheck();
	}
}

  