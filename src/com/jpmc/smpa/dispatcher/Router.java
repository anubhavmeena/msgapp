/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.dispatcher;

import com.jpmc.smpa.model.messages.Message;
import com.jpmc.smpa.model.handlers.Handler;

/**
 * Interface: Router
 * All dispatchers will implement this interface.
 * 
 * @author ANMEENA
 */
public interface Router<E extends Message> {

    /**
     * This function will register a Handler against a specific message type.
     * 
     * @param messageType
     * @param handler
     */
    public void registerHandler(Class<? extends E> messageType,
            Handler handler);

    /**
     *  This function will get the registered handler for the given message type and dispatch the message to it.
     * 
     * @param message
     */
    public abstract void dispatch(E message);
}
