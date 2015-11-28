/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import userinterface.GUIManager;

/**
 *
 * @author User
 */
public class HighScoresPanel extends JPanel implements ActionListener{

    // Variables
    private GUIManager guiManager;
    private JLabel title;    
    private JButton backToMenuPanel;
    
    //Constructor
    public HighScoresPanel(GUIManager guiManager) {
       this.guiManager = guiManager;
       setLayout(new FlowLayout(FlowLayout.CENTER,100000,20));
       
       title = new JLabel("High Scores");
       title.setFont(new Font("Serif", Font.BOLD, 24));
       title.setForeground(Color.BLUE);
       
       backToMenuPanel = new JButton("Back");
       
       backToMenuPanel.addActionListener(this);
       
       add(title);
       add(backToMenuPanel);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToMenuPanel)
            guiManager.setMenuPanelVisible();
    }
}
