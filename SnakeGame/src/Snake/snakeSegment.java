package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class snakeSegment extends Rectangle{
	private Color snakeGreen = new Color(44,188,28);
	private boolean isHead = false;
	private boolean isTail = false;
	private String headDirection = null;
	private int prevX = -1;
	private int prevY = -1;
	private int index;
	
	public snakeSegment(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void makeHead() {
		isHead = true;
	}
	
	public void makeTail() {
		isTail = true;
	}
	
	public void notTail() {
		isTail = false;
	}
	
	public int returnX() {
		return x;
	}
	
	public int returnY() {
		return y;
	}
	
	public String returnHeadDirection() {
		return headDirection;
	}
	
	public void setX(int newX) {
		prevX = x;
		x = newX;
	}
	
	public void setY(int newY) {
		prevY = y;
		y = newY;
	}
	
	public void updateX(int velocityX) {
		prevX = x;
		x += velocityX;
	}
	
	public void updateY(int velocityY){
		prevY = y;
		y += velocityY;
	}
	
	public void setIndex(int index){
		this.index = index;
	}
	
	public void draw(Graphics2D t, ArrayList<snakeSegment> snakeArray) {
		if (prevX == -1) return; //doesn't draw segments that were just created (prevX hasn't been assigned a value yet)
		
		if (isHead) {
			if (x > prevX) {
				t.drawImage(Images.hr, x, y, width, height, null);
				headDirection = "right";
			}
			if (x < prevX) {
				t.drawImage(Images.hl, x, y, width, height, null);
				headDirection = "left";
			}
			if (y > prevY) {
				t.drawImage(Images.hd, x, y, width, height, null);
				headDirection = "down";
			}
			if (y < prevY) {
				t.drawImage(Images.hu, x, y, width, height, null);
				headDirection = "up";
			}
		}
		else if (isTail) {
			if ((x > prevX && snakeArray.get(index-1).returnY() == y) || snakeArray.get(index-1).returnX() > x) t.drawImage(Images.tl, x, y, width, height, null);
			if ((x < prevX && snakeArray.get(index-1).returnY() == y) || snakeArray.get(index-1).returnX() < x) t.drawImage(Images.tr, x, y, width, height, null);
			if ((y > prevY && snakeArray.get(index-1).returnX() == x) || snakeArray.get(index-1).returnY() > y) t.drawImage(Images.tu, x, y, width, height, null);
			if ((y < prevY && snakeArray.get(index-1).returnX() == x) || snakeArray.get(index-1).returnY() < y) t.drawImage(Images.td, x, y, width, height, null);
		}
		else {
			if ((snakeArray.get(index-1).returnX() < x && snakeArray.get(index+1).returnY() > y) || (snakeArray.get(index+1).returnX() < x && snakeArray.get(index-1).returnY() > y)) t.drawImage(Images.bld, x, y, width, height, null);
			if ((snakeArray.get(index-1).returnX() < x && snakeArray.get(index+1).returnY() < y) || (snakeArray.get(index+1).returnX() < x && snakeArray.get(index-1).returnY() < y)) t.drawImage(Images.blu, x, y, width, height, null);
			if ((snakeArray.get(index-1).returnX() > x && snakeArray.get(index+1).returnY() > y) || (snakeArray.get(index+1).returnX() > x && snakeArray.get(index-1).returnY() > y)) t.drawImage(Images.brd, x, y, width, height, null);
			if ((snakeArray.get(index-1).returnX() > x && snakeArray.get(index+1).returnY() < y) || (snakeArray.get(index+1).returnX() > x && snakeArray.get(index-1).returnY() < y)) t.drawImage(Images.bru, x, y, width, height, null);
			if (snakeArray.get(index-1).returnX() == snakeArray.get(index+1).returnX()) t.drawImage(Images.bv, x, y, width, height, null);
			if (snakeArray.get(index-1).returnY() == snakeArray.get(index+1).returnY()) t.drawImage(Images.bh, x, y, width, height, null);
		}
		/*
		else {
			t.setColor(snakeGreen);
			t.fill(this);
			System.out.println("fail");
		}
		System.out.println("test");
		*/
	}
}
