/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameentities.powerups;

import externalsourcemanagement.SoundManager;
import gameentities.PowerUp;
import gamemanagement.gamelogic.GameManager;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sera
 */
public class InstantWin extends PowerUp
{
    public InstantWin(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible);
    }
    
    
    @Override
    public void activate(){
        super.activate();
        SoundManager.levelFinished();
        attachedChar.setY(16*(GameManager.currentLevel +4) + 100);
        System.out.println("instant win");
    }
    
    @Override
    public void deactivate(){
        super.deactivate();
    }
    
}
