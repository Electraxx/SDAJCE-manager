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
public class SearchCarteEvent extends EventObject {
    
    private String search;

    public SearchCarteEvent(Object source,String search) {
        super(source);
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    
    
            
            
            

}
