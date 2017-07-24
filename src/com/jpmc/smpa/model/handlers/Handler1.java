/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.handlers;

import com.jpmc.smpa.model.messages.Message;
import com.jpmc.smpa.model.messages.MsgType1;
import com.jpmc.smpa.model.sale.Product;
import com.jpmc.smpa.model.sale.Sale;

/**
 *  Class: Handler1
 * 
 *  This class will handle messages of type1.
 * 
 * @author ANMEENA
 */
public class Handler1 implements Handler {

    @Override
    public void dispatch(Message message) {
        MsgType1 msg = (MsgType1) message;
        Sale sale = msg.getSale();
        Product product = sale.getProduct();
        product.addSales(sale);
    }
}
