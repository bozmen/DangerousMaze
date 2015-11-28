/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import userinterface.GUIManager;

/**
 *
 * @author Erdi A.
 */
public class HelpPanel extends JPanel implements ActionListener{

    // Variables
    private GUIManager guiManager;
    private JLabel title;    
    private JTextArea statement;
    private JScrollPane areaScrollPane;
    private JButton backToMenuPanel;
    
    //Constructor
    public HelpPanel(GUIManager guiManager) {
        this.guiManager = guiManager;
        setLayout(new FlowLayout(FlowLayout.CENTER,100000,20));
       
        title = new JLabel("Help");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setForeground(Color.RED);
       
        
        statement = new JTextArea(   
			"Power-ups:\n\n"+
			"Light expand: It expands the light for\n "+
			" a short amount of time.\n"+
			"Invulnerability: It prevents you\n "+
			" from dying for a short amount of time.\n\n"+
			"Instant win: Makes the character proceed\n "+
			" to next level instantly.\n\n"+
			"Unstoppable: Makes the character be able to\n "+
			" pass through the walls for a short amount of time.\n\n"+
			"Shrink: Shrinks the character so that \n"+
			" it gets more difficult to hit the walls,\n "+
			" obstacles or monsters.\n\n"+
			"Power-downs:\n"+
			"Light narrow: It narrows the light for\n "+
			" a short amount of time.\n\n"+
			"Instant death: Makes the player start over the level.\n\n"+
			"Enlarge: Enlarges the character causes him/her\n "+
			" to hit the walls, obstacles or monsters easier.\n\n"+
			"Scream:  A scary voice is heard instantly \n"+
			" which may panic/scare the player which may\n "+
			" result in random mouse movements that kills\n "+
			" the character by touching the walls.\n\n"+
			"Teleport: Teleports the character to a random \n"+
			" location on the map. That may be actually harmful\n "+
			" or helpful for the player, so this can’t be\n "+
			" distinguished as power-down or power-up."
        );
        
        statement.setFont(new Font("Serif", Font.ITALIC, 15));
		// if the statement exeed capacity,this provide scrolling capability.
        areaScrollPane = new JScrollPane(statement);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
       
        backToMenuPanel = new JButton("Back");
       
        backToMenuPanel.addActionListener(this);
       
        add(title);
        add(areaScrollPane);
        add(backToMenuPanel);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToMenuPanel)
            guiManager.setMenuPanelVisible();
    }
}