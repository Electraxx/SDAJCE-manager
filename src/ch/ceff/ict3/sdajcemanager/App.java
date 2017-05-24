/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager;

import ch.ceff.ict3.sdajcemanager.composants.MainFrame;
import ch.ceff.ict3.sdajcemanager.modele.Database;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author cp-14luf
 */
public class App {

    public static final String APP_NAME = "SDAJCE-manager";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame fenetre = new MainFrame(APP_NAME);
                fenetre.setVisible(true);
            }
        });
    }

}
