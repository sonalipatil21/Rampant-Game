package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class GuidePane extends GraphicsPane {
	private MainApplication program; 
	
	GImage BackgroundImage = new GImage("OtherBackgrounds.jpg", 0, 0);
	private GParagraph title, guide;
	private GButton menuB, pwr, cntrl, play;

	public GuidePane(MainApplication app) {
		super();
		this.program = app;
		pwr = new GButton("PowerUps", 340, 150, 150, 100);
		pwr.setFillColor(Color.GREEN);
		cntrl = new GButton("Controls", 340, 300, 150, 100);
		cntrl.setFillColor(Color.GREEN);
		menuB = new GButton("Back to Menu", 450, 450, 200, 100);
		menuB.setFillColor(Color.RED);
		play = new GButton("Play Game", 150, 450, 200, 100);
		play.setFillColor(Color.RED);
		title = new GParagraph("Instructions", 310, 50);
		title.setFont("Arial-46");
		
		
	}

	@Override
	public void showContents() {
		program.add(BackgroundImage);
		program.add(title);
		program.add(pwr);
		program.add(cntrl);
		program.add(menuB);
		program.add(play);

	}

	@Override
	public void hideContents() {
		program.remove(BackgroundImage);
		program.remove(title);
		program.remove(pwr);
		program.remove(cntrl);
		program.remove(menuB);
		program.remove(play);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menuB) {
			program.switchToMenu();
		}
		else if (obj == pwr) {
			program.switchToPowerUp();
		}
		else if (obj == cntrl) {
			program.switchToControls();
			
		}
		else if (obj == play) {
			program.switchToGame();
		}
	}
}


