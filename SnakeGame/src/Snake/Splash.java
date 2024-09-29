package Snake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import utilities.GDV5;

public class Splash {
	private String screenSetting = "splash"; //should be splash
	private Color edgeBlue = new Color(43,203,243);
	private Color headerBlue = new Color(0,185,232);
	private Color pinkRed = new Color(225,68,97);
	private Color appleRed = new Color(249,72,72);
	private Color appleGold = new Color(255,208,66);
	private Color tacoTan = new Color(243,214,158);
	private Color bombGray = new Color(115,115,115); //actual: (77,77,77)
	private Tile boardBackground = new Tile(0, 0, GDV5.getMaxWindowX(), GDV5.getMaxWindowY(), edgeBlue); //appears as the edges
	private Tile header; 
	private Tile screenBackground = new Tile(0, 0, GDV5.getMaxWindowX(), GDV5.getMaxWindowY(), headerBlue);
	private String speed = "normal";
	
	public Splash() {}
	
	public String getScreenSetting() {
		return screenSetting;
	}
	
	public void setGameOverScreen() {
		screenSetting = "gameOver";
	}
	
	public void changeScreen(Tile[][] map, Sound sd, Score sc, Snake s, Food f, boolean snakeDead, boolean drawStarBurst, boolean drawBombExplosion, int size, int rowNum, ArrayList<snakeSegment> sa) {
		if (screenSetting == "splash") {
			if (GDV5.KeysPressed[KeyEvent.VK_P]) {
				screenSetting = "play";
				sd.playBackgroundSound(true);
			}
			
			if (GDV5.KeysPressed[KeyEvent.VK_S]) speed = "slow";
			if (GDV5.KeysPressed[KeyEvent.VK_N]) speed = "normal";
			if (GDV5.KeysPressed[KeyEvent.VK_F]) speed = "fast";
			
		}
		
		if (screenSetting == "play" && !drawStarBurst && !drawBombExplosion) { 
			if (snakeDead) screenSetting = "gameOver";
		}
		
		if (screenSetting == "gameOver") {
			boolean valid = true;
			sd.stopPlayBackgroundSound(); //should be uncommented
			if (GDV5.KeysPressed[KeyEvent.VK_P]) {
				sc.resetScore();
				sc.resetLevel();
				s.respawnSnake(size);
				f.clearBoard(map, rowNum, size);
				f.resetFood(map, rowNum, size, sa);
				s.makeDeathSoundCheckTrue();
				s.makeBombDeathSoundCheckTrue();
				valid = false;
				screenSetting = "play";
				sd.playBackgroundSound(true);
			}
			if (GDV5.KeysPressed[KeyEvent.VK_M]) {
				sc.resetScore();
				sc.resetLevel();
				s.respawnSnake(size);
				f.clearBoard(map, rowNum, size);
				f.resetFood(map, rowNum, size, sa);
				s.makeDeathSoundCheckTrue();
				s.makeBombDeathSoundCheckTrue();
				valid = false;
				screenSetting = "splash";
			}
		}
	}
	
	public int returnSpeed() {
		if (speed == "slow") return 10;
		if (speed == "normal") return 7;
		if (speed == "fast") return 4;
		return 0;
	}
	
	public void drawPlayScreen(Graphics2D win, Tile[][] map, Score sc, int size) {
		header = new Tile(0, 0, GDV5.getMaxWindowX(), size*2, headerBlue); 
		boardBackground.draw(win);
		header.draw(win);
		for (Tile[] innerArray : map) {
			for (Tile t : innerArray) {
				t.draw(win);
			}
		}
		
		win.setColor(Color.white);
		win.setFont(new Font("Helvetica", Font.PLAIN, 40));
		win.drawString("score: ", size, 50);
		win.setFont(new Font("Helvetica", Font.BOLD, 30));
		win.drawString(sc.returnScore() + "", 155, 50);
		
		win.setFont(new Font("Helvetica", Font.PLAIN, 40));
		win.drawString("level: ", size*7, 50);
		win.setFont(new Font("Helvetica", Font.BOLD, 30));
		win.drawString(sc.returnLevel() + "", 360, 50);
	}
	
	public void drawGameOverScreen(Graphics2D win, Score sc) {
		//screenBackground.draw(win);
		win.drawImage(Images.gameOverRed, 55, 50, 600, 120, null);
		win.drawImage(Images.deadSnake, 200, 200, 300, 300, null);
		
		win.setColor(Color.white);
		win.setFont(new Font("Helvetica", Font.BOLD, 50));
		win.drawString("SCORE: " + sc.returnScore() + "       " + "LEVEL: " + sc.returnLevel(), 65, 600);
		win.setFont(new Font("Helvetica", Font.ITALIC, 30));
		win.drawString("Press       to Play Again", 190, 670);
		win.drawString("Press       to Return to the Menu", 130, 730);
		win.setFont(new Font("Helvetica", Font.ITALIC | Font.BOLD, 30));
		win.drawString("'P'", 280, 670);
		win.drawString("'M'", 220, 730);
	}
	
	public void drawSplashScreen(Graphics2D win) {
		//screenBackground.draw(win);
		win.drawImage(Images.snakeTitle, 25, 20, 640, 176, null);
		
		win.setColor(Color.white);
		win.setFont(new Font("Helvetica", Font.ITALIC, 30));
		win.drawString("Made with ❤️ by Sasan Liaw", 160, 230);
		
		win.drawImage(Images.arrowKeys, 100, 220, 200, 200, null);
		win.setFont(new Font("Helvetica", Font.BOLD, 30));
		win.drawString("Use Arrow Keys to", 340, 310);
		win.drawString("Move the Snake", 340, 350);
		
		win.setFont(new Font("Helvetica", Font.BOLD, 25));
		win.setColor(appleRed);
		int appleX = 200; int appleY = 400;
		win.drawImage(Images.apple, appleX, appleY, 40, 40, null);
		win.drawString("Increases Score By 1", appleX+50, appleY+30);
		
		win.setColor(appleGold);
		int goldAppleX = 180; int goldAppleY = 445;
		win.drawImage(Images.goldenApple, goldAppleX, goldAppleY, 40, 40, null);
		win.drawString("Spawns Multiple Apples", goldAppleX+50, goldAppleY+30);
		
		win.setColor(tacoTan);
		int tacoX = 190; int tacoY = 490;
		win.drawImage(Images.taco, tacoX, tacoY, 40, 40, null);
		win.drawString("Increases Score By 3", tacoX+50, tacoY+30);
		
		win.setColor(bombGray);
		int bombX = 50; int bombY = 535;
		win.drawImage(Images.bomb, bombX, bombY, 40, 40, null);
		win.drawString("Instant Death, 1 Spawns Every Level (10 Points)", bombX+50, bombY+30);
		
		win.setColor(Color.white);
		win.setFont(new Font("Helvetica", Font.BOLD, 35));
		int speedX = 150; int speedY = 620;
		win.drawImage(Images.speedWordTwo, speedX-100, speedY-30, 150, 34, null);
		win.drawString(":     Slow     Normal     Fast", speedX+60, speedY);
		win.setColor(Color.red);
		win.setStroke(new BasicStroke(6));
		if (speed == "normal") win.drawLine(speedX+255, speedY+20, speedX+367, speedY+20);
		else if (speed == "slow") win.drawLine(speedX+124, speedY+20, speedX+202, speedY+20);
		else if (speed == "fast") win.drawLine(speedX+424, speedY+20, speedX+490, speedY+20); //482
		
		win.setColor(Color.white);
		win.setFont(new Font("Helvetica", Font.ITALIC, 20));
		win.drawString("[ 'S': Slow, 'N': Normal, 'F': Fast ]", 200, 670);
		
		win.setFont(new Font("Helvetica", Font.BOLD, 40));
		win.drawString("Press       to Play", 187, 740);
		win.setColor(Color.red);
		win.drawString("'P'", 312, 740);
		
	}
}
