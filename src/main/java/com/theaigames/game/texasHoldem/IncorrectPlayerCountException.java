/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theaigames.game.texasHoldem;

/**
 *
 * @author olivier
 */

/**
 *
 * @author Jackie Xu <jackie@starapple.nl>
 */
public class IncorrectPlayerCountException extends Exception {
    
    public IncorrectPlayerCountException(String message) {
        super(message);
    }
    
    public IncorrectPlayerCountException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
