package com.uptc.views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.FontUIResource;
import com.uptc.controllers.MouseEvent;
import com.uptc.controllers.OwnActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String buttons[][];
    private JToolBar jToolBar;
    private Options lastOption;

    public PanelMenu() {
        jToolBar = new JToolBar();
        //jToolBar.setPreferredSize(new DimensionUIResource(830, 40));
        jToolBar.setFloatable(false);
        initButtons();
        this.add(jToolBar);
        MouseEvent.getInstance().setPanelMenu(this);
        this.setVisible(true);
    }

    public void initButtons() {
        this.buttons = new String[][] { 
                { "Estado", "/Add.png", Options.NEW_STATE.name() },
                { "Transición", "/Add.png" ,Options.NEW_TRANSITION.name() },
                { "Eliminar Estado", "/Delete.png", Options.DELETE_STATE.name() },
                { "Eliminar Transición", "/Delete.png" ,Options.DELETE_TRANSITION.name()},
                { "Minimizar", "/Minimizate.png" ,Options.MINIMIZATE.name()},
                { "Validar Palabras", "/Validate.png",Options.VALIDATE_WORD.name()},
                { "Paso por estado", "/path-steps.png",Options.STEP_BY_STATE.name()}
                };
                init();
    }

    public void init() {
        FontUIResource font = new FontUIResource("Times New Roman", FontUIResource.BOLD, 16);
        for (String[] b : buttons) {
            JButton button = new JButton(b[0]);
            button.setFont(font);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.addActionListener(OwnActionListener.getInstance());
            button.setActionCommand(b[2]);
            Image img= new ImageIcon(getClass().getResource("/images" + b[1])).getImage();
            ImageIcon img2=new ImageIcon(img.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            button.setIcon(img2);
            jToolBar.add(button);

        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lastOption=Options.valueOf(e.getActionCommand());
        switch (lastOption){
            case MINIMIZATE:
                MouseEvent.getInstance().algorithm();             
                break;
            case VALIDATE_WORD:
                MouseEvent.getInstance().visibleTable();
                break;
            default:
                break;
        }
    }


    public Options getLastOption(){
        return lastOption;
    }
    
    public void setLastOption(Options last) {
    	this.lastOption = last;
    }
    
}
