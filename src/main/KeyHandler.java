
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jayrald
 */
public class KeyHandler implements KeyListener{
    
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, enterPressed;

    //DEBUG
    boolean checkDrawTime = false;    
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
    
        //PLAY STATE
        if (gp.gameState == gp.playState) {
             playState(code);
         } 
        
        // PAUSE STATE
        else if (gp.gameState == gp.pauseState) {
             pauseState(code);
          } 
        
        // OPTION STATE
        else if (gp.gameState == gp.OptionState) {
             OptionState(code);
          } 
        
        // TITLE STATE
        else if (gp.gameState == gp.titleState) {
             titleState(code);
        }  
        
        // WIN STATE
        else if (gp.gameState == gp.WinState) {
             winState(code);
        }  
        
        // LOSS STATE
        else if (gp.gameState == gp.LossState) {
            lossState(code);
        } 
        
        // END STATE
        else if (gp.gameState == gp.cutSceneState) {
            cutSceneState(code);
        } 
    }
    
    public void playState(int code){
        
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            gp.playerSFX(6);
            spacePressed = true;
        }
        
        //DEBUG
        if(code == KeyEvent.VK_T){
            if(checkDrawTime == false){
                checkDrawTime=true;
            }
            else if (checkDrawTime == true){
                checkDrawTime=false;
            }
        }
        if(code == KeyEvent.VK_R){
            switch(gp.currentMap){
                case 0:gp.tileM.loadMap("/maps/1Cave.txt", 0);
                case 1:gp.tileM.loadMap("/maps/2Jungle.txt", 1);

                
            }
        }
        
        // PAUSE STATE 
        if(code == KeyEvent.VK_P){
                gp.ui.subState = 0;
                gp.gameState = gp.pauseState;
                 gp.togglePause();
}
    }
    
    public void titleState(int code){
        
        if(gp.ui.titleScreenState == 0){
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            gp.ui.commandNum--;
            gp.playerSFX(10);
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 2;
            }
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            gp.ui.commandNum++;
            gp.playerSFX(10);
            if(gp.ui.commandNum > 2){
                gp.ui.commandNum = 0;
            }
        }
    
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.playMusic(13);
                gp.ui.titleScreenState =1;
            }
            if(gp.ui.commandNum == 1){
                gp.gameState= gp.OptionState;
            }
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }
        }
        }
        else if(gp.ui.titleScreenState == 1){
         
        if(code == KeyEvent.VK_K){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.ui.titleScreenState=6;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                 gp.ui.titleScreenState =2;
            }
        }
    }
        else if(gp.ui.titleScreenState == 2){
         
        if(code == KeyEvent.VK_K){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
               gp.ui.titleScreenState=6;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                 gp.ui.titleScreenState =3;
            }
        }
    }
        else if(gp.ui.titleScreenState == 3){
         
        if(code == KeyEvent.VK_K){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.ui.titleScreenState=6;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                 gp.ui.titleScreenState =4;
            }
        }
    }
        else if(gp.ui.titleScreenState == 4){
         
        if(code == KeyEvent.VK_K){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
               gp.ui.titleScreenState=6;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.ui.titleScreenState =5;
            }
        }
    }
        else if(gp.ui.titleScreenState == 5){
         
        if(code == KeyEvent.VK_K){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.ui.titleScreenState=6;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
            }
        }
    }
         else if(gp.ui.titleScreenState == 6){
          if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            gp.ui.commandNum--;
            gp.playerSFX(10);
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 1;
            }
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            gp.ui.commandNum++;
            gp.playerSFX(10);
            if(gp.ui.commandNum > 1){
                gp.ui.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.playMusic(0);
                gp.gameState=gp.playState;
            }
            if(gp.ui.commandNum == 1){
                gp.stopMusic();
                gp.playMusic(11);
                gp.ui.titleScreenState=0;
            }
        }
    }

        
    }
    public void cutSceneState(int code){
        if(code == KeyEvent.VK_ENTER){
            
            System.exit(0);
        }   
    }
    public void pauseState(int code){
        if (code == KeyEvent.VK_P) {
        gp.gameState = gp.playState;
        gp.togglePause();
        }
        
        int maxCommandNum = 0;
        switch(gp.ui.subState){
            case 0: maxCommandNum = 3;
        }
        
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.playerSFX(10);
            gp.ui.commandNum--;
        if (gp.ui.commandNum < 0) {
            gp.ui.commandNum = maxCommandNum;
        }
    } else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.playerSFX(10);
            gp.ui.commandNum++;
        if (gp.ui.commandNum > maxCommandNum) {
            gp.ui.commandNum = 0;
        }
    }
    if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.gameThread = null;
                gp.ui.subState = 2;
                gp.playerSFX(10);
                gp.stopMusic();
                gp.playMusic(0);
            }
            if(gp.ui.commandNum == 1){
                gp.ui.subState=1;
            }
            if(gp.ui.commandNum == 2){
                gp.stopMusic();
                gp.playMusic(11);
                gp.gameThread=null;
                gp.ui.titleScreenState=0;
                gp.quit();
                
                gp.currentMap = 0;
            }
            if(gp.ui.commandNum == 3){
                gp.gameState = gp.playState;
                gp.togglePause();
            }
        }
    }
    public void lossState(int code) {
    if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
        gp.playerSFX(10);
        gp.ui.commandNum--;
        if (gp.ui.commandNum < 0) {
            gp.ui.commandNum = 1;
        }
    } else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
        gp.playerSFX(10);
        gp.ui.commandNum++;
        if (gp.ui.commandNum > 1) {
            gp.ui.commandNum = 0;
        }
    }
    if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.playMusic(0);
                gp.gameThread = null;
                gp.retry();
            }
            if(gp.ui.commandNum == 1){
                System.exit(0);
            }
        }
}
    public void winState(int code) {
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            gp.ui.commandNum--;
            gp.playerSFX(10);
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 2;
            }
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            gp.ui.commandNum++;
            gp.playerSFX(10);
            if(gp.ui.commandNum > 2){
                gp.ui.commandNum = 0;
            }
        }
    
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.playMusic(0);
                gp.gameThread = null;                
                gp.retry();
               
            }
            if(gp.ui.commandNum == 1){
                gp.playerSFX(10);
                gp.stopMusic();
                gp.playMusic(0);
                gp.gameThread = null;                
                gp.retry();
                
                gp.currentMap++;
            }
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }
        }
}
    public void OptionState(int code){
        
        int maxNum = 0;
        switch(gp.ui.option){
            case 0: maxNum = 2;
        }
        
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.playerSFX(10);
            gp.ui.commandNum--;
        if (gp.ui.commandNum < 0) {
            gp.ui.commandNum = maxNum;
        }
    } else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.playerSFX(10);
            gp.ui.commandNum++;
        if (gp.ui.commandNum > maxNum) {
            gp.ui.commandNum = 0;
        }
    }
    if(code == KeyEvent.VK_ESCAPE){
         gp.ui.option=0;
    }
    if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                 gp.ui.option=2;
            }
            if(gp.ui.commandNum == 1){
                gp.ui.option=1;
                
            }
            if(gp.ui.commandNum == 2){
                gp.gameState = gp.titleState;
            }
        }
    }

    
    @Override
    public void keyReleased(KeyEvent e) {
          int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            gp.player.attacking = false;
    }
        
    }
    
    
    
}
