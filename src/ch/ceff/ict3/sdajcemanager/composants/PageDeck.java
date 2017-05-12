/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

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
    private FormPanelDeck panelCarte;
    private TablePanelDeck tablePanel;

    public PageDeck() {
        initComponents();
    }

    public void initComponents() {
        
        //toolBar = new ToolBar();
        tablePanel = new TablePanelDeck();
        panelCarte = new FormPanelDeck();

        List<Deck> temp_data = new ArrayList<Deck>();
        
        List<Carte> temp_data_carte = new ArrayList<Carte>();
        
        temp_data_carte.add(new Carte(0, "test", "tests", "test", 2, new Conteneur(0, "test", "test")));
        temp_data_carte.add(new Carte(0, "test", "tests", "test", 2, new Conteneur(0, "test", "test")));
        temp_data_carte.add(new Carte(0, "test", "tests", "test", 2, new Conteneur(0, "test", "test")));
        temp_data_carte.add(new Carte(0, "test", "tests", "test", 2, new Conteneur(0, "test", "test")));
        
        temp_data.add(new Deck(0, "deck 1 test", temp_data_carte));
        temp_data.add(new Deck(0, "deck 2 test", temp_data_carte));
        temp_data.add(new Deck(0, "deck 3 test", temp_data_carte));
        temp_data.add(new Deck(0, "deck 4 test", temp_data_carte));
        
        tablePanel.setData(temp_data);

        this.add(panelCarte, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.SOUTH);


    }
}
