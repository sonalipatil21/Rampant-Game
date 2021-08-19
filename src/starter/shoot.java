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

public class shoot extends GraphicsPane implements ActionListener, KeyListener{
	private MainApplication program;
	private Player player;
	double x = 0, y = 0, angle = 315;
    private double axisRadius = 150;
	private double velX = 0;
    private double velY = 0;
    
    private GOval bullet = null;
    double bulletRadius = 5;
	private double bulletLength = axisRadius;
    
	Timer shooterTimer = new Timer(10, this);          
	
    public shoot()
	{
	}
    
    public shoot(MainApplication app, Player player) {
 
    	double cosAngle = Math.cos(Math.toRadians(angle));
    	double sinAngle = Math.sin(Math.toRadians(angle));
    	
    	this.program = app;
    	this.player = player;
    	axisRadius = player.axisRadius;
    	velX   = player.axisX + player.axisRadius - player.shooterRadius;
    	velY   = player.axisY + player.axisRadius - player.shooterRadius;
    	   
		x = velX + bulletRadius + bulletLength * cosAngle;
	    y = velY + bulletRadius + bulletLength * sinAngle;		
	    bullet = new GOval(x, y, bulletRadius*2, bulletRadius*2); 
	    bullet.setVisible(false);
		playerTraits();
    }
    
    public void fire(double angle) {
 
    	this.angle = angle;
    	bulletLength = axisRadius;
		x = velX  + bulletRadius + bulletLength * Math.cos(Math.toRadians(angle));
	    y = velY  + bulletRadius + bulletLength * Math.sin(Math.toRadians(angle));		
	    bullet.setLocation(x, y);
	    bullet.setVisible(true);
	    shooterTimer.start();
 	    playerTraits();
 	}

	public void playerTraits() {
		bullet.setFillColor(Color.RED);
		bullet.setFilled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		playerTraits();

		boolean collision = player.isCollided(bullet);
	
		bulletLength += 2;
		if (bulletLength > (axisRadius * 3) || collision) {
			shooterTimer.stop();
			bulletLength = axisRadius;
		    bullet.setVisible(false);
		    shooterTimer.stop();
		} else {
			x = velX  + bulletRadius + bulletLength * Math.cos(Math.toRadians(angle));
			y = velY  + bulletRadius + bulletLength * Math.sin(Math.toRadians(angle));		
			bullet.setLocation(x, y);
			bullet.setVisible(true);
		}
	}

	@Override
	public void showContents() {
		program.add(bullet);
	}

	@Override
	public void hideContents() {
		program.remove(bullet);
	}
}