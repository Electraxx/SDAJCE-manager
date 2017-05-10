/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.event;

import ch.ceff.ict3.sdajcemanager.modele.Carte;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author cp-14syf
 */
public class AddDeckEvent extends EventObject {

    private String nom;
    private List<Carte> cartes;

    public AddDeckEvent(Object source) {
        super(source);
    }

    public AddDeckEvent(String nom, List<Carte> cartes, Object source) {
        super(source);
        this.nom = nom;
        this.cartes = cartes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

}
