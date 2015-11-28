/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities;

import externalsourcemanagement.SoundManager;
import gameentities.powerups.Enlarge;
import gameentities.powerups.InstantDeath;
import gameentities.powerups.InstantWin;
import gameentities.powerups.LightExpand;
import gameentities.powerups.LightNarrow;
import gameentities.powerups.Scream;
import gameentities.powerups.Shrink;
import gameentities.powerups.Teleport;
import gameentities.powerups.Unstoppable;
import java.awt.image.BufferedImage;
import java.util.Random;


public class PowerUp extends GameObject
{
    Random selectPowerUp = new Random();
    public int duration;
    public boolean isOnEffect;
    public Character attachedChar;
     
    public PowerUp(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible);  
        duration = 500;
    }
    
    public void collided(Character c){
        this.destroy();
        SoundManager.cling();
        attach(c);
    }
    
    public void setDuration(int d){
    	this.duration = d;
    }
    
    public int getDuration(){
    	return duration;
    }
    
    public void activate(){
        isOnEffect = true;
        System.out.println("activated");
    }
    
    public void deactivate(){
        isOnEffect = false;
        System.out.println("deactivated");
    }
    
    public void attach(Character c){
        int selectedPowerUp = selectPowerUp.nextInt(9);
        PowerUp p;
        switch (selectedPowerUp)
        {
          //for enlarge
            case 0 : 
                p = new Enlarge(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
          //for instant death
            case 1 :
                p = new InstantDeath(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
           //for instant win
            case 2 :
                p = new InstantWin(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
           //for light expand
            case 3 :
                p = new LightExpand(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
           //for light narrow
            case 4 :
                p = new LightNarrow(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
           //for scream
            case 5 :
                p = new Scream(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
          //for shrink
            case 6 :
                p = new Shrink(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
          //for teleport    
            case 7 :
                p = new Teleport(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;
          //for unstoppable  
            case 8 :
                p = new Unstoppable(0, 0, 0, 0, null, false);
                c.attachPowerUp(p);
                break;                
        }
    }
}
