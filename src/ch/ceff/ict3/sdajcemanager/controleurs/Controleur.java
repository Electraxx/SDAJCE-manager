/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.controleurs;

import ch.ceff.ict3.sdajcemanager.event.*;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import ch.ceff.ict3.sdajcemanager.modele.Database;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.Partie;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cp-14luf
 */
public class Controleur {

    private Database db;

    public Controleur() {
        db = Database.newDatabase();
    }

    public void addCarte(AddCarteEvent event) {
        Carte carte = new Carte(-1, event.getNom(), event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        try {
            db.addCarte(carte);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delCarte(int index) {
        try {
            db.delCarte(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Carte getCarte(int index) {
        try {
            return db.getCarte(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<Carte> getAllCartes() {
        try {
            return db.getAllCartes();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void editCarte(EditCarteEvent event) {
        Carte carte = new Carte(event.getId(), event.getNom(), event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        try {
            db.editCarte(carte);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addDeck(AddDeckEvent event) {
        Deck deck = new Deck(-1, event.getNom(), event.getCartes());
        try {
            db.addDeck(deck);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delDeck(int index) {
        try {
            db.delDeck(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Deck getDeck(int index) {
        try {
            return db.getDeck(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<Deck> getAllDecks() {
        try {
            return db.getAllDecks();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void addPartie(AddPartieEvent event) {
        Partie partie = new Partie(-1, event.getDate(), event.isResultat(), event.getDecks());
        try {
            db.addPartie(partie);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delPartie(int index) {
        try {
            db.delPartie(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Partie getPartie(int index) {
        try {
            return db.getPartie(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<Partie> getAllParties() {
        try {
            return db.getAllParties();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void addConteneur(AddConteneurEvent event) {
        Conteneur conteneur = new Conteneur(-1, event.getNom(), event.getAbbr());
        try {
            db.addConteneur(conteneur);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delConteneur(int index) {
        try {
            db.delConteneur(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Conteneur getConteneur(int index) {
        try {
            return db.getConteneur(index);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<Conteneur> getAllConteneur() {
        try {
            return db.getAllConteneur();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
