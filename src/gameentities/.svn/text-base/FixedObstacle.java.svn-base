
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities;

import externalsourcemanagement.SoundManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;


public class FixedObstacle extends Obstacle
{
    public static Color color = Color.gray;
    public FixedObstacle(int x, int y, int width, int height, BufferedImage icon, boolean collidible) {
        super(x, y, width, height, icon, collidible);
    }
    
    public void draw(Graphics g, int ratio){
        g.setColor(color);
        g.fillRect(x*ratio, y*ratio, width*ratio, height*ratio);
    }
    
    public void collided(Character c){
        c.kill();
        SoundManager.hit();
    }
    
}

