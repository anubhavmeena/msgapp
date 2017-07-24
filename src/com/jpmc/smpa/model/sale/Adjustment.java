/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.sale;

import com.jpmc.smpa.model.operations.Operation;

/**
 * Class: Adjustment
 * 
 *  This class will contain the adjustment value and the operation to be performed
 * 
 * @author ANMEENA
 */
public class Adjustment {
    
    private Operation op;
    private double adjustValue;

    public Adjustment(Operation op, double adjustValue) {
        this.op = op;
        this.adjustValue = adjustValue;
    }
    
    /**
     * @return the op
     */
    public Operation getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(Operation op) {
        this.op = op;
    }

    /**
     * @return the adjustValue
     */
    public double getAdjustValue() {
        return adjustValue;
    }

    /**
     * @param adjustValue the adjustValue to set
     */
    public void setAdjustValue(double adjustValue) {
        this.adjustValue = adjustValue;
    }
}
