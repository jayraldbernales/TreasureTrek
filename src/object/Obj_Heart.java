package object;

import entity.Entity;
import main.GamePanel;

/**
 *
 * @author jayrald
 */
public class Obj_Heart extends Entity {
  

    public Obj_Heart(GamePanel gp) {
        
        super(gp);
        
        name = "Heart";
        image = setUp("/objects/heart_full", gp.tileSize, gp.tileSize);
        image2 = setUp("/objects/heart_half", gp.tileSize, gp.tileSize);
        image3 = setUp("/objects/heart_blank", gp.tileSize, gp.tileSize);
        
        
           
        collision = true;
    }    
}
