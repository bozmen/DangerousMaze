/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemanagement.settings;

import externalsourcemanagement.FileManager;
import gameentities.FixedObstacle;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Burak Ö
 */
public class SettingsManager {
    public static Color wallColor;
    public static BufferedImage charIcon;
    public static boolean soundOn;
    public static FileManager fm;
    public static String charName;
    
    public SettingsManager()
    {
        fm = new FileManager();
    }

    
    public Color getWallColor(){
        return wallColor;
    }
    
    public static void setColor(String color)
    {
        switch(color)
        {
            case "Gray":
                FixedObstacle.color = Color.gray;
                break;
            case "Red":
                FixedObstacle.color = Color.red;
                break;
            case "Blue":
                FixedObstacle.color = Color.blue;
                break;
            case "Cyan":
                FixedObstacle.color = Color.cyan;
                break;
            case "Yellow":
                FixedObstacle.color = Color.yellow;
                break;
            case "Pink":
                FixedObstacle.color = Color.pink;
            case "Orange":
                FixedObstacle.color = Color.orange;
                break;
            case "White":
                FixedObstacle.color = Color.white;
                break;
            case "Green":
                FixedObstacle.color = Color.green;
                break;
        }
    }
    
    public BufferedImage getCharIcon(){
        return charIcon;
    }
    
    public static void setCharIcon(int index){
        fm = new FileManager();
        SettingsManager.charIcon = fm.readCharIcon(index);
    }
    
    public boolean isSoundOn(){
        return soundOn;
    }
}
