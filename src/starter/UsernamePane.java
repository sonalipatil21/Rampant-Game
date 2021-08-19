package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import acm.graphics.GImage;
import acm.graphics.GObject;


public class UsernamePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
							// all of the GraphicsProgram calls
	GImage BackgroundImage = new GImage("OtherBackgrounds.jpg", 0, 0);
	
	private GButton contdButton;
	private GButton ERROR = new GButton("USERNAME MUST BE LESS THAN 7 CHARACTERS",250,250,300,50,Color.RED);
	private GParagraph title;
	private char user[];
	private int count;
	private GButton usernm;
	private String wumbo;
	public UsernamePane(MainApplication app) {
		this.program = app;
		contdButton = new GButton("Continue", 250, 480, 300, 100);
		contdButton.setFillColor(Color.GREEN);
		title = new GParagraph("Username",300, 50);
		title.setFont("Arial-46");
		user = new char[7];
		count=0;
		wumbo = "";
		usernm= new GButton(wumbo,300,325,200,50);
	} 

	@Override
	public void showContents() {
		program.add(BackgroundImage);
		program.add(contdButton);
		program.add(title);
		program.add(usernm);
	}

	@Override
	public void hideContents() {
		program.remove(BackgroundImage);
		program.remove(contdButton);
		program.remove(title);
		program.remove(usernm);
		program.remove(ERROR);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		 if (obj == contdButton){
				SettingsPane sett = program.getSettingsPane();
				if (sett.getPopUp())
					program.switchToGuide();
				else
					program.switchToGame();
			}
		 if (obj == ERROR) {
			 program.remove(ERROR);
		 }
		}
	@Override
	public void keyPressed(KeyEvent e) {
		char temp = e.getKeyChar();
		if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && count <=6 && e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
				user[count]=temp;
				count++;
				wumbo = "";
				for(int i = 0; i<7; i++) {
					wumbo += user[i];
				}
			}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			if(count>0) {
					count--;
					user[count]=' ';
					wumbo = "";
					for(int i= 0; i<7; i++) {
						wumbo += user[i];
					}
				}
			}
		
		else if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			program.add(ERROR);
		}
		program.remove(usernm);
		usernm= new GButton(wumbo,300,325,200,50);
		program.add(usernm);		
		}
	public String getUsername() {
		return wumbo;
		}
	}
	
