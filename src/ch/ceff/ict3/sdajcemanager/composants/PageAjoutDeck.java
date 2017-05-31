/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PageAjoutDeck extends JPanel {

    private TablePanelAjoutCarte tablePanel;

    public PageAjoutDeck() {
        initComponents();
    }

    public void initComponents() {

        //toolBar = new ToolBar();
        tablePanel = new TablePanelAjoutCarte();

        List<Carte> temp_data = new ArrayList<Carte>();
        temp_data.add(new Carte(0, "Bilbon Sacquet", "Héros", "Connaissance", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Marque Des Dúnedain", "Attachement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Histoires au Coin du Feu", "Evénement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Gardien Ailé", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Les Aigles Arrivent", "Evénement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Dompteur de Chevaux de L’ouestfolde", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Rassemblement des Rohirrim", "Evénement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Ménestrel de Fondcombe", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));

        tablePanel.setData(temp_data);
        tablePanel.refresh();
        tablePanel.setAutoCreateRowSorter();
        tablePanel.setSorter();
        this.add(tablePanel, BorderLayout.CENTER);

    }

    private void layoutComponents() {

    }

}
