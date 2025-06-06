/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Entity;
import javax.imageio.ImageIO;
import main.GamePanel;


/**
 *
 * @author jayrald
 */
public class Obj_Entrance extends Entity {
    
    
    public Obj_Entrance(GamePanel gp) {
        
        super(gp);
        
    name = "Entrance";
    down1 = setUp("/objects/EXIT", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
