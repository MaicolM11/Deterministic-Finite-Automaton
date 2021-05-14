package com.uptc.views;
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class WindowPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelMenu panelMenu;
    private PanelInteractive panelInteractive;
    private PanelStepByState panelStepByState;
    
    public WindowPrincipal(){
        panelMenu=new PanelMenu();
        panelInteractive= new PanelInteractive();
        this.panelStepByState = new PanelStepByState();
        new java.awt.BorderLayout();
		this.getContentPane().add(panelMenu,BorderLayout.NORTH);
        this.getContentPane().add(panelInteractive,BorderLayout.CENTER);
        this.getContentPane().add(this.panelStepByState,BorderLayout.SOUTH);
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

	/**
	 * @return the panelInteractive
	 */
	public PanelInteractive getPanelInteractive() {
		return panelInteractive;
	}

	public PanelStepByState getPanelStepByState() {
		return panelStepByState;
	}

}
