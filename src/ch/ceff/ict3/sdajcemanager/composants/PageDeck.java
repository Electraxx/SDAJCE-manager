/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-14syf
 */
public class PageDeck  extends JPanel{
    private FormPanelDeck panelDeck;
    private TablePanelDeck tablePanel;

    public PageDeck() {
        initComponents();
    }

    private void initComponents() {
        
        //toolBar = new ToolBar();
        tablePanel = new TablePanelDeck();
        panelDeck = new FormPanelDeck();

        List<Deck> temp_data = new ArrayList<Deck>();
        
        List<Carte> temp_data_carte = new ArrayList<Carte>();
        
        temp_data_carte.add(new Carte(0, "test", "tests", "test", 2, new Conteneur(0, "test", "test")));
        
        for(int i = 0; i < 200; i++){
        temp_data.add(new Deck(0, "deck" + i + " test", temp_data_carte));
        }
        
        tablePanel.setData(temp_data);
        tablePanel.setAutoCreateRowSorter();
        tablePanel.setSorter();

        this.add(panelDeck, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.SOUTH);


    }
    public void search(String text){
        tablePanel.search(text);
    }
    
    public void setData(List<Deck> data) {
        tablePanel.setData(data);
    }
    
    public void setListener(AppListener appListener){
        panelDeck.setSearchDeckListener(appListener);
    }
}
