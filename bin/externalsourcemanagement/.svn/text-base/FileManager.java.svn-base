/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsourcemanagement;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Burak Ö
 */
public class FileManager {
    
    public BufferedImage readMap(String path)
    {
        BufferedImage img = null;
        String filePath = new File("").getAbsolutePath();
        try{
            img = ImageIO.read(new File("resources\\maps\\" + path));
        }
        catch (IOException e){
            System.out.println("Image not found.");
        }
        
        return img;
    }
    
    public BufferedImage readCharIcon(int index){
        BufferedImage img = null;
        String filePath = new File("").getAbsolutePath();
        try{
            img = ImageIO.read(new File("resources\\icons\\charsprite.png")).getSubimage(index%4*12, index/4*12, 12, 12);
        }
        catch (IOException e){
            System.out.println("Image not found.");
        }
        
        return img;
    }
    
    public BufferedReader readHighScores(String path)
    {
        BufferedReader r = null;
        try{
            r = new BufferedReader(new FileReader(path));
        }
        catch (IOException e){
            System.out.println("File not found.");
        }
        
        return r;
    }
    
    public BufferedReader readSettings(String path)
    {
        BufferedReader r = null;
        try{
            r = new BufferedReader(new FileReader(path));
        }
        catch (IOException e){
            System.out.println("File not found.");
        }
        
        return r;
    }

    public BufferedImage readPowerUpIcon() {
        BufferedImage img = null;
        String filePath = new File("").getAbsolutePath();
        try{
            img = ImageIO.read(new File("resources\\icons\\powerup.png")); 
        }
        catch (IOException e){
            System.out.println("Image not found.");
        }
        
        return img;
    }
}
