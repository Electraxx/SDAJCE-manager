/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author CP-13JRU
 */
public class PageAjoutCarte extends JPanel {

    private FormPanelAjoutCarte ajoutCarte;
    private AppListener listener;

    public PageAjoutCarte() {
        initComponents();
    }

    private void initComponents() {
        ajoutCarte = new FormPanelAjoutCarte();
        this.add(ajoutCarte, BorderLayout.CENTER);
    }

    public void setListener(AppListener listener) {
        this.listener = listener;
        ajoutCarte.setListener(listener);
    }
    
    public void setData(List<Conteneur> data) {
        ajoutCarte.setData(data);
    }
}
