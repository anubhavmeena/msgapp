/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.messages;

import com.jpmc.smpa.model.sale.Sale;
import com.jpmc.smpa.model.sale.Adjustment;

/**
 *  Class: MsgType3
 * 
 * This class implements messages of type3
 * 
 * @author ANMEENA
 */
public class MsgType3 extends Message{

    private Adjustment adjustment;

    public MsgType3(Sale sale, Adjustment adjustment) {
        super(sale);
        this.adjustment = adjustment;
    }

   @Override
    public Class<? extends Message> getType() {
        return this.getClass();
    }
    
    /**
     * @return the adjustment
     */
    public Adjustment getAdjustment() {
        return adjustment;
    }

    /**
     * @param adjustment the adjustment to set
     */
    public void setAdjustment(Adjustment adjustment) {
        this.adjustment = adjustment;
    }
   
}
