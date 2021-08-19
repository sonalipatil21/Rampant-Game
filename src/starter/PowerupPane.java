package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class PowerupPane extends GraphicsPane {
	private MainApplication program;
	
	GImage PUBackgroundImage = new GImage("InstructionsBackground.jpg", 0, 0);
	private GParagraph title, powerUps, explanation0, explanation1, explanation2, explanation3, explanation4, explanation5, explanation6;
	private GButton menuB, guideB;
	
	public PowerupPane(MainApplication app) {
		super();
		this.program = app;
		title = new GParagraph("Power-Ups", 300, 50);
		title.setFont("Arial-46");
		powerUps = new GParagraph("How to Utilize:", 310, 100);
		powerUps.setFont("Arial-25");
		explanation0 = new GParagraph("OBJECTIVE: Use power-ups to help you survive.", 170, 130);
		explanation0.setFont("Arial-18");
		explanation0.setColor(Color.RED);
		explanation1 = new GParagraph("Only one power-up can be used at a time by pressing the spacebar." , 130, 160);
		explanation1.setFont("Arial-18");
		explanation1.setColor(Color.RED);
		explanation2 = new GParagraph("1. Double Shot (20 coins): Fire 2 bullets at a time for 15 seconds.", 70, 220);
		explanation2.setFont("Arial-18");
		explanation3 = new GParagraph("2. Burst fire power-up (30 coins): Wipe out enemies with a bomb." , 70, 250);
		explanation3.setFont("Arial-18");
		explanation4 = new GParagraph("3. Invincibility (30 coins): Be invincible to all damage for 10 seconds." , 70, 280);
		explanation4.setFont("Arial-18");
		explanation5 = new GParagraph("4. 1-UP (50 coins): Automatically get an extra life added on." , 70, 310);
		explanation5.setFont("Arial-18");
		explanation6 = new GParagraph("5. 2X (50 coins): Coins collected are doubled for 10 seconds." , 70, 340);
		explanation6.setFont("Arial-18");
		menuB = new GButton("Back to Menu", 450, 450, 200, 100);
		menuB.setFillColor(Color.YELLOW);
		guideB = new GButton("Back to Guide", 150, 450, 200, 100);
		guideB.setFillColor(Color.YELLOW);
	}
	
	@Override
	public void showContents() {
		program.add(PUBackgroundImage);
		program.add(title);
		program.add(powerUps);
		program.add(menuB);
		program.add(guideB);
		program.add(explanation0);
		program.add(explanation1);
		program.add(explanation2);
		program.add(explanation3);
		program.add(explanation4);
		program.add(explanation5);
		program.add(explanation6);
	}

	@Override
	public void hideContents() {
		program.remove(PUBackgroundImage);
		program.remove(title);
		program.remove(powerUps);
		program.remove(menuB);
		program.remove(guideB);
		program.remove(explanation0);
		program.remove(explanation1);
		program.remove(explanation2);
		program.remove(explanation3);
		program.remove(explanation4);
		program.remove(explanation5);
		program.remove(explanation6);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menuB) {
			program.switchToMenu();
		}
		else if (obj == guideB) {
			program.switchToGuide();
		}
	}

}
