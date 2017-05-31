/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.event.AddPartieEvent;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class FormPanelAjoutPartie extends JPanel {

    private JButton addButton;
    private JComboBox comboDeck;
    private JComboBox comboResult;
    private AppListener listener;
    private TablePanelPartie tablePartie;
    
    private List<Deck> decks;

    public FormPanelAjoutPartie() {
        initComponents();
    }

    private void initComponents() {
        this.decks = new ArrayList<>();
        
        addButton = new JButton("Ajouter");
        tablePartie = new TablePanelPartie();
        //liste déroulante pour les decks
        comboDeck = new JComboBox();
        
        DefaultComboBoxModel modelDeck = new DefaultComboBoxModel();
        
        for(Deck d : this.decks) {
            modelDeck.addElement(d);
        }
        
        comboDeck.setModel(modelDeck);
        comboDeck.setEditable(true);

        //liste déroulante pour la victoire ou la défaite
        comboResult = new JComboBox();
        DefaultComboBoxModel modelResult = new DefaultComboBoxModel();
        modelResult.addElement("Victoire");
        modelResult.addElement("Défaite");
        comboResult.setModel(modelResult);
        comboResult.setSelectedIndex(0);
        comboResult.setEditable(true);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                SimpleDateFormat formatter = new SimpleDateFormat();
                String partie = (String)comboResult.getSelectedItem();
                
                
                boolean ok = false;
                if(partie == "Victoire"){
                    ok = true;
                }
                
                List<Deck> partieDecks = new ArrayList<>();
                
                partieDecks.add((Deck)comboDeck.getSelectedItem());
                
                listener.addPartie(new AddPartieEvent(new Date(), ok, partieDecks, this));
                
                listener.changePage("pagePartie");
            }
        });

        layoutComponents();
    }

    public void setListener(AppListener listener) {
        this.listener = listener;
    }
    
    public void setData(List<Deck> decks) {
        this.decks = decks;
        refresh();
    }
    
    public void refresh() {
        DefaultComboBoxModel modelDeck = new DefaultComboBoxModel();
        
        for(Deck d : this.decks) {
            modelDeck.addElement(d);
        }
        
        comboDeck.setModel(modelDeck);
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weighty = 0.1;


        //ligne 1 
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.PAGE_START;
        add(comboResult, gc);

        //ligne 1
        gc.gridx = 2;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,5,0,5);
        add(addButton, gc);

        //ligne 2
        gc.gridx = 1;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.CENTER;
        add(comboDeck, gc);
    }

}
