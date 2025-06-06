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
public class Obj_MetalDoor extends Entity {
    
    
    public Obj_MetalDoor(GamePanel gp) {
        
        super(gp);
        
    name = "MetalDoor";
    down1 = setUp("/objects/door_iron", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
