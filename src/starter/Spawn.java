package starter;
import acm.util.RandomGenerator;
import java.awt.Color;
import acm.graphics.*;

public class Spawn {
	
	private RandomGenerator rgen;
	private int spawnRate;
	public GRect[] spawnZone = new GRect[4];
	
	// Constructor for the class, rate starts at zero.
	// Spawn zones are in a clockwise circle, each corner reading 0 1 2 3
	public Spawn() {
		rgen  = new RandomGenerator();
		spawnRate = 0;	
		spawnZone[0] = new GRect(0,0,20,20);
		spawnZone[1] = new GRect(780,0,20,20);
		spawnZone[2] = new GRect(780,680,20,20);
		spawnZone[3] = new GRect(0,680,20,20);
		spawnTrait();
	}
	
	public GRect[] getSpawns() {
		return spawnZone;
	}
	// Getter for the spawn rate, may be helpful later on.
	int getSpawnRate() {
		return spawnRate;		
	}
	
	public GRect getRandomZone() {
		return spawnZone[rgen.nextInt(4)];
	}
	
	public int findZoneNumber(GRect zone) {
		if (zone == spawnZone[0])
			return 0;
		else if (zone == spawnZone[1])
			return 1;
		else if (zone == spawnZone[2])
			return 2;
		else if (zone == spawnZone[3])
			return 3;
		return 0;
	}
	
	/* Calculates Spawn rate for a certain level (input).*/
	public void calculateSR(int levelNum) {
		spawnRate = (int) (levelNum*1.5 + rgen.nextInt(1,3)); 
	}
	
	// Makes the spawn zones have color, for early visual purposes
	private void spawnTrait() {
		for (int i  = 0; i < 4; i++) {
			spawnZone[i].setFillColor(Color.GREEN);
			spawnZone[i].setFilled(true);
		}
	}
}