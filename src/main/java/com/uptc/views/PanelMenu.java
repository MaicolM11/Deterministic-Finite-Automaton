package com.uptc.views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class PanelMenu extends JPanel{

    public PanelMenu(){
     this.setVisible(true);
     JToolBar jToolBar=addButtons();
     this.add(jToolBar);
    }

    public JToolBar addButtons(){
        FontUIResource font=new FontUIResource("Times New Roman", FontUIResource.BOLD, 16);
        JToolBar jToolBar= new JToolBar();
        jToolBar.setPreferredSize(new DimensionUIResource(600, 40));
        jToolBar.setFloatable(false);
        JButton btnNewState= new JButton("Estado");
        btnNewState.setFont(font);
        btnNewState.setContentAreaFilled(false);
        btnNewState.setBorderPainted(false);
        btnNewState.setIcon(new ImageIcon("src/images/Add.png"));
        JButton btnNewTransition= new JButton("Transición");
        btnNewTransition.setFont(font);
        btnNewTransition.setContentAreaFilled(false);
        btnNewTransition.setBorderPainted(false);
        btnNewTransition.setIcon(new ImageIcon("src/images/Add.png"));
        JButton btnDelete= new JButton("Eliminar");
        btnDelete.setFont(font);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setBorderPainted(false);
        btnDelete.setIcon(new ImageIcon("src/images/Delete.png"));
        JButton btnMinimization= new JButton("Minimizar");
        btnMinimization.setFont(font);
        btnMinimization.setContentAreaFilled(false);
        btnMinimization.setBorderPainted(false);
        btnMinimization.setIcon(new ImageIcon("src/images/Minimizate.png"));
        JButton btnValidateWord= new JButton("Validar palabras");
        btnValidateWord.setFont(font);
        btnValidateWord.setContentAreaFilled(false);
        btnValidateWord.setBorderPainted(false);
        btnValidateWord.setIcon(new ImageIcon("src/images/Validate.png"));
        jToolBar.add(btnNewState);
        jToolBar.add(btnNewTransition);
        jToolBar.add(btnDelete);
        jToolBar.add(btnMinimization);
        jToolBar.add(btnValidateWord);

        return jToolBar;
    }


    
}
