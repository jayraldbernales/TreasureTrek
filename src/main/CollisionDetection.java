/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Entity;


/**
 *
 * @author jayrald
 */
public class CollisionDetection {
    GamePanel gp;
   
    public CollisionDetection(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity) {
        
        int entityLeftx = entity.x + entity.solidArea.x;
        int entityRightx = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopy = entity.y + entity.solidArea.y;
        int entityBottomy = entity.y + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftx/gp.tileSize;
        int entityRightCol = entityRightx/gp.tileSize;
        int entityTopRow = entityTopy/gp.tileSize;
        int entityBottomRow = entityBottomy/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
            case"up" :
                entityTopRow = (entityTopy - entity.speed) / gp.tileSize;
            if (entityTopRow >= 0) {
                entityTopRow = (entityTopy - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
            if (tileNum1 >= 0 && tileNum2 >= 0 && gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                entity.collisionOn = true;
        }
    }
                break;
            case "down" :
                entityBottomRow = (entityBottomy + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left" :
                entityLeftCol = (entityLeftx - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right" :
                entityRightCol = (entityRightx + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
        
    }
    
    public int checkObject(Entity entity, boolean player) {
     
        int index = 999;
        
        for(int i = 0; i < gp.obj[1].length; i++) {
            if(gp.obj[gp.currentMap][i] != null) {
                
                //GET ENTITY'S SOLID AREA COLLISION
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                
                //GET THE OBJECT'S SOLID AREA POSITION
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].x + gp.obj[gp.currentMap][i].solidArea.x;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].y + gp.obj[gp.currentMap][i].solidArea.y;
                
                switch(entity.direction) {
                    case "up":entity.solidArea.y -= entity.speed;break;
                    case "down":entity.solidArea.y += entity.speed;break;
                    case "left":entity.solidArea.x -= entity.speed;break;
                    case "right":entity.solidArea.x += entity.speed;break;
                }
                if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
                            if(gp.obj[gp.currentMap][i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
            }
        }
        
        return index;
    }

    //MONSTER
    public int checkEntity(Entity entity,Entity[][] target){
        int index = 999;
        
        for(int i = 0; i < target[1].length; i++) {
            if(target[gp.currentMap][i] != null) {
                
                //GET ENTITY'S SOLID AREA COLLISION
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                
                //GET THE OBJECT'S SOLID AREA POSITION
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].x + target[gp.currentMap][i].solidArea.x;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].y + target[gp.currentMap][i].solidArea.y;
                
                switch(entity.direction) {
                    case "up":entity.solidArea.y -= entity.speed;break;
                    case "down":entity.solidArea.y += entity.speed;break;
                    case "left":entity.solidArea.x -= entity.speed;break;
                    case "right":entity.solidArea.x += entity.speed;break;
                }
                if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
                    if(target[gp.currentMap][i] != entity){
                          entity.collisionOn = true;
                          index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    
    public boolean checkPlayer(Entity entity){
        
        boolean contactPlayer = false;
        
           //GET ENTITY'S SOLID AREA COLLISION
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                
                //GET THE OBJECT'S SOLID AREA POSITION
                gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
                gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;
                
                switch(entity.direction) {
                    case "up":entity.solidArea.y -= entity.speed;break;
                    case "down":entity.solidArea.y += entity.speed;break;
                    case "left":entity.solidArea.x -= entity.speed;break;
                    case "right": entity.solidArea.x += entity.speed;break;
                }
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                            entity.collisionOn = true;
                            contactPlayer = true;
                        }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.player.solidArea.x = gp.player.solidAreaDefaultX;
                gp.player.solidArea.y = gp.player.solidAreaDefaultY;
                return contactPlayer;
            
    }
}
