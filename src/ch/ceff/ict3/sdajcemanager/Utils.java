/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
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
    
    public static Point getTopRightPoint(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX();
        int y = 0;
        return new Point(x,y);
    }
    

}
