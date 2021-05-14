package com.uptc.views;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.uptc.controllers.ManageAutomaton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


public class TableWords extends JPanel implements ActionListener{

  public DefaultTableModel defaultTableModel;
  public JTable table;
  public JScrollPane scrollPane;

    public TableWords(){
      this.setPreferredSize(new Dimension(300, 100));
      FontUIResource font = new FontUIResource("Times New Roman", FontUIResource.BOLD, 16);
      JButton btnClose=new JButton();
      btnClose.setText("CERRAR");
      btnClose.setFont(font);
      btnClose.setContentAreaFilled(false);
      btnClose.setBorderPainted(false);
      btnClose.addActionListener(this);
      btnClose.setActionCommand(Options.CLOSE.name());
      btnClose.setIcon(new ImageIcon(getClass().getResource("/images/Cerrar.png")));
      this.add(btnClose,BorderLayout.SOUTH);


      defaultTableModel= new DefaultTableModel(24, 0);
      JPanel panelP=new JPanel();
      panelP.setPreferredSize(new Dimension(280,420));
      defaultTableModel.addColumn("Palabra");
      defaultTableModel.addColumn("Estado");
      table= new JTable(defaultTableModel);
      scrollPane=new JScrollPane(table);
      scrollPane.setPreferredSize(new Dimension(280,420));
      TableColumn columna = table.getColumn("Palabra");
      TableColumn columna2 = table.getColumn("Estado");
      TableColumnModel columnModel = table.getColumnModel();
      columnModel.getColumn(0).setPreferredWidth(160);
      columnModel.getColumn(0).setMaxWidth(160);
      columnModel.getColumn(1).setPreferredWidth(115);
      columnModel.getColumn(1).setMaxWidth(115);
      panelP.add(scrollPane);
      this.add(panelP,BorderLayout.CENTER);

      JPanel panelButtons= new JPanel();
      panelButtons.setLayout(new BoxLayout(panelButtons, 0));
      JButton btnRun=new JButton();
      btnRun.setText("Validar");
      btnRun.setFont(font);
      btnRun.setForeground(Color.white);
      btnRun.setBackground(Color.BLUE);
      btnRun.addActionListener(this);
      btnRun.setActionCommand(Options.VALIDATE.name());

      JButton btnCancel=new JButton();
      btnCancel.setText("Cancelar");
      btnCancel.addActionListener(this);
      btnCancel.setFont(font);
      btnCancel.setForeground(Color.white);
      btnCancel.setBackground(Color.BLUE);
      btnCancel.setActionCommand(Options.CANCEL.name());
      panelButtons.add(btnRun);
      panelButtons.add(btnCancel);
      this.add(panelButtons,BorderLayout.SOUTH);
    }

    public List<String>  sendWords(){
      List<String>  words=new ArrayList<>();
      for (int i = 0; i < table.getRowCount(); i++) {
          if(table.getValueAt(i, 0)!=null){
          words.add(i, String.valueOf(table.getValueAt(i,0)));
          }
          else{
          return words;
          }
      }
      return words;
    }

    public void cleanTable(){
      defaultTableModel.setNumRows(0);
      defaultTableModel.setNumRows(24);
    }

    public void setColumnValidate(List<Boolean> validate){
      for (int i = 0; i < validate.size(); i++) {
        table.setValueAt((validate.get(i))?"Aceptada":"Rechazada",i, 1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
        case "VALIDATE":
            List<Boolean>  validateRes=ManageAutomaton.getInstance().validateWords(sendWords());
            setColumnValidate(validateRes);
          break;
        case "CANCEL":
            cleanTable();
        break;
        case  "CLOSE":
            hideMe();
            cleanTable();
        break;
      
        default:
          break;
      }
      
    }

    public void showMe(){
      this.setVisible(true);
    }

    public void hideMe(){
      this.setVisible(false);
    }

}