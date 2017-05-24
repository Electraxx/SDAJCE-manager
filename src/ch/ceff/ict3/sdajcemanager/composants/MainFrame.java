/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.controleurs.Controleur;
import ch.ceff.ict3.sdajcemanager.event.*;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

/**
 *
 * @author cp-14luf
 */
public class MainFrame extends JFrame implements WindowListener, AppListener {

    private TablePanelCarte tablePanel;
    private ToolBar toolBar;
    private FormPanelCarte panelCarte;
    private FormPanelDeck panelDeck;
    private FormPanelPartie panelPartie;
    private TablePanelDeck tablePanelDeck;
    private PageCarte pageCarte;
    private PageDeck pageDeck;
    private PagePartie pagePartie;
    private JSplitPane splitPane;
    private AppListener listener;
    private Controleur controler;

    public MainFrame(String titre) {
        initComponents(titre);
    }

    public void initComponents(String titre) {
        Container contentPane = getContentPane();
        pageCarte = new PageCarte();
        pageDeck = new PageDeck();
        pagePartie = new PagePartie();
        toolBar = new ToolBar();
        pageDeck.setListener(this);
        pageCarte.setListener(this);
        toolBar.setListener(this);
        //tablePanel.setCarteTableListener(this);

        contentPane.add(pageDeck, BorderLayout.CENTER);
        contentPane.add(toolBar, BorderLayout.PAGE_START);

        setJMenuBar(createJMenuBar());
        setMinimumSize(new Dimension(700, 450));
        setLocationRelativeTo(null);
        
        controler = new Controleur();
        
        List<Carte> cartes = new ArrayList<>();
        
        cartes.add(controler.getCarte(1));
        cartes.add(controler.getCarte(2));
        cartes.add(controler.getCarte(14));
        cartes.add(controler.getCarte(20));
        
        Deck deck = new Deck(1, "SUPER DECK", cartes);
        
        controler.addDeck(deck);
        
        pageCarte.setData((ArrayList<Carte>)controler.getAllCartes());
        pageDeck.setData((ArrayList<Deck>)controler.getAllDecks());
        pagePartie.setData((ArrayList<Partie>)controler.getAllParties());
        
        addWindowListener(this);
        
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
        itemAjouterCarte.setMnemonic(KeyEvent.VK_F);
        itemNouveauDeck.setMnemonic(KeyEvent.VK_D);
        itemNouvellePartie.setMnemonic(KeyEvent.VK_P);

        //accelerateur
        itemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        itemAjouterCarte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        itemNouveauDeck.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        itemNouvellePartie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        //listerner menu 
        itemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter();
            }
        });

        addWindowListener((WindowListener) this);
        return menuBar;
    }

    private void quitter() {
        int option = JOptionPane.showConfirmDialog(this,
                "Voulez-vous réellement quitter l'application",
                "Demande de confirmation",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }


    public void setListener(AppListener listener) {
        this.listener = listener;
    }

    @Override
    public void addCarte(AddCarteEvent event) {
        Carte carte = new Carte(-1, event.getNom(), event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        this.controler.addCarte(carte);
    }

    @Override
    public void delCarte(DelCarteEvent event) {
        this.controler.delCarte(event.getId());
    }

    @Override
    public void editCarte(EditCarteEvent event) {
        Carte carte = new Carte(event.getId(), event.getNom(), event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        this.controler.editCarte(carte);
    }

    @Override
    public void addConteneur(AddConteneurEvent event) {
        Conteneur conteneur = new Conteneur(-1, event.getNom(), event.getAbbr());
        this.controler.addConteneur(conteneur);
    }

    @Override
    public void editConteneur(DelConteneurEvent event) {
    }

    @Override
    public void addDeck(AddDeckEvent event) {
        Deck deck = new Deck(-1, event.getNom(), event.getCartes());
        this.controler.addDeck(deck);
    }

    @Override
    public void delDeck(DelDeckEvent event) {
        this.controler.delDeck(event.getId());
    }

    @Override
    public void addPartie(AddPartieEvent event) {
        Partie partie = new Partie(-1, event.getDate(), event.isResultat(), event.getDecks());
        this.controler.addPartie(partie);
    }

    @Override
    public void delPartie(DelPartieEvent event) {
        this.controler.delPartie(event.getId());
    }

    @Override
    public void searchDeck(SearchDeckEvent event) {
        pageDeck.search(event.getSearch());
    }

    @Override
    public void searchCarte(SearchCarteEvent event) {
        pageCarte.search(event.getSearch());
    }
    
    
    
    

    @Override
    public void windowClosing(WindowEvent e) {
        quitter();
    }

    @Override
    public void windowOpened(WindowEvent e) {

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

    @Override
    public void changePage(String page) {
        Container contentPane = getContentPane();

        contentPane.removeAll();
        contentPane.add(toolBar, BorderLayout.PAGE_START);
        if (page == "pageCarte") {
            contentPane.add(pageCarte, BorderLayout.CENTER);
        } else if (page == "pageDeck") {
            contentPane.add(pageDeck, BorderLayout.CENTER);
        } else if (page == "pagePartie") {
            contentPane.add(pagePartie, BorderLayout.CENTER);
        }

        contentPane.revalidate();
        contentPane.repaint();
    }

    
}
