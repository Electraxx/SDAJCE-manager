/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        DBConnect.query(connection, query);
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
        DBConnect.query(connection, query);
    }
    public Carte getCarte(int index) throws SQLException {
        
        String query1 = "SELECT * FROM cartes WHERE id_carte=" + index;
        ResultSet resultCarte = DBConnect.query(connection, query1);
        
        String query2 = "SELECT * FROM conteneur WHERE id_cont=" + resultCarte.getInt("id_conteneur_carte");
        ResultSet resultConteneur = DBConnect.query(connection, query2);
        
        Conteneur conteneur = new Conteneur(
                resultConteneur.getInt("id_contn"),
                resultConteneur.getString("nom_contn"),
                resultConteneur.getString("abbr_contn")
        );
        
        Carte carte = new Carte(
                index,
                resultCarte.getString("nom_carte"),
                resultCarte.getString("type_carte"),
                resultCarte.getString("sphere_nombre"),
                resultCarte.getInt("nombre_carte"),
                conteneur
        );
        return carte;
    }
    public List<Carte> getAllCartes() throws SQLException {
        String query = "SELECT * FROM cartes";
        ResultSet resultCartes = DBConnect.query(connection, query);
        
        List<Carte> cartes = new ArrayList<>();
        
        while (resultCartes.next()) {
            String query2 = "SELECT * FROM conteneur WHERE id_cont=" + resultCartes.getInt("id_conteneur_carte");
            ResultSet resultConteneur = DBConnect.query(connection, query2);

            Conteneur conteneur = new Conteneur(
                resultConteneur.getInt("id_contn"),
                resultConteneur.getString("nom_contn"),
                resultConteneur.getString("abbr_contn")
            );

            Carte carte = new Carte(
                resultCartes.getInt("id_carte"),
                resultCartes.getString("nom_carte"),
                resultCartes.getString("type_carte"),
                resultCartes.getString("sphere_nombre"),
                resultCartes.getInt("nombre_carte"),
                conteneur
            );
            cartes.add(carte);
        }
        return cartes;
    }
    public void delCarte(int index) {
        String query = "DELETE FROM cartes WHERE id_carte=" + index;
        DBConnect.query(connection, query);
    }
    
    public void addDeck(Deck deck) {
        String queryDeck = "INSERT INTO decks ("
                + "nom_deck"
                + ") "
                + "OUTPUT INSERTED.id_deck"
                + "VALUES ("
                + deck.getName()
                +");";
        
        String queryCartesDeck = "INSERT INTO cartes_deck ("
                + "id_carte"
                + "nombre_carte_deck"
                + ") VALUES ";
        
        for(Carte carte: deck.getCartes()) {
            queryCartesDeck += "(" + carte.getId()+ "," + carte.getNombre() + "),";
        }
        DBConnect.query(connection, queryDeck);
        DBConnect.query(connection, queryCartesDeck);
    }
    public Deck getDeck(int index) throws SQLException {
        String queryDeck = "SELECT * FROM decks WHERE id_deck=" + index;
        ResultSet resultDeck = DBConnect.query(this.connection, queryDeck);
        
        String queryCartesDeck = "SELECT * FROM cartes_deck WHERE id_deck=" + index;
        ResultSet resultCartesDeck = DBConnect.query(this.connection, queryCartesDeck);
        
        
        List<Carte> cartes = new ArrayList<>();
        
        while(resultCartesDeck.next()) {
            Carte carte = getCarte(resultCartesDeck.getInt("id_carte"));
            carte.setNombre(resultCartesDeck.getInt("nombre_carte_deck"));
            cartes.add(carte);
        }
        
        Deck deck = new Deck(resultDeck.getInt("id_deck"), resultDeck.getString("nom_deck"), cartes);
        
        return deck;
    }
    public List<Deck> getAllDecks() throws SQLException {
        String queryDecks = "SELECT * FROM decks";
        ResultSet resultDecks = DBConnect.query(connection, queryDecks);
        
        List<Deck> decks = new ArrayList<>();
        
        while(resultDecks.next()) {
            String queryCartesDeck = "SELECT * FROM cartes_deck WHERE id_deck=" + resultDecks.getInt("id_deck");
            ResultSet resultCartesDeck = DBConnect.query(this.connection, queryCartesDeck);
            
            List<Carte> cartes = new ArrayList<>();
        
            while(resultCartesDeck.next()) {
                Carte carte = getCarte(resultCartesDeck.getInt("id_carte"));
                carte.setNombre(resultCartesDeck.getInt("nombre_carte_deck"));
                cartes.add(carte);
            }

            Deck deck = new Deck(resultDecks.getInt("id_deck"), resultDecks.getString("nom_deck"), cartes);
            decks.add(deck);
        }
        return decks;
        
    }
    public void delDeck(int index) {}
    
    public void addConteneur(Conteneur conteneur) {}
    public Conteneur getConteneur(int index) {return null;}
    public List<Conteneur> getAllConteneur() {return null;}
    public void delConteneur(int index) {}
    
    public void addPartie(Partie partie) {}
    public Partie getPartie(int index) {return null;}
    public List<Partie> getAllParties() {return null;}
    public void delPartie(int index) {}
}
