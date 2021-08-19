package starter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Leaderboard {
	int board[];
	String players[];
	int ct = 0;
	int min;
	int max;
	File Leader;
	public Leaderboard() {
		board = new int[10];
		players = new String[10];
		Leader = new File("path");
		if(!Leader.exists()) {
			try {
				Leader.createNewFile();
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	void newEntry(int score, String name) {
		//read Leader add scores to board and usernames to players
		min = board[0];
		max = board[10];
		for(int i = 0; i < 10; i++) {
			if (score > board[i]&& score<board[i+1]) {
				board[i]=score;
				players[i]= name;
			}
		}
		//Write board and players to Leader
	}
	int getMin() {
		return min;
	}
	void addToBoard() {
		
	}
}