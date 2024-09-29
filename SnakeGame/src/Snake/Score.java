package Snake;

import java.util.ArrayList;

public class Score {
	private int score = 0;
	private int prevScore = 0;
	private int level = 1;
	
	public Score() {}
	
	public void increaseScore(int amount, Food f, Tile[][] map, int rowNum, int size, ArrayList<snakeSegment> s) {
		for (int i = 0; i < amount; i++) {
			score++;
			if (score != 0 && score % 10 == 0) {
				level++;
				f.generateBomb(map, rowNum, size, s);
			}
		}
	}
	
	public void resetScore() {
		score = 0;
	}
	
	public void resetLevel() {
		level = 1;
	}
	
	public int returnScore() {
		return score;
	}
	
	public int returnLevel() {
		return level;
	}
}
