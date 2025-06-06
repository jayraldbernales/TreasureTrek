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
public class Obj_PowerBoots extends Entity {
    
    //public int bootCounter = 0;
    
    
    public Obj_PowerBoots(GamePanel gp) {
        
        super(gp);
    name = "PowerBoots";
    down1 = setUp("/objects/boots", gp.tileSize, gp.tileSize);
        
        collision = true;
        
        
//        if(bootCounter > 150) {
//            bootCounter = 0;
//            
//            
//        }
    }    

}
