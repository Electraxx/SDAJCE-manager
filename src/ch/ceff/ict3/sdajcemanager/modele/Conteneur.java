/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cp-14luf
 */
public class Conteneur {
    
    private int id;
    private String nom;
    private String abbreviation;
    
    public Conteneur(int id, String nom, String abbreviation) {
        this.id = id;
        this.nom = nom;
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
