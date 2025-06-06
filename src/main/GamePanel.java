package main;

import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import tile.TileManager;

/**
 *
 * @author jayrald
 */

public class GamePanel extends JPanel implements Runnable{
    
    
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16 x 16 tile
    final int scale = 4;
    
    // SCREEN SETTINGS
    public final int tileSize = originalTileSize * scale;// 64x64 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol; //1280 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 960 pixels
    
    // MAP
    public int maxMap = 10;
    public int currentMap =0;
    
    //FPS 
    int FPS = 60;
    
    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Music music = new Music();  
    Music SFX = new Music();  
    public CollisionDetection cDetector = new CollisionDetection(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    public cutSceneManager csManager = new cutSceneManager(this);
    public Thread gameThread;
    
    //ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public Entity obj[][] = new Entity[maxMap][50];
    public Entity monster[][] = new Entity[maxMap][50];
    ArrayList<Entity> entityList = new ArrayList<>();
    
    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int WinState = 3;
    public final int LossState = 4;
    public final int cutSceneState = 5;
    public final int OptionState = 6;
    
    //pause
    public boolean gamePaused = false;
    private long pauseStartTime;
    private double pausedTime = 0;
       
    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);     
    }
    
    public void restart(){
        
     System.out.println("Restarting game...");

    // Reset player defaults
    player.setDefaultValues();
    System.out.println("Player defaults reset.");

    // Reset object and monster setups
    aSetter.setObject();
    aSetter.setMonster();
    System.out.println("Object and monster setups reset.");

    // Reset other variables
    player.hasChest = 0;
    player.hasKey = 0;
    ui.subState = 0;
    ui.playTime=180.0;

    // Toggle pause
    togglePause();

    // Set game state to playState
    gameState = playState;

    // Start the game thread
    startGameThread();

    System.out.println("Game restarted.");
   
        
    }
    public void quit(){
    player.setDefaultValues();
    aSetter.setObject();
    aSetter.setMonster();
    ui.playTime =180.0;
    player.hasChest = 0;
    player.hasKey = 0;
    ui.subState = 0;
    togglePause();
    ui.commandNum=0;
    gameState = titleState;
    
    startGameThread();
   
        
    }
    public void retry(){
        
    player.setDefaultValues();
    aSetter.setObject();
    aSetter.setMonster();
    ui.playTime =180.0;
    player.hasChest = 0;
    player.hasKey = 0;
    gameState = playState;
   
    startGameThread();
   
        
    }
    public void setUpGame() {
        
        playMusic(11);
        aSetter.setObject();
        aSetter.setMonster();
        
        gameState = titleState;
    }
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while (gameThread != null) { 
                      
            update();
            repaint();          
            
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
          }
    public void update(){
           
        if (gameState == playState && !gamePaused) {
            //PLAYER
            player.update();
            
            //MONSTER
            for(int i = 0; i < monster[1].length; i++){
                if(monster[currentMap][i] != null){
                    if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false){
                        monster[currentMap][i].update();
                    }
                    if(monster[currentMap][i].alive == false){
                        monster[currentMap][i].checkDrop();
                        
                        monster[currentMap][i] = null;
                    }
                }
            }
            
            
            resumeMusic();
        }
        if (gameState == pauseState) {}
            
        }
    @Override
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            
            //DEBUG
            
            long drawStart = 0;
            if(keyH.checkDrawTime == true){
                 drawStart = System.nanoTime();
            }
           
            if(gameState == LossState){
               
               ui.draw(g2);
            }
            
            if(gameState == WinState){
                
               ui.draw(g2);
            }
            
            if(gameState == pauseState){
                
               ui.draw(g2);
            }
            
            if(gameState == OptionState){
                
               ui.draw(g2);
            }
            
            //TITLE SCREEN
            if(gameState == titleState){
               ui.draw(g2);
            }
            else{
                //PLAY STATE
                //TILE
            tileM.draw(g2);
            
            //PLAYER
            entityList.add(player);
            
            //MONSTER
            for (int i = 0; i<monster[1].length; i ++) {
                if (monster[currentMap][i] != null) {
                    entityList.add(monster[currentMap][i]);
                }
            }
            
            // OBJECT 
            for(int i = 0; i < obj[1].length; i++){
                if(obj[currentMap][i] != null){
                    entityList.add(obj[currentMap][i]);
                }
            }
            
            // SORT
                Collections.sort(entityList, new Comparator<Entity>(){
                @Override
                public int compare(Entity e1, Entity e2) {
                    
                    int result = Integer.compare(e1.y, e2.y);
                    return result;
                }
                });
            
            // DRAW ENTITIES
            
            for(int i = 0; i < entityList.size(); i++){
                entityList.get(i).draw(g2);
            }
            //EMPTY ENTITY LIST
             entityList.clear();
             
            // CUTSCENE
            csManager.draw(g2);
                
            //UI
            ui.draw(g2);
            }
            
            
            //DEBUG
            if(keyH.checkDrawTime == true){
                  long drawEnd = System.nanoTime();
                  long passed = drawEnd-drawStart;
                  g2.setColor(Color.WHITE);
                  g2.drawString("Draw Time: "+ passed, 10, 400);
                  System.out.println("Draw Time: "+ passed);
            }
           
            
            g2.dispose();
            
        }    
    
    public void playMusic(int i) {
        
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        
        music.stop();
        
    }
    public void playerSFX(int i) {
        
        SFX.setFile(i);
        SFX.play();
    }
    public void resumeMusic() {   
        music.loop();
    }
    public void togglePause() {
        if (gamePaused) {
            resumeMusic();
            long pauseEndTime = System.nanoTime();
            long pauseDuration = pauseEndTime - pauseStartTime;
            pausedTime += pauseDuration / 1000000000.0; // convert nanoseconds to seconds
        } else {
            stopMusic();
            pauseStartTime = System.nanoTime();
        }
        gamePaused = !gamePaused;
    }
    public double getPausedTime() {
        return pausedTime;
    }
    
}