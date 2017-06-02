/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.event.AddCarteEvent;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author CP-13JRU
 */
public class FormPanelAjoutCarte extends JPanel {

    private JTextField fieldName;
    private JComboBox comboType;
    private JComboBox comboSphere;
    private JSpinner fieldNumber;
    private JComboBox comboConteneur;
    private JButton addCarte;
    private AppListener listener;

    public FormPanelAjoutCarte() {
        initComponents();
    }

    private void initComponents() {
        fieldName = new JTextField(10);
        fieldNumber = new JSpinner(new SpinnerNumberModel(0, 0, 256, 1));
        addCarte = new JButton("ajouter");

        //liste déroulante pour les type de carte
        comboType = new JComboBox();
        DefaultComboBoxModel modelType = new DefaultComboBoxModel();
        modelType.addElement("Héros");
        modelType.addElement("Evénement");
        modelType.addElement("Attachement");
        modelType.addElement("Allié");
        comboType.setModel(modelType);
        comboType.setSelectedIndex(0);
        comboType.setEditable(true);

        //liste déroulante pour les sphère des cartes
        comboSphere = new JComboBox();
        DefaultComboBoxModel modelSphere = new DefaultComboBoxModel();
        modelSphere.addElement("Tactique");
        modelSphere.addElement("Connaissance");
        modelSphere.addElement("Energie");
        modelSphere.addElement("Commandement");
        modelSphere.addElement("Neutre");
        comboSphere.setModel(modelSphere);
        comboSphere.setSelectedIndex(0);
        comboSphere.setEditable(true);

        //liste déroulante pour le conteneur de la carte
        comboConteneur = new JComboBox();
        comboConteneur.setEditable(true);

        addCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                listener.addCarte(new AddCarteEvent(this, fieldName.getText(), (String)comboType.getSelectedItem(), (String)comboSphere.getSelectedItem(), (int)fieldNumber.getValue(), (Conteneur)comboConteneur.getSelectedItem()));
                listener.changePage("pageCarte");
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
        
        comboConteneur.setModel(modelConteneur);
        comboConteneur.setSelectedIndex(0);
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("nombre de carte"), gc);

        //ligne 1 
        gc.gridx = 1;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
         gc.insets = new Insets(0, 5, 5, 5);
        add(fieldNumber, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        
        add(new JLabel("nom de la carte"), gc);

        //ligne 1
        gc.gridx = 1;
        gc.gridy = 1;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_END;
         gc.insets = new Insets(0, 5, 5, 5);
        add(fieldName, gc);
        
         gc.gridx = 0;
        gc.gridy = 2;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        
        add(new JLabel("Type de carte"), gc);

        //ligne 3
        gc.gridx = 1;
        gc.gridy = 2;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 5, 5, 5);
        add(comboType, gc);
        
         gc.gridx = 0;
        gc.gridy = 3;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        
        add(new JLabel("Sphere de la carte"), gc);

        //ligne 4
        gc.gridx = 1;
        gc.gridy = 3;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 5, 5, 5);
        add(comboSphere, gc);
        
         gc.gridx = 0;
        gc.gridy = 4;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        
        add(new JLabel("Conteneur de la carte"), gc);

        //ligne 5
        gc.gridx = 1;
        gc.gridy = 4;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 5, 5, 5);
        add(comboConteneur, gc);

        //ligne 2 colonne 2
        gc.gridx = 1;
        gc.gridy = 5;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 5, 0, 5);
        add(addCarte, gc);

    }
}
