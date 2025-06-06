package object;

import entity.Entity;
import javax.imageio.ImageIO;
import main.GamePanel;


/**
 *
 * @author jayrald
 */
public class Obj_Door extends Entity {
    
   
    
    public Obj_Door(GamePanel gp) {
        
        super(gp);
        
        name = "Door";
        down1 = setUp("/objects/door4", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
