/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.actions;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.ImageIcon;

/**
 *
 * @author cp-14luf
 */
public class Action extends AbstractAction {

    protected AppListener listener;

    public Action(String text, ImageIcon icon, String desc, int mnemonic, AppListener listener) {
        super(text, icon);
        init(desc, mnemonic, listener);
    }

    private void init(String desc, int mnemonic, AppListener listener) {
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

}

