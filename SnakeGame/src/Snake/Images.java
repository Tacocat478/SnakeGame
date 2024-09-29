package Snake;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static Image apple; {
		try {
			File file = new File("src/images/apple.png");
			FileInputStream fis = new FileInputStream(file);
			apple = ImageIO.read(fis);
			//System.out.println("test");
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image goldenApple; {
		try {
			File file = new File("src/images/goldenApple.png");
			FileInputStream fis = new FileInputStream(file);
			goldenApple = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image taco; {
		try {
			File file = new File("src/images/taco.png");
			FileInputStream fis = new FileInputStream(file);
			taco = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image bh; {
		try {
			File file = new File("src/images/bh.png");
			FileInputStream fis = new FileInputStream(file);
			bh = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image bld; {
		try {
			File file = new File("src/images/bld.png");
			FileInputStream fis = new FileInputStream(file);
			bld = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image blu; {
		try {
			File file = new File("src/images/blu.png");
			FileInputStream fis = new FileInputStream(file);
			blu = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image brd; {
		try {
			File file = new File("src/images/brd.png");
			FileInputStream fis = new FileInputStream(file);
			brd = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image bru; {
		try {
			File file = new File("src/images/bru.png");
			FileInputStream fis = new FileInputStream(file);
			bru = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image bv; {
		try {
			File file = new File("src/images/bv.png");
			FileInputStream fis = new FileInputStream(file);
			bv = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image hd; {
		try {
			File file = new File("src/images/hd.png");
			FileInputStream fis = new FileInputStream(file);
			hd = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image hl; {
		try {
			File file = new File("src/images/hl.png");
			FileInputStream fis = new FileInputStream(file);
			hl = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image hr; {
		try {
			File file = new File("src/images/hr.png");
			FileInputStream fis = new FileInputStream(file);
			hr = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image hu; {
		try {
			File file = new File("src/images/hu.png");
			FileInputStream fis = new FileInputStream(file);
			hu = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image td; {
		try {
			File file = new File("src/images/td.png");
			FileInputStream fis = new FileInputStream(file);
			td = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image tl; {
		try {
			File file = new File("src/images/tl.png");
			FileInputStream fis = new FileInputStream(file);
			tl = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image tr; {
		try {
			File file = new File("src/images/tr.png");
			FileInputStream fis = new FileInputStream(file);
			tr = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image tu; {
		try {
			File file = new File("src/images/tu.png");
			FileInputStream fis = new FileInputStream(file);
			tu = ImageIO.read(fis);
			//System.out.println("tailPrinted");
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst1; {
		try {
			File file = new File("src/images/starBurstFill1.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst1 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst2; {
		try {
			File file = new File("src/images/starBurstFill2.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst2 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst3; {
		try {
			File file = new File("src/images/starBurstFill3.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst3 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst4; {
		try {
			File file = new File("src/images/starBurstFill4.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst4 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst5; {
		try {
			File file = new File("src/images/starBurstFill5.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst5 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst6; {
		try {
			File file = new File("src/images/starBurstFill6.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst6 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst7; {
		try {
			File file = new File("src/images/starBurstFill7.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst7 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image starBurst8; {
		try {
			File file = new File("src/images/starBurstFill8.png");
			FileInputStream fis = new FileInputStream(file);
			starBurst8 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image gameOverRed; {
		try {
			File file = new File("src/images/gameOverRed.png");
			FileInputStream fis = new FileInputStream(file);
			gameOverRed = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image gameOverWhite; {
		try {
			File file = new File("src/images/gameOverWhite.png");
			FileInputStream fis = new FileInputStream(file);
			gameOverWhite = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image deadSnake; {
		try {
			File file = new File("src/images/deadSnake.png");
			FileInputStream fis = new FileInputStream(file);
			deadSnake = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image bomb; {
		try {
			File file = new File("src/images/bomb.png");
			FileInputStream fis = new FileInputStream(file);
			bomb = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion1; {
		try {
			File file = new File("src/images/explosion1.png");
			FileInputStream fis = new FileInputStream(file);
			explosion1 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion2; {
		try {
			File file = new File("src/images/explosion2.png");
			FileInputStream fis = new FileInputStream(file);
			explosion2 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion3; {
		try {
			File file = new File("src/images/explosion3.png");
			FileInputStream fis = new FileInputStream(file);
			explosion3 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion4; {
		try {
			File file = new File("src/images/explosion4.png");
			FileInputStream fis = new FileInputStream(file);
			explosion4 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion5; {
		try {
			File file = new File("src/images/explosion5.png");
			FileInputStream fis = new FileInputStream(file);
			explosion5 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion6; {
		try {
			File file = new File("src/images/explosion6.png");
			FileInputStream fis = new FileInputStream(file);
			explosion6 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion7; {
		try {
			File file = new File("src/images/explosion7.png");
			FileInputStream fis = new FileInputStream(file);
			explosion7 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion8; {
		try {
			File file = new File("src/images/explosion8.png");
			FileInputStream fis = new FileInputStream(file);
			explosion8 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image explosion9; {
		try {
			File file = new File("src/images/explosion9.png");
			FileInputStream fis = new FileInputStream(file);
			explosion9 = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image snakeTitle; {
		try {
			File file = new File("src/images/finalSnakeTitle.png");
			FileInputStream fis = new FileInputStream(file);
			snakeTitle = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image arrowKeys; {
		try {
			File file = new File("src/images/arrowKeys.png");
			FileInputStream fis = new FileInputStream(file);
			arrowKeys = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image speedWord; {
		try {
			File file = new File("src/images/speedCropped.png");
			FileInputStream fis = new FileInputStream(file);
			speedWord = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static Image speedWordTwo; {
		try {
			File file = new File("src/images/speedCroppedTwo.png");
			FileInputStream fis = new FileInputStream(file);
			speedWordTwo = ImageIO.read(fis);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	
	
}
