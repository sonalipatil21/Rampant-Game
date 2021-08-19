package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton rect, lbrd, sett, guide, exit;
	
	GImage MenuBackgroundImage = new GImage("BackgroundImage.png", 0, 0);
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Play Game", 250, 50, 300, 100);
		lbrd = new GButton ("Leaderboard", 250, 170, 300, 100); 
		sett = new GButton("Settings", 250, 290, 300, 100);
		guide = new GButton("Guide", 250, 410, 300, 100);
		exit = new GButton("Exit", 250, 530, 300, 100);
		rect.setFillColor(Color.ORANGE);
		lbrd.setFillColor(Color.YELLOW);
		sett.setFillColor(Color.ORANGE);
		guide.setFillColor(Color.YELLOW);
		exit.setFillColor(Color.ORANGE);
		
		
	}

	@Override
	public void showContents() {
		program.add(MenuBackgroundImage);
		program.add(rect);
		program.add(lbrd);
		program.add(sett);
		program.add(guide);
		program.add(exit);
	}

	@Override
	public void hideContents() {
		program.remove(MenuBackgroundImage);
		program.remove(rect);
		program.remove(lbrd);
		program.remove(sett);
		program.remove(guide);
		program.remove(exit);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToUsername();
		}
		else if (obj == guide) {
			program.switchToGuide();
		}
		else if (obj == lbrd) {
			program.switchToLeaderbd();
		}
		else if (obj == sett) {
			program.switchToSettings();
		}
		else if (obj == exit) {
			System.exit(0);
		}
	}
}
