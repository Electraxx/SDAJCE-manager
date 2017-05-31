/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cp-14luf
 */
public class CarteTableModele extends AbstractTableModel{
    
    private final String[] COLNAMES = {"Nombre", "Nom", "Type", "Sphère", "Conteneur"};
    
    private List<Carte> cartes;
    
    @Override
    public int getRowCount() {
        return cartes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carte carte = cartes.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return carte.getNombre();
            case 1:
                return carte.getNom();
            case 2:
                return carte.getType();
            case 3:
                return carte.getSphere();
            case 4:
                return carte.getConteneur().getAbbreviation();
        }
        return null;
    }
    
    public void setData(List<Carte> cartes) {
        try{
        this.cartes = cartes;
        }catch(Exception e){}
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
}
