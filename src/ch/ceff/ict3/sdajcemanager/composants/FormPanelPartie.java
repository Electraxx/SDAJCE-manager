/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;


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

/**
 *
 * @author cp-13jru
 */
public class FormPanelPartie extends JPanel {

    private JButton buttonAdd;

    private AppListener listener;

    public FormPanelPartie() {
        initComponents();
    }

    private void initComponents() {

        setPreferredSize(new Dimension(700, 150));

        Border bordure = BorderFactory.createTitledBorder("Option");
        Border marge = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(marge, bordure));

        buttonAdd = new JButton("Ajouter");

        //placement des composants
        layoutComponents();

        //action sur le bouton rechercher
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            }
        });

        //action sur le bouton ajouter carte
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
        add(buttonAdd, gc);

    }
}
