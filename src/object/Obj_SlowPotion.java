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
public class Obj_SlowPotion extends Entity{
    
    
    
    public Obj_SlowPotion(GamePanel gp) {
        
        super(gp);
    name = "Potion";
    down1 = setUp("/objects/potion", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
}
