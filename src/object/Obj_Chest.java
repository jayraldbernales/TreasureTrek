/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Entity;
import main.GamePanel;

/**
 *
 * @author jayrald
 */
public class Obj_Chest extends Entity{
    
    
    public Obj_Chest(GamePanel gp) {
        
        super(gp);
        
        name = "Chest";
        down1 = setUp("/objects/chest1", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
