package object;

import entity.Entity;
import main.GamePanel;



/**
 *
 * @author jayrald
 */
public class Obj_Key extends Entity{
    
   

    public Obj_Key(GamePanel gp) {
        
        super(gp);  
    name = "Key";
    down1 = setUp("/objects/key2", gp.tileSize, gp.tileSize);
        
           
        collision = true;
    }    
}
