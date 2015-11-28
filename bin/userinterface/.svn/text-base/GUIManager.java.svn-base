/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import gamemanagement.gamelogic.GameManager;
import userinterface.panels.HighScoresPanel;
import userinterface.panels.HelpPanel;
import userinterface.panels.GamePanel;
import userinterface.panels.SettingsPanel;
import userinterface.panels.CreditsPanel;
import userinterface.panels.MenuPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Erdi A.
 */
public class GUIManager extends javax.swing.JFrame {
    
    // Variables
    
    private JPanel currentPanel = null;
    private GamePanel gp = null;
    private GameManager gm = null;
    
    //Constructor
    public GUIManager(){
        
        super("Dangerous Maze");
        
        setMenuPanelVisible();
        externalsourcemanagement.SoundManager.loadSounds();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(400,420);
        setResizable(false);
        this.setVisible(true);
        
    }
    
    public void setMenuPanelVisible() {
        
        if(currentPanel != null)
            currentPanel.setVisible(false);
        
        JPanel newPanel;
        newPanel = new MenuPanel(this);
        setContentPane(newPanel);
        currentPanel = newPanel;
        setSize(400,400);
    }
    
    public void setGamePanelVisible(){
        
        if(currentPanel != null)
            currentPanel.setVisible(false);
        
        GamePanel gp = new GamePanel(this);
        setContentPane(gp);
        setSize(800, 800);
        currentPanel = gp;
    }
    
    public void setSettingsPanelVisible() {
        if (currentPanel != null)
            currentPanel.setVisible(false);

	JPanel newPanel;
        newPanel = new SettingsPanel(this);
        
	setContentPane(newPanel);
	currentPanel = newPanel;
    }
    
    public void setCreditsPanelVisible(){
        if (currentPanel != null)
            currentPanel.setVisible(false);

	JPanel newPanel;
        newPanel = new CreditsPanel(this);

	setContentPane(newPanel);
	currentPanel = newPanel;
        
    }
    
    public void setHighScoresPanelVisible(){
         if (currentPanel != null)
            currentPanel.setVisible(false);

	JPanel newPanel;
        newPanel = new HighScoresPanel(this);

	setContentPane(newPanel);
	currentPanel = newPanel;
    }
    
    public void setHelpPanelVisible(){
         if (currentPanel != null)
            currentPanel.setVisible(false);

	JPanel newPanel;
        newPanel = new HelpPanel(this);

	setContentPane(newPanel);
	currentPanel = newPanel;
    }
    
    // EXTRAAA
    public void exit(){
        externalsourcemanagement.SoundManager.playGameMusic(false);
        this.dispose();
    }
}
