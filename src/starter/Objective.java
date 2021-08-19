package starter;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GOval;


public class Objective {
	
	public GImage objective;
	private int lives = 3;
	
	public Objective() {
		objective = new GImage("houseImage.png", 350, 300);
	}
	
	public void takeDamage() {
		if(!levelPane.isRunning4())
			lives = lives - 1;
	}
	
	public void oneUp() {
		lives = lives + 1;
	}
	
	public int getLives() {
		return lives;
	}
	
	public boolean isDead() {
		return (lives <= 0);
	}
	
	public void addLife() {
		lives++;
	}
}

/*public class Objective {
	public GOval objective;
	private int lives = 3;
	public Objective() {
		objective = new GOval(375,325,50,50);
		objective.setFillColor(Color.BLUE);
		objective.setFilled(true);
	}
	public void takeDamage() {
		lives = lives - 1;
	}
	public void oneUp() {
		lives = lives + 1;
	}
	public int getLives() {
		return lives;
	}
	public boolean isDead() {
		return (lives <= 0);
	}
}*/



