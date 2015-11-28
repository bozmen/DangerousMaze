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
public class LightNarrow extends PowerUp
{
    public LightNarrow(int x, int y, int width, int height, BufferedImage icon, boolean collidible)
    {
        super(x, y, width, height, icon, collidible);
    }
    
    @Override
    public void activate(){
        super.activate();
        attachedChar.light.setRadius(attachedChar.light.getRadius()/2);
        System.out.println("light narrow");
    }
    
    @Override
    public void deactivate(){
        super.deactivate();
        attachedChar.light.setRadius(attachedChar.light.getRadius()*2);
    }
    
}
