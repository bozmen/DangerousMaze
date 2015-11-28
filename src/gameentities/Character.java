
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Character extends GameObject
{
    public Light light;
    private boolean isInvulnerable;
    private Point initialPos;
    private List<PowerUp> powerUps;
    
    public Character(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible); 
        light = new Light(x, y, 1, 1, null, false);
        light.setRadius(30);
        powerUps = new ArrayList<PowerUp>();
    }
    public void setSize(int height, int width)
    {
    	if (height > 0)
    		this.height = height;
    	if (width > 0)
    		this.width = width;
        hitBox.setSize(width, height);
    }
    
    public Light getLight()
    {
        return light;
    }
    
    public boolean contains(Point p){
       return this.getRect().contains(p);
    }
    
    public void update()
    {
        this.light.setX(x);
        this.light.setY(y);
        for(int i = powerUps.size() - 1; i >= 0; i--){
            PowerUp p = powerUps.get(i);
            if(p.duration > 0){
                if(!p.isOnEffect){
                    p.activate();
                }
                else
                    p.duration--;
            }
            else if(p.duration <= 0){
                p.deactivate();
                powerUps.remove(p);
            }
        }
    }
    
    public void setInitialPoint(Point x){
        this.initialPos = x;
    }
    
    public Point getInitialPoint(){
        return initialPos;
    }
    
    public void attachPowerUp(PowerUp p){
        powerUps.add(p);
        p.attachedChar = this;
    }
    
    public List<PowerUp> getPowerUps(){
    	return powerUps;
    }
    
    public void moveTo(int x, int y){
    	setX(x);
    	setY(y);
    }
    
    public void kill(){
        if(!isInvulnerable){
            setX(getInitialPoint().x);
            setY(getInitialPoint().y);
        }
        /*for(int i = powerUps.size() - 1; i >= 0; i--){
            powerUps.remove(i);
        }*/
    }
    
    public void setInvulnerable(boolean b){
        this.isInvulnerable = b;
    }
    
    public boolean isInvulnerable(){
    	return isInvulnerable;
    }
}
