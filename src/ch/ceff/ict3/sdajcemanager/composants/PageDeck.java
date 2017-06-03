/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.controleurs.Controleur;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-14syf
 */
public class PageDeck extends JPanel {

    private FormPanelDeck panelDeck;
    private TablePanelDeck tablePanel;
    private TablePanelCarte tablePanelCarte;
    private Controleur controleur;

    public PageDeck() {
        initComponents();
    }

    private void initComponents() {
        
        //toolBar = new ToolBar();
        tablePanel = new TablePanelDeck();
        panelDeck = new FormPanelDeck();
        tablePanelCarte = new TablePanelCarte();
        controleur = new Controleur();

        
        
        
        

        this.add(panelDeck, BorderLayout.PAGE_START);
        this.add(tablePanel, BorderLayout.LINE_START);
        this.add(tablePanelCarte, BorderLayout.LINE_END);

    }
    
    public void changeDeckCarte(int index){
        
        tablePanelCarte.setData(controleur.getDeck(index).getCartes());
        tablePanelCarte.setAutoCreateRowSorter();
        tablePanelCarte.refresh();
    }

    public void search(String text) {
        tablePanel.search(text);
    }

    public void setData(List<Deck> data) {
        tablePanel.setData(data);
        
        tablePanel.setAutoCreateRowSorter();
        tablePanel.setSorter();
    }
    
    public void setListener(AppListener appListener){
        panelDeck.setSearchDeckListener(appListener);
        tablePanel.setTableDeckListener(appListener);
    }
}
