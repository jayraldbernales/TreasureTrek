package entity;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;
import main.UI;


/**
 *
 * @author jayrald
 */
public class Player extends Entity{

    KeyHandler keyH;
    public int hasKey = 0;
    public int hasChest = 0;
    private boolean hasPowerBoots = false;
    private int powerBootsTimer = 0;
    private boolean hasSlowPotion = false;
    private int potionTimer = 0;
    public Player (GamePanel gp, KeyHandler keyH ){
        super(gp);
        this.keyH = keyH;
        
       
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32; 
        
        
        attackArea.width = 36;
        attackArea.height= 36;
        
        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
        
    }
    
    public void setDefaultValues(){
        
        x = gp.tileSize*18;
        y = gp.tileSize*13;
        speed = 4;
        direction = "down";
        
        // PLAYER STATUS
        maxLife = 3;
        life = maxLife*2;
        
    }
    
    
    public void getPlayerImage(){
       
        up1 = setUp("/player/up", gp.tileSize, gp.tileSize);
        up2 = setUp("/player/up2", gp.tileSize, gp.tileSize);
        down1 = setUp("/player/down", gp.tileSize, gp.tileSize);
        down2 = setUp("/player/down2", gp.tileSize, gp.tileSize);
        left1 = setUp("/player/left", gp.tileSize, gp.tileSize);
        left2 = setUp("/player/left2", gp.tileSize, gp.tileSize);
        right1 = setUp("/player/right", gp.tileSize, gp.tileSize);
        right2 = setUp("/player/right2", gp.tileSize, gp.tileSize);
        TitleImage = setUp("/objects/Untitled", gp.tileSize, gp.tileSize);
        Chest = setUp("/objects/title", gp.tileSize, gp.tileSize);
        Chest1 = setUp("/objects/objects", gp.tileSize, gp.tileSize);
        
    }
    
    public void getPlayerAttackImage(){
        
        attackU1 =  setUp("/player/attackU1", gp.tileSize, gp.tileSize*2);
        attackU2 =  setUp("/player/attackU2", gp.tileSize, gp.tileSize*2);
        attack1 =  setUp("/player/attack1", gp.tileSize, gp.tileSize*2);
        attack2 =  setUp("/player/attack2", gp.tileSize, gp.tileSize*2);
        attackL1 =  setUp("/player/attackL1", gp.tileSize*2, gp.tileSize);
        attackL2 =  setUp("/player/attackL2", gp.tileSize*2, gp.tileSize);
        attackR1 =  setUp("/player/attackR1", gp.tileSize*2, gp.tileSize);
        attackR2 =  setUp("/player/attackR2", gp.tileSize*2, gp.tileSize);
        
    }
    
    public void update(){
        
        // POWER BOOTS TIMER
        if (hasPowerBoots) {
            // Decrement the power boots timer
            if (powerBootsTimer > 0) {
                powerBootsTimer--;

                // Modify player speed based on the remaining time
                speed = 7;
                System.out.println("speed + 3");// Set the desired speed with power boots
            } else {
                // Power boots expired, reset player speed
                hasPowerBoots = false;
                speed = 4; // Set the default speed
            }
        }
        
        // SLOW POTION TIMER
        if (hasSlowPotion) {
            // Decrement the power boots timer
            if (potionTimer > 0) {
                potionTimer--;

                // Modify player speed based on the remaining time
                speed = 2;
                System.out.println("slow");// Set the desired speed with power boots
            } else {
                // Power boots expired, reset player speed
                hasSlowPotion = false;
                speed = 4; // Set the default speed
            }
        }
        
        if(attacking == true){
        attacking();    
        }
        
        
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true ){
            if (keyH.upPressed==true){
                direction = "up";              
            }
            else if (keyH.downPressed==true){
                direction = "down";
            }
            else if (keyH.leftPressed==true){
                direction = "left";
            }
            else if (keyH.rightPressed==true){
                direction = "right";              
            }
            
                        
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cDetector.checkTile(this);
            
            //CHECK OBJECT COLLISION
            int objIndex = gp.cDetector.checkObject(this, true);
            pickUpObject(objIndex);
            
            //CHECK MONSTER COLLISION
            int monsterIndex = gp.cDetector.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);
            
            // CHECK EVENT
            gp.eHandler.checkEvent();
            
            //IF COLLISION IS FALSE PLAYER CAN STILL MOVE
            if (collisionOn == false) {
                
            switch(direction){
                case "up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right":
                    x += speed;
                    break;
            }
            
            spriteCOunter++;
            if(spriteCOunter > 12){
                if (spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum=1;
                }
                spriteCOunter = 0;
                }
            }   
        }
        if (keyH.spacePressed == true) {
        attacking = true;
    }
        keyH.spacePressed = false;
        
        
        if(life <= 0){
            gp.gameState = gp.LossState;
            gp.playerSFX(5);
        }
        
        if(life > maxLife*2){
            life = maxLife*2;
        }
}
        
    public void attacking(){
        
        spriteCOunter++;
        
        if(spriteCOunter <= 5){
            spriteNum = 1;
        }
        if(spriteCOunter > 5 && spriteCOunter <= 25){
            spriteNum = 2;
            
            // SOLID AREA
            int currentWorldX = x;
            int currentWorldY = y;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            
            // Adjust player x y for attackArea
            switch(direction){
                case "up": y -= attackArea.height; break;
                case "down": y += attackArea.height; break;
                case "left": x -= attackArea.width; break;
                case "right": x += attackArea.width; break;
            }
            
            //  Attack area becomes solid area
            solidArea.width =attackArea.width;
            solidArea.height =attackArea.height;
            
            // Check monster collision 
            int monsterIndex = gp.cDetector.checkEntity(this, gp.monster);
            
            x = currentWorldX;
            y = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
            damageMonster(monsterIndex);
        }
        if(spriteCOunter > 25){
            spriteNum = 1;
            spriteCOunter = 0;
            attacking= false;
        }
    }
    
    public void pickUpObject(int i) {
        
        if(i != 999) {
            
        
            
            
          String objectName = gp.obj[gp.currentMap][i].name;
          
            switch (objectName) {
                case "Key":
                    gp.playerSFX(3);
                    hasKey++;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                case "Door":
                    if(hasKey > 0){
                    gp.playerSFX(9);
                    gp.obj[gp.currentMap][i] = null;
                    hasKey--;
                    }
                    break;
                case "PowerBoots":
                    gp.playerSFX(2);
                    hasPowerBoots = true;
                    powerBootsTimer = 300; // Set the desired duration (in frames)
                    gp.obj[gp.currentMap][i] = null;                    
                    break;
                case "Potion":
                    gp.playerSFX(2);
                    hasSlowPotion = true;
                    potionTimer = 300;
                    gp.obj[gp.currentMap][i] = null;
                    break;  
                case "Heal":
                    gp.playerSFX(2);
                    gp.player.life += 2;
                    gp.obj[gp.currentMap][i] = null;
                    break;    
                case "Chest":
                    if(hasKey > 0){
                    gp.playerSFX(2);
                    gp.playerSFX(4);
                    hasChest++;
                    gp.obj[gp.currentMap][i] = null;
                    hasKey--;
                    }
                    break;
                    
                 case "Diamond":
                    if(hasKey > 0){
                    gp.playerSFX(2);
                    gp.playerSFX(4);
                    hasChest++;
                    gp.obj[gp.currentMap][i] = null;
                    hasKey--;
                    }
                    break;    
                    
                case "END":
                    if(hasChest > 0){
                    hasChest--;
                    gp.obj[gp.currentMap][i] = null;
                    gp.playerSFX(10);
                    gp.gameState = gp.cutSceneState;
                    gp.csManager.sceneNum = gp.csManager.ending;
                    }
                    break;
                    
                case "MetalDoor":
                    if(hasChest > 0){
                    gp.ui.gameDone = true;
                    gp.stopMusic();
                    gp.playerSFX(4);
                    hasChest--;
                    }
                    break;
                }
            }
        
            //INVINCIBLE COUNTER
        
            if(invincible==true){
                invincibleCounter++;
                if(invincibleCounter>60){
                    invincible=false;
                    invincibleCounter = 0;
                }
            }
        
        }
    
    public void Attack(int i){
        if(i != 999){
            if(gp.keyH.spacePressed == true){
                 
                attacking = true;
                
               
            }
        }
        gp.keyH.spacePressed = false;
    }
        
    public void contactMonster(int i){
        if(i != 999) {
            if(invincible == false){
            gp.playerSFX(7);
            life -=1;
            invincible = true;
            }
        }    
    }
    
    public void damageMonster(int i){
        if(i  != 999){
            if(gp.monster[gp.currentMap][i].invincible == false){
                gp.playerSFX(8);
                gp.monster[gp.currentMap][i].life -= 1;
                gp.monster[gp.currentMap][i].invincible = true;
                gp.monster[gp.currentMap][i].damageReaction();
                
                if(gp.monster[gp.currentMap][i].life <= 0){
                    gp.monster[gp.currentMap][i].dying = true;
                }
            }
        }
    }
    
    public void draw(Graphics2D g2){
//            g2.setColor(Color.WHITE);
//            g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        int tempScreenX = x;
        int tempScreenY = y;
        
        switch (direction) {
            case "up":
                if(attacking == false){
                    if(spriteNum == 1){image = up1;}
                    if(spriteNum == 2){image = up2;}
                }
                if(attacking == true){
                    tempScreenY = y - gp.tileSize;
                    if(spriteNum == 1){image = attackU1;}
                    if(spriteNum == 2){image = attackU2;}
                }
                
                break;
            case "down":
                if(attacking == false){
                    if(spriteNum == 1){image = down1;}
                    if(spriteNum == 2){image = down2;}
                }
                if(attacking == true){
                    if(spriteNum == 1){image = attack1;}
                    if(spriteNum == 2){image = attack2;}
                }
                break;
            case "left":
                if(attacking == false){
                    if(spriteNum == 1){image = left1;}
                    if(spriteNum == 2){ image = left2;}
                }
                if(attacking == true){
                    tempScreenX = x - gp.tileSize;
                    if(spriteNum == 1){image = attackL1;}
                    if(spriteNum == 2){ image = attackL2;}
                }
                break;
            case "right":
                if(attacking == false){
                    if(spriteNum == 1){image = right1;}
                    if(spriteNum == 2){image = right2;}
                }
                if(attacking == true){
                    if(spriteNum == 1){image = attackR1;}
                    if(spriteNum == 2){image = attackR2;}
                }
                break;
        }
         if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        
           g2.drawImage(image,tempScreenX , tempScreenY, null);
       
           g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
    }
    
}
