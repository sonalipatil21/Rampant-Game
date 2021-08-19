package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LeaderboardPane extends GraphicsPane {
	private MainApplication program; 
	
	GImage BackgroundImage = new GImage("OtherBackgrounds.jpg", 0, 0);
	private GParagraph title;
	private GButton menuB;

	public LeaderboardPane(MainApplication app) {
		super();
		this.program = app;
		title = new GParagraph("Leaderboard", 300, 50);
		title.setFont("Arial-46");
		menuB = new GButton("Back to Menu", 315, 450, 200, 100);
		menuB.setFillColor(Color.RED);
	}

	@Override
	public void showContents() {
		program.add(BackgroundImage);
		program.add(title);
		program.add(menuB);
	}

	@Override
	public void hideContents() {
		program.remove(BackgroundImage);
		program.remove(title);
		program.remove(menuB);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menuB) {
			program.switchToMenu();
		}
	}
}
