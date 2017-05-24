/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Partie;
import ch.ceff.ict3.sdajcemanager.modele.PartieTableModele;
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
      private PartieTableModele partieModele;
    
    public TablePanelPartie(){
        initComponents();
    }
    private void initComponents(){
        setLayout(new BorderLayout());
    
        table = new JTable();
        partieModele = new PartieTableModele();
        table = new JTable(partieModele);
        setPreferredSize(new Dimension(685,200));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
     public void setData(List<Partie> data) {
        partieModele.setData(data);
    }
     
      public void refresh() {
        partieModele.fireTableDataChanged();
    }
    
    
}
