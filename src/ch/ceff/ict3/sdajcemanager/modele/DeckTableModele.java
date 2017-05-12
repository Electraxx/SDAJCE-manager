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
public class DeckTableModele extends AbstractTableModel {
    private final String[] COLNAMES = {"Deck"};
    
    private List<Deck> decks;
    
    @Override
    public int getRowCount() {
        return decks.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Deck deck = decks.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return deck.getName();
        }
        return null;
    }
    
    public void setData(List<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
}
