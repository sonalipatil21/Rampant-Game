package starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.*;
import acm.graphics.*;
import starter.Item.Type;

import javax.swing.Timer;

public class levelPane extends GraphicsPane implements ActionListener {

	private MainApplication game;
	GImage GameBackgroundImage = new GImage("GameBackground.jpg", 0, 0);
	
	private ArrayList<Enemy> enemyWave;
	private int levelNum, coins;
	private Spawn spawnZone;
	private Boss waveBoss;
	private Player player;
	private Timer enemyTimer;
	private Objective GunLegs;
	private GLabel livesCount, enemiesCount, levelCount, coinCount;
	private Shop shop;
	private GButton dbShot, invinc, burst, dbScore, up1, showShop, pause, PopUp, exit;
	public static int currentItem = -1;
	private static Timer pUpTimer1;
	private static Timer pUpTimer4;
	int count = 1;
	public boolean played;
	public levelPane(MainApplication app) {

		this.game = app;
		shop = new Shop();
		showShop = new GButton("Shop", 355, 0, 100, 50);
		showShop.setFillColor(Color.GREEN);
		dbShot = new GButton("Double Shot-20", 150, 600, 100, 50);
		dbShot.setFillColor(Color.yellow);
		dbShot.setVisible(false);
		invinc = new GButton("Invincibility-30", 260, 600, 100, 50 );
		invinc.setFillColor(Color.yellow);
		invinc.setVisible(false);
		burst = new GButton("Burst Fire-30", 370, 600, 100, 50);
		burst.setFillColor(Color.yellow);
		burst.setVisible(false);
		dbScore = new GButton("Double Score-50", 480, 600, 100, 50);
		dbScore.setFillColor(Color.yellow);
		dbScore.setVisible(false);
		up1 = new GButton("1 Up-50", 590, 600, 100, 50);
		up1.setFillColor(Color.yellow);
		up1.setVisible(false);
		
		levelNum = 1;
		coins = 0;
		GunLegs = new Objective();
		spawnZone = new Spawn();
		enemyWave = new ArrayList<Enemy>();	
		player = new Player(game, this);
		enemyWave = new ArrayList<Enemy>();	
		enemyTimer= new Timer(100, this);
		pause = new GButton("pause", 700, 550, 100, 50, Color.GREEN);
		exit = new GButton("Exit", 700, 450, 100, 50, Color.GREEN);
		PopUp= new GButton("NEXT LEVEL", 350, 300, 100, 100, Color.GREEN); 
		
		livesCount = new GLabel("",35,12);
		enemiesCount = new GLabel("",160,12);
		levelCount = new GLabel("",500,12);
		levelCount.setColor(Color.GREEN);
		livesCount.setColor(Color.GREEN);
		enemiesCount.setColor(Color.GREEN);
		
		coinCount = new GLabel("",600,12);
		coinCount.setColor(Color.GREEN);
		//displayRefresh = new Timer(500,this);
		
		pUpTimer1 = new Timer(10000, this);
		pUpTimer1.setRepeats(false);
		pUpTimer4 = new Timer(30000, this);
		pUpTimer4.setRepeats(false);
		
		
	}
	
	private int getLevelNum() {
		return levelNum;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}
	
	@Override
	public void showContents() {
		game.add(GameBackgroundImage);
		game.add(pause);
		game.add(exit);
		game.add(GunLegs.objective);
		
		game.add(livesCount);
		game.add(enemiesCount);
		game.add(levelCount);
		game.add(coinCount);
		
		game.add(showShop);
		game.add(dbShot);
		game.add(invinc);
		game.add(burst);
		game.add(dbScore);
		game.add(up1);
		
		player.showContents();
		playLevel();
	}
	
	@Override
	public void hideContents() {
		game.remove(showShop);
		game.remove(GameBackgroundImage);
		game.remove(pause);
		game.remove(exit);
		game.remove(GunLegs.objective);
		
		game.remove(enemiesCount);
		game.remove(livesCount);
		game.remove(levelCount);
		game.remove(coinCount);
		
		game.remove(dbShot);
		game.remove(invinc);
		game.remove(burst);
		game.remove(dbScore);
		game.remove(up1);
		player.hideContents();
	}
	
	private void callSpawnRate(int levelN) {
		spawnZone.calculateSR(levelN);
	}
	
	public ArrayList<Enemy> getEnemyWave() {
		return enemyWave;
	}
	
	public void removeEnemy(Enemy enemy) {
		enemyWave.remove(enemy);
	}
	
	public Boss getBoss() {
		return waveBoss;
	}
	
	/* This function will create the enemy entities. However they only exist as JAVA entities and not visual ones.
	   The tmpEnemy is the enemy that is being added to the enemyWave arraylist. */
	private void spawnEnemies(int spawnRate, GRect zone) {

		for (int i  = 0; i < spawnRate; i++) {
			GRect tmpZone = spawnZone.getRandomZone();
			Enemy tmpEnemy = new Enemy((int)tmpZone.getX(),(int)tmpZone.getY());
			tmpEnemy.setSpawnLocation(spawnZone.findZoneNumber(tmpZone));
			enemyWave.add(tmpEnemy);
		}
		System.out.println(spawnRate);
	}
	
	private void spawnBoss() {
		if (count == 1) {
			game.add(waveBoss.bossSprite);
		}
		else if (waveBoss.isDead()) {
			levelNum++;
			enemyTimer.stop();
			shop = new Shop();
			up1.setFillColor(Color.yellow);
			invinc.setFillColor(Color.yellow);
			dbShot.setFillColor(Color.yellow);
			dbScore.setFillColor(Color.yellow);
			burst.setFillColor(Color.yellow);
			game.add(PopUp);
		}
		else {
			waveBoss.move(levelNum);
		}
	}
	
	private boolean checkWave() {
			return enemyWave.isEmpty();
	}
	
	private boolean checkBoss() {
		return (waveBoss.isDead());
	}
	
	public boolean intersects(GObject rect, GObject oval) {
	    double x = Math.abs(oval.getX() - rect.getX());
	    double y = Math.abs(oval.getY() - rect.getY());
	
	    if (x > (rect.getWidth()/2 + oval.getWidth()/2))   { return false; }
	    if (y > (rect.getHeight()/2 + oval.getHeight()/2)) { return false; }
	
	    if (x <= (rect.getWidth()/2))  { return true; } 
	    if (y <= (rect.getHeight()/2)) { return true; }
	
	    double sq = Math.pow(x - rect.getWidth()/2, 2) + Math.pow(y - rect.getHeight()/2, 2);
	
	    return (sq <= Math.pow(oval.getWidth()/2, 2));
	}	

	public boolean isCollided(GOval bullet) {

		if (enemyWave.isEmpty()) {
			if (!waveBoss.isDead() && intersects(waveBoss.bossSprite, bullet)) {
				waveBoss.takeDamage();
				if (waveBoss.isDead()) {
					if(isRunning())
						coins+=12;
					else
						coins += 6;
				}
				return true;
			}
		} else {
		
			for(Enemy enemy: enemyWave) {
				if (!enemy.isDead() && intersects(enemy.foe, bullet)) {
					enemy.takeDamage();
					if (enemy.isDead()) {
						enemyWave.remove(enemy);
						if(isRunning())
							coins+=6;
						else
							coins += 3;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	// This level is the workhorse of the class and the game. It is charged with spawning
	// the enemies and will handle the creation of the player entity and it's functions. 
	// The game screen relies on this program.
	private void playLevel() {

		count = 1;
		this.callSpawnRate(levelNum);
		int SR = spawnZone.getSpawnRate();
		waveBoss = new Boss(levelNum);
		spawnEnemies(SR, spawnZone.getRandomZone());
		for(Enemy tempEnemy:enemyWave) {
			tempEnemy.setVelocity(levelNum);
			game.add(tempEnemy.foe);
		}
		System.out.println(enemyWave);
		enemyTimer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Action Performed, tick rate 100 ms");
		if (GunLegs.isDead()) {
			System.out.println("Objective Destroyed.... Game over!");
			enemyTimer.stop();
			game.switchToGameOver();
			return;
		}
		
		if (checkWave()) {
			spawnBoss();
			count++;
		}
		
		if (!waveBoss.isDead() && intersects(waveBoss.bossSprite, GunLegs.objective)) {
			GunLegs.takeDamage();
			waveBoss.takeDamage();
			waveBoss.thetaOpposite();
		}
		
		for(Enemy singleEnemy: enemyWave) {
			singleEnemy.move();
			if(!singleEnemy.isDead() && intersects(singleEnemy.foe, GunLegs.objective)) {
				singleEnemy.makeDead();
				GunLegs.takeDamage();
				if (singleEnemy.isDead()) {
					enemyWave.remove(singleEnemy);
					break;
				}
			}
		}
		
		enemiesCount.setLabel("Enemies left in the Wave : " + enemyWave.size());	
		livesCount.setLabel("Lives Remaining: " + GunLegs.getLives());
		levelCount.setLabel("Level: " + levelNum);
		coinCount.setLabel("Coins: " + coins);
	}
		
	public static void startTimer() {
		pUpTimer1.start();
	}
	public static boolean isRunning() {
		return pUpTimer1.isRunning();
	}
	public static void startTimer4() {
		pUpTimer4.start();
	}
	public static boolean isRunning4() {
		return pUpTimer4.isRunning();
	}
	
	public void mousePressed(MouseEvent e) {
		
		GObject obj = game.getElementAt(e.getX(), e.getY());
		if (obj == pause){  									// pause button 
			played=true;
			enemyTimer.stop();
			game.switchToMenu();

		} 
		else if(obj == PopUp) {
			game.remove(PopUp);
			playLevel();
		}
		else if (obj == exit) {
			enemyTimer.stop();
			game.switchToGameOver();
		}
		else if(obj == showShop) {
			if(!dbShot.isVisible()) {
				dbShot.setVisible(true);
				invinc.setVisible(true);
				burst.setVisible(true);
				dbScore.setVisible(true);
				up1.setVisible(true);
			}
			else {
				dbShot.setVisible(false);
				invinc.setVisible(false);
				burst.setVisible(false);
				dbScore.setVisible(false);
				up1.setVisible(false);
			}
		}
		else if(obj == dbShot) {
			if(dbShot.isVisible()) {
				if(shop.buyItem(Type.DOUBLESHOT, coins)) {
					dbShot.setFillColor(Color.GRAY);
					currentItem = 0;
					coins-=20;
				}
			}
		}
		else if(obj == invinc) {
			if(invinc.isVisible()) {
				if(shop.buyItem(Type.IVINC, coins)) {
					invinc.setFillColor(Color.GRAY);
					currentItem = 4;
					coins-=30;
				}
			}
		}
		else if(obj == dbScore) {
			if(dbScore.isVisible()) {
				if(shop.buyItem(Type.DOUBLESCORE, coins)) {
					dbScore.setFillColor(Color.GRAY);
					currentItem = 1;
					coins-=50;
				}
			}
		}
		else if(obj == burst) {
			if(burst.isVisible()) {
				if(shop.buyItem(Type.BURST, coins)) {
					burst.setFillColor(Color.GRAY);
					currentItem = 2;
					coins-=30;
				}
			}
		}
		else if(obj == up1) {
			if(up1.isVisible()) {
				if(shop.buyItem(Type.UP1, coins)){
					up1.setFillColor(Color.GRAY);
					GunLegs.addLife();
					coins-=50;
				}
			}
		}
	}
}