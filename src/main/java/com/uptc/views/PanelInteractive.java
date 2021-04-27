package com.uptc.views;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.uptc.controllers.ManageAutomaton;
import com.uptc.controllers.MouseEvent;
import com.uptc.controllers.OwnActionListener;

public class PanelInteractive extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private JPopupMenu popupMenu;
	private JMenuItem initialState;
	private JMenuItem finalState;
	
	public PanelInteractive(){
		this.setVisible(true);
		JLabel jLabel= new JLabel("PANEL INTERACTIVO");
		this.add(jLabel);
        this.addMouseListener(MouseEvent.getInstance());
        this.addMouseMotionListener(MouseEvent.getInstance());
        this.createJpopMenu();
    }
	
	
	public void paint(Graphics g){
		super.paint(g);
		ManageAutomaton.getInstance().redibujarEstados(g);
    }
	
	/**
	 * 
	 */
	private void createJpopMenu() {
		this.popupMenu = new JPopupMenu();
		this.initialState = new JMenuItem(Options.INITIAL_STATE.name());
		this.initialState.setActionCommand(Options.INITIAL_STATE.toString());
		this.initialState.addActionListener(OwnActionListener.getInstance());
		this.finalState = new JMenuItem(Options.FINAL_STATE.name());
		this.finalState.setActionCommand(Options.FINAL_STATE.toString());
		this.finalState.addActionListener(OwnActionListener.getInstance());
		this.popupMenu.add(this.initialState);
		this.popupMenu.add(this.finalState);
		this.add(this.popupMenu);
	}
	
	public void showPopMenu(int x, int y) {
		this.popupMenu.show(this, x, y);
	}
	
}
