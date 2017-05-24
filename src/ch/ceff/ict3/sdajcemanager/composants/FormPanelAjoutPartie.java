/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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

    public FormPanelAjoutPartie() {
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
        add(comboResult,gc);
        
        //ligne 1
        gc.gridx = 2;
        gc.gridy = 0;
        
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(addButton,gc);
        
        //ligne 2
        gc.gridx = 1;
        gc.gridy = 1;
        
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(comboDeck,gc);
    }
    
    

}
