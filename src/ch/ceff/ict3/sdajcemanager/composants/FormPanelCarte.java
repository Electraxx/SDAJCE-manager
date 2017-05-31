/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.event.SearchCarteByConteneurEvent;
import ch.ceff.ict3.sdajcemanager.event.SearchCarteBySphereEvent;
import ch.ceff.ict3.sdajcemanager.event.SearchCarteByTypeEvent;
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
    private JComboBox comboSphere;
    private JComboBox comboConteneur;
    private JTextField searchField;
    private AppListener listener;

    public FormPanelCarte() {
        initComponents();
    }

    private void initComponents() {
        //liste des types

        comboType = new JComboBox();
        DefaultComboBoxModel modelType = new DefaultComboBoxModel();
        modelType.addElement("Type");
        modelType.addElement("Héros");
        modelType.addElement("Evenement");
        modelType.addElement("Attachement");
        modelType.addElement("Allié");
        comboType.setModel(modelType);
        comboType.setSelectedIndex(0);
        comboType.setEditable(true);
        //liste des sphère

        comboSphere = new JComboBox();
        DefaultComboBoxModel modelSphere = new DefaultComboBoxModel();
        modelSphere.addElement("Sphere");
        modelSphere.addElement("Tactique");
        modelSphere.addElement("Connaissance");
        modelSphere.addElement("Energie");
        modelSphere.addElement("Commandement");
        modelSphere.addElement("Neutre");
        comboSphere.setModel(modelSphere);
        comboSphere.setSelectedIndex(0);
        comboSphere.setEditable(true);

        //Liste des Conteneur
        comboConteneur = new JComboBox();
        DefaultComboBoxModel modelConteneur = new DefaultComboBoxModel();
        modelConteneur.addElement("Conteneur");
        modelConteneur.addElement("Boîte de base");
        modelConteneur.addElement("Cycle 1");
        comboConteneur.setModel(modelConteneur);
        comboConteneur.setSelectedIndex(0);
        comboConteneur.setEditable(true);

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
                searchAll();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAll();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchAll();
            }
        });

        comboType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAll();
            }
        });

        //action sur le bouton rechercher
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (listener != null) {
                    searchAll();
                }

            }
        });

        comboSphere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAll();
            }
        });
        
        comboConteneur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAll();
            }
        });

        //action sur le bouton ajouter carte
        buttonAddCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                listener.changePage("pageAjoutCarte");
            }
        });
    }

    public void searchAll() {
        if (listener != null) {
            listener.delFilters();
            searchByText();
            searchByType();
            searchBySphere();
            searchByConteneur();
        }

    }

    public void setSearchCarteListener(AppListener appListener) {
        this.listener = appListener;
    }

    public void searchByText() {
        String search = searchField.getText();
        SearchCarteEvent searchcarteEvent = new SearchCarteEvent(this, search);
        if (listener != null) {
            listener.searchCarte(searchcarteEvent);
        }
    }

    public void searchByType() {
        String search = comboType.getSelectedItem().toString();
        SearchCarteByTypeEvent searchCarteByTypeEvent;
        if (!search.equalsIgnoreCase("type")) {
            searchCarteByTypeEvent = new SearchCarteByTypeEvent(this, search);
        } else {
            searchCarteByTypeEvent = new SearchCarteByTypeEvent(this, "");
        }
        if (listener != null) {
            listener.searchCarteByType(searchCarteByTypeEvent);
        }
    }

    public void searchBySphere() {
        String search = comboSphere.getSelectedItem().toString();
        SearchCarteBySphereEvent searchCarteBySphereEvent;
        if (!search.equalsIgnoreCase("sphere")) {
            searchCarteBySphereEvent = new SearchCarteBySphereEvent(this, search);
        } else {
            searchCarteBySphereEvent = new SearchCarteBySphereEvent(this, "");
        }
        if (listener != null) {
            listener.searchCarteBySphere(searchCarteBySphereEvent);
        }
    }
    
    public void searchByConteneur(){
        String search = comboConteneur.getSelectedItem().toString();
        SearchCarteByConteneurEvent searchCarteByConteneurEvent;
        if (!search.equalsIgnoreCase("Conteneur")) {
            searchCarteByConteneurEvent = new SearchCarteByConteneurEvent(this, search);
        } else {
            searchCarteByConteneurEvent = new SearchCarteByConteneurEvent(this, "");
        }
        if (listener != null) {
            listener.searchCarteByConteneur(searchCarteByConteneurEvent);
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
        add(comboSphere, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 3);
        add(comboConteneur, gc);
    }

}
