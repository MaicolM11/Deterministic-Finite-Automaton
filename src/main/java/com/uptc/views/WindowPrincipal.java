package com.uptc.views;
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class WindowPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelMenu panelMenu;
    private PanelInteractive panelInteractive;
	private TableWords tableWords;

    public WindowPrincipal(){
        panelMenu=new PanelMenu();
        panelInteractive= new PanelInteractive();
		tableWords= new TableWords();

        new java.awt.BorderLayout();
		this.getContentPane().add(panelMenu,BorderLayout.NORTH);
        this.getContentPane().add(panelInteractive,BorderLayout.CENTER);
		this.getContentPane().add(tableWords,BorderLayout.EAST);
		tableWords.hideMe();
        this.pack();
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);    
    }

	/**
	 * @return the panelMenu
	 */
	public PanelMenu getPanelMenu() {
		return panelMenu;
	}

	
    public TableWords getTableWords() {
	    return tableWords;
    }
	/**
	 * @return the panelInteractive
	 */
	public PanelInteractive getPanelInteractive() {
		return panelInteractive;
	}
    
}
