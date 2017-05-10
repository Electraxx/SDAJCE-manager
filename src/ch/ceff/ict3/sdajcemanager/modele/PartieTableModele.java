/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cp-14luf
 */
public class PartieTableModele extends AbstractTableModel{
    private final String[] COLNAMES = {"Date", "Resultat", "Decks"};
    
    
    
    private List<Partie> parties;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    
    @Override
    public int getRowCount() {
        return parties.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Partie partie = parties.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return format.format(partie.getDate());
            case 1:
                
                if(partie.isResultat()) {
                    return "Victoire";
                }
                return "Défaite";
                
            case 2:
                String nomsDecks = "";
                
                for(Deck deck: partie.getDecks()) {
                    nomsDecks += deck.getName() + ";";
                }
                
                return nomsDecks;
        }
        return null;
    }
    
    public void setData(List<Partie> parties) {
        this.parties = parties;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
}
