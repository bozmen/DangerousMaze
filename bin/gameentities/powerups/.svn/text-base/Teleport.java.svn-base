/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities.powerups;

import gameentities.PowerUp;
import gamemanagement.gamelogic.GameManager;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sera
 */
public class Teleport extends PowerUp
{
    public Teleport(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible);
    }
    
    @Override
    public void activate(){
        super.activate();
        attachedChar.setX((int) (Math.random()*(16*(GameManager.currentLevel +4))));
        attachedChar.setY((int) (Math.random()*(16*(GameManager.currentLevel +4))));
        System.out.println("teleport");
    }
    
    @Override
    public void deactivate(){
        super.deactivate();
    }
    
}
