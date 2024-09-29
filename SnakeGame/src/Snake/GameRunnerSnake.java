package Snake;


import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import utilities.GDV5;

public class GameRunnerSnake extends GDV5{
	private Tile[][] map;
	private int numTiles = 289;
	private int rowNum = (int)Math.sqrt(numTiles);
	private int size = 37; //GDV5.getMaxWindowX() / rowNum;
	private boolean snakeDead = false; //should be false
	private boolean drawStarBurst = false;
	private boolean drawBombExplosion = false;
	private int drawBurstCount = 0;
	private int drawBombExplosionCount = 0;
	private int speed;
	private Color lightBlue = new Color(157,235,242);
	private Color darkerBlue = new Color(157,227,242);
	private boolean colorSwitch = true;
	private int count;
	private Snake s = new Snake(0);
	private Images i = new Images();
	private Food f = new Food();
	private Splash screen = new Splash();
	private Sound sd = new Sound();
	private Score sc = new Score();
	
	public GameRunnerSnake() {
		int x = size, y = size*3;
		map = new Tile[rowNum][rowNum];
		for (int j = 0; j<rowNum; j++) {
			x = size;
			for (int i = 0; i<rowNum; i++) {
				if (colorSwitch) map[j][i] = new Tile(x,y,size,size, lightBlue);
				if (!colorSwitch) map[j][i] = new Tile(x,y,size,size, darkerBlue);
				colorSwitch = !colorSwitch;
				x += size;
			}
			y += size;
		}
		s.spawnSnake(size);
		f.resetFood(map, rowNum, size, s.returnSnakeArray());
	}
	
	public static void main(String[] args) {
		GameRunnerSnake g = new GameRunnerSnake();
		g.start();
	}
	
	public void pause() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		screen.changeScreen(map, sd, sc, s, f, snakeDead, drawStarBurst, drawBombExplosion, size, rowNum, s.returnSnakeArray());
		if (screen.getScreenSetting().equals("splash")) speed = screen.returnSpeed();
		if (screen.getScreenSetting().equals("play")) {
			if (s.checkRegDeath(size, sd)) { //duplicate but for checkBombDeath
				snakeDead = true; drawStarBurst = true; 
			}
			if (s.checkBombDeath(map, sd, size, rowNum)) {
				snakeDead = true; drawBombExplosion = true;
			}
			s.setSnakeDirection(size);
			if (count >= speed && !snakeDead) { //7
				s.snakeMove(size); count = 0;
			}
			count++;
			s.growSnake(map, f, sd, sc, rowNum, size, s.returnSnakeArray());
		}
		if (screen.getScreenSetting().equals("gameOver")) snakeDead = false;
	}
 
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		if (screen.getScreenSetting().equals("gameOver")) {
			screen.drawGameOverScreen(win, sc);
		}
		
		if (screen.getScreenSetting().equals("splash")) {
			screen.drawSplashScreen(win);
		}
		
		if (screen.getScreenSetting().equals("play")) {
			screen.drawPlayScreen(win, map, sc, size);
			for (snakeSegment snakeSeg : s.returnSnakeArray()) {
				snakeSeg.draw(win, s.returnSnakeArray());
			}
			
			if (drawStarBurst) {
				snakeSegment head = s.returnSnakeArray().get(0);
				int pause = 50, burstWidth = 125, burstHeight = 125, xShift = -42, yShift = -42;
				if (drawBurstCount <= pause*0.5) win.drawImage(Images.starBurst1, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBurstCount <= pause)win.drawImage(Images.starBurst2, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBurstCount <= pause*3)win.drawImage(Images.starBurst3, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBurstCount <= pause*4)win.drawImage(Images.starBurst4, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBurstCount <= pause*5)win.drawImage(Images.starBurst5, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBurstCount <= pause*6)win.drawImage(Images.starBurst6, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);		
				else if (drawBurstCount <= pause*7)win.drawImage(Images.starBurst7, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);		
				else if (drawBurstCount <= pause*8)win.drawImage(Images.starBurst8, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				drawBurstCount++;
				if (drawBurstCount >= pause*8) {
					drawBurstCount = 0;
					drawStarBurst = false;
				}
			}
			
			if (drawBombExplosion) {
				snakeSegment head = s.returnSnakeArray().get(0);
				int pause = 50, burstWidth = 125, burstHeight = 125, xShift = -42, yShift = -42;
				if (drawBombExplosionCount <= pause*0.5) win.drawImage(Images.explosion1, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBombExplosionCount <= pause)win.drawImage(Images.explosion2, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBombExplosionCount <= pause*3)win.drawImage(Images.explosion3, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBombExplosionCount <= pause*4)win.drawImage(Images.explosion4, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBombExplosionCount <= pause*5)win.drawImage(Images.explosion5, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBombExplosionCount <= pause*6)win.drawImage(Images.explosion6, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);		
				else if (drawBombExplosionCount <= pause*7)win.drawImage(Images.explosion7, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);		
				else if (drawBombExplosionCount <= pause*8)win.drawImage(Images.explosion8, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				else if (drawBombExplosionCount <= pause*8)win.drawImage(Images.explosion9, head.returnX()+xShift, head.returnY()+yShift, burstWidth, burstHeight, null);
				drawBombExplosionCount++;
				if (drawBombExplosionCount >= pause*9) {
					drawBombExplosionCount = 0;
					drawBombExplosion = false;
				}
			}
			
		}
	
	}
}
