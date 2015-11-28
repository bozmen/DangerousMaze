
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
 
public class Light extends GameObject
{
    public int radius;
    
    public Light(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
       super(x, y, width, height, icon, collidible);
    }
    public void setRadius(int radius)
    {
        this.radius = radius;
    }
    public int getRadius()
    {
        return radius;
    }
    
    public boolean collides(GameObject o)
    {
        int distanceX = x - o.getX();
        int distanceY = y - o.getY();
        int actualDistance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        return (radius > actualDistance);
    }
}

