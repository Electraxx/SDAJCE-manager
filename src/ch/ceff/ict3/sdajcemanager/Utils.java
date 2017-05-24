/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager;

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

}
