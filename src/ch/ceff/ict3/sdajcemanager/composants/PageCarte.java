/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PageCarte extends JPanel {

    private FormPanelCarte panelCarte;
    private TablePanelCarte tablePanel;

    public PageCarte() {
        initComponents();
    }

    public void initComponents() {
        
        //toolBar = new ToolBar();
        tablePanel = new TablePanelCarte();
        panelCarte = new FormPanelCarte();

        List<Carte> temp_data = new ArrayList<Carte>();

        temp_data.add(new Carte(0, "Bla", "kljnkljbn", "kljbnk", 2, new Conteneur(0, "Test", "tst")));
        temp_data.add(new Carte(1, "Bla", "kljnkljbn", "kljbnk", 2, new Conteneur(0, "Test", "tst")));
        temp_data.add(new Carte(0, "Bla", "kljnkljbn", "kljbnk", 2, new Conteneur(0, "Test", "tst")));
        
        

        tablePanel.setData(temp_data);

        this.add(panelCarte, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.SOUTH);


    }
}
