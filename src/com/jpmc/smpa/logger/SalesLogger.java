/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.logger;

import com.jpmc.smpa.processor.SalesProcessor;
import java.util.Map.Entry;
import com.jpmc.smpa.model.sale.Product;
import com.jpmc.smpa.model.sale.Adjustment;

/**
 * Class: SalesLogger
 *
 * This class will generate and print sales report after every 10 sales
 * notifications and will pause the processing after the 50th sales notification
 *
 * @author ANMEENA
 */
public class SalesLogger {

    /**
     * Generate and print sales report after every 10th sales notification.
     */
    public static void generateReport() {
        System.out.println();
        System.out.println("----------------------Sales Report----------------------------");
        for (Entry e : SalesProcessor.getProductMap().entrySet()) {
            Product prod = (Product) e.getValue();
            String out = String.format("Product Type: %s \nNumber of sales: %d\nTotal Sold Value: %.2f",
                    prod.getProdType(), prod.getNoOfSold(), prod.getTotalValue());
            System.out.println(out);
            System.out.println("---------------------------------------------------------------");
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    /**
     * Generate and print report of adjustments made for each product.
     */
    public static void logAdjustments() {
        System.out.println();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Application has reached 50 message limit and is pausing now..");
        System.out.println("--------------------------------Adjustments Report----------------------------------");
        for (Entry e : SalesProcessor.getProductMap().entrySet()) {
            Product prod = (Product) e.getValue();
            System.out.println("Product Type:" + prod.getProdType());
            if(prod.getListOfAdjustment().size()>0){
                for (Adjustment adj : prod.getListOfAdjustment()) {
                    System.out.println("---------------------------------------");
                    System.out.println("Operation Type:" + adj.getOp().toString());
                    System.out.println("Adjusted Value:" + adj.getAdjustValue());
                    System.out.println("---------------------------------------");
                }
            }
            else{
                System.out.println("No adjustments made");
            }
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }
}
