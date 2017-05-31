/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager;

import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author cp-13jru
 */
public class Utils {

    public static ImageIcon createIcon(String path) {
        URL url = App.class.getResource(path);
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            return icon;
        }
        return null;
    }
    
    public static String getExtension(File fichier) {
        //Récupérer le nom du fichier 
        String nomFichier = fichier.getName();

        //Recherche du début de l'extension
        int debutExtension = nomFichier.lastIndexOf(".");

        if (debutExtension != -1 && debutExtension != 0) {
            return nomFichier.substring(debutExtension + 1);
        }

        return null;
    }

    public static File getFichierAvecExtension(File fichier, String extension) {
        String nomFichier = fichier.getAbsolutePath();
        if (nomFichier.lastIndexOf(".") == -1) {
            fichier = new File(nomFichier + "." + extension);
        }
        return fichier;
    }

}
