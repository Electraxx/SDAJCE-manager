/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PagePartie extends JPanel {

    private TablePanelPartie tablePartie;
    private FormPanelPartie panelPartie;
    private AppListener listener;

    public PagePartie() {
        initComponents();
    }

    private void initComponents() {
        tablePartie = new TablePanelPartie();
        panelPartie = new FormPanelPartie();
        panelPartie.setListener(listener);

        tablePartie.refresh();
        this.add(panelPartie, BorderLayout.NORTH);
        this.add(tablePartie, BorderLayout.SOUTH);

        //    temp_data.add(new Partie(0, true, decks))
    }
    
    public void setData(List<Partie> data) {
        tablePartie.setData(data);
    }

    public void setListener(AppListener listener) {
        this.listener = listener;
        panelPartie.setListener(listener);
    }
}
