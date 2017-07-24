/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.messages;

import com.jpmc.smpa.model.sale.Sale;

/**
 * Abstract Class: Message
 * 
 * This class has the basic implementation of a message
 * 
 * @author ANMEENA
 */
public abstract class Message{

    private Sale sale;

    public Message(Sale sale) {
        this.sale = sale;
    }
    
    public abstract Class<? extends Message> getType();    
     
    /**
     * @return the sale
     */
    public Sale getSale() {
        return sale;
    }
}
