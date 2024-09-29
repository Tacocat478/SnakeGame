package Snake;

import java.util.ArrayList;

public class Food {
	public Food() {}
	
	public Tile generateValidTile(Tile[][] map, int rowNum, int size, ArrayList<snakeSegment> s) {
		boolean checkOne = false, checkTwo = true;
		int randNumOne = 0, randNumTwo = 0; //will be reinitialized after the (guarenteed) first loop anyways
		while (!checkOne || !checkTwo) {
			randNumOne = (int)(Math.random()*rowNum);
			randNumTwo = (int)(Math.random()*rowNum);
			if (!map[randNumOne][randNumTwo].isApple() && !map[randNumOne][randNumTwo].isGoldenApple() && !map[randNumOne][randNumTwo].isTaco() && !map[randNumOne][randNumTwo].isBomb()) checkOne = true;
			checkTwo = true;
			for (snakeSegment ss : s) {
				if (map[randNumOne][randNumTwo].returnX() == ss.returnX() && map[randNumOne][randNumTwo].returnY() == ss.returnY()) checkTwo = false;
			}
		}
		return map[randNumOne][randNumTwo];
	}
	
	public boolean validTile(Tile[][] map, int j, int i, int size, ArrayList<snakeSegment> s) {
		boolean checkOne = false, checkTwo = true;
		if (!map[j][i].isApple() && !map[j][i].isGoldenApple() && !map[j][i].isTaco() && !map[j][i].isBomb()) checkOne = true;
		for (snakeSegment ss : s) {
			if (map[j][i].returnX() == ss.returnX() && map[j][i].returnY() == ss.returnY()) checkTwo = false;
		}
		if (checkOne && checkTwo) return true;
		return false;
	}
	
	public void resetFood(Tile[][] map, int rowNum, int size, ArrayList<snakeSegment> s) {
		boolean noFood = false;
		
		for (int j = 0; j < rowNum; j++) {
			for (int i = 0; i < rowNum; i++) {
				if (map[j][i].isApple()) {
					noFood = true;
				}
			}
		}
		if (noFood) return;
		
		generateValidTile(map, rowNum, size, s).makeApple();
		if ((int)(Math.random()*100) < 25) generateValidTile(map, rowNum, size, s).makeGoldenApple();
		if ((int)(Math.random()*100) < 25) generateValidTile(map, rowNum, size, s).makeTaco();
	}
	
	public void goldenResetFood(Tile[][] map, int rowNum, int size, ArrayList<snakeSegment> s) {
		for (int j = 0; j < rowNum; j++) {
			for (int i = 0; i < rowNum; i++) {
				if ( ((int)(Math.random()*100) + 1 < 3) && validTile(map, j, i, size, s)) {
					if ((int)(Math.random()*100) + 1 < 3) map[j][i].makeTaco();
					else map[j][i].makeApple();
				}
			}
		}
	}
	
	public void generateBomb(Tile[][] map, int rowNum, int size, ArrayList<snakeSegment> s) {
		generateValidTile(map, rowNum, size, s).makeBomb();
	}
	
	public void clearBoard(Tile[][] map, int rowNum, int size) {
		for (int j = 0; j < rowNum; j++) {
			for (int i = 0; i < rowNum; i++) {
				map[j][i].removeFood();
			}		
		}
	}
	
	
	
}
