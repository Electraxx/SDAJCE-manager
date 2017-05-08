/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

/**
 *
 * @author cp-14luf
 */
public class Carte {
    
    private int id;
    private String nom;
    private String type;
    private String sphere;
    private int nombre;
    private Conteneur conteneur;
    
    public Carte(int id, String nom, String type, String sphere, int nombre, Conteneur conteneur){
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.sphere = sphere;
        this.nombre = nombre;
        this.conteneur = conteneur;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    public Conteneur getConteneur() {
        return conteneur;
    }

    public void setConteneur(Conteneur conteneur) {
        this.conteneur = conteneur;
    }
    
    
}
