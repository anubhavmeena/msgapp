/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.operations;

import com.jpmc.smpa.model.sale.Sale;

/**
 * Interface: Operation
 * 
 * This interface is used to implement the adjustment operation of add/subtract/multiply on sales objects
 * 
 * @author ANMEENA
 */
public interface Operation {
    abstract void operate(Sale sale, double value);
}
