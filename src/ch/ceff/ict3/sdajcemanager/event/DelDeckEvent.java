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
public class DelDeckEvent extends EventObject {

    private int id;

    public DelDeckEvent(int id, Object source) {
        super(source);
        this.id = id;
    }

    public DelDeckEvent(Object source) {
        super(source);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
