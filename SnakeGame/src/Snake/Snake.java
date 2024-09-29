package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import utilities.GDV5;

public class Snake{
	private int velocityX = 0;
	private int velocityY = 0;
	private ArrayList<snakeSegment> snakeArray = new ArrayList<snakeSegment>();
	private int tempTailCount = 0;
	private boolean deathSoundCheck = true;
	private boolean bombDeathSoundCheck = true;
	
	public Snake(int initialVelocityX) {
		velocityX = initialVelocityX;
	}
	
	public void spawnSnake(int size) {
		int x = 370;
		for (int i = 0; i < 3; i++) {
			snakeArray.add(new snakeSegment(x, 444, size, size));
			snakeArray.get(i).setIndex(i);
			x += size;
		}
		snakeArray.get(0).makeHead();
		snakeArray.get(snakeArray.size()-1).makeTail();
	}
	
	public void snakeMove(int size) {
		//snakeArray.get(snakeArray.size()-2).notTail(); //we must wait to draw a new tail to prevent overlapping tails. We keep the old tail drawn until the first move statement after the new tail's creation, which gives the new tail a proper prevX value [preventing overlap] and allows us to now undraw the old tail [which this line does] {after the creation of the new tail, the old tail is now index size-2 indtead of index size-1}
	
		if (tempTailCount > 0) {
			snakeArray.get(snakeArray.size()-1-tempTailCount).notTail();
			tempTailCount --;
		}
		
		for (int i = snakeArray.size()-1; i > 0; i--) {
			snakeArray.get(i).setX(snakeArray.get(i-1).returnX());
			snakeArray.get(i).setY(snakeArray.get(i-1).returnY());
		}
		snakeArray.get(0).updateX(velocityX);
		snakeArray.get(0).updateY(velocityY);
	}
	
	public void setSnakeDirection(int size) {
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT] && velocityX != size && !GDV5.KeysPressed[KeyEvent.VK_RIGHT] && !GDV5.KeysPressed[KeyEvent.VK_UP] && !GDV5.KeysPressed[KeyEvent.VK_DOWN]) { //have other key conditionals to help prevent multiple keys from being registered at the same time/in the same loop/cycle
			velocityX = -size;
			velocityY = 0;
			return; //return was to help prevent multiple keys from being registered at the same time/in the same loop -- with the additional key conditionals it seems that this isn't necessary anymore (the problem wasn't multiple if statements running in the same setSnakeDirection cycle, but multiple keys being registered at the same time? (honestly idk lol)
		}
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT] && velocityX != -size && !GDV5.KeysPressed[KeyEvent.VK_LEFT] && !GDV5.KeysPressed[KeyEvent.VK_UP] && !GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
			velocityX = size;
			velocityY = 0;
			return;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_UP] && velocityY != size && !GDV5.KeysPressed[KeyEvent.VK_DOWN] && !GDV5.KeysPressed[KeyEvent.VK_LEFT] && !GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
			velocityY = -size;
			velocityX = 0;
			return;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_DOWN] && velocityY != -size && !GDV5.KeysPressed[KeyEvent.VK_UP] && !GDV5.KeysPressed[KeyEvent.VK_LEFT] && !GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
			velocityY = size;
			velocityX = 0;
			return;
		}
	}
	
	public void growSnake(Tile[][] map, Food f, Sound sd, Score sc, int rowNum, int size, ArrayList<snakeSegment> s) {
		for (int j = 0; j < rowNum; j++) {
			for (int i = 0; i < rowNum; i++) {
				if (snakeArray.get(0).intersects(map[j][i]) && map[j][i].isApple()) {
					//snakeArray.get(snakeArray.size()-1).notTail();
					snakeArray.add(new snakeSegment(snakeArray.get(snakeArray.size()-1).returnX(), snakeArray.get(snakeArray.size()-1).returnY(), size, size));
					snakeArray.get(snakeArray.size()-1).setIndex(snakeArray.size()-1);
					snakeArray.get(snakeArray.size()-1).makeTail();
					tempTailCount += 1;
					map[j][i].removeFood();
					f.resetFood(map, rowNum, size, snakeArray);
					sc.increaseScore(1, f, map, rowNum, size, s);
					sd.appleCrunch(false);
				}
				
				if (snakeArray.get(0).intersects(map[j][i]) && map[j][i].isGoldenApple()) {
					snakeArray.add(new snakeSegment(snakeArray.get(snakeArray.size()-1).returnX(), snakeArray.get(snakeArray.size()-1).returnY(), size, size));
					snakeArray.get(snakeArray.size()-1).setIndex(snakeArray.size()-1);
					snakeArray.get(snakeArray.size()-1).makeTail();
					tempTailCount += 1;
					map[j][i].removeFood();
					f.goldenResetFood(map, rowNum, size, snakeArray);
					sc.increaseScore(1, f, map, rowNum, size, s);
					sd.goldenAppleCrunch(false);
				}
				
				if (snakeArray.get(0).intersects(map[j][i]) && map[j][i].isTaco()) {
					for (int z = 0; z < 3; z++) {
						snakeArray.add(new snakeSegment(snakeArray.get(snakeArray.size()-1).returnX(), snakeArray.get(snakeArray.size()-1).returnY(), size, size));
						snakeArray.get(snakeArray.size()-1).setIndex(snakeArray.size()-1);
						snakeArray.get(snakeArray.size()-1).makeTail();
					}
					tempTailCount += 3;
					map[j][i].removeFood();
					f.resetFood(map, rowNum, size, snakeArray);
					sc.increaseScore(3, f, map, rowNum, size, s);
					sd.tacoBell(false);
				}
			}
		}
	}
	
	public boolean checkRegDeath(int size, Sound sd) {
		boolean dead = false;
		snakeSegment head = snakeArray.get(0);
		if (head.returnX() <= 0 || head.returnX() >= GDV5.getMaxWindowX()-size) {
			dead = true;
		}
		if (head.returnY() <= (size*2) || head.returnY() >= GDV5.getMaxWindowY()-size) {
			dead = true;
		}
		
		for (snakeSegment snakeSeg : snakeArray) {
			if (head.returnHeadDirection() != null && snakeSeg != head) { //need to check headDirection because this can only run after the snake has moved to prevent false output when the segments initially overlap, and headDirection is != only after the snake moves
				if (head.returnX() == snakeSeg.returnX() && head.returnY() == snakeSeg.returnY()) {
					dead = true;
				}
			}
		}
		
		if (dead) {
			if (deathSoundCheck) sd.deathSound(false);
			deathSoundCheck = false;
			return true;
		}
		return false;
	}
	
	public boolean checkBombDeath(Tile[][] map, Sound sd, int size, int rowNum) {
		boolean bombDead = false;
		snakeSegment head = snakeArray.get(0);
		
		for (int j = 0; j < rowNum; j++) {
			for (int i = 0; i < rowNum; i++) {
				if (map[j][i].isBomb()) {
					if (head.intersects(map[j][i])) {
						bombDead = true;
						map[j][i].removeFood();  
					}
				}
			}		
		}
		
		if (bombDead) {
			if (bombDeathSoundCheck) sd.explosionDeathSound(false);
			bombDeathSoundCheck = false;
			return true;
		}
		return false;
	}
	
	public void respawnSnake(int size) {
		for (int i = 0; i < snakeArray.size(); i++) {
			snakeArray.clear();
		}
		velocityX = 0;
		velocityY = 0;
		spawnSnake(size);
	}
	
	public void makeDeathSoundCheckTrue() {
		deathSoundCheck = true;
	}
	
	public void makeBombDeathSoundCheckTrue() {
		bombDeathSoundCheck = true;
	}
	
	public ArrayList<snakeSegment> returnSnakeArray(){
		return snakeArray;
	}
}
