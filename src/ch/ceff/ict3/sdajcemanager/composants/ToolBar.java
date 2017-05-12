/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.Utils;
import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import java.awt.FlowLayout;
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

    public ToolBar() {
        initComponents();
    }

    private void initComponents() {
//    setBackground(Color.red);
        setBorder(BorderFactory.createEtchedBorder());

        buttonCarte = new JButton();
        buttonCarte.setIcon(Utils.createIcon("images/IconeCarte.png"));
        buttonCarte.setSize(1,1);
        buttonDeck = new JButton();
        buttonDeck.setIcon(Utils.createIcon("images/IconeDeck.png"));
        buttonCarte.setSize(1,1);
        buttonParty = new JButton();
        buttonParty.setIcon(Utils.createIcon("images/IconeDuel.png"));
        buttonCarte.setSize(1,1);

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
