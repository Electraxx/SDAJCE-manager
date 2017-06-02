/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.listeners;

import ch.ceff.ict3.sdajcemanager.event.*;
import java.util.EventListener;

/**
 *
 * @author cp-14luf
 */
public interface AppListener extends EventListener{
    
    public void quitter();
    public void importer();
    
    public void pageAjoutCarte();
    public void pageAjoutDeck();
    public void pageAjoutPartie();
    
    public void changePage(String page);
    
    public void addCarte(AddCarteEvent event);
    public void delCarte(DelCarteEvent event);
    public void editCarte(EditCarteEvent event);

    
    public void addConteneur(AddConteneurEvent event);
    public void editConteneur(DelConteneurEvent event);
    
    public void addDeck(AddDeckEvent event);
    public void delDeck(DelDeckEvent event);
    
    public void addPartie(AddPartieEvent event);
    public void delPartie(DelPartieEvent event);
    
    public void searchDeck(SearchDeckEvent event);
    public void searchCarte(SearchCarteEvent event);
    public void searchCarteByType(SearchCarteByTypeEvent event);
    public void searchCarteBySphere(SearchCarteBySphereEvent event);
    public void searchCarteByConteneur(SearchCarteByConteneurEvent event);
    public void delFilters();
    public void changeDeckCarte(int index);
    
    
    
    
    
}
