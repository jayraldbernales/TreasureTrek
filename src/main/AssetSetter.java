package main;

import monster.AbandonMons;
import monster.AbandonMons2;
import monster.AbandonMons3;
import monster.BeachMons;
import monster.BeachMons2;
import monster.BeachMons3;
import monster.CaveMons;
import monster.CaveMons2;
import monster.CaveMons3;
import monster.DesertMons;
import monster.DesertMons2;
import monster.DesertMons3;
import monster.JungleMons;
import monster.JungleMons2;
import monster.JungleMons3;
import object.Obj_Chest;
import object.Obj_Diamond;
import object.Obj_Door;
import object.Obj_END;
import object.Obj_Entrance;
import object.Obj_Heal;
import object.Obj_Key;
import object.Obj_MetalDoor;
import object.Obj_PowerBoots;
/**
 *
 * @author jayrald
 */
public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setObject(){
        
        int i = 0;
        int mapNum = 0;
        CaveObj(mapNum);
        
        mapNum = 1;
        JungleObj(mapNum);
        
        mapNum = 2;
        DesertObj( mapNum);
        
        mapNum = 3;
        BeachObj(mapNum);
        
        
         mapNum = 4;
        AbandonObj(mapNum);
    }
    
    public void setMonster(){
        
        int i = 0;
        int mapNum = 0;
        Cave(mapNum);
        
        mapNum = 1;
        Jungle(mapNum);
        
        
        mapNum = 2;
        Desert(mapNum);
        
        mapNum = 3;
        Beach(mapNum);
        
        mapNum = 4;
        Abandon(mapNum);
    }
    public void CaveObj(int mapNum){
        int i = 0;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 10 * gp.tileSize;
        gp.obj[mapNum][i].y = 7* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 10 * gp.tileSize;
        gp.obj[mapNum][i].y = 5 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 8 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 12 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 4 * gp.tileSize;
        gp.obj[mapNum][i].y = 10 * gp.tileSize;
        i++;
        
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 15 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 10 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Chest(gp);
        gp.obj[mapNum][i].x = 9 * gp.tileSize;
        gp.obj[mapNum][i].y = 13 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_MetalDoor(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 0 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_PowerBoots(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 2* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Entrance(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 14 * gp.tileSize;
        i++;
    }
    public void Cave(int mapNum){
        int i = 0;
        
        // MONSTER
        
        gp.monster[mapNum][i] = new CaveMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*3;
        gp.monster[mapNum][i].y =gp.tileSize*2;
        i++;
        
        gp.monster[mapNum][i] = new CaveMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize*13;
        gp.monster[mapNum][i].y =gp.tileSize*12;
        i++;
        
        gp.monster[mapNum][i] = new CaveMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*3;
        gp.monster[mapNum][i].y =gp.tileSize*12;
        i++;
        
        gp.monster[mapNum][i] = new CaveMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*18;
        gp.monster[mapNum][i].y =gp.tileSize;
        i++;
        
        gp.monster[mapNum][i] = new CaveMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize*7;
        gp.monster[mapNum][i].y =gp.tileSize*9;
        i++;
        
        gp.monster[mapNum][i] = new CaveMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*13;
        gp.monster[mapNum][i].y =gp.tileSize*5;
        i++;
        
        gp.monster[mapNum][i] = new CaveMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*4;
        gp.monster[mapNum][i].y =gp.tileSize*4;
        i++;
    }
    public void DesertObj(int mapNum){
         int i = 0;
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 11 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 9 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 16 * gp.tileSize;
        gp.obj[mapNum][i].y = 2 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 7 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 4 * gp.tileSize;
        gp.obj[mapNum][i].y = 6 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 6 * gp.tileSize;
        gp.obj[mapNum][i].y = 10 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 13 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 4 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 7 * gp.tileSize;
        gp.obj[mapNum][i].y = 7 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 6* gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 17* gp.tileSize;
        gp.obj[mapNum][i].y = 4* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 2* gp.tileSize;
        gp.obj[mapNum][i].y = 4 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 1* gp.tileSize;
        gp.obj[mapNum][i].y = 7 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Chest(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 7 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_MetalDoor(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 0 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_PowerBoots(gp);
        gp.obj[mapNum][i].x = 10 * gp.tileSize;
        gp.obj[mapNum][i].y = 1* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Entrance(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 14 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Heal(gp);
        gp.obj[mapNum][i].x = 12 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Heal(gp);
        gp.obj[mapNum][i].x = 2 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
    }
    public void Desert(int mapNum){
        int i = 0;
        
        // MONSTER
        gp.monster[mapNum][i] = new DesertMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 7;
        gp.monster[mapNum][i].y =gp.tileSize* 3;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 4;
        gp.monster[mapNum][i].y =gp.tileSize* 1;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 16;
        gp.monster[mapNum][i].y =gp.tileSize* 9;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 7;
        gp.monster[mapNum][i].y =gp.tileSize* 8;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 13;
        gp.monster[mapNum][i].y =gp.tileSize* 1;
        i++;
                
        gp.monster[mapNum][i] = new DesertMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 3;
        gp.monster[mapNum][i].y =gp.tileSize* 12;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 13;
        gp.monster[mapNum][i].y =gp.tileSize* 3;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*1;
        gp.monster[mapNum][i].y =gp.tileSize*4;
        i++;
        
        gp.monster[mapNum][i] = new DesertMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*11;
        gp.monster[mapNum][i].y =gp.tileSize*10;
        i++;
    }
    public void BeachObj(int mapNum){
        int i = 0;
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 17 * gp.tileSize;
        gp.obj[mapNum][i].y = 5 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 15 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 13 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 2 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 7 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 2 * gp.tileSize;
        gp.obj[mapNum][i].y = 7 * gp.tileSize;
        i++;
        
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 8 * gp.tileSize;
        gp.obj[mapNum][i].y = 5 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 11 * gp.tileSize;
        gp.obj[mapNum][i].y = 13 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 13 * gp.tileSize;
        gp.obj[mapNum][i].y =1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 2 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Chest(gp);
        gp.obj[mapNum][i].x = 4 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_MetalDoor(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 0 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_PowerBoots(gp);
        gp.obj[mapNum][i].x = 15 * gp.tileSize;
        gp.obj[mapNum][i].y = 5* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Heal(gp);
        gp.obj[mapNum][i].x = 11 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Entrance(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 14 * gp.tileSize;
        i++;
    }
    public void Beach(int mapNum){
        int i = 0;
        
        // MONSTER
        gp.monster[mapNum][i] = new BeachMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 1;
        gp.monster[mapNum][i].y =gp.tileSize* 3;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 4;
        gp.monster[mapNum][i].y =gp.tileSize* 2;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 4;
        gp.monster[mapNum][i].y =gp.tileSize* 7;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 1;
        gp.monster[mapNum][i].y =gp.tileSize* 11;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 9;
        gp.monster[mapNum][i].y =gp.tileSize* 7;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 16;
        gp.monster[mapNum][i].y =gp.tileSize* 1;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 5;
        gp.monster[mapNum][i].y =gp.tileSize* 2;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*9;
        gp.monster[mapNum][i].y =gp.tileSize*11;
        i++;
        
        gp.monster[mapNum][i] = new BeachMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*15;
        gp.monster[mapNum][i].y =gp.tileSize*6;
        i++;
    }
    public void JungleObj(int mapNum){
         int i = 0;
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 8 * gp.tileSize;
        gp.obj[mapNum][i].y = 9 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 7 * gp.tileSize;
        gp.obj[mapNum][i].y = 6 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 10 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 14 * gp.tileSize;
        gp.obj[mapNum][i].y = 2 * gp.tileSize;
        i++;
        
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 11 * gp.tileSize;
        gp.obj[mapNum][i].y = 6 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 14 * gp.tileSize;
        gp.obj[mapNum][i].y = 8 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Chest(gp);
        gp.obj[mapNum][i].x = 9 * gp.tileSize;
        gp.obj[mapNum][i].y = 5 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_MetalDoor(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 0 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_PowerBoots(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 7* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Entrance(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 14 * gp.tileSize;
        i++;
}
    public void Jungle(int mapNum){
        int i = 0;
        
        // MONSTER
        gp.monster[mapNum][i] = new JungleMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*16;
        gp.monster[mapNum][i].y =gp.tileSize*10;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*7;
        gp.monster[mapNum][i].y =gp.tileSize*12;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*12;
        gp.monster[mapNum][i].y =gp.tileSize*6;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 13;
        gp.monster[mapNum][i].y =gp.tileSize* 13;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize* 3;
        gp.monster[mapNum][i].y =gp.tileSize* 4;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*4;
        gp.monster[mapNum][i].y =gp.tileSize*3;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*2;
        gp.monster[mapNum][i].y =gp.tileSize*8;
        i++;
        
        gp.monster[mapNum][i] = new JungleMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*5;
        gp.monster[mapNum][i].y =gp.tileSize*8;
        i++;
    }
    public void AbandonObj(int mapNum){
        int i = 0;
        
        gp.obj[mapNum][i]=new Obj_Entrance(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 14 * gp.tileSize;
        i++;
        
        //change to 18
        gp.obj[mapNum][i]=new Obj_Diamond(gp);
        gp.obj[mapNum][i].x = 15 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_END(gp);
        gp.obj[mapNum][i].x = 18 * gp.tileSize;
        gp.obj[mapNum][i].y = 0 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 9 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        //key 16
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 14 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 11 * gp.tileSize;
        gp.obj[mapNum][i].y = 11* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 2* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 13* gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 13 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 1 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Key(gp);
        gp.obj[mapNum][i].x = 12 * gp.tileSize;
        gp.obj[mapNum][i].y = 6 * gp.tileSize;
        i++;
        
        //Delete
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 16 * gp.tileSize;
        gp.obj[mapNum][i].y = 5 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 10 * gp.tileSize;
        gp.obj[mapNum][i].y = 1 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 14 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 4 * gp.tileSize;
        gp.obj[mapNum][i].y = 6 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 11 * gp.tileSize;
        gp.obj[mapNum][i].y = 13 * gp.tileSize;
        i++;
        
        
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 4 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_Door(gp);
        gp.obj[mapNum][i].x = 6 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i]=new Obj_PowerBoots(gp);
        gp.obj[mapNum][i].x = 10 * gp.tileSize;
        gp.obj[mapNum][i].y = 3 * gp.tileSize;
        i++;
 
        gp.obj[mapNum][i]=new Obj_Heal(gp);
        gp.obj[mapNum][i].x = 5 * gp.tileSize;
        gp.obj[mapNum][i].y = 12 * gp.tileSize;
        i++;
    }    
    public void Abandon(int mapNum){
        int i = 0;
        // MONSTER
        
        gp.monster[mapNum][i] = new AbandonMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*3;
        gp.monster[mapNum][i].y =gp.tileSize*2;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*17;
        gp.monster[mapNum][i].y =gp.tileSize*7;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*13;
        gp.monster[mapNum][i].y =gp.tileSize*6;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize*5;
        gp.monster[mapNum][i].y =gp.tileSize*1;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize*14;
        gp.monster[mapNum][i].y =gp.tileSize*13;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize*1;
        gp.monster[mapNum][i].y =gp.tileSize*10;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*5;
        gp.monster[mapNum][i].y =gp.tileSize*9;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*10;
        gp.monster[mapNum][i].y =gp.tileSize*4;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*7;
        gp.monster[mapNum][i].y =gp.tileSize*3;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*12;
        gp.monster[mapNum][i].y =gp.tileSize*5;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons(gp);
        gp.monster[mapNum][i].x =gp.tileSize*7;
        gp.monster[mapNum][i].y =gp.tileSize*12;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons2(gp);
        gp.monster[mapNum][i].x =gp.tileSize*14;
        gp.monster[mapNum][i].y =gp.tileSize*5;
        i++;
        
        gp.monster[mapNum][i] = new AbandonMons3(gp);
        gp.monster[mapNum][i].x =gp.tileSize*9;
        gp.monster[mapNum][i].y =gp.tileSize*6;
        i++;
    }
}
