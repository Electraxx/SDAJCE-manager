/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.LinkedList;

/**
 *
 * @author cp-14luf
 */
public class Deck {
    
    private int id;
    private String name;
    private LinkedList<Carte> cartes;
    
    public Deck(int id, String name, LinkedList<Carte> cartes) {
        this.id = id;
        this.name = name;
        this.cartes = cartes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(LinkedList<Carte> cartes) {
        this.cartes = cartes;
    }
    
    
    
}
