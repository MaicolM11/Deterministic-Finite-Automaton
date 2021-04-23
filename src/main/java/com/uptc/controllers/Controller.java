package com.uptc.controllers;

import com.uptc.views.WindowPrincipal;

public class Controller{
    
	public Controller() {
		WindowPrincipal principal = new WindowPrincipal();
		MouseEvent.getInstance().setPanelInteractive(principal.getPanelInteractive());
		principal.setVisible(true);
	}
	
}
