/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.controleurs;

import ch.ceff.ict3.sdajcemanager.event.AddCarteEvent;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Database;

/**
 *
 * @author cp-14luf
 */
public class Controleur {

    private Database db;

    public Controleur() {
        db = db.newDatabase();
    }


    public void AddCarte(AddCarteEvent event) {
        Carte carte = new Carte(-1,event.getNom(),event.getType(), event.getSphere(), event.getNombre(), event.getConteneur());
        db.addCarte(carte);
    }
}
