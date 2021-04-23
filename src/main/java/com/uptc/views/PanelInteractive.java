package com.uptc.views;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInteractive extends JPanel{
    
    public PanelInteractive(){
     this.setVisible(true);
     JLabel jLabel= new JLabel("PANEL INTERACTIVO");
     this.add(jLabel);
    }
}
