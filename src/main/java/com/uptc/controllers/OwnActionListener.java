package com.uptc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.uptc.views.Options;
import com.uptc.views.PanelInteractive;
import com.uptc.views.PanelMenu;
import com.uptc.views.PanelStepByState;

public class OwnActionListener implements ActionListener{
	
	private static OwnActionListener ownActionListener;
	private PanelInteractive panelInteractive;
	private PanelMenu panelMenu;
	private PanelStepByState panelStepByState;
	
	private OwnActionListener() {
		
	}
	
	public static OwnActionListener getInstance() {
		if(ownActionListener == null) {
			ownActionListener = new OwnActionListener();
		}
		return ownActionListener;
	}

	/**
	 * @param panelInteractive the panelInteractive to set
	 */
	public void setPanelInteractive(PanelInteractive panelInteractive) {
		this.panelInteractive = panelInteractive;
	}

	
	public void setPanelMenu(PanelMenu panelMenu) {
		this.panelMenu = panelMenu;
	}
	
	public void setPanelStepByState(PanelStepByState panelStepByState) {
		this.panelStepByState = panelStepByState;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Options.valueOf(e.getActionCommand())) {
			case INITIAL_STATE:
				ManageAutomaton.getInstance().changeToInitial();
				break;
			case FINAL_STATE:
				ManageAutomaton.getInstance().changeToFinal();
				break;
			case MINIMIZATE:
				this.panelMenu.setLastOption(Options.MINIMIZATE);
				break;
			case VALIDATE_WORD:
				this.panelMenu.setLastOption(Options.VALIDATE_WORD);
				ManageAutomaton.getInstance().setStep(-1);
				ManageAutomaton.getInstance().setFirstSate();
				ManageAutomaton.getInstance().setElementsStepByState(JOptionPane.showInputDialog(null,"Palabra"));
				this.panelStepByState.repaint();
				break;
			case NEW_STATE:
				this.panelMenu.setLastOption(Options.NEW_STATE);
				break;
			case NEW_TRANSITION:
				this.panelMenu.setLastOption(Options.NEW_TRANSITION);
				break;
			case DELETE_STATE:
				this.panelMenu.setLastOption(Options.DELETE_STATE);
				break;
			case DELETE_TRANSITION:
				this.panelMenu.setLastOption(Options.DELETE_TRANSITION);
				break;
			case STEP:
				ManageAutomaton.getInstance().addStep();
				this.panelStepByState.repaint();
				break;
			default:
				break;
		}
		this.panelInteractive.repaint();
	}

}
