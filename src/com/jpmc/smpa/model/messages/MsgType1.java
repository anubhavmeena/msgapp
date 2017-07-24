/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.messages;

import com.jpmc.smpa.model.sale.Sale;

/**
 * Class: MsgType1
 * 
 * This class implements messages of type1
 *
 * @author ANMEENA
 */
public class MsgType1 extends Message{

    public MsgType1(Sale sale) {
        super(sale);
    }
    
    @Override
    public Class<? extends Message> getType() {
        return this.getClass();
    }

}
