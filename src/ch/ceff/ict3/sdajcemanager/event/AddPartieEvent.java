/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.event;

import ch.ceff.ict3.sdajcemanager.modele.Deck;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author cp-14syf
 */
public class AddPartieEvent extends EventObject {

    private Date date;
    private boolean resultat;
    private List<Deck> decks;

    public AddPartieEvent(Object source) {
        super(source);
    }

    public AddPartieEvent(Date date, boolean resultat, List<Deck> decks, Object source) {
        super(source);
        this.date = date;
        this.resultat = resultat;
        this.decks = decks;
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
