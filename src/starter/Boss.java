package starter;
import java.awt.Color;
import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

public class Boss {
	
	private RandomGenerator rgen;
	private int theta;
	private int bossLives;
	public GImage bossSprite;
	private int bossVelocity;
	private int originalX;
	
	public Boss (int level) {
		rgen = new RandomGenerator();
		
		originalX = rgen.nextInt(0,500);
		bossLives = (5 * level);
		bossSprite = new GImage("pixil-frame-0.png",originalX,0);
		bossSprite.setSize(110-(10*level),110-(10*level));
	
		bossVelocity = 5;
		theta = 45;
		
	}
		
	public void takeDamage() {
		bossLives = bossLives - 1;
		if (isDead()) {
			bossSprite.setVisible(false);
		}
	}
	
	public boolean isDead() {
		return (bossLives <= 0);
	}
	
	public void thetaOpposite() {
		theta = theta*-1;
		bossSprite.setLocation(originalX, 0);
	}
	
	public void move(int level) { //movement for the Boss
		
		rgen = new RandomGenerator();
		
		if (bossSprite.getX() <= 0) {
			System.out.println("Hit the left Edge");
			theta  = theta - 90;
			bossSprite.movePolar((bossVelocity*level)+(level/2),theta);
			return;			
		}
		
		if (bossSprite.getX()+bossSprite.getWidth() >= 800) {
			System.out.println("Hit the right edge");
			theta = theta - 90;
			bossSprite.movePolar((bossVelocity*level)+(level/2),theta);
			return;
		}
		
		if (bossSprite.getY() <= 0) {
			System.out.println("Hit the Top Edge");
			theta = theta - 90;
			bossSprite.movePolar((bossVelocity*level)+(level/2),theta);
			return;
		}
		
		if (bossSprite.getY()+bossSprite.getHeight() >= 700) {
			System.out.println("Hit the Bottom Edge");
			theta = theta - 90;
			bossSprite.movePolar((bossVelocity*level)+(level/2),theta);
			return;	
		}
		
		bossSprite.movePolar((bossVelocity*level)+(level),theta + rgen.nextInt(0,50));
	}
}