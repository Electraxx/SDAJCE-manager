/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager;

import ch.ceff.ict3.sdajcemanager.composants.MainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author cp-14luf
 */
public class App {

    public static final String APP_NAME = "SDAJCE-manager";
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(APP_NAME);
            }
        });
    }
    
}
