package com.uptc.views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import com.uptc.controllers.ManageAutomaton;

public class PanelStepByState extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelListButtons panelListButtons;
	
	public PanelStepByState() {
//		this.setBackground(new Color(204, 204, 204));
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.addComponents();
		this.setVisible(true);
	}
	
	private void addComponents() {
		this.setPreferredSize(new DimensionUIResource(100, 100));
		this.panelListButtons = new PanelListButtons();
		this.add(this.panelListButtons , BorderLayout.SOUTH);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ManageAutomaton.getInstance().paintElementsStepByState(g);
	}
	
}
