package ch.ceff.ict3.sdajcemanager.fileFilters;


import ch.ceff.ict3.sdajcemanager.Utils;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * @Auteur cp-14syf
 */
public class CsvFileFilter extends FileFilter{

    public static final String EXTENSION = "csv";
    
    @Override
    public boolean accept(File file) {

        if (file.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(file);

        if (extension == null) {
            return false; // On ne le veut pas
        }

        if (extension.equals(EXTENSION)) {
            return true;
        }

        return false;
    }

    /**
     * S'affiche dans JFileChooser
     *
     * @return
     */
    @Override
    public String getDescription() {
        return "fichier csv (.*" + EXTENSION + ")";
    }

    @Override
    public String toString() {
        return EXTENSION;
    }
    
    

}
