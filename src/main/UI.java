
package main;


import entity.Entity;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import object.Obj_Chest;
import object.Obj_Heart;
import object.Obj_Key;

/**
 *
 * @author jayrald
 */
public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart_full, heart_half,heart_blank, chest1;
    Font arial_40, arial_80;
    BufferedImage keyImage;
    public boolean gameDone = false;
    private int textLength;
    public int commandNum = 0;
    public int subState = 0;
    public int option = 0;
    public int titleScreenState = 0;
    float alpha = 0f;
    
    double playTime = 180.0;
    DecimalFormat dFormat = new DecimalFormat("#0.0");
    
    
    public UI(GamePanel gp){
        this.gp = gp;
        
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80 = new Font("Arial", Font.BOLD, 80);
        
        Obj_Key key = new Obj_Key(gp);
        keyImage = key.image;
        
        // CREATE HUD OBJECT
        Entity heart = new Obj_Heart(gp);
        Entity chest = new Obj_Chest(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        chest1 = chest.down1;
        
    }
    
    public void draw(Graphics2D g2){
        
        
        
        this.g2 = g2;
        
        g2.setFont(arial_40);
        g2.setColor(WHITE);
        
        //PLAY STATE
        if(gp.gameState == gp.playState){
        
            drawPlayerLife();
            keyCounter();
            timer();
         if(gp.ui.gameDone == true){
            gp.gameState = gp.WinState;
            gp.stopMusic();
            gp.playerSFX(1);
            gameDone = false;
        }
        
    }
        // WIN
        if(gp.gameState == gp.WinState){
            gp.stopMusic();
            drawWinScreen();
            
        }
        
        // GAME OVER
        if(gp.gameState==gp.LossState){
                drawLossScreen();
                gp.stopMusic();
            }
    
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
            
        }
        
        //OPTION STATE
        if(gp.gameState == gp.OptionState){
            drawOptionScreen();
            
        }
        
        
        //PAUSE
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
            drawPlayerLife();
            keyCounter();
            timer();
        }
    }
    public void drawTitleScreen() {
        
        if(titleScreenState == 0){

        g2.drawImage(gp.player.Chest1, 0, 0 , gp.screenWidth, gp.screenHeight, null);
    
        g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 88));
         // TITLE NAME
        g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 88));
        String text = "TREASURE";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 5;
        // SHADOW COLOR TEXT
        g2.setColor(Color.BLACK);
        g2.drawString(text, x -2, y + 26);
        // MAIN COLOR TEXT
        g2.setColor(Color.YELLOW);
        g2.drawString(text, x-10, y+19);
        
        text = "TREK";
        x = getXforCenteredText(text);
        y = gp.tileSize * 7;
        // SHADOW COLOR TEXT
        g2.setColor(Color.BLACK);
        g2.drawString(text, x -2, y + 26);
        // MAIN COLOR TEXT
        g2.setColor(Color.YELLOW);
        g2.drawString(text, x-10, y+19);

        //FRAME
         final int frameX = gp.tileSize*7;
         final int frameY =  gp.tileSize*9;
         final int frameWidth = gp.tileSize*6;
         final int frameHeight = gp.tileSize*4;
         drawWindow(frameX, frameY, frameWidth, frameHeight);
        // MENU
       g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 48));
       //SHADOW
        text ="NEW GAME";
        g2.setColor(Color.BLACK);
        g2.drawString(text, gp.tileSize*7+27, gp.tileSize*10+18);
        text ="ABOUT";
        g2.setColor(Color.BLACK);
        g2.drawString(text, gp.tileSize*8+27, gp.tileSize*11+25);
        text ="QUIT";
        g2.setColor(Color.BLACK);
        g2.drawString(text, gp.tileSize*9+2, gp.tileSize*12+33);
        
        // OPTION
        drawOption("NEW GAME", 0, y += gp.tileSize * 3+18);
        drawOption("ABOUT", 1, y += gp.tileSize + 7);
        drawOption("QUIT", 2, y += gp.tileSize + 7);
        
        }
        else if(titleScreenState == 1){
            
            g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));       
            g2.drawImage(gp.player.TitleImage, 0, 0 , gp.screenWidth, gp.screenHeight, null);
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            
            String text = "Once upon a moonlit night, in the realm of dreams,\n"
                    +"there lived a young child named Oliver, whose imagination \n"
                    +"knew no bounds. Oliver's favorite game was Treasure Trek,\n"
                    +"a thrilling adventure where a courageous treasure hunter\n"
                    +"embarks on a quest through a perilous maze. Little did he\n"
                    +"know that his dreams would intertwine with his favorite\n"
                    +"game in the most extraordinary way.\n";
                    drawString(alpha, 30f, gp.tileSize*4, text,70);

                    text = "Press K to Skip";
                    drawString(alpha, 20f, gp.tileSize*12, text,70);
                    alpha += 0.005f;
                    if(alpha > 1f){
                       alpha = 1f;
                    }
            
            if(gp.csManager.counterReached(1500)==true){
                titleScreenState++;
            }
        }
        else if(titleScreenState == 2){
            g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            g2.drawImage(gp.player.TitleImage, 0, 0 , gp.screenWidth, gp.screenHeight, null);
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            
            String text = "As Oliver slipped into a deep slumber, his mind transported\n"
                    +" him into the captivating world of Treasure Trek. He found himself\n"
                    +"embodying the fearless treasure hunter, facing a maze teeming with\n"
                    +"dangerous creatures and treacherous obstacles. Harmful animals prowled\n"
                    +"in the shadows, and fearsome monsters lurked around every corner,\n"
                    +"challenging his every step. Just as Oliver was about to reach the heart\n"
                    +" of the maze, he felt a strange sensation.\n";
                    drawString(alpha, 30f, gp.tileSize*4, text,70);
                    
                    
                    text = "Press K to Skip";
                    drawString(alpha, 20f, gp.tileSize*12, text,70);
                    alpha += 0.005f;
                    if(alpha > 1f){
                    alpha = 1f;
                }
                    if(gp.csManager.counterReached(1740)==true){
                       titleScreenState++;
                    }
                }
        else if(titleScreenState == 3){
             g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            g2.drawImage(gp.player.TitleImage, 0, 0 , gp.screenWidth, gp.screenHeight, null);
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            
            String text = " He opened his eyes,expecting to find himself back in his cozy bed,\n"
                    +" but instead, he stood in a real-life playground that mirrored the very\n"
                    +"landscape of his favorite game. Shock washed over him as he realized\n"
                    +"he had stepped into the world of Treasure Trek itself\n"
                    +"As Oliver took in the wonder of his surroundings, he heard a\n"
                    +"mischievous whisper in the wind, \n";
                    drawString(alpha, 30f, gp.tileSize*4, text,70);
                    
                    
                    text = "Press K to Skip";
                    drawString(alpha, 20f, gp.tileSize*12, text,70);
                    alpha += 0.005f;
                    if(alpha > 1f){
                        alpha = 1f;
                    }
            if(gp.csManager.counterReached(1410)==true){
                titleScreenState++;
                    }
                }
        else if(titleScreenState == 4){
            g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            g2.drawImage(gp.player.TitleImage, 0, 0 , gp.screenWidth, gp.screenHeight, null);
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            
            String text = "\"Welcome to Treasure Trek, an exciting adventure where you\n"   
                    +" embark on a thrilling journey through various treacherous terrains\n"
                    +"in search of hidden treasure! As a brave solo explorer, you will\n"
                    +"face a myriad of challenging obstacles in each level, all with\n"
                    +"unique themes to keep you on your toes.\n";
                    drawString(alpha, 30f, gp.tileSize*5, text,70);
                    
                    
                    text = "Press K to Skip";
                    drawString(alpha, 20f, gp.tileSize*12, text,70);
                    alpha += 0.005f;
                    if(alpha > 1f){
                        alpha = 1f;
                    }
                    if(gp.csManager.counterReached(1260)==true){
                        titleScreenState++;
                    }
                }
        else if(titleScreenState == 5){
             g2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
            g2.drawImage(gp.player.TitleImage, 0, 0 , gp.screenWidth, gp.screenHeight, null);
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            
            String text = "Remember, each level presents its own unique challenges and obstacles,\n"   
                    +"pushing your skills and abilities to the limit. With each successfully\n"
                    +"obtained treasure, you unlock the next level of increasing difficulty,\n"
                    +"bringing you closer to becoming the ultimate treasure hunter.\n"
                    +"So, are you ready to embark on this epic adventure through the maze\n"
                    +"of Treasure Trek? The treasure awaits, and your journey \n"
                    +"BEGINS NOW!\n";
                    drawString(alpha, 30f, gp.tileSize*4, text,70);
                    
                    
                    text = "Press K to Start";
                    drawString(alpha, 30f, gp.tileSize*12, text,70);
                    alpha += 0.005f;
                    if(alpha > 1f){
                        alpha = 1f;
                    }
                    if(gp.csManager.counterReached(1600)==true){
                         gp.stopMusic();
                    }
               }
        else if(titleScreenState == 6){
           
            //FRAME
       final int frameX = -10;
       final int frameY = -10;
       final int frameWidth = gp.screenWidth + 30;
       final int frameHeight = gp.screenHeight + 30;
       drawWindow(frameX, frameY, frameWidth, frameHeight);
       
       g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 48));
       //SHADOW
        String text ="Are you ready?";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 6;  
        g2.drawString(text, x-10, y+19);
        text = "Find the chest and get out.";
        g2.setColor(Color.WHITE);
        g2.drawString(text, gp.tileSize*3+10, gp.tileSize * 5+19);
        
        // OPTION
        drawOption("Yes", 0, y += gp.tileSize * 2+18);
        drawOption("No", 1, y += gp.tileSize + 7);
        }
        
       
    
}
    public void drawEndScreen(){
     
    }
    public void drawLossScreen() {
    
    //FRAME
    final int frameX = -10;
    final int frameY = -10;
    final int frameWidth = gp.screenWidth + 30;
    final int frameHeight = gp.screenHeight + 30;
    drawWindow(frameX, frameY, frameWidth, frameHeight);

    // TITLE NAME
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 85));
    String text = "GAME OVER!";
    int x = getXforCenteredText(text);
    int y = gp.tileSize * 6;

    // SHADOW COLOR TEXT
    g2.setColor(Color.gray);
    g2.drawString(text, x + 4, y + 4);

    // MAIN COLOR TEXT
    g2.setColor(Color.WHITE);
    g2.drawString(text, x, y);

    // Display the time in minutes and seconds
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 30));
    int minutes = (int) playTime / 60;
    int seconds = (int) playTime % 60;
    text = "Your remaining time is: " + minutes + " minutes " + seconds + " seconds!";
    textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    x = gp.screenWidth / 2 - textLength / 2;
    y += gp.tileSize + 20;
    g2.drawString(text, x, y);

    // MAIN
    g2.setColor(WHITE);
    g2.drawString(text, x, y);
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 40));
    
    drawOption("TRY AGAIN", 0, y += gp.tileSize);
    drawOption("QUIT", 1, y += gp.tileSize);

    // Update the graphics
    gp.repaint();


}
    public void drawWinScreen() {
     //FRAME
    final int frameX = gp.tileSize*4;
    final int frameY = gp.tileSize*4;
    final int frameWidth = gp.tileSize*12;
    final int frameHeight = gp.screenHeight /2;
    drawWindow(frameX, frameY, frameWidth, frameHeight);

    // TITLE NAME
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 60));
    String text = "CONGRATULATIONS!";
    int x = getXforCenteredText(text);
    int y = gp.tileSize * 6;

    // SHADOW COLOR TEXT
    g2.setColor(Color.gray);
    g2.drawString(text, x + 4, y + 4);

    // MAIN COLOR TEXT
    g2.setColor(Color.WHITE);
    g2.drawString(text, x, y);

    // Display the time in minutes and seconds
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 30));
    int minutes = (int) playTime / 60;
    int seconds = (int) playTime % 60;
    text = "Your remaining time is: " + minutes + " minutes " + seconds + " seconds!";
    textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    x = gp.screenWidth / 2 - textLength / 2;
    y += gp.tileSize + 20;
    g2.drawString(text, x, y);

    // MAIN
    g2.setColor(WHITE);
    g2.drawString(text, x, y);
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 40));

    drawOption("RETRY", 0, y += gp.tileSize+5);
    drawOption("NEXT LEVEL", 1, y + gp.tileSize );
    drawOption("QUIT", 2, y + 2 * gp.tileSize );

    // Update the graphics
    gp.repaint();

    
}
    public void drawPauseScreen(){
        
         //FRAME
    final int frameX = gp.tileSize*6;
    final int frameY = gp.tileSize*3;
    final int frameWidth = gp.tileSize*8;
    final int frameHeight = gp.tileSize*9;
    drawWindow(frameX, frameY, frameWidth, frameHeight);

        
    switch(subState){
        case 0: PauseTop(frameX, frameY);break;
        case 1: controls(frameX, frameY);break;        
        case 2: gp.restart();break;
    }
    
        // Update the graphics
        gp.repaint();
        
    }
     public void drawOptionScreen(){
     
    g2.drawImage(gp.player.Chest, 0, 0 , gp.screenWidth, gp.screenHeight, null);
         //FRAME
    final int frameX = gp.tileSize*5;
    final int frameY = gp.tileSize*3;
    final int frameWidth = gp.tileSize*10;
    final int frameHeight = gp.tileSize*9;
    drawWindowBlack(frameX, frameY, frameWidth, frameHeight);

    switch(option){
        case 0: OptionsTop(frameX, frameY);break;
        case 1: controlsOption(frameX, frameY);break;        
        case 2: About(frameX, frameY);break;
    }
    
        // Update the graphics
        gp.repaint();
        
    }
    public void drawPlayerLife(){
        
        int x = 0;
        int y = 0;
        int i = 0;
        
        // DRAW BLANK HEART
        while(i < gp.player.maxLife){
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        
        // RESET    
        x = 0;
        y = 0;
        i = 0;
        
        // DRAW CURRENT LIFE
        while(i < gp.player.life){
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
        
    }
    public void controls(int frameX, int frameY){
        
        String text = "CONTROLS";
        int x = getXforCenteredText(text);
        int y = frameY + gp.tileSize+20;
        g2.drawString(text, x, y);
        
        x = frameX + gp.tileSize;
        y += gp.tileSize+20;
        g2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        g2.drawString("MOVE:      W, S, A, D ", x, y); y += gp.tileSize;
        g2.drawString("PAUSE:     P", x, y); y += gp.tileSize;
        g2.drawString("ATTACK:    SPACE", x, y); y += gp.tileSize*3;
        g2.drawString("Press P to back", x, y); y += gp.tileSize;
        
        

    }
    public void controlsOption(int frameX, int frameY){
        g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 60));
        String text = "CONTROLS";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*4+20;
        // SHADOW COLOR TEXT
        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y + 5);

        // MAIN COLOR TEXT
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        
        x = frameX + gp.tileSize;
        y += gp.tileSize+18;
        g2.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        g2.drawString("MOVE:       W - Up         A - Left", x, y); y += gp.tileSize-5;
        g2.drawString("                S - Down      D - Right", x, y); y += gp.tileSize-5;
        g2.drawString("PAUSE:     P", x, y); y += gp.tileSize-5;
        g2.drawString("ATTACK:    SPACE", x, y); y += gp.tileSize*2;
        g2.drawString("Press ESCAPE to back", x, y); y += gp.tileSize*3;
        
        

    }
    public void PauseTop(int frameX, int frameY){
        // PAUSE
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 60));
    String text = "PAUSED!";
    int x = getXforCenteredText(text);
    int y = gp.tileSize * 5;

    // SHADOW COLOR TEXT
    g2.setColor(Color.gray);
    g2.drawString(text, x + 2, y + 2);

    // MAIN COLOR TEXT
    g2.setColor(Color.WHITE);
    g2.drawString(text, x, y);
        
        // MAIN
    g2.setColor(WHITE);
    g2.drawString(text, x, y);
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 40));
    
    drawOption("RESTART", 0, y += gp.tileSize + 45 );
    drawOption("CONTROLS", 1, y += gp.tileSize);
    drawOption("QUIT", 2, y += gp.tileSize);
    drawOption("BACK", 3, y += gp.tileSize*2);
    }
    public void OptionsTop(int frameX, int frameY){
            // PAUSE
    g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 70));
    String text = "OPTION";
    int x = getXforCenteredText(text);
    int y = gp.tileSize * 4+20;

    // SHADOW COLOR TEXT
    g2.setColor(Color.black);
    g2.drawString(text, x + 5, y + 5);

    // MAIN COLOR TEXT
    g2.setColor(Color.WHITE);
    g2.drawString(text, x, y);
        
    g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 45));
    
    drawOption("ABOUT", 0, y += gp.tileSize *3 );
    drawOption("CONTROLS", 1, y += gp.tileSize);
    drawOption("BACK", 2, y += gp.tileSize*2);
    }
    public int getXforCenteredText(String text){
        
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    public void keyCounter(){
    // KEY COUNTER
    g2.setFont(arial_40);
    g2.setColor(WHITE);

    // Draw key count
    String keyText = "KEY = " + gp.player.hasKey;
    g2.drawString(keyText, 20, 945);

    // Draw chest images based on the number of chests collected
    int x = 180;
    int y = 895;

    for (int i = 0; i < gp.player.hasChest; i++) {
        g2.drawImage(chest1, x, y, null);
        x += gp.tileSize;
    }
}
    private void drawOption(String text, int optionNum, int y) {
    int x = getXforCenteredText(text);

    // Change color if the option is selected
    if (commandNum == optionNum) {
        g2.setColor(Color.GREEN);
    } else {
        g2.setColor(Color.WHITE);
    }
    g2.drawString(text, x, y);
}
    public void About(int frameX, int frameY){
    g2.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 70));
    String text = "GAME INFO";
    int x = getXforCenteredText(text);
    int y = gp.tileSize * 4+20;

    // SHADOW COLOR TEXT
    g2.setColor(Color.black);
    g2.drawString(text, x + 5, y + 5);

    // MAIN COLOR TEXT
    g2.setColor(Color.WHITE);
    g2.drawString(text, x, y);
    
    x = frameX + gp.tileSize;
    y += gp.tileSize+15;
    g2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
    g2.drawString("Game Name:               Treasure Trek", x, y); y += gp.tileSize-5;
    g2.drawString("Game Levels:             5", x, y); y += gp.tileSize-5;
    g2.drawString("Creator:                     JBuddies", x, y); y += gp.tileSize-5;
    g2.drawString("Date Created:             11-06-23", x, y); y += gp.tileSize-5;
    g2.drawString("Date Finished:            12-08-23", x, y); y += gp.tileSize-5;
    g2.drawString("Language used:            Java", x, y); y += gp.tileSize;
    g2.drawString("Press ESCAPE to back", x, y); y += gp.tileSize;
    }
    public void drawWindow(int x, int y, int width, int height){
        
        Color c = new Color(0, 0,0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35 ,35);
        
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        
    }
    public void drawWindowBlack(int x, int y, int width, int height){
        
        Color c = new Color(0, 0,0);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35 ,35);
        
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        
    }
   public void timer(){
    if (!gp.gamePaused) {
        playTime -= (double) 1 / 60;

        if (playTime <= 0) {
            playTime = 0;
            gp.gameState = gp.LossState;
            gp.stopMusic();
            gp.playerSFX(5); 
        }
    }

    int minutes = (int) playTime / 60;
    int seconds = (int) playTime % 60;

    // Format seconds to always have two digits
    String secondsString = String.format("%02d", seconds);

    // Display the formatted time
    g2.drawString("Time: " + minutes + ":" + secondsString, gp.tileSize * 9, 50);
}
    public void drawString(float alpha, float fontSize, int y, String text, int lineHeight){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
        
        for(String line: text.split("\n")){
            int x = gp.ui.getXforCenteredText(line);
            g2.drawString(line, x, y);
            y+=lineHeight;
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
    public void drawBlackBackground(float alpha){
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
    }

}