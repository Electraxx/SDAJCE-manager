/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javafx.scene.control.ToolBar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

/**
 *
 * @author cp-14luf
 */
public class MainFrame extends JFrame implements WindowListener {

    private TablePanelCarte tablePanel;
    private ToolBar toolBar;
    private FormPanelCarte panelCarte;
    
    private JSplitPane splitPane;

    public MainFrame(String titre) {
        initComponents(titre);
    }

    public void initComponents(String titre) {
        Container contentPane = getContentPane();

        //toolBar = new ToolBar();
        tablePanel = new TablePanelCarte();
        panelCarte = new FormPanelCarte();
        
        
        
        //splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,tablePanel,panelCarte);

        contentPane.add(panelCarte, BorderLayout.NORTH);
        contentPane.add(tablePanel, BorderLayout.SOUTH);

        setJMenuBar(createJMenuBar());
        setMinimumSize(new Dimension(700, 450));
        setLocationRelativeTo(null);
    }

    private JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //menu fichier
        JMenu menuFichier = new JMenu("Fichier");
        menuBar.add(menuFichier);
        //sous-menu Fichier
        JMenuItem itemQuitter = new JMenuItem("Quitter");
        menuFichier.add(itemQuitter);

        //menu page 
        JMenu menuPage = new JMenu("Page");
        menuBar.add(menuPage);
        //sous-menu Page
        JMenu menuCarte = new JMenu("Carte");
        JMenu menuDeck = new JMenu("Deck");
        JMenu menuPartie = new JMenu("Partie");
        menuPage.add(menuCarte);
        menuPage.add(menuDeck);
        menuPage.add(menuPartie);
        //ajout d'un sous-menu au sous-menu MenuCarte
        JMenuItem itemAjouterCarte = new JMenuItem("ajout carte");
        menuCarte.add(itemAjouterCarte);
        //ajout d'un sous-menu au sous-menu MenuItem
        JMenuItem itemNouveauDeck = new JMenuItem("Nouveau Deck");
        menuDeck.add(itemNouveauDeck);
        //ajout d'un sous-menu au sous-menu MenuPartie
        JMenuItem itemNouvellePartie = new JMenuItem("nouvelle partie");
        menuPartie.add(itemNouvellePartie);
        
        //Mnémonique
        itemQuitter.setMnemonic(KeyEvent.VK_Q);
        itemAjouterCarte.setMnemonic(KeyEvent.VK_C);
        itemNouveauDeck.setMnemonic(KeyEvent.VK_D);

        return menuBar;
    }
    
    private void quitter(){
        int option = JOptionPane.showConfirmDialog(this,"désirez-vous quitter ?"
                ,"demande de confirmation",
                JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
        quitter();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    
    
}
