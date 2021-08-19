package starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import starter.Item.Type;

public class Player extends GraphicsPane implements ActionListener, KeyListener {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	
	
	private GOval axis;
	public double axisX = 250;
	public double axisY = 200;
	public double axisRadius = 150;
    
	private GImage shooter;
	public levelPane level;
	public double shooterRadius = 10;
	private double shooterX = axisX + axisRadius - shooterRadius;
    private double shooterY = axisY + axisRadius - shooterRadius;
	double x = 0, y = 0, angle = 315;

	private shoot[] soot = new shoot[6];
	private int sootIndex = 0;
	
	private Timer pUpTimer0;
	private Timer pUpTimer2;
	
	private GImage Fence = new GImage("Fence.png", 235, 190);
	
    public Player()
	{
	}
    
	public Player(MainApplication app, levelPane level) {
		this.program = app;
		this.level = level;
		
		x = shooterX + axisRadius * Math.cos(Math.toRadians(angle));
	    y = shooterY + axisRadius * Math.sin(Math.toRadians(angle));		
	 
		axis = new GOval(axisX, axisY, axisRadius * 2, axisRadius * 2);
		shooter = new GImage("slingshot.png", x, y); 
		
		soot[0] = new shoot(this.program, this);
		soot[1] = new shoot(this.program, this);
		soot[2] = new shoot(this.program, this);
		soot[3] = new shoot(this.program, this);
		soot[4] = new shoot(this.program, this);
		soot[5] = new shoot(this.program, this);
		
		pUpTimer0 = new Timer(10000, this);
		pUpTimer0.setRepeats(false);
		pUpTimer2 = new Timer(10000, this);
		pUpTimer2.setRepeats(false);
		}

	public boolean isCollided(GOval bullet) {
		return level.isCollided(bullet);
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
	    if (e.getKeyCode() == KeyEvent.VK_LEFT)  { // <-
	    	angle -= 5; 
	    	if (angle < 0) angle = 360; 
	    }	
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // ->
	    	angle += 5; 
	    	if (angle > 360) angle = 0;
	    }  
	    
	    if (e.getKeyCode() == KeyEvent.VK_UP) { // ^
	    	if(pUpTimer0.isRunning()) {
	    		soot[sootIndex++%3].fire(angle-2);
	    		soot[sootIndex++%3].fire(angle+2);
	    	}
	    	else if(pUpTimer2.isRunning()) {
	    		soot[sootIndex++%3].fire(angle);
				soot[sootIndex++%3].fire(angle + 10);
				soot[sootIndex++%3].fire(angle - 10);
	    	}
	    	else
	    		soot[sootIndex++%3].fire(angle);
	    } 
	    if (e.getKeyCode() == KeyEvent.VK_SPACE) { // ^
			if(levelPane.currentItem != -1) {
				if(levelPane.currentItem == 0) {
					pUpTimer0.start();
				}
				else if(levelPane.currentItem == 1) {
					levelPane.startTimer();
				}
				else if(levelPane.currentItem == 2) {
					pUpTimer2.start();
				}
				else if(levelPane.currentItem == 4) {
					levelPane.startTimer4();
				}
			}
	    }
	   // playerTraits();

		x = shooterX + axisRadius * Math.cos(Math.toRadians(angle));
	    y = shooterY + axisRadius * Math.sin(Math.toRadians(angle));
	    
	    shooter.setLocation(x, y);

    
	    this.program.repaint();
	}
	
	@Override
	public void showContents() {
		//playerTraits();
		program.add(Fence);
		soot[0].showContents();
		soot[1].showContents();
		soot[2].showContents();
		soot[3].showContents();
		soot[4].showContents();
		soot[5].showContents();
		program.add(shooter);
	}

	@Override
	public void hideContents() {
		soot[0].hideContents();
		soot[1].hideContents();
		soot[2].hideContents();
		soot[3].hideContents();
		soot[4].hideContents();
		soot[5].hideContents();
		program.remove(shooter);
		program.remove(Fence);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//playerTraits();
		x = shooterX + axisRadius * Math.cos(Math.toRadians(angle));
	    y = shooterY + axisRadius * Math.sin(Math.toRadians(angle));
	}
}

