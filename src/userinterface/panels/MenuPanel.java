/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import userinterface.GUIManager;

/**
 *
 * @author Erdi A.
 */
public class MenuPanel extends JPanel implements ActionListener {

    // Variables
    private GUIManager guiManager;
    private JLabel title;
    private JButton play;
    private JButton settings;
    private JButton credits;
    private JButton highScores;
    private JButton help;
    private JButton quit;
    
    //Constructor
    public MenuPanel(GUIManager guiManager) {
        this.guiManager = guiManager;
        
        setLayout(new FlowLayout(FlowLayout.CENTER,100000,20));
        
        title = new JLabel("DANGEROUS MAZE");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.BLUE);
        play = new JButton("Play");
        settings = new JButton("Settings");
        credits = new JButton("Credits");
        highScores = new JButton("HighScores");
        help = new JButton("Help");
        quit = new JButton("Quit");
        
        add(title);
        add(play);
        add(settings);
        add(credits);
        add(highScores);
        add(help);
        add(quit);
        
        play.addActionListener(this);
        settings.addActionListener(this);
        credits.addActionListener(this);
        highScores.addActionListener(this);
        help.addActionListener(this);
        quit.addActionListener(this);
    }

    
    public void actionPerformed(ActionEvent e) {
        
        JButton pushedButton =(JButton) e.getSource();
        
        if(pushedButton == play)
        {
            guiManager.setGamePanelVisible();                    
        }

        else if(pushedButton == settings)
            guiManager.setSettingsPanelVisible();
        else if(pushedButton == credits)
            guiManager.setCreditsPanelVisible();
        else if(pushedButton == highScores)
            guiManager.setHighScoresPanelVisible();
        else if(pushedButton == help)
            guiManager.setHelpPanelVisible();
        else if(pushedButton == quit)
            guiManager.exit();
    }
    
    
}
