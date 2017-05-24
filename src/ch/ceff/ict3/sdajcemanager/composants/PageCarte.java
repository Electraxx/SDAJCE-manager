/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
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

        temp_data.add(new Carte(0, "Gimli", "Heros", "energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(1, "Legolas", "Heros", "Tactique", 2, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(2, "Gandalf", "Allié", "Neutre", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(3, "Thorin", "Heros", "neutre", 2, new Conteneur(0, "Test", "c1")));
        
        

        tablePanel.setData(temp_data);
        tablePanel.refresh();
        tablePanel.setAutoCreateRowSorter();
        tablePanel.setSorter();
        this.add(panelCarte, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.SOUTH);


    }
    
    public void search(String text){
        tablePanel.search(text);
    }
    
    public void setData(ArrayList<Carte> data) {
        tablePanel.setData(data);
    }
    
    public void setListener(AppListener appListener){
        panelCarte.setSearchCarteListener(appListener);
    }
}
