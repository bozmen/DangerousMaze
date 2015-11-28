/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class GameObject
{
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected boolean isDestroyed;
    protected BufferedImage icon;
    protected boolean collidible;
    protected Rectangle hitBox;
    
    public GameObject(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    { 
        this.x = x;
        this.y = y;
        this.icon = icon;
        this.collidible = collidible;
        this.hitBox = new Rectangle(x, y, width, height);
        this.width = width;
        this.height = height;
        isDestroyed = false;
    }
    
    public void setX(int x)
    {
       this.x = x;
       hitBox.setLocation(x, y);
    }
    public int getX()
    {
        return x;
    }
    public void setY(int y)
    {
        this.y = y;
        hitBox.setLocation(x, y);
    }
    public int getY()
    {
        return y;
    }
    public Rectangle getRect()
    {
        return hitBox;
    }

    public BufferedImage getIcon(){
        return icon;
    }
    
    public void setIcon(BufferedImage icon)
    {
        this.icon = icon;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void update()
    {
        
    }
    
    public boolean isCollided(gameentities.Character c)
    {
        return this.getRect().intersects(c.getRect());
    }
    
    
    public void draw(Graphics g, int ratio){
        g.drawImage(icon, x*ratio, y*ratio, 
                        width*ratio, width*ratio,
                        null);
    }

    public void collided(gameentities.Character o2) {
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
    
    public void destroy() {
    	isDestroyed = true;
    }
}
