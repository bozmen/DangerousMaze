/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities.powerups;

import gameentities.PowerUp;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sera
 */
public class InstantDeath extends PowerUp
{
    public InstantDeath(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible);
    }
    
    @Override
    public void activate(){
        super.activate();
        attachedChar.kill();
        System.out.println("instant death");
    }
    
    @Override
    public void deactivate(){
        super.deactivate();
    }
    
}
