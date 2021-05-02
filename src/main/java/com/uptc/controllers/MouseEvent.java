package com.uptc.controllers;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.Optional;

import com.uptc.views.Options;
import com.uptc.strucs.State;
import com.uptc.views.PanelInteractive;
import com.uptc.views.PanelMenu;


public class MouseEvent implements MouseMotionListener, MouseListener {
	
	private static MouseEvent MY_INSTANCE;
	private PanelInteractive panelInteractive;
	private PanelMenu panelMenu;
	private State circle_move;
	private Optional<State> stateInit;
	
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
			} else if(panelMenu.getLastOption() == Options.DELETE_STATE) {
				ManageAutomaton.getInstance().deleteState(e.getPoint());
			}
		} else if(button == 3) {//Click Derecho
			Optional<State> s = ManageAutomaton.getInstance().searchState(e.getPoint());
			if(s.isPresent()) {				
				this.panelInteractive.showPopMenu(e.getX(), e.getY());
			}
		}
		this.panelInteractive.repaint();
	}
	
	
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		stateInit= ManageAutomaton.getInstance().searchState(e.getPoint());
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		Options op = panelMenu.getLastOption();
		Optional<State> other = ManageAutomaton.getInstance().searchState(e.getPoint());
		if (other.isPresent() && stateInit.isPresent()) {
			switch (op) {
				case NEW_TRANSITION:
					ManageAutomaton.getInstance().addTransition(stateInit.get(), other.get(),this.panelInteractive.showBox());
					break;
				case DELETE_TRANSITION:
					ManageAutomaton.getInstance().deleteTransition(stateInit.get(), other.get());
					break;
				default:
					break;
			}
		}
		this.panelInteractive.repaint();
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
		if (this.panelMenu.getLastOption() == Options.NEW_STATE) {
			if (circle_move == null) {
				ManageAutomaton.getInstance().searchState(e.getPoint()).ifPresent(x -> circle_move = x);
			} else {
				circle_move.translate(e.getPoint().x - circle_move.x, e.getPoint().y - circle_move.y);
			}
			this.panelInteractive.repaint();
		}
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		circle_move = null;
	}

	public void algorithm(){
		ManageAutomaton.getInstance().init();
		panelInteractive.repaint();
	}

}
