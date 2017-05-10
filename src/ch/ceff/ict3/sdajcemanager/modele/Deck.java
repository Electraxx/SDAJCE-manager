/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.List;

/**
 *
 * @author cp-14luf
 */
public class Deck {
    
    private int id;
    private String name;
    private List<Carte> cartes;
    
    public Deck(int id, String name, List<Carte> cartes) {
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

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }
    
    
    
}
