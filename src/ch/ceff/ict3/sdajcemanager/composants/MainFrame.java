/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.actions.ImporterAction;
import ch.ceff.ict3.sdajcemanager.actions.OuvrirAideAction;
import ch.ceff.ict3.sdajcemanager.actions.PageAjoutCarteAction;
import ch.ceff.ict3.sdajcemanager.actions.PageAjoutDeckAction;
import ch.ceff.ict3.sdajcemanager.actions.PageAjoutPartieAction;
import ch.ceff.ict3.sdajcemanager.actions.QuitterAction;
import ch.ceff.ict3.sdajcemanager.controleurs.Controleur;
import ch.ceff.ict3.sdajcemanager.event.*;
import ch.ceff.ict3.sdajcemanager.fileFilters.CsvFileFilter;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
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
    private PageAjoutPartie pageAjoutPartie;
    private PageAjoutCarte pageAjoutCarte;
    private JSplitPane splitPane;
    private AppListener listener;
    private Controleur controler;
    private JFileChooser fileChooser;
    private PageAjoutDeck pageAjoutDeck;

    public MainFrame(String titre) {
        initComponents(titre);
    }

    private void initComponents(String titre) {
        controler = new Controleur();
        
        setMinimumSize(new Dimension(700, 450));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setJMenuBar(createJMenuBar());
        
        Container contentPane = getContentPane();
        pageCarte = new PageCarte();
        pageDeck = new PageDeck();
        pagePartie = new PagePartie();
        pageAjoutPartie = new PageAjoutPartie();
        pageAjoutCarte = new PageAjoutCarte();
        toolBar = new ToolBar();
        pageAjoutDeck = new PageAjoutDeck();
        pageDeck.setListener(this);
        pageCarte.setListener(this);
        pagePartie.setListener(this);
        pageAjoutPartie.setListener(this);
        pageAjoutCarte.setListener(this);

        toolBar.setListener(this);
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new CsvFileFilter());
        //tablePanel.setCarteTableListener(this);

        contentPane.add(pageCarte, BorderLayout.CENTER);
        contentPane.add(toolBar, BorderLayout.PAGE_START);

        changePage("pageCarte");
        
        addWindowListener(this);

    }

    private JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //menu fichier
        JMenu menuFichier = new JMenu("Fichier");
        menuBar.add(menuFichier);
        //sous-menu Fichier
        JMenuItem itemImportCartes = new JMenuItem(new ImporterAction("Importer Cartes", null, "Importe des cartes depuis un .csv", KeyEvent.VK_I, MainFrame.this));
        JMenuItem itemQuitter = new JMenuItem(new QuitterAction("Quitter", null, "Quitter le programme", KeyEvent.VK_Q, MainFrame.this));

        menuFichier.add(itemImportCartes);
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
        JMenuItem itemAjouterCarte = new JMenuItem(new PageAjoutCarteAction("Ajout Carte...", null, "Ajoute une carte dans la base de données", KeyEvent.VK_F, MainFrame.this));
        menuCarte.add(itemAjouterCarte);
        //ajout d'un sous-menu au sous-menu MenuItem
        JMenuItem itemNouveauDeck = new JMenuItem(new PageAjoutDeckAction("Nouveau Deck...", null, "Ajoute un deck dans la base de données", KeyEvent.VK_D, MainFrame.this));
        menuDeck.add(itemNouveauDeck);
        //ajout d'un sous-menu au sous-menu MenuPartie
        JMenuItem itemNouvellePartie = new JMenuItem(new PageAjoutPartieAction("Nouvelle Partie...", null, "Ajoute une partie dans la base de données", KeyEvent.VK_P, MainFrame.this));
        menuPartie.add(itemNouvellePartie);

        //menu Aide
        JMenu menuAide = new JMenu("Aide");
        menuBar.add(menuAide);
        //sous-menu de l'aide
        JMenuItem itemAide = new JMenuItem(new OuvrirAideAction("Aide", null, "Ouvre une page d'aide", KeyEvent.VK_F1, MainFrame.this));
        menuAide.add(itemAide);

        //accelerateur
        itemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        itemAjouterCarte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        itemNouveauDeck.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        itemNouvellePartie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        itemAide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        //listerner menu 


        addWindowListener((WindowListener) this);
        return menuBar;
    }
    
    @Override
    public void quitter() {
        int option = JOptionPane.showConfirmDialog(this,
                "Voulez-vous réellement quitter l'application",
                "Demande de confirmation",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    private void addCsvToDataBase(File fileName) {

        String csvFile = fileName.getPath();
        BufferedReader br = null;
        String line = "";
        String cvsSplit = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplit);
                Carte carte = new Carte(-1, data[0], data[1], data[2], Integer.parseInt(data[3]), controler.getConteneur(1));
                controler.addCarte(carte);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    pageCarte.setData((ArrayList<Carte>) controler.getAllCartes());
                    pageCarte.refresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        pageCarte.searchByText(event.getSearch());
    }

    @Override
    public void searchCarteByType(SearchCarteByTypeEvent event) {
        pageCarte.searchByType(event.getSearch());
    }

    @Override
    public void searchCarteBySphere(SearchCarteBySphereEvent event) {
        pageCarte.searchBySphere(event.getSearch());
    }

    @Override
    public void searchCarteByConteneur(SearchCarteByConteneurEvent event) {
        pageCarte.searchByConteneur(event.getSearch());
    }    

    @Override
    public void delFilters() {
        pageCarte.delFilters();
    }

    @Override
    public void changeDeckCarte(int index) {
        pageDeck.changeDeckCarte(index);
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

    //méthode permettant de modifier le contenu du mainFrame lors d'un clique sur un bouton de page
    @Override
    public void changePage(String page) {
        Container contentPane = getContentPane();

        contentPane.removeAll();
        contentPane.add(toolBar, BorderLayout.PAGE_START);
        if (page == "pageCarte") {
            pageCarte.setData(controler.getAllCartes());
            contentPane.add(pageCarte, BorderLayout.CENTER);
        } else if (page == "pageDeck") {
            pageDeck.setData(controler.getAllDecks());
            contentPane.add(pageDeck, BorderLayout.CENTER);
        } else if (page == "pagePartie") {
            pagePartie.setData(controler.getAllParties());
            contentPane.add(pagePartie, BorderLayout.CENTER);
        }else if (page == "pageAjoutPartie"){
            pageAjoutPartie.setData(controler.getAllDecks());
            contentPane.add(pageAjoutPartie,BorderLayout.CENTER);
        }else if (page == "pageAjoutCarte"){
            pageAjoutCarte.setData(controler.getAllConteneur());
            contentPane.add(pageAjoutCarte,BorderLayout.CENTER);
            
        }else if( page == "ajoutDeck"){
            contentPane.add(pageAjoutDeck, BorderLayout.CENTER);
        }

        contentPane.revalidate();
        contentPane.repaint();
    }

    @Override
    public void importer() {
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
            System.out.println(fileChooser.getSelectedFile());
            addCsvToDataBase(fileChooser.getSelectedFile());
        }
    }

    @Override
    public void pageAjoutCarte() {
        changePage("pageAjoutCarte");
    }

    @Override
    public void pageAjoutDeck() {
        changePage("pageAjoutDeck");
    }

    @Override
    public void pageAjoutPartie() {
        changePage("pageAjoutPartie");
    }

    @Override
    public void ouvrirAide() {
        new AideDialog(MainFrame.this, false).setVisible(true);
    }

    
}
