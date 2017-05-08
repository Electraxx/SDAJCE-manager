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
public class Database {
    private static Database INSTANCE;
    
    public static Database creerDatabase() {
        if(INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
    
    private Database() {
        
    }
    
    // Gestion de la DB
    
    public void addCarte(){}
    public Carte getCarte(){return null;}
    public List<Carte> getAllCartes(){return null;}
    public void delCarte(int index){}
    
    
    public void addDeck(){}
    public Deck getDeck(){return null;}
    public List<Deck> getAllDecks(){return null;}
    public void delDeck(int index){}
    
    public void addConteneur(){}
    public Conteneur getConteneur(){return null;}
    public List<Conteneur> getAllConteneur(){return null;}
    public void delConteneur(int index){}
    
    public void addPartie(){}
    public Partie getPartie(){return null;}
    public List<Partie> getAllParties(){return null;}
    public void delPartie(int index){}
}
