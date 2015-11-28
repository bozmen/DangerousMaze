/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsourcemanagement;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author User
 */


public class SoundManager extends Thread {

    private static int effectLevel;
    private static int musicLevel;

    public static AudioClip[] sounds = new AudioClip[6];
    

        public static void loadSounds() {
		
            try {
		sounds[0] = Applet.newAudioClip(new URL("file", "localhost",
					"resources\\sounds\\Maze.wav"));
		sounds[1] = Applet.newAudioClip(new URL("file", "localhost",
					"resources\\sounds\\hit.wav"));
		sounds[2] = Applet.newAudioClip(new URL("file","localhost",
					"resources\\sounds\\levelFinished.wav")); 
		sounds[3] = Applet.newAudioClip(new URL("file", "localhost",
					"resources\\sounds\\scream.wav"));
                sounds[4] = Applet.newAudioClip(new URL("file", "localhost",
					"resources\\sounds\\coin.wav"));
                sounds[5] = Applet.newAudioClip(new URL("file", "localhost",
					"resources\\sounds\\Unstoppable.wav"));
				
		effectLevel = 1;
		setMusicLevel(1);
	}

		catch (Exception e) {
			System.out.println(e);
		}
	}


	
	
	public static void setEffectLevel(int effectLevel) {
            SoundManager.effectLevel = effectLevel;
	}
        
        public static int getEffectLevel() {
		return effectLevel;
	}

	public static int getMusicLevel() {
		return musicLevel;
	}


	public static void setMusicLevel(int musicLevel) {
		SoundManager.musicLevel = musicLevel;
		
		if (musicLevel == 0)
			playGameMusic(false);
		else
			playGameMusic(true);
	}


	public static void hit() {
		if (effectLevel > 0)
			sounds[1].play();
	}

	
	public static void levelFinished() {
		if (effectLevel > 0)
			sounds[2].play();
	}

	
	public static void scream() {
		if (effectLevel > 0)
			sounds[3].play();
	}
        
        public static void cling() {
            if (effectLevel > 0)
                sounds[4].play();
        }
        
        public static void unstoppable() {
            if (effectLevel > 0)
                sounds[5].play();
        }

	public static void playGameMusic(boolean start) {
		if (start)
			sounds[0].loop();
		else
		{
			sounds[0].stop();
		}
	}

}
