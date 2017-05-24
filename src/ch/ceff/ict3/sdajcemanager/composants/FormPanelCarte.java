/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.event.SearchCarteEvent;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author cp-13jru
 */
public class FormPanelCarte extends JPanel {

    private JButton buttonSearch;
    private JButton buttonAddCart;
    private JComboBox comboType;
    private JComboBox comboAttribut;
    private JComboBox comboProperty;
    private JTextField searchField;
    private AppListener appListener;

    public FormPanelCarte() {
        initComponents();
    }

    private void initComponents() {
        //liste des types

        comboType = new JComboBox();
        DefaultComboBoxModel modelType = new DefaultComboBoxModel();
        modelType.addElement("Type");
        modelType.addElement("Heros");
        modelType.addElement("Evenement");
        modelType.addElement("Attachement");
        modelType.addElement("Allié");
        comboType.setModel(modelType);
        comboType.setSelectedIndex(0);
        comboType.setEditable(true);
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

        //Liste des Conteneur
        comboProperty = new JComboBox();
        DefaultComboBoxModel modelConteneur = new DefaultComboBoxModel();
        modelConteneur.addElement("Conteneur");
        modelConteneur.addElement("BB");
        modelConteneur.addElement("C1");
        comboProperty.setModel(modelConteneur);
        comboProperty.setSelectedIndex(0);
        comboProperty.setEditable(true);

        setPreferredSize(new Dimension(700, 150));

        Border bordure = BorderFactory.createTitledBorder("Option");
        Border marge = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(marge, bordure));

        searchField = new JTextField(9);
        buttonSearch = new JButton("Rechercher");
        buttonAddCart = new JButton("Ajouter carte");

        //placement des composants
        layoutComponents();

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
                System.out.println("fdsfd");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
                System.out.println("fdsfd");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
                System.out.println("fdsfd");
            }
        });

        //action sur le bouton rechercher
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String nom = searchField.getText();
                String type = (String) comboType.getSelectedItem();
                String sphere = (String) comboAttribut.getSelectedItem();
                String conteneur = (String) comboProperty.getSelectedItem();

                //  SearchCarteEvent carteEvent = new SearchCarteEvent(this,nom,type,sphere,conteneur);
                if (appListener != null) {
                    //   listener.searchCarte(carteEvent);
                }

            }
        });

        //action sur le bouton ajouter carte
        buttonAddCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });
    }

    public void setSearchCarteListener(AppListener appListener) {
        this.appListener = appListener;
    }

    public void search() {
        String search = searchField.getText();
        SearchCarteEvent searchcarteEvent = new SearchCarteEvent(this, search);

        if (appListener != null) {
            appListener.searchCarte(searchcarteEvent);
        }
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

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(comboType, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(0, 0, 0, 3);
        add(comboAttribut, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 3);
        add(comboProperty, gc);
    }

}
