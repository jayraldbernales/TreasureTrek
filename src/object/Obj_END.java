
package object;

import entity.Entity;
import javax.imageio.ImageIO;
import main.GamePanel;


/**
 *
 * @author jayrald
 */
public class Obj_END extends Entity {
    
    
    public Obj_END(GamePanel gp) {
        
        super(gp);
        
    name = "END";
    down1 = setUp("/objects/END", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
