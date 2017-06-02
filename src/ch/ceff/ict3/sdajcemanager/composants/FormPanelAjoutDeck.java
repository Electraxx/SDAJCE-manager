/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author CP-13JRU
 */
public class FormPanelAjoutDeck extends JPanel {

    private JTextField fieldName;
    private JButton addDeckButton;
    private AppListener listener;

    public FormPanelAjoutDeck() {
        initComponents();
    }

    private void initComponents() {
        fieldName = new JTextField(10);
        addDeckButton = new JButton("Ajouter");

        addDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.addDeck();
                listener.changePage("pageDeck");
            }
        });
        layoutComponents();

    }

    public void setListener(AppListener listener) {
        this.listener = listener;
    }
    
    public void setData(List<Conteneur> data){
        DefaultComboBoxModel modelConteneur = new DefaultComboBoxModel();
        modelConteneur.addElement("Conteneur");
        
        for(Conteneur c : data) {
            modelConteneur.addElement(c);
        }
        
    }
    
    public String getNom() {
        return fieldName.getText();
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

       
        
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        
        add(new JLabel("Nom du deck"), gc);

        //ligne 1
        gc.gridx = 1;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_END;
         gc.insets = new Insets(0, 5, 5, 5);
        add(fieldName, gc);
        
        gc.gridx = 1;
        gc.gridy ++;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 5, 0, 5);
        add(addDeckButton, gc);

    }
}
