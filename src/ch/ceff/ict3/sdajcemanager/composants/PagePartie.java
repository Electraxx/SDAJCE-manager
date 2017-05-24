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
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PagePartie extends JPanel {

    private TablePanelPartie tablePartie;
    private FormPanelPartie panelPartie;
    private AppListener listener;

    public PagePartie() {
        initComponents();
    }

    private void initComponents() {
        tablePartie = new TablePanelPartie();
        panelPartie = new FormPanelPartie();
        panelPartie.setListener(listener);

        List<Deck> temp_data_Deck = new ArrayList<Deck>();
        List<Carte> temp_data_carte = new ArrayList<Carte>();
        List<Partie> temp_data_partie = new ArrayList<Partie>();

        temp_data_Deck.add(new Deck(0, "deck" + 7, temp_data_carte));

        temp_data_partie.add(new Partie(0, new Date(), true, temp_data_Deck));

        tablePartie.setData(temp_data_partie);
        tablePartie.refresh();
        this.add(panelPartie, BorderLayout.NORTH);
        this.add(tablePartie, BorderLayout.SOUTH);

        //    temp_data.add(new Partie(0, true, decks))
    }
    
    public void setListener(AppListener listener) {
        this.listener = listener;
        panelPartie.setListener(listener);
    }
}
