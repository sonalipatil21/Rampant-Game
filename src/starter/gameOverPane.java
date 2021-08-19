package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
public class gameOverPane extends GraphicsPane {
	private MainApplication program;
	
	GImage GameOverBackgroundImage = new GImage("GameOverBackground.jpg", 0, 0);
	
	private GButton restart, exit, leaderboard;
	private GParagraph gameOver;	
	
	public gameOverPane(MainApplication app) {
		super();
		this.program = app;
		gameOver = new GParagraph("Game Over", 170, 200);
		gameOver.setFont("Arial-90");
		gameOver.setColor(Color.RED);
		restart = new GButton("Play Again", 250, 290, 300, 100, Color.ORANGE);
		leaderboard = new GButton("Leaderboard", 250, 410, 300, 100, Color.YELLOW);
		exit = new GButton("Main Menu", 250, 530, 300, 100, Color.ORANGE);
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(GameOverBackgroundImage);
		program.add(gameOver);
		program.add(restart);
		program.add(leaderboard);
		program.add(exit);
		program.resetGame();
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(GameOverBackgroundImage);
		program.remove(gameOver);
		program.remove(restart);
		program.remove(leaderboard);
		program.remove(exit);
		
	}
	
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());

		if (obj == restart)
		{

			program.switchToGame();

			program.switchToUsername();
		}
		else if (obj == leaderboard)
		{
			program.switchToLeaderbd();
		}
		else if (obj == exit)
		{
			program.switchToMenu();	
		}
	}

	
}