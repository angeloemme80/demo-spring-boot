/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.angelomassaro.cdi;

import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author admwks
 */

public class SessionData {
    
    private int contatore;

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }
    
}
