package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
public class ControlsPane extends GraphicsPane{
	private MainApplication program;
	
	GImage CtrlBackgroundImage = new GImage("InstructionsBackground.jpg", 0, 0);
	
	private GParagraph title, controls, explanation1, explanation2, explanation3, explanation4, explanation5, explanation6;
	private GButton menuB, guideB;
	
	public ControlsPane(MainApplication app) {
		super();
		this.program = app;
		title = new GParagraph("Controls", 300, 50);
		title.setFont("Arial-46");
		controls = new GParagraph("How to Play:", 310, 100);
		controls.setFont("Arial-25");
		explanation1 = new GParagraph("OBJECTIVE: Protect the - from enemies and bosses." , 150, 130);
		explanation1.setFont("Arial-18");
		explanation1.setColor(Color.RED);
		explanation2 = new GParagraph("The - has 3 lives, while enemies have 2 lives and bosses have 5 lives." , 100, 160);
		explanation2.setFont("Arial-18");
		explanation2.setColor(Color.RED);
		explanation3 = new GParagraph("1. To move the shooter in a clockwise direction, press the right arrow button. " , 70, 220);
		explanation3.setFont("Arial-18");
		explanation4 = new GParagraph("2. To move the shooter in a counterclockwise direction, press the left arrow button. " , 70, 250);
		explanation4.setFont("Arial-18");
		explanation5 = new GParagraph("3. To shoot, press the up arrow button.", 70, 280);
		explanation5.setFont("Arial-18");
		explanation6 = new GParagraph("4. To use any given power-up, press the spacebar. " , 70, 310);
		explanation6.setFont("Arial-18");
		menuB = new GButton("Back to Menu", 450, 450, 200, 100);
		menuB.setFillColor(Color.YELLOW);
		guideB = new GButton("Back to Guide", 150, 450, 200, 100);
		guideB.setFillColor(Color.YELLOW);
	}
	
	@Override
	public void showContents() {
		program.add(CtrlBackgroundImage);
		program.add(title);
		program.add(controls);
		program.add(menuB);
		program.add(guideB);
		program.add(explanation1);
		program.add(explanation2);
		program.add(explanation3);
		program.add(explanation4);
		program.add(explanation5);
		program.add(explanation6);
	}

	@Override
	public void hideContents() {
		program.remove(CtrlBackgroundImage);
		program.remove(title);
		program.remove(controls);
		program.remove(menuB);
		program.remove(guideB);
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
