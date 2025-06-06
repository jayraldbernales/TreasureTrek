
package monster;

import entity.Entity;
import java.awt.Rectangle;
import java.util.Random;
import main.GamePanel;
import object.Obj_Heal;
import object.Obj_PowerBoots;
import object.Obj_SlowPotion;
/**
 *
 * @author jayrald
 */
public class AbandonMons2 extends Entity{
    
    public AbandonMons2(GamePanel gp){
        super(gp);
        
        name = "Snake";
        speed =3;
        maxLife = 8;
        life = maxLife;
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 42;
        solidArea.height = 42; 
        
        getImage();
        
    }
    
    public void getImage(){

        // ABANDON
        up1 = setUp("/AbandonMons/AsnakeU1", gp.tileSize, gp.tileSize);
        up2 = setUp("/AbandonMons/AsnakeU2", gp.tileSize, gp.tileSize);
        down1 = setUp("/AbandonMons/AsnakeD1", gp.tileSize, gp.tileSize);
        down2 = setUp("/AbandonMons/AsnakeD2", gp.tileSize, gp.tileSize);
        left1 = setUp("/AbandonMons/AsnakeL1", gp.tileSize, gp.tileSize);
        left2 = setUp("/AbandonMons/AsnakeL2", gp.tileSize, gp.tileSize);
        right1 = setUp("/AbandonMons/AsnakeR1", gp.tileSize, gp.tileSize);
        right2 = setUp("/AbandonMons/AsnakeR2", gp.tileSize, gp.tileSize);
    }
    
    public void setAction(){
        
        actionLockCounter++;
        
        if(actionLockCounter == 60){
            Random random = new Random();
        int i = random.nextInt(100)+1;// pick up number from 1 - 100
        
        if (i<= 25) {
            direction = "up";
        }
        if (i > 25 && i<=50) {
            direction = "down";
        }
        if (i > 50 && i<=75) {
            direction = "left";
        }
        if (i > 75 && i<=100) {
            direction = "right";
        }
        actionLockCounter = 0;
        }
    }
    
   public void damageReaction() {
    actionLockCounter = 0;
//    direction = gp.player.direction;

    // Get the player's direction
    String playerDirection = gp.player.direction;

    // Determine the opposite direction
    String oppositeDirection = "";
    switch (playerDirection) {
        case "up":
            oppositeDirection = "down";
            break;
        case "down":
            oppositeDirection = "up";
            break;
        case "left":
            oppositeDirection = "right";
            break;
        case "right":
            oppositeDirection = "left";
            break;
    }
    direction = oppositeDirection;
}
    public void checkDrop(){
        
        // CAST A DIE
        int i = new Random().nextInt(100)+1;
        
        // SET THE MONSTER DROP
        if(i>0 && i<50 ){
            // NO DROP
        }
        if(i>=50 && i<80){
           dropItem(new Obj_SlowPotion(gp));
        }
        if(i>=80 && i<90){
            dropItem(new Obj_Heal(gp));
        }
        if(i>=90 && i<100){
           dropItem(new Obj_PowerBoots(gp));
        }
    }
        
}
