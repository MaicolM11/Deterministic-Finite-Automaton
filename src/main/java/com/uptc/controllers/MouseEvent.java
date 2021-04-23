package com.uptc.controllers;

import java.awt.event.MouseListener;
import com.uptc.views.PanelInteractive;

public class MouseEvent implements MouseListener {
	
	private static MouseEvent MY_INSTANCE;
	private PanelInteractive panelInteractive;
	
	public static MouseEvent getInstance() {
		if(MY_INSTANCE == null) {
			MY_INSTANCE = new MouseEvent();
		}
		return MY_INSTANCE;
	}
	
	/**
	 * Constructor privado para implementar el patron SINGLETON
	 */
	private MouseEvent() {

	}
	
	public void setPanelInteractive(PanelInteractive p) {
		this.panelInteractive = p;
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int button = e.getButton();
		if(button == 1) {//Click Izquierdo
			ManageAutomaton.getInstance().addState(e.getX(), e.getY());
			this.panelInteractive.repaint();
		}else if(button == 2) {//Click Derecho
			
		}
				
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		
	}

}
