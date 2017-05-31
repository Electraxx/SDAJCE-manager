/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author cp-14luf
 */
public class CarteTableModeleAjout extends AbstractTableModel {

    private final String[] COLNAMES = {"tete", "Nombre", "Nom", "Type", "Sphère", "Conteneur"};

    private List<Carte> cartes;
    
    public void setData(){
        
        Object[][] data = {cartes.toArray()};
        
    }

    @Override
    public int getRowCount() {
        return cartes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carte carte = cartes.get(rowIndex);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Knitting");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Pool");
        comboBox.addItem("None of the above");
        //setCellEditor(new DefaultCellEditor(comboBox));

        switch (columnIndex) {
            case 0:
                return true;
            case 1:
                return carte.getNombre();
            case 2:
                return carte.getNom();
            case 3:
                return carte.getType();
            case 4:
                return carte.getSphere();
            case 5:
                return carte.getConteneur().getAbbreviation();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Boolean.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
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
//        Carte carte = cartes.get(row);
//        carte = value;
        fireTableCellUpdated(row, col);
    }

    public void setData(List<Carte> cartes) {
        this.cartes = cartes;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
}
