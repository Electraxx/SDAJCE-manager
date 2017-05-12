/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author cp-14syf
 */
public class FormPanelDeck extends JPanel {

    private JButton buttonSearch;
    private JButton buttonAddCart;
    private JComboBox comboAttribut;
    private JTextField searchField;

    public FormPanelDeck() {
        initComponents();
    }

    private void initComponents() {

        //liste des sphère
        comboAttribut = new JComboBox();
        DefaultComboBoxModel modelSphere = new DefaultComboBoxModel();
        modelSphere.addElement("Sphere");
        modelSphere.addElement("Tactique");
        modelSphere.addElement("Connaissance");
        modelSphere.addElement("Energie");
        modelSphere.addElement("Commandement");
        modelSphere.addElement("Neutre");
        comboAttribut.setModel(modelSphere);
        comboAttribut.setSelectedIndex(0);
        comboAttribut.setEditable(true);

        setPreferredSize(new Dimension(700, 150));

        Border bordure = BorderFactory.createTitledBorder("Option");
        Border marge = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(marge, bordure));

        searchField = new JTextField(9);
        buttonSearch = new JButton("Rechercher");
        buttonAddCart = new JButton("Nouveau Deck");

        //placement des composants
        layoutComponents();

        //action sur le bouton rechercher
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String search = searchField.getText();
                System.out.println(search);
            }
        });

        //action sur le bouton nouveau deck
        buttonAddCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        comboAttribut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sphereSearch = comboAttribut.getSelectedItem().toString();
                System.out.println(sphereSearch);
            }
        });

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
        add(new JLabel("Recherche :"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 3);
        add(searchField, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(buttonSearch, gc);

        gc.gridx = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(buttonAddCart, gc);

        //ligne 2
        gc.gridx = 0;
        gc.gridy = 1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(0, 0, 0, 3);
        add(comboAttribut, gc);

    }
}
