/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTextField;

/**
 *
 * @author cp-13jru
 */
public class FormPanelAjoutPartie extends JPanel {

    private JButton addButton;
    private JComboBox comboDeck;
    private JComboBox comboResult;
    private JTextField dateField;
    private AppListener listener;
    private TablePanelPartie tablePartie;

    public FormPanelAjoutPartie() {
        initComponents();
    }

    private void initComponents() {
        addButton = new JButton("Ajouter");

        tablePartie = new TablePanelPartie();
        //liste déroulante pour les decks
        comboDeck = new JComboBox();
        DefaultComboBoxModel modelDeck = new DefaultComboBoxModel();
        for (int i = 0; i < 10; i++) {
            modelDeck.addElement("deck" + i);
        }
        comboDeck.setModel(modelDeck);
        comboDeck.setSelectedIndex(0);
        comboDeck.setEditable(true);

        //liste déroulante pour la victoire ou la défaite
        comboResult = new JComboBox();
        DefaultComboBoxModel modelResult = new DefaultComboBoxModel();
        modelResult.addElement(true);
        modelResult.addElement(false);
        comboResult.setModel(modelResult);
        comboResult.setSelectedIndex(0);
        comboResult.setEditable(true);

        dateField = new JTextField(9);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat();
                String dateString = dateField.getText();
                String deck = (String) comboDeck.getSelectedItem();

                Boolean partie = (Boolean) comboResult.getSelectedItem();
                List<Carte> temp_data_carte = new ArrayList<Carte>();
                List<Partie> temp_data_partie = new ArrayList<Partie>();
                List<Deck> temp_data_deck = new ArrayList<Deck>();

                temp_data_deck.add(new Deck(0, deck, temp_data_carte));

                System.out.println("OK !");
               
                temp_data_partie.add(new Partie(1, new Date(), partie, temp_data_deck));
                
                
                listener.changePage("pagePartie");
            }
        });

        layoutComponents();
    }

    public void setListener(AppListener listener) {
        this.listener = listener;
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
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(dateField, gc);

        //ligne 1 
        gc.gridx = 1;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(comboResult, gc);

        //ligne 1
        gc.gridx = 2;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(addButton, gc);

        //ligne 2
        gc.gridx = 1;
        gc.gridy = 1;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(comboDeck, gc);
    }

}
