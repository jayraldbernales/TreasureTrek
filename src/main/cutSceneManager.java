package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

/**
 *
 * @author jayrald
 */
public class cutSceneManager {
    
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;
    int counter = 0;
    float alpha = 0f;
    int y;
    String Credits;
    
    // SCENE NUMBER
    public final int NA = 0;
    public final int ending = 1;
    
    public cutSceneManager(GamePanel gp){
        this.gp = gp;
        
        Credits = " TREASURE TREK                             "
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + " PROGRAMERS\n\n"
                + "Jayrald Bernales\n"
                + "Diana Rose Atuel\n"
                + "\n\n"
                + "MONSTERS AND TILE DESIGNERS\n\n"
                + "Kimberly Ligan\n"
                + "Evelyn Musong\n"
                + "Junre Gamutan\n"
                + "Diana Rose Atuel\n"
                + "Jayrald Bernales\n"
                + "\n\n"
                + "SOUND AND MUSIC\n\n"
                + "Junre Gamutan\n"
                + "Evelyn Musong\n"
                + "Kimberly Ligan\n"
                + "\n\n\n\n"
                
                + "THANK YOU\n";
                
    }
    
    public void draw(Graphics2D g2){
        this.g2 = g2;
        
        switch(sceneNum){
            case ending:scene_ending();break;
            
        }
    }
    
    public void scene_ending(){
        
        
        if(scenePhase == 0){
             
            gp.stopMusic();
            scenePhase++;
        }
        if(scenePhase == 1){
            
            gp.playerSFX(12);
            scenePhase++;
        }
        if(scenePhase == 2){
             
            // WAIT UNTIL SOUND END
            if(counterReached(300)==true){
                scenePhase++;
            }
        }
        if(scenePhase == 3){
            
            // THE SCREEN GET DARKER
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            drawBlackBackground(alpha);
            if(alpha == 1f){
                alpha = 0;
                scenePhase++;
            }
        }
        if(scenePhase == 4){
//            g2.drawImage(gp.player.TitleImage, 0, 0 , gp.screenWidth, gp.screenHeight, null);
            drawBlackBackground(1f);
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            String text = "Finally, after the a series of awe-inspring trials,\n"
                    +"   Oliver reached the heart of the playground maze.\n"
                    +"   There, bathed in a radiant glow, was the long-awaited\n"
                    +"   treasure. As he reached out to claim it, a surge of triumph\n"
                    +"   and exhilaration coursed through his veins. He had done it.\n"
                    +"   He had overcome the challenges of his dreams, and now\n"
                    +"the treasure was his to keep.\n";
                    drawString(alpha, 30f, gp.tileSize*5-5, text,70);
            if(counterReached(1000)==true){
                gp.playMusic(11);
                scenePhase++;
            }
        }
        if(scenePhase == 5){
            
            drawBlackBackground(1f);
            
            y =  gp.screenHeight/2;
            g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            drawString(1f, 38f,y, Credits, 40);
            if(counterReached(240)==true){
                scenePhase++;
            }
        }
        if(scenePhase == 6){
            drawBlackBackground(1f);
            
            //scrolling
            y--;
            g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            drawString(1f, 38f, y, Credits, 40);
            
        }
        
    }
    public boolean  counterReached(int target){
        
        boolean counterReached = false;
        counter++;
        if(counter > target){
            counterReached = true;
            counter = 0;
        }
        return counterReached;
    }
    public void drawBlackBackground(float alpha){
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
    }
   public void drawString(float alpha, float fontSize, int y, String text, int lineHeight) {
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    g2.setColor(Color.white);

    FontMetrics originalFontMetrics = g2.getFontMetrics();
    Font originalFont = g2.getFont();

    for (String line : text.split("\n")) {
        // Set a larger font size for the title "TREASURE TREK"
        if (line.trim().equals("TREASURE TREK")) {
            g2.setFont(originalFont.deriveFont(Font.BOLD, 70));
        } else {
            // Set the original font size for the rest of the text
            g2.setFont(originalFont.deriveFont(Font.BOLD, fontSize));
        }

        int x = gp.ui.getXforCenteredText(line);
        g2.drawString(line, x, y);
        y += lineHeight;
    }

    // Reset to the original font
    g2.setFont(originalFont);

    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
}

    
}
