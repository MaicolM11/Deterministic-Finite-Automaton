package com.uptc.controllers;

import java.awt.event.MouseListener;

import com.uptc.views.Options;
import com.uptc.strucs.State;
import com.uptc.views.PanelInteractive;
import com.uptc.views.PanelMenu;

import java.awt.event.MouseMotionListener;
import java.util.Optional;

public class MouseEvent implements MouseMotionListener, MouseListener {
	
	private static MouseEvent MY_INSTANCE;
	private PanelInteractive panelInteractive;
	private PanelMenu panelMenu;
	private State circle_move;
	
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
	
	public void setPanelMenu(PanelMenu panelMenu) {
		this.panelMenu = panelMenu;
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int button = e.getButton();
		if(button == 1) {//Click Izquierdo
			if(this.panelMenu.getLastOption() == Options.NEW_STATE) {//Si se pulso el boton nuevo estado
				ManageAutomaton.getInstance().addState(e.getX(), e.getY());
				this.panelInteractive.repaint();
			}
		}else if(button == 3) {//Click Derecho
			Optional<State> s = ManageAutomaton.getInstance().searchState(e.getPoint());
			if(s.isPresent()) {				
				this.panelInteractive.showPopMenu(e.getX(), e.getY());
			}
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

	/***
	 * Mover el estado por la pantalla
	 * @param e
	 */
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		if (circle_move == null) {
            ManageAutomaton.getInstance().searchState(e.getPoint()).ifPresent(x -> circle_move = x);
        } else {
            circle_move.translate(e.getPoint().x - circle_move.x, e.getPoint().y - circle_move.y);
        }
         this.panelInteractive.repaint();
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		circle_move = null;
	}

}
