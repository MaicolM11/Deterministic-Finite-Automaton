package com.uptc.controllers;

import com.uptc.views.WindowPrincipal;

public class Controller{
    
	public Controller() {
		WindowPrincipal principal = new WindowPrincipal();
		MouseEvent.getInstance().setPanelInteractive(principal.getPanelInteractive());
		OwnActionListener.getInstance().setPanelInteractive(principal.getPanelInteractive());
		OwnActionListener.getInstance().setPanelMenu(principal.getPanelMenu());
		OwnActionListener.getInstance().setPanelStepByState(principal.getPanelStepByState());
		principal.setVisible(true);
	}
	
}
