package com.uptc.views;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.uptc.controllers.OwnActionListener;

public class PanelListButtons extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelListButtons() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.addComponents();
		this.setVisible(true);
	}
	
	private void addComponents() {
		JButton s = new JButton(Options.STEP.name());
		s.setActionCommand(Options.STEP.name());
		s.addActionListener(OwnActionListener.getInstance());
		this.add(s);
	}
	
}
