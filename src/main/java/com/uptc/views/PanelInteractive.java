package com.uptc.views;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uptc.controllers.ManageAutomaton;
import com.uptc.controllers.MouseEvent;

public class PanelInteractive extends JPanel{
    
	private static final long serialVersionUID = 1L;
	
	public PanelInteractive(){
     this.setVisible(true);
     JLabel jLabel= new JLabel("PANEL INTERACTIVO");
     this.add(jLabel);
     this.addMouseListener(MouseEvent.getInstance());
    }
	
	
	public void paint(Graphics g){
		System.out.println("Me llamaron");
		super.paint(g);
		ManageAutomaton.getInstance().redibujarEstados(g);
    }
		
	
}
