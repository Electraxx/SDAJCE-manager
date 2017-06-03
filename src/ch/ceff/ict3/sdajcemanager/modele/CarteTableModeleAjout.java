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
public class CarteTableModeleAjout extends AbstractTableModel {

    private final String[] COLNAMES = {"Nombre", "Disponnible", "ID", "Nom", "Type", "Sphère", "Conteneur"};

    private List<Carte> cartes;
    private int[] nbr;
    
    
    @Override
    public int getRowCount() {
        return cartes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carte carte = cartes.get(rowIndex);
        
        
        switch (columnIndex) {
            case 0:
                return this.nbr[rowIndex];
            case 1:
                return carte.getNombre();
            case 2:
                return carte.getId();
            case 3:
                return carte.getNom();
            case 4:
                return carte.getType();
            case 5:
                return carte.getSphere();
            case 6:
                return carte.getConteneur().getNom();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        this.nbr[row] = (int)value;
        
        fireTableCellUpdated(row, col);
        fireTableDataChanged();
        
    }

    public void setData(List<Carte> cartes) {
        this.cartes = cartes;
        this.nbr = new int[cartes.size()];
        
        for(int i = 0; i < cartes.size(); i++) {
            this.nbr[i] = cartes.get(i).getNombre();
        }
        
    }
    
    public List<Carte> getCartes() {
        return this.cartes;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
}
