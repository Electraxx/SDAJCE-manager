/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.Utils;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author cp-13jru
 */
public class ToolBar extends JToolBar implements ActionListener {

    private JButton buttonCarte;
    private JButton buttonDeck;
    private JButton buttonParty;
    private AppListener listener;
    private PageCarte pageCarte;
    private PageDeck pageDeck;

    public ToolBar() {
        initComponents();
    }

    private void initComponents() {
//    setBackground(Color.red);
        setBorder(BorderFactory.createEtchedBorder());

        
        buttonCarte = new JButton();
        //ajoute une image dans le bouton
        buttonCarte.setIcon(Utils.createIcon("images/IconeCarte.png"));
        //ajoute une infoBulle
        buttonCarte.setToolTipText("Onglet Carte");
        buttonDeck = new JButton();
        buttonDeck.setIcon(Utils.createIcon("images/IconeDeck.png"));
        buttonDeck.setToolTipText("Onglet Deck");
        buttonParty = new JButton();
        buttonParty.setIcon(Utils.createIcon("images/IconeDuel.png"));
        buttonParty.setToolTipText("Onglet Partie");
  
        buttonCarte.addActionListener(this);
        buttonDeck.addActionListener(this);
        buttonParty.addActionListener(this);

        //setLayout(new FlowLayout(FlowLayout.LEFT));
        add(buttonCarte);
        add(buttonDeck);
        add(buttonParty);
        
        //setFloatable(false);
    }

    public void setListener(AppListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton activeButton = (JButton)e.getSource();
        
        if (listener != null) {
            if(activeButton == buttonCarte){
                listener.changePage("pageCarte");
            }else if(activeButton == buttonDeck){
                 listener.changePage("pageDeck");
            }else if(activeButton == buttonParty){
                 listener.changePage("pagePartie");
            }
            
        }
    }

}
