package com.uptc.views;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class WindowPrincipal extends JFrame{

    private PanelMenu panelMenu;
    private PanelInteractive panelInteractive;

    public WindowPrincipal(){
        panelMenu=new PanelMenu();
        panelInteractive= new PanelInteractive();

        this.getContentPane().add(panelMenu,new java.awt.BorderLayout().NORTH);
        this.getContentPane().add(panelInteractive,new java.awt.BorderLayout().CENTER);
        this.pack();
        this.setSize(700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);    
    }


    
}
