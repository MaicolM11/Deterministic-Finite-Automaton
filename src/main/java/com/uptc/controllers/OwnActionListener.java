package com.uptc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uptc.views.Options;
import com.uptc.views.PanelInteractive;

public class OwnActionListener implements ActionListener{
	
	private static OwnActionListener ownActionListener;
	private PanelInteractive panelInteractive;
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Options.valueOf(e.getActionCommand())) {
			case INITIAL_STATE:
				ManageAutomaton.getInstance().changeToInitial();
				break;
			case FINAL_STATE:
				ManageAutomaton.getInstance().changeToFinal();
				break;
			default:
				break;
		}
		this.panelInteractive.repaint();
	}

}
