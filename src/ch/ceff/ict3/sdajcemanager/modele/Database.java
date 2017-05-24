/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author cp-14luf
 */
public class Database {
    private static Database INSTANCE;
    
    private Connection connection;
    
    public static Database newDatabase() {
        if(INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
    
    private Database() {
        this.connection = DBConnect.connect("localhost", "root", "");
    }
    
    // Gestion de la DB
    
    public void addCarte(Carte carte) {
        String query = "INSERT INTO cartes ("
                + "nom_carte,"
                + "type_carte,"
                + "sphere_carte,"
                + "nombre_carte,"
                + "id_conteneur_carte"
                + ") VALUES ("
                + carte.getNom() + ","
                + carte.getType() + ","
                + carte.getSphere() + ","
                + carte.getNombre() + ","
                + carte.getConteneur().getId() + ","
                +");";
        ResultSet result = DBConnect.query(connection, query);
    }
    public void editCarte(Carte carte) {
        String query = "INSERT INTO cartes ("
                + "id_carte,"
                + "nom_carte,"
                + "type_carte,"
                + "sphere_carte,"
                + "nombre_carte,"
                + "id_conteneur_carte"
                + ") VALUES ("
                + carte.getId()+ ","
                + carte.getNom() + ","
                + carte.getType() + ","
                + carte.getSphere() + ","
                + carte.getNombre() + ","
                + carte.getConteneur().getId() + ","
                +");";
        ResultSet result = DBConnect.query(connection, query);
    }
    public Carte getCarte(int index) {
        String query = "SELECT * FROM cartes WHERE id_carte=" + index;
        ResultSet result = DBConnect.query(connection, query);
        return null;
    }
    public List<Carte> getAllCartes() {
        String query = "SELECT * FROM cartes";
        ResultSet result = DBConnect.query(connection, query);
        return null;
    }
    public void delCarte(int index) {
        String query = "DELETE FROM cartes WHERE id_carte=" + index;
        ResultSet result = DBConnect.query(connection, query);
    }
    
    
    public void addDeck(Deck deck) {
        

        
        
        String query1 = "INSERT INTO cartes ("
                + "nom_deck"
                + ") VALUES ("
                + deck.getName()
                +");";
        
        String query2 = "INSERT INTO cartes_deck ("
                + "id_carte"
                + "nombre_carte_deck"
                + ") VALUES ";
        
        for(Carte carte: deck.getCartes()) {
            query2 += "(" + carte.getId()+ "," + carte.getNombre() + "),";
        }
        ResultSet result = DBConnect.query(connection, query1);
    }
    public Deck getDeck(int index) {return null;}
    public List<Deck> getAllDecks() {return null;}
    public void delDeck(int index) {}
    
    public void addConteneur(Conteneur conteneur) {}
    public Conteneur getConteneur(int index) {return null;}
    public List<Conteneur> getAllConteneur() {return null;}
    public void delConteneur(int index) {}
    
    public void addPartie(Partie partie) {}
    public Partie getPartie(int index) {return null;}
    public List<Partie> getAllParties() {return null;}
    public void delPartie(int index) {}
    public void orderTable(){
        //Collections.sort(personnes);
    }
}
