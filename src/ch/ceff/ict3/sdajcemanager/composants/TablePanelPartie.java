/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.CarteTableModele;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author cp-13jru
 */
public class TablePanelPartie extends JPanel {
    
      private JTable table;
    private CarteTableModele carteModel;
    
    public TablePanelPartie(){
        initComponents();
    }
    private void initComponents(){
        setLayout(new BorderLayout());
    
        table = new JTable();
        carteModel = new CarteTableModele();
        table = new JTable(carteModel);
        setPreferredSize(new Dimension(685,200));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
     public void setData(List<Carte> data) {
        carteModel.setData(data);
    }
     
      public void refresh() {
        carteModel.fireTableDataChanged();
    }
    
    
}
