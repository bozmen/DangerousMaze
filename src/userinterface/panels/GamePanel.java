/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.panels;

import gameentities.GameObject;
import gamemanagement.gamelogic.GameManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import userinterface.GUIManager;


/**
 *
 * @author Erdi A.
 */
public class GamePanel extends JPanel implements ActionListener{

    // Variables
    private GUIManager guiManager;
    private GameManager gm = null;
    private JButton backToMenuPanel;
    private MapPanel mp;
       
    //Constructor
    public GamePanel(GUIManager guiManager) {
        this.guiManager = guiManager;
        setLayout(new GridBagLayout());
        mp = new MapPanel();
        this.add(mp);
        this.gm = new GameManager(this);
        setBackground(Color.black);
    }
    
    public void initiate(){
       this.gm = new GameManager(this);

       //backToMenuPanel = new JButton("Back");
       
       //backToMenuPanel.addActionListener(this);
   
       //add(backToMenuPanel,BorderLayout.EAST);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToMenuPanel)
            guiManager.setMenuPanelVisible();
    }
    
    public void paintObjects(List<GameObject> objects){
        mp.paintObjects(objects);
    }
    
    public void setMapSize(int width, int height){
        mp.setMapSize(width, height);
    }
    
    public void setActionListener(MouseInputListener ml, KeyListener kl){
        mp.addMouseListener(ml);
        mp.addMouseMotionListener(ml);
        mp.addKeyListener(kl);
    }
    
    public void setZoom(int m)
    {
        mp.ZOOM = m;
    }
}

class MapPanel extends JPanel {
    
    public java.util.List<GameObject> obj; 
    public int ZOOM;
    
    public MapPanel(){
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
        this.setFocusable(true);
        this.requestFocus();
    }
    
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if(obj != null){
            for(GameObject o : obj){
                o.draw(g, ZOOM);
            }
        }
    }
    
    public void paintObjects(List<GameObject> objects){
        this.obj = objects;
        repaint();
    }
    

    void setMapSize(int width, int height) {
        setPreferredSize(new Dimension(width*ZOOM+ZOOM*2, height*ZOOM+ZOOM*2));
    }
}
