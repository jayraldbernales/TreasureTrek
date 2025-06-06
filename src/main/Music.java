
package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author jayrald
 */

public class Music {
    Clip clip;
    
    URL musicURL[] = new URL[50];
    
    public Music() {
        
        musicURL[0] = getClass().getResource("/sounds/Royalty.wav");
        musicURL[1] = getClass().getResource("/sounds/Yayyy.wav");
        musicURL[2] = getClass().getResource("/sounds/power.wav");
        musicURL[3] = getClass().getResource("/sounds/ting.wav");
        musicURL[4] = getClass().getResource("/sounds/TreasureChest.wav");
        musicURL[5] = getClass().getResource("/sounds/gameover.wav");
        musicURL[6] = getClass().getResource("/sounds/slash.wav");
        musicURL[7] = getClass().getResource("/sounds/punch.wav");
        musicURL[8] = getClass().getResource("/sounds/hitmonster.wav");
        musicURL[9] = getClass().getResource("/sounds/door.wav");
        musicURL[10] = getClass().getResource("/sounds/click.wav");
        musicURL[11] = getClass().getResource("/sounds/WarDrums.wav");
        musicURL[12] = getClass().getResource("/sounds/fanfare.wav");
        musicURL[13] = getClass().getResource("/sounds/Dialogue.wav");
        musicURL[14] = getClass().getResource("/sounds/boogsh.wav");
        musicURL[15] = getClass().getResource("/sounds/r2.wav");
    }
    
    public void setFile(int i) {
        
        try {
            
            AudioInputStream ais = AudioSystem.getAudioInputStream(musicURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }
    public void play() {
        
        clip.start();
    }
    public void loop( ){
        
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        
        clip.stop();
    }
}
