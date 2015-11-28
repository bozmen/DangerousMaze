/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.panels;

import java.awt.BorderLayout;
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
public class CreditsPanel extends JPanel implements ActionListener{

    // Variables
    private GUIManager guiManager;
    private JLabel title;
    private JTextArea statement;
    private JScrollPane areaScrollPane;
    private JButton backToMenuPanel;
    
    
    //Constructor
    public CreditsPanel(GUIManager guiManager) {
        this.guiManager = guiManager;
        setLayout(new FlowLayout(FlowLayout.CENTER,100000,20));
       
        title = new JLabel("Credits");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setForeground(Color.RED);
       
        statement = new JTextArea(   
            "Erdi Atalay - CS\n" +
            "erdia@ug.bilkent.edu.tr\n\n"+
            "Sera Büyükgöz - CS\n" +
            "sera.buyukgoz@ug.bilkent.edu.tr\n\n"+
            "Efe İşsever - CS\n" +
            "issever@ug.bilkent.edu.tr\n\n"+
            "Burak Özmen - CS\n" +
            "burak.ozmen@ug.bilkent.edu.tr\n"                    
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
