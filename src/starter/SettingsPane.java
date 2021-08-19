package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SettingsPane extends GraphicsPane {
	
	public static final int NUM_VOLUME_LEVELS = 6;
	
	private MainApplication program; // you will use program to get access to
						// all of the GraphicsProgram calls
	
	GImage SettingsBackgroundImage = new GImage("OtherBackgrounds.jpg", 0, 0);
	private GParagraph title, popUps, volumeLabel;
	private GButton menuB, On, Off;
	private ArrayList<GButton> volumeWave;
	private boolean popUpOn = true;
	private int volumeLevel = 2;

	public SettingsPane(MainApplication app) {
		super();
		this.program = app;
		title = new GParagraph("Settings", 350, 50);
		title.setFont("Arial-46");
		menuB = new GButton("Back to Menu", 315, 450, 200, 100);
		menuB.setFillColor(Color.RED);
		On = new GButton("On", 500, 150, 70, 50);
		On.setFillColor(Color.YELLOW);
		Off = new GButton ("Off", 400, 150, 70, 50);
		Off.setFillColor(Color.YELLOW);
		popUps = new GParagraph("Instructions Pop-up:", 150, 180);
		popUps.setFont("Arial-25");
		volumeLabel = new GParagraph("Volume:", 150, 280);
		volumeLabel.setFont("Arial-25");
		
		volumeWave = new ArrayList<GButton>();
		for (int level = 0; level < NUM_VOLUME_LEVELS; level++) {
			GButton vol = new GButton("",300 + level * 40, 250, 30, 50);
			vol.setFillColor((level < volumeLevel) ? Color.YELLOW : Color.LIGHT_GRAY);
			volumeWave.add(vol); 
		}
	}
	
	public boolean getPopUp() {
		return popUpOn;
	}

	public double getVolumeLevel() {
		return volumeLevel / (NUM_VOLUME_LEVELS * 1.0);
	}
	
	@Override
	public void showContents() {
		program.add(SettingsBackgroundImage);
		program.add(title);
		program.add(menuB);
		program.add(On);
		program.add(Off);
		program.add(popUps);
		program.add(volumeLabel);
		for(GButton vol: volumeWave)
			program.add(vol);
	}

	@Override
	public void hideContents() {
		program.remove(SettingsBackgroundImage);
		program.remove(title);
		program.remove(menuB);
		program.remove(On);
		program.remove(Off);
		program.remove(popUps);

		for(GButton vol: volumeWave)
			program.remove(vol);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menuB) {
			program.switchToMenu();
		}
		else if (obj == On) {
			On.setFillColor(Color.GRAY);
			Off.setFillColor(Color.YELLOW);
			popUpOn = true;
		}
		else if (obj == Off) {
			Off.setFillColor(Color.GRAY);
			On.setFillColor(Color.YELLOW);
			popUpOn = false;
		}
		else {

			for(int level = 1; level <= NUM_VOLUME_LEVELS; level++) {
				if (obj == volumeWave.get(level-1)) {
	
					if (volumeLevel == 1 && level == 1) {
						volumeLevel = 0;
						level = -1;
					}
					else {
						volumeLevel = level;						
					}
					// Set yellow color till the clicked index
					for (int j = 0; j < NUM_VOLUME_LEVELS; j++) {
						GButton vol = volumeWave.get(j);
						vol.setFillColor((j < level) ? Color.YELLOW : Color.LIGHT_GRAY);
					}
					break;
				}
			}
		}
	}
}