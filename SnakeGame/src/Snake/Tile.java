package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import utilities.GDV5;

public class Tile extends Rectangle{
	private Color color;
	private boolean apple = false;
	private boolean goldenApple = false;
	private boolean taco = false;
	private boolean bomb = false;
	
	public Tile(int x, int y, int width, int height, Color c) {
		super(x, y, width, height);
		color = c;
	} 
	
	public void draw(Graphics2D t) {
		t.setColor(color);
		t.fill(this);
		
		if (apple) t.drawImage(Images.apple, x, y, width, height, null);
		if (goldenApple) t.drawImage(Images.goldenApple, x, y, width, height, null);
		if (taco) t.drawImage(Images.taco, x, y, width, height, null);
		if (bomb) t.drawImage(Images.bomb, x, y, width, height, null);
		
	}
	
	public int returnX() {
		return x;
	}
	public int returnY() {
		return y;
	}
	
	public boolean isApple() {
		return apple;
	}
	
	public boolean isGoldenApple() {
		return goldenApple;
	}
	
	public boolean isTaco() {
		return taco;
	}
	
	public boolean isBomb() {
		return bomb;
	}
	
	public void removeFood() {
		apple = false;
		goldenApple = false;
		taco = false;
		bomb = false;
	}
	
	public void makeApple() {
		apple = true;
	}
	
	public void makeGoldenApple() {
		goldenApple = true;
	}
	
	public void makeTaco() {
		taco = true;
	}
	
	public void makeBomb() {
		bomb = true;
	}
	
	
}
