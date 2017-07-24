/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.handlers;

import com.jpmc.smpa.model.messages.Message;

/**
 *  Interface: Handler
 *  
 *  All handlers of different message type needs to implement this interface 
 *  containing their own implementations of dispatch method
 * 
 * @author ANMEENA
 */
public interface Handler<E extends Message> {
    public void dispatch(E message);
}
