package starter;


public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 700;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "New_Hanover_Ambience.mp3" , "Lancer - Deltarune OST.mp3" };
	

	private Player player;
	private SomePane pane;
	private MenuPane menu;
	private GuidePane guide;
	private SettingsPane sett;
	private LeaderboardPane ldbrd;
	private PowerupPane powerUp;
	private ControlsPane controls;
	private UsernamePane username;
	private levelPane game;
	private gameOverPane gameOver;
	private int count;
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}
	
	public SettingsPane getSettingsPane() {
		return sett;		
	}
	
	public void run() {
		
		System.out.println("Hello, world!");
		menu = new MenuPane(this);
		pane = new SomePane(this);
		guide = new GuidePane(this);
		sett = new SettingsPane(this);
		ldbrd = new LeaderboardPane(this);
		powerUp = new PowerupPane(this);
		controls = new ControlsPane(this);
		username = new UsernamePane(this);
		game = new levelPane(this);
		gameOver = new gameOverPane(this);
		switchToMenu();
	}

	public void switchToMenu() {
		count++;
		switchToScreen(menu);
	}
	public void switchToGuide() {
		count++;
		switchToScreen(guide);
	}
	public void switchToGame() {
		count++;
		playRandomSound();
		switchToScreen(game);
	}
	public void switchToSome() {
		switchToScreen(pane);
	}
	public void switchToSettings() {
		switchToScreen(sett);
	}
	public void switchTo() {
		switchToScreen(player);
	}
	public void switchToLeaderbd() {
		switchToScreen(ldbrd);
	}
	public void switchToPowerUp() {
		switchToScreen(powerUp);
	}
	public void switchToControls() {
		switchToScreen(controls);
	}
	public void switchToUsername() {
			if (!game.played) {
			switchToScreen(username);}
			else switchToGame();
	}
	public void switchToGameOver() {
		switchToScreen(gameOver);
	}
	private void playRandomSound() {
		
		AudioPlayer audio = AudioPlayer.getInstance();
		double vol = sett.getVolumeLevel();
		audio.setVolume(vol);
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[1], true);//test
	}
	public void resetGame() {
		username = new UsernamePane(this);
		game = new levelPane(this);
	}
	public int getWINDOW_WIDTH() {
		return WINDOW_WIDTH;
	}
	
	public int getWINDOW_HEIGHT() {
		return WINDOW_HEIGHT;
	}
}
