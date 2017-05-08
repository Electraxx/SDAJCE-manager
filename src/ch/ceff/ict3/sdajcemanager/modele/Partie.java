/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.Date;
import java.util.List;

/**
 *
 * @author cp-14luf
 */
public class Partie {
    
    private int id;
    private Date date;
    private boolean resultat;
    private List<Deck> decks;
    
    public Partie(int id, Date date, boolean resultat, List<Deck> decks) {
        this.id = id;
        this.date = date;
        this.resultat = resultat;
        this.decks = decks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isResultat() {
        return resultat;
    }

    public void setResultat(boolean resultat) {
        this.resultat = resultat;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }
    
}
