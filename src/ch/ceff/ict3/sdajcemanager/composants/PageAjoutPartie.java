/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PageAjoutPartie extends JPanel {

    private FormPanelAjoutPartie ajoutPartie;
    private AppListener listener;
    public PageAjoutPartie() {
        initComponents();
    }

    public void initComponents() {

        //toolBar = new ToolBar();
        ajoutPartie = new FormPanelAjoutPartie();

        this.add(ajoutPartie, BorderLayout.CENTER);

    }

    public void setListener(AppListener listener) {
        this.listener = listener;
        ajoutPartie.setListener(listener);
    }
}
