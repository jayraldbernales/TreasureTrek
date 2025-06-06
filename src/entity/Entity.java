
package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author jayrald
 */
public class Entity {
    
    public GamePanel gp;
    public int x, y;
    public int speed;
    
    public BufferedImage up1, up2 ,down1 ,down2, right1, right2, left1, left2, TitleImage, Chest,Chest1;
    public BufferedImage attack1, attack2,attackL1, attackL2, attackR1, attackR2, attackU1, attackU2;
    public String direction = "down";
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    
    // COUNTER
    public int spriteCOunter = 0;
    public int invincibleCounter = 0;
    public int actionLockCounter = 0;
    
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public boolean invincible = false;
    public boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    public int dyingCounter = 0;
    public boolean  hpBarOn = false;
    public int hpBarCounter = 0;
    
    
    //CHARACTER STATUS
    public int maxLife;
    public int life;
    
    
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    
    
    public void setAction(){}
    public void damageReaction(){}
    public void checkDrop(){}  
    public void dropItem(Entity droppedItem){
    
    for(int i = 0; i < gp.obj[1].length; i++){
        if(gp.obj[gp.currentMap][i] == null){
            gp.obj[gp.currentMap][i]= droppedItem;
            gp.obj[gp.currentMap][i].x = x;
            gp.obj[gp.currentMap][i].y = y;
            break;
        }
        
    }
    }  
    public void update(){
        setAction();
        
        collisionOn = false;
        gp.cDetector.checkTile(this);
        gp.cDetector.checkObject(this, false);
        boolean contactPlayer = gp.cDetector.checkPlayer(this);
        gp.cDetector.checkEntity(this, gp.monster);
        
        if(contactPlayer == true){
            if(gp.player.invincible == false){
                gp.playerSFX(7);
                gp.player.life -= 1;
                gp.player.invincible =true;
            }
        }
        
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
            
            if(invincible==true){
                invincibleCounter++;
            if(invincibleCounter>40){
                invincible=false;
                invincibleCounter = 0;
            }
       }
        
    }
    public void draw(Graphics2D g2) {
        
         BufferedImage image = null;
        
        switch (direction) {
            case "up":
                if(spriteNum == 1){image = up1;}
                if(spriteNum == 2){image = up2;}
                break;
            case "down":
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}
                break;
            case "left":
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}
                break;
            case "right":
                if(spriteNum == 1){image = right1;}
                if(spriteNum == 2){image = right2;}
                break;
        }
        
        //MONSTER LIFE BAR
        
    boolean isMonster = false;
    for (Entity[] monsterArray : gp.monster) {
    for (Entity monsterEntity : monsterArray) {
        if (this == monsterEntity) {
            isMonster = true;
            break;
        }
    }
    if (isMonster) {
        // If the entity is found in any of the arrays, break out of the outer loop
        break;
    }
}
    if (isMonster && hpBarOn == true) {
        // Draw the monster's life bar
        
        double oneScale = (double)gp.tileSize/maxLife;
        double hpBarValue = oneScale*life;
                
        g2.setColor(new Color(35, 35, 35));
        g2.fillRect(x-1, y - 16, gp.tileSize+2, 12);
        g2.setColor(new Color(255, 0, 33));
        g2.fillRect(x, y - 15, (int)hpBarValue, 10);

        hpBarCounter++;
        
        if(hpBarCounter>600){
            hpBarCounter = 0;
            hpBarOn = false;
        }
    }
        
       // Other code for handling invincibility and dying animations
        if (invincible == true) {
            hpBarOn = true;
            hpBarCounter = 0;
            changeAlpha(g2, 0.5f);
           
        }

        if (dying == true) {
            dyingAnimation(g2);
        }
        
       g2.drawImage(image, x, y , null);
       
       changeAlpha(g2, 1f);
    }
    
    public void dyingAnimation(Graphics2D g2){
        
        dyingCounter++;
        if(dyingCounter <= 5){ changeAlpha(g2, 0f);}
        if(dyingCounter > 5 && dyingCounter <= 10){ changeAlpha(g2, 1f);}
        if(dyingCounter > 10 && dyingCounter <= 15){ changeAlpha(g2, 0f);}
        if(dyingCounter > 15 && dyingCounter <= 20){ changeAlpha(g2, 1f);}
        if(dyingCounter > 20 && dyingCounter <= 25){ changeAlpha(g2, 0f);}
        if(dyingCounter > 25 && dyingCounter <= 30){ changeAlpha(g2, 1f);}
        if(dyingCounter > 35 && dyingCounter <= 40){ changeAlpha(g2, 0f);}
        if(dyingCounter > 45 && dyingCounter <= 50){ changeAlpha(g2, 1f);}
        if(dyingCounter > 40){
            dying = false;
            alive = false;
        }
    }
    
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
    
    public BufferedImage setUp(String imagePath, int width, int height){
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
          
         image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
         image = uTool.scaleImage(image, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    
}
