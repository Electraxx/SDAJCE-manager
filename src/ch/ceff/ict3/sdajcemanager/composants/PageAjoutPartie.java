/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cp-13jru
 */
public class PageAjoutPartie extends JPanel {

    private JButton addButton;
    private JComboBox comboDeck;
    private JComboBox comboResult;
    private JTextField dateField;

    public PageAjoutPartie() {
        initComponents();
    }

    private void initComponents() {
        addButton = new JButton();
        
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
        modelResult.addElement("victoire");
        modelResult.addElement("défaite");
        comboResult.setModel(modelDeck);
        comboResult.setSelectedIndex(0);
        comboResult.setEditable(true);

        dateField = new JTextField(9);
        
        layoutComponents();
    }
    
    private void layoutComponents(){
        
    }
    
    

}
