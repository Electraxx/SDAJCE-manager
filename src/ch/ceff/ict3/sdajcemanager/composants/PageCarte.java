/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author cp-13jru
 */
public class PageCarte extends JPanel {

    private FormPanelCarte panelCarte;
    private TablePanelCarte tablePanel;

    public PageCarte() {
        initComponents();
    }

    public void initComponents() {

        //toolBar = new ToolBar();
        tablePanel = new TablePanelCarte();
        panelCarte = new FormPanelCarte();

        List<Carte> temp_data = new ArrayList<Carte>();

        temp_data.add(new Carte(0, "Aragorn", "Héros", "Commandement", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Théodred", "Héros", "Commandement", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Glóin", "Héros", "Commandement", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Gimli", "Héros", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Legolas", "Héros", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Thalin", "Héros", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Éowyn", "Héros", "Energie", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Eleanor", "Héros", "Energie", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Dúnhere", "Héros", "Energie", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Denethor", "Héros", "Connaissance", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Glorfindel", "Héros", "Connaissance", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Beravor", "Héros", "Connaissance", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Garde de la Citadelle", "Allié", "Commandement", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Faramir", "Allié", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Fils de l’Arnor", "Allié", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Éclaireur du Snowbourn", "Allié", "Commandement", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Archer du Cours d’Argent", "Allié", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Tueur d’Orques Longue-Barbe", "Allié", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Brok Poing-de-Fer", "Allié", "Commandement", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Toujours Vigilant", "Evénement", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Cause Commune", "Evénement", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Pour le Gondor !", "Evénement", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Attaque Furtive", "Evénement", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Sacrifice Héroïque", "Evénement", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Détermination Acharnée", "Evénement", "Commandement", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Intendant du Gondor", "Attachement", "Commandement", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Pierre de Celebrían", "Attachement", "Commandement", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Vétéran à la Hache", "Allié", "Tactique", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Lancier Gondorien", "Allié", "Tactique", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Archer à Cheval", "Allié", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Beorn", "Allié", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Maîtrise des Armes", "Evénement", "Tactique", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Pluie de Flèches", "Evénement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Feinte", "Evénement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Coup Rapide", "Evénement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Haie de Lances", "Evénement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Coup Brutal", "Evénement", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Faire Face Ensemble", "Evénement", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Lame de Gondolin", "Attachement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Armure de la Citadelle", "Attachement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Hache de Nain", "Attachement", "Tactique", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Cor du Gondor", "Attachement", "Tactique", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Touque Aventureux", "Allié", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Guide de la Lórien", "Allié", "Energie", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Traqueur du Nord", "Allié", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Salutations des Galadhrim", "Evénement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Force de la Volonté", "Evénement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Coup Précipité", "Evénement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Volonté de l’Ouest", "Evénement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Tester sa Volonté", "Evénement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Tenir et Combattre", "Evénement", "Energie", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Une Lumière dans les Ténèbres", "Evénement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Tombe de Nain", "Evénement", "Energie", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Chance ou Destin", "Evénement", "Energie", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "La Faveur de la Dame", "Attachement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Le Pouvoir de la Terre", "Attachement", "Energie", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Courage Inattendu", "Attachement", "Energie", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Fille de la Nimrodel", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Forgeron d’Erebor", "Allié", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Henamarth Chantrivière", "Allié", "Connaissance", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Mineurs des Mont du Fer", "Allié", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Gléowine", "Allié", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Savoir d’Imladris", "Evénement", "Connaissance", 3, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Opulence de la Lórien", "Evénement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Ruse de Radagast", "Evénement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Chemins Secrets", "Evénement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Recherches de Gandalf", "Evénement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Hospitalité de Beorn", "Evénement", "Connaissance", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Danger de la Forêt", "Attachement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Protecteur de la Lórien", "Attachement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Savoir Ténébreux", "Attachement", "Connaissance", 1, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Instinct de Survie", "Attachement", "Connaissance", 2, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Gandalf", "Allié", "Neutre", 4, new Conteneur(0, "Test", "bb")));
        temp_data.add(new Carte(0, "Bilbon Sacquet", "Héros", "Connaissance", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Marque Des Dúnedain", "Attachement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Histoires au Coin du Feu", "Evénement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Gardien Ailé", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Les Aigles Arrivent", "Evénement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Dompteur de Chevaux de L’ouestfolde", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Rassemblement des Rohirrim", "Evénement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Ménestrel de Fondcombe", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Chemin de Grand-Pas", "Evénement", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Chant des Rois", "Attachement", "Neutre", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Frodon Sacquet", "Héros", "Energie", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Avertissement des Dúnedain", "Attachement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Un Second Petit Déjeuner", "Evénement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Apiculteur Beornide", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Né en Altitude", "Attachement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Éomund", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Je ne Suis pas un Étranger", "Attachement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Cartographe Longue-Barbe", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Un Tison Enflammé", "Attachement", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Chant de Sagesse", "Attachement", "Neutre", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Prince Imrahil", "Héros", "Commandement", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Quête des Dúnedain", "Attachement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Cadeaux d’Adieu", "Evénement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Landroval", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Vers l’Aire des Aigles", "Evénement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Escorte d’Edoras", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Ancien Mathom", "Attachement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Haldir de la Lórien", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Conflits Internes", "Evénement", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Radagast", "Allié", "Neutre", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Brand fils de Bain", "Héros", "Tactique", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Touque à la Vue Perçante", "Allié", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Arrière Garde", "Evénement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Descendant de Thorondor", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Le voL de Meneldor", "Evénement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Monture de Riddermark", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Courir à la Ruine", "Evénement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Gildor Inglorion", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Conseil de Gildor", "Evénement", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Chant du Voyage", "Attachement", "Neutre", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Boromir", "Héros", "Tactique", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Observateur Dúnedain", "Allié", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Cache des Dúnedain", "Attachement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Vassal du Seigneur des Vents", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Chant Moqueur", "Attachement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Elfhelm", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Nous ne Dormons Pas", "Evénement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Pisteur Sylvain", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Nœud Serré", "Attachement", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Chant de Bataille", "Attachement", "Neutre", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Dáin Pied d’Acier", "Héros", "Commandement", 1, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Signe des Dúnedain", "Attachement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Que l’Aube Vous Saisisse", "Evénement", "Commandement", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Aigles des Monts Brumeux", "Allié", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Soutien des Aigles", "Attachement", "Tactique", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Voyageuse de la Route de l’Ouest ", "Allié", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Rapidité Étonnante", "Evénement", "Energie", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Messager de la Forêt Noire", "Allié", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Rumeur de la Terre", "Evénement", "Connaissance", 3, new Conteneur(0, "Test", "c1")));
        temp_data.add(new Carte(0, "Une Ombre du Passé", "Evénement", "Neutre", 3, new Conteneur(0, "Test", "c1")));

        tablePanel.setData(temp_data);
        tablePanel.refresh();
        tablePanel.setAutoCreateRowSorter();
        tablePanel.setSorter();
        this.add(panelCarte, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.SOUTH);

    }

    public void searchByText(String text) {
        tablePanel.searchByText(text);
    }

    public void searchByType(String text) {
        tablePanel.searchByType(text);
    }

    public void searchBySphere(String text) {
        tablePanel.searchBySphere(text);
    }

    public void searchByConteneur(String text) {
        tablePanel.searchByConteneur(text);
    }

    public void setListener(AppListener appListener) {
        panelCarte.setSearchCarteListener(appListener);
    }

    public void delFilters() {
        tablePanel.delFilters();
    }
}
