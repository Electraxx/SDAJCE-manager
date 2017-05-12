/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.event.AddCarteEvent;
import ch.ceff.ict3.sdajcemanager.event.AddConteneurEvent;
import ch.ceff.ict3.sdajcemanager.event.AddDeckEvent;
import ch.ceff.ict3.sdajcemanager.event.AddPartieEvent;
import ch.ceff.ict3.sdajcemanager.event.DelCarteEvent;
import ch.ceff.ict3.sdajcemanager.event.DelConteneurEvent;
import ch.ceff.ict3.sdajcemanager.event.DelDeckEvent;
import ch.ceff.ict3.sdajcemanager.event.DelPartieEvent;
import ch.ceff.ict3.sdajcemanager.event.EditCarteEvent;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    private PageCarte pageCarte;
    private JSplitPane splitPane;
    private AppListener listener;

    public MainFrame(String titre) {
        initComponents(titre);
    }

    public void initComponents(String titre) {
        Container contentPane = getContentPane();
        pageCarte = new PageCarte();
        toolBar = new ToolBar();

        toolBar.setListener(this);

        contentPane.add(pageCarte, BorderLayout.CENTER);
        contentPane.add(toolBar, BorderLayout.PAGE_START);

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

    }

    @Override
    public void delCarte(DelCarteEvent event) {

    }

    @Override
    public void editCarte(EditCarteEvent event) {

    }

    @Override
    public void addConteneur(AddConteneurEvent event) {

    }

    @Override
    public void editConteneur(DelConteneurEvent event) {

    }

    @Override
    public void addDeck(AddDeckEvent event) {

    }

    @Override
    public void delDeck(DelDeckEvent event) {

    }

    @Override
    public void addPartie(AddPartieEvent event) {

    }

    @Override
    public void delPartie(DelPartieEvent event) {

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
}
