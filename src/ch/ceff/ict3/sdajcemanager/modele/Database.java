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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
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
        this.connection = DBConnect.connect("localhost", "sdajce-manager", "root", "");
    }
    
    
    // Gestion de la DB
    public void addCarte(Carte carte) throws SQLException {
        Statement stmtCarte = connection.createStatement();
        
        String queryCarte = "INSERT INTO cartes ("
                + "nom_carte,"
                + "type_carte,"
                + "sphere_carte,"
                + "nombre_carte,"
                + "id_conteneur_carte"
                + ") VALUES ('"
                + carte.getNom() + "','"
                + carte.getType() + "','"
                + carte.getSphere() + "',"
                + carte.getNombre() + ","
                + carte.getConteneur().getId()
                +");";
        
        DBConnect.update(stmtCarte, queryCarte);
        stmtCarte.close();
    }
    public void editCarte(Carte carte) throws SQLException {
        Statement stmtCarte = connection.createStatement();
        
        String queryCarte = "INSERT INTO cartes ("
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
        
        DBConnect.update(stmtCarte, queryCarte);
        stmtCarte.close();
    }
    public Carte getCarte(int index) throws SQLException {
        Statement stmtCarte = connection.createStatement();
        
        String queryCarte = "SELECT * FROM cartes WHERE id_carte=" + index;
        ResultSet resultCarte = DBConnect.query(stmtCarte, queryCarte);
        resultCarte.next();
        
        Conteneur conteneur = getConteneur(resultCarte.getInt("id_conteneur_carte"));
        Carte carte = new Carte(
                index,
                resultCarte.getString("nom_carte"),
                resultCarte.getString("type_carte"),
                resultCarte.getString("sphere_carte"),
                resultCarte.getInt("nombre_carte"),
                conteneur
        );
        
        resultCarte.close();
        stmtCarte.close();
        return carte;
    }
    public List<Carte> getAllCartes() throws SQLException {
        Statement stmtCartes = connection.createStatement();
        
        String queryCartes = "SELECT id_carte FROM cartes";
        ResultSet resultCartes = DBConnect.query(stmtCartes, queryCartes);
        
        List<Carte> cartes = new ArrayList<>();
        
        while (resultCartes.next()) {
            Carte carte = getCarte(resultCartes.getInt("id_carte"));
            cartes.add(carte);
        }
        
        resultCartes.close();
        stmtCartes.close();
        return cartes;
    }
    public void delCarte(int index) throws SQLException {
        Statement stmtCarte = connection.createStatement();
        
        String queryCarte = "DELETE FROM cartes WHERE id_carte=" + index;
        DBConnect.update(stmtCarte, queryCarte);
        
        stmtCarte.close();
    }
    
    public void addDeck(Deck deck) throws SQLException {
        Statement stmtDeck = connection.createStatement();
        Statement stmtCartesDeck = connection.createStatement();
        
        String queryDeck = "INSERT INTO decks ("
                + "nom_deck"
                + ") "
                + "VALUES ( '"
                + deck.getName()
                +"' );";
        
        String queryCartesDeck = "INSERT INTO cartes_deck ("
                + "id_carte,"
                + "id_deck,"
                + "nombre_carte_deck"
                + ") VALUES ";
        
        DBConnect.prepareStmtUpdate(stmtDeck, queryDeck);
        ResultSet resultDeck = stmtDeck.getGeneratedKeys();
        resultDeck.next();
        int deck_id = resultDeck.getInt(1);
        
        List<String> queryCartesDeckList = new LinkedList<>();
        
        
        for(Carte carte: deck.getCartes()) {
            queryCartesDeckList.add("(" + carte.getId() + "," + deck_id + "," + carte.getNombre() + ")");
        }
        
        String joined = String.join(",", queryCartesDeckList);
        queryCartesDeck += joined;
        
        
        System.out.println(queryCartesDeck);
        DBConnect.update(stmtCartesDeck, queryCartesDeck);
        stmtDeck.close();
        stmtCartesDeck.close();
    }
    public Deck getDeck(int index) throws SQLException {
        Statement stmtDeck = connection.createStatement();
        Statement stmtCartesDeck = connection.createStatement();
        
        String queryDeck = "SELECT * FROM decks WHERE id_deck=" + index;
        ResultSet resultDeck = DBConnect.query(stmtDeck, queryDeck);
        resultDeck.next();
        
        String queryCartesDeck = "SELECT * FROM cartes_deck WHERE id_deck=" + index;
        ResultSet resultCartesDeck = DBConnect.query(stmtCartesDeck, queryCartesDeck);
        
        
        List<Carte> cartes = new ArrayList<>();
        
        while(resultCartesDeck.next()) {
            Carte carte = getCarte(resultCartesDeck.getInt("id_carte"));
            carte.setNombre(resultCartesDeck.getInt("nombre_carte_deck"));
            cartes.add(carte);
        }
        
        Deck deck = new Deck(resultDeck.getInt("id_deck"), resultDeck.getString("nom_deck"), cartes);
        
        resultDeck.close();
        resultCartesDeck.close();
        stmtDeck.close();
        stmtCartesDeck.close();
        return deck;
    }
    public List<Deck> getAllDecks() throws SQLException {
        Statement stmtDecks = connection.createStatement();
        
        String queryDecks = "SELECT id_deck FROM decks";
        ResultSet resultDecks = DBConnect.query(stmtDecks, queryDecks);
        
        List<Deck> decks = new ArrayList<>();
        
        while(resultDecks.next()) {
            Deck deck = getDeck(resultDecks.getInt("id_deck"));
            decks.add(deck);
        }
        
        resultDecks.close();
        stmtDecks.close();
        return decks;
        
    }
    public void delDeck(int index) throws SQLException {
        Statement stmtDeck = connection.createStatement();
        Statement stmtCartesDeck = connection.createStatement();
        
        
        String queryDeck = "DELETE FROM decks WHERE id_deck=" + index;
        String queryCartesDeck = "DELETE FROM carte_decks WHERE id_deck=" + index;
        DBConnect.update(stmtDeck, queryDeck);
        DBConnect.update(stmtCartesDeck, queryCartesDeck);
        
        stmtDeck.close();
        stmtCartesDeck.close();
    }
    
    public void addConteneur(Conteneur conteneur) throws SQLException {
        Statement stmtConteneur = connection.createStatement();
        
        String queryConteneur = "INSERT INTO conteneur ("
                + "nom_contn,"
                + "abbd_contn"
                + ") VALUES ("
                + conteneur.getNom() + ","
                + conteneur.getAbbreviation()
                + ");";
        DBConnect.update(stmtConteneur, queryConteneur);
        
        stmtConteneur.close();
    }
    public Conteneur getConteneur(int index) throws SQLException {
        Statement stmtConteneur = connection.createStatement();
        
        String queryConteneur = "SELECT * FROM conteneur WHERE id_contn=" + index;
        ResultSet resultConteneur = DBConnect.query(stmtConteneur, queryConteneur);
        resultConteneur.next();
        
        Conteneur conteneneur = new Conteneur(
                resultConteneur.getInt("id_contn"),
                resultConteneur.getString("nom_contn"),
                resultConteneur.getString("abbr_contn")
        );
        
        resultConteneur.close();
        stmtConteneur.close();
        return conteneneur;
    }
    public List<Conteneur> getAllConteneur() throws SQLException {
        Statement stmtConteneurs = connection.createStatement();
        String queryConteneurs = "SELECT id_contn FROM conteneur";
        ResultSet resultConteneurs = DBConnect.query(stmtConteneurs, queryConteneurs);
        
        List<Conteneur> conteneurs = new ArrayList<>();
        
        while(resultConteneurs.next()){
            Conteneur conteneur = getConteneur(resultConteneurs.getInt("id_contn"));
            conteneurs.add(conteneur);
        }
        
        resultConteneurs.close();
        stmtConteneurs.close();
        return conteneurs;
        
    }
    public void delConteneur(int index) throws SQLException {
        Statement stmtConteneur = connection.createStatement();
        String queryConteneur = "DELETE FROM conteneur WHERE id_contn=" + index;
        DBConnect.update(stmtConteneur, queryConteneur);
        stmtConteneur.close();
    }
    
    public void addPartie(Partie partie) throws SQLException {
        Statement stmtPartie = connection.createStatement();
        
        int partie_resultat = 0;
        
        if(partie.isResultat()) partie_resultat = 1;
        
        String queryPartie = "INSERT INTO partie ("
                + "date_partie,"
                + "resultat"
                + ") VALUES ("
                + "'"+new Timestamp(partie.getDate().getTime()) + "',"
                + partie_resultat
                +");";
        
        System.out.println(queryPartie);
        
        DBConnect.prepareStmtUpdate(stmtPartie, queryPartie);
        ResultSet resultPartie = stmtPartie.getGeneratedKeys();
        resultPartie.next();
        int partie_id = resultPartie.getInt(1);
        
        for (Deck deck: partie.getDecks()) {
            Statement stmtQueryDecksPartie = connection.createStatement();
            String queryDecksPartie = "INSERT INTO decks_partie ("
                    + "id_deck,"
                    + "id_partie"
                    + ") VALUES ("
                    + deck.getId() + ","
                    + partie_id
                    +");";
            DBConnect.update(stmtQueryDecksPartie, queryDecksPartie);
            stmtQueryDecksPartie.close();
        }
        
        
        stmtPartie.close();
    }
    public Partie getPartie(int index) throws SQLException {
        Statement stmtPartie = connection.createStatement();
        Statement stmtDecksPartie = connection.createStatement();
        
        String queryPartie = "SELECT * FROM partie WHERE id_partie=" + index;
        ResultSet resultPartie = DBConnect.query(stmtPartie, queryPartie);
        resultPartie.next();
        
        String queryDecksPartie = "SELECT id_deck FROM decks_partie WHERE id_partie=" + index; 
        ResultSet resultDecksPartie = DBConnect.query(stmtDecksPartie, queryDecksPartie);
        
        List<Deck> decks = new ArrayList<>();
        
        
        while(resultDecksPartie.next()) {
            decks.add(getDeck(resultDecksPartie.getInt("id_deck")));
        }
        
        
        Partie partie = new Partie(
                resultPartie.getInt("id_partie"),
                resultPartie.getTimestamp("date_partie"),
                resultPartie.getBoolean("resultat"),
                decks
        );
        
        resultDecksPartie.close();
        resultPartie.close();
        stmtPartie.close();
        stmtDecksPartie.close();
        return partie;
    }
    public List<Partie> getAllParties() throws SQLException {
        Statement stmtParties = connection.createStatement();
        
        String queryParties = "SELECT id_partie FROM partie";
        ResultSet resultParties = DBConnect.query(stmtParties, queryParties);
        
        List<Partie> parties = new ArrayList<>();
        
        while(resultParties.next()) {
            parties.add(getPartie(resultParties.getInt("id_partie")));
        }
        
        resultParties.close();
        stmtParties.close();
        return parties;
    }
    public void delPartie(int index) throws SQLException {
        Statement stmtPartie = connection.createStatement();
        Statement stmtDeckPartie = connection.createStatement();
        
        String queryPartie = "DELETE FROM partie WHERE id_deck=" + index;
        String queryDeckPartie = "DELETE FROM decks_partie WHERE id_deck=" + index;
        DBConnect.update(stmtPartie, queryPartie);
        DBConnect.update(stmtDeckPartie, queryDeckPartie);
        stmtPartie.close();
        stmtDeckPartie.close();
    }
}
