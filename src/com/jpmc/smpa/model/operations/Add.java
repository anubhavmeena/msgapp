/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.operations;

import com.jpmc.smpa.model.sale.Sale;

/**
 *  Class: Add
 * 
 *  This class implements the add operation
 * 
 * @author ANMEENA
 */
public class Add implements Operation{

    @Override
    public void operate(Sale sale, double value) {
        sale.setPrice(sale.getPrice() + value);
    }
    @Override
    public String toString(){
        return "Add";
    }
}
