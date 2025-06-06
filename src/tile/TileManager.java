
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author jayrald
 */
public class TileManager {
     
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];
    
    public TileManager(GamePanel gp){
        
        this.gp = gp;
        
        tile = new Tile[40];
        mapTileNum = new int [gp.maxMap][gp.maxScreenCol][gp.maxScreenRow];
        
        getTileImage();
        loadMap("/maps/1Cave.txt", 0);
        loadMap("/maps/2Jungle.txt", 1);
        loadMap("/maps/4Desert.txt", 2);
        loadMap("/maps/3Beach.txt", 3);
        loadMap("/maps/5Abandoned.txt", 4);
    }
    public void getTileImage(){
      
            // CAVE
            setUp(0, "grass", false);
            setUp(1, "wall", true);
            setUp(2, "water", false);
            setUp(3, "earth", false);
            setUp(4, "sand", false);
            setUp(5, "tree", true);
            setUp(6, "cave", true);
            setUp(7, "earth", false);
            setUp(8, "cave_rock", true);
            setUp(9, "cave_stone", true);
            
            //JUNGLE
            setUp(10, "JungleTile1", true);
            setUp(11, "JungleTile2", true);
            setUp(12, "JungleTile3", true);
            setUp(13, "JungleTile4", true);
            setUp(14, "JungleTile5", false);
            setUp(15, "JungleTile6", true);
            
            // BEACH
            setUp(16, "beachTile1", true);
            setUp(17, "beachTile2", true);
            setUp(18, "beachTile3", true);
            setUp(19, "beachTile4", false);
            setUp(20, "beachTile5", true);
        
            // DESSERT
            setUp(21, "DessertTile1", true);
            setUp(22, "DessertTile2", true);
            setUp(23, "DessertTile3", true);
            setUp(24, "DessertTile4", true);
            setUp(25, "DessertTile5", false);
            setUp(26, "DessertTile6", true);
            setUp(27, "DessertTile7", false);
            
            
            // ABANDONED
            setUp(28, "abandon1", true);
            setUp(29, "abandon2", true);
            setUp(30, "abandon3", true);
            setUp(31, "abandon4", true);
            setUp(32, "abandon5", true);
            setUp(33, "abandon6", true);
            setUp(34, "abandon7", true);
            setUp(35, "abandon8", false);
            setUp(36, "abandon9", false);
    }
    
    public void setUp(int index, String imageName, boolean collision){
        
        UtilityTool uTool = new UtilityTool();
        
        try {
          
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName +".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void loadMap(String filePath, int map){
        try {
            
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
           while (col<gp.maxScreenCol && row < gp.maxScreenRow) {
      
            String line = br.readLine();
            
            while (col<gp.maxScreenCol ) {
       
                String numbers[] = line.split(" ");
                
                int num = Integer.parseInt(numbers[col]);
                
                mapTileNum[map][col][row] = num;
                col++;  
        }
            if(col == gp.maxScreenCol){
                col = 0;
                row++;
            }
    }      
            br.close();
         } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2){
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y =0;
        
        while (col<gp.maxScreenCol && row < gp.maxScreenRow) {
            
            int tileNum = mapTileNum[gp.currentMap][col][row];
      
            g2.drawImage(tile[tileNum].image, x, y , null);
            col++;
            x += gp.tileSize;
            
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
            
        }
        
        
    }
    
}
