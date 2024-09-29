package Snake;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private static Clip playBackground;
	private static Clip explosion;
	private static Clip explosionDeath;
	
	public static void appleCrunch(boolean repeat) {
		Clip clip = null;
		File f = new File("src/sounds/appleEatingSound.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (clip != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 clip.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	public static void goldenAppleCrunch(boolean repeat) {
		Clip clip = null;
		File f = new File("src/sounds/goldenAppleEatingSound.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (clip != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 clip.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	public static void tacoBell(boolean repeat) {
		Clip clip = null;
		File f = new File("src/sounds/tacoEatingSound.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (clip != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 clip.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	public static void deathSound(boolean repeat) {
		Clip clip = null;
		File f = new File("src/sounds/deathSound.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (clip != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 clip.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	public static void playBackgroundSound(boolean repeat) {
		playBackground = null;
		File f = new File("src/sounds/playBackgroundMusic.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			playBackground = AudioSystem.getClip();
			playBackground.open(audioIn);
			playBackground.start();
			FloatControl gainControl = (FloatControl) playBackground.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (playBackground != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 playBackground.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	public void stopPlayBackgroundSound() {
		playBackground.stop();
	}
	
	public static void explosionSound(boolean repeat) {
		explosion = null;
		File f = new File("src/sounds/explosion.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			explosion = AudioSystem.getClip();
			explosion.open(audioIn);
			explosion.start();
			FloatControl gainControl = (FloatControl) explosion.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (explosion != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 explosion.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	public static void explosionDeathSound(boolean repeat) {
		explosionDeath = null;
		File f = new File("src/sounds/explosion+deathSound.wav");
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			explosionDeath = AudioSystem.getClip();
			explosionDeath.open(audioIn);
			explosionDeath.start();
			FloatControl gainControl = (FloatControl) explosionDeath.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6f); 
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
		
		 if (explosionDeath != null && repeat) {
	         // If repeat is enabled, we set the clip to loop continuously
			 explosionDeath.loop(Clip.LOOP_CONTINUOUSLY);
	     }
	}
	
	
}
