package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.*;

public class SomePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GParagraph para;
	private Enemy enemy;
	
	public SomePane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Click the\nshooter\nto go back to\n the menu.", 150, 300);
		para.setFont("Arial-24");
		enemy = new Enemy(10,20);
		
	} 

	@Override
	public void showContents() {
		program.add(para);
	}

	@Override
	public void hideContents() {
		program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		 if (obj != null){
				program.switchToMenu();
				}
		}
}