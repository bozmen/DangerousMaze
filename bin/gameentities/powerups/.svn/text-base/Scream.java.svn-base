/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities.powerups;

import externalsourcemanagement.SoundManager;
import gameentities.PowerUp;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sera
 */
public class Scream extends PowerUp
{
    public Scream(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible);
    }
    
    @Override
    public void activate(){
        super.activate();
        SoundManager.scream();
        System.out.println("scream");
    }
    
    @Override
    public void deactivate(){
        super.deactivate();
    }
    
}
