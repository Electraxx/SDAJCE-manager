/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.event;

import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import java.util.EventObject;

/**
 *
 * @author cp-14syf
 */
public class AddCarteEvent extends EventObject {

    private String nom;
    private String type;
    private String sphere;
    private int nombre;
    private Conteneur conteneur;

    public AddCarteEvent(Object source, String nom, String type, String sphere, int nombre, Conteneur conteneur) {
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

    public Conteneur getConteneur() {
        return conteneur;
    }

    public void setConteneur(Conteneur conteneur) {
        this.conteneur = conteneur;
    }
    
    

}
