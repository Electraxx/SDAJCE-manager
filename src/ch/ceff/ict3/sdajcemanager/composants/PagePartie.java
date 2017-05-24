/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PagePartie extends JPanel {

    private TablePanelPartie tablePartie;
    private FormPanelPartie panelPartie;

    public PagePartie() {
        initComponents();
    }

    private void initComponents() {
        tablePartie = new TablePanelPartie();
        panelPartie = new FormPanelPartie();
        List<Partie> temp_data = new ArrayList<Partie>();
        
        //tablePartie.setData(temp_data);
        tablePartie.refresh();
        this.add(panelPartie,BorderLayout.NORTH);
        this.add(tablePartie,BorderLayout.SOUTH);

    //    temp_data.add(new Partie(0, true, decks))
    }

}
