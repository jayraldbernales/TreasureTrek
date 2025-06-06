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
public class Obj_Diamond extends Entity{
    
    
    public Obj_Diamond(GamePanel gp) {
        
        super(gp);
        
        name = "Diamond";
        down1 = setUp("/objects/Diamond", gp.tileSize, gp.tileSize);
        
        collision = true;
        
    }    
    
}
