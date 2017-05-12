/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.DeckTableModele;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author cp-14syf
 */
public class TablePanelDeck  extends JPanel {
     private JTable table;
    private DeckTableModele deckModel;
    
    public TablePanelDeck(){
        initComponents();
    }
    private void initComponents(){
        setLayout(new BorderLayout());
    
        table = new JTable();
        deckModel = new DeckTableModele();
        table = new JTable(deckModel);
        setPreferredSize(new Dimension(685,200));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
     public void setData(List<Deck> data) {
        deckModel.setData(data);
    }
    
}
