package com.uptc.views;
import javax.swing.JFrame;


public class WindowPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelMenu panelMenu;
    private PanelInteractive panelInteractive;

    public WindowPrincipal(){
        panelMenu=new PanelMenu();
        panelInteractive= new PanelInteractive();

        this.getContentPane().add(panelMenu,new java.awt.BorderLayout().NORTH);
        this.getContentPane().add(panelInteractive,new java.awt.BorderLayout().CENTER);
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
    
}
