/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsourcemanagement;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import util.QuadTree;
import gameentities.Character;
import gameentities.FixedObstacle;
import gameentities.GameObject;
import gameentities.PowerUp;
import gamemanagement.gamelogic.GameManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Burak Ö
 */
public class MapManager {
    private FileManager fm;
    private GameManager gm;
    
    public MapManager(GameManager gm)
    {
        fm = new FileManager();
        this.gm = gm;
    }
    
    private List<GameObject> analyseImage(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        
        List<GameObject> list = new ArrayList<GameObject>();
        
        int wallCount = 0;
        int charCount = 0;
        int powerUpCount = 0;
        
        for(int i = 0; i < h; i+=2){
            for(int j = 0; j < w; j+=2){
                //System.out.print("x: " + j + " y: " + i + " ");
                int pixel = image.getRGB(j, i);
                // Character
                if(getRedARGB(pixel) == 100)
                {
                    charCount++;
                    System.out.println("Char location: " + j + " " + i);
                    BufferedImage icon = fm.readCharIcon(4);
                    Character c = new Character(j, i, 6, 6, icon, true);
                    list.add(c);
                    gm.setChar(c);
                }
                // Powerups
                else if(getRedARGB(pixel) == 200)
                {
                    powerUpCount++;
                    System.out.println("Powerup location: " + j + " " + i);
                    BufferedImage icon = fm.readPowerUpIcon();
                    list.add(new PowerUp(j, i, 6, 6, icon, true));
                }
                // Walls/obstacles
                else if(getRedARGB(pixel) == 0)
                {
                    wallCount++;
                    list.add(new FixedObstacle(j, i, 2, 2, null, true));
                }     
            }
        };
        System.out.println("Wall count: " + wallCount +
                " Char count: " + charCount +
                " Power-up count: " + powerUpCount);
        return list;
    }
    
    public List<GameObject> getLevel(int level){
        int map = level + 4;
        //String mapName = map + "x" + map + ".png";
        String mapName = map + "x" + map + ".png";
        BufferedImage image = fm.readMap(mapName);
        List<GameObject> list = analyseImage(image);
        return list;
    }
    
    private int getRedARGB(int pixel){
        return (pixel >> 16) & 0xff;
    }
}
