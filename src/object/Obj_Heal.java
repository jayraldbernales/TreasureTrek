package object;

import entity.Entity;
import javax.imageio.ImageIO;
import main.GamePanel;


/**
 *
 * @author jayrald
 */
public class Obj_Heal extends Entity {
    
   
    
    public Obj_Heal(GamePanel gp) {
        
        super(gp);
        name = "Heal";
        down1 = setUp("/objects/heart_full", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
