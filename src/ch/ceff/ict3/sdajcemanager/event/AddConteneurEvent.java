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
public class AddConteneurEvent extends EventObject{
    
    private String nom;
    private String abbr;

    public AddConteneurEvent(Object source) {
        super(source);
    }

    public AddConteneurEvent(String nom, String abbr, Object source) {
        super(source);
        this.nom = nom;
        this.abbr = abbr;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
    
    
}
