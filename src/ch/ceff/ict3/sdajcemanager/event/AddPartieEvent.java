/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.event;

import java.util.EventObject;

/**
 *
 * @author cp-14syf
 */
public class AddPartieEvent extends EventObject {

    private String date;
    private boolean resultat;
    private int decks;

    public AddPartieEvent(Object source) {
        super(source);
    }

    public AddPartieEvent(String date, boolean resultat, int decks, Object source) {
        super(source);
        this.date = date;
        this.resultat = resultat;
        this.decks = decks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isResultat() {
        return resultat;
    }

    public void setResultat(boolean resultat) {
        this.resultat = resultat;
    }

    public int getDecks() {
        return decks;
    }

    public void setDecks(int decks) {
        this.decks = decks;
    }

}
