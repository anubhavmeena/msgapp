/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.messages;

import com.jpmc.smpa.model.sale.Sale;

/**
 *  Class: MsgType2
 * 
 * This class implements messages of type2
 * 
 * @author ANMEENA
 */
public class MsgType2 extends Message{

    int noOfOccur;

    public MsgType2(Sale sale, int noOfOccur) {
        super(sale);
        this.noOfOccur = noOfOccur;
    }

    @Override
    public Class<? extends Message> getType() {
        return this.getClass();
    }
    
}
