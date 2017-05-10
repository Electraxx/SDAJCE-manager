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
public class EditCarteEvent extends EventObject{

    private String nom;
    private String type;
    private String sphere;
    private int nombre;
    private String conteneur;

    public EditCarteEvent(Object source, String nom, String type, String sphere, int nombre, String conteneur) {
        super(source);
        this.nom = nom;
        this.type = type;
        this.sphere = sphere;
        this.nombre = nombre;
        this.conteneur = conteneur;
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

    public String getConteneur() {
        return conteneur;
    }

    public void setConteneur(String conteneur) {
        this.conteneur = conteneur;
    }
}
