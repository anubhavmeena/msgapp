/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Product
 * 
 * This class will contain all details about a Product
 * 
 * @author ANMEENA
 */
public class Product {

    private String prodType;
    private double totalValue;
    private int noOfSold;
    private List<Sale> listSales;
    private List<Adjustment> listOfAdjustment;
    
    public Product(String prodType){
        this.prodType = prodType;
        listSales = new ArrayList<>();
        listOfAdjustment = new ArrayList<>();
    }
    
    public void addSales(Sale sale){
        listSales.add(sale);
        noOfSold += sale.getQuantity();
        totalValue += sale.getPrice() * sale.getQuantity();
    }
    
    public void updateSales(Adjustment adjustment){
        getListOfAdjustment().add(adjustment);
        applyAdjustment(adjustment);
        reCalculateTotalValue();
    }
    
    private void applyAdjustment(Adjustment adj){
        for(Sale sale : listSales){
            adj.getOp().operate(sale, adj.getAdjustValue());
        }
    }
    
     private void reCalculateTotalValue(){
        double sum = 0;
        for(Sale sale : listSales){
            sum += sale.getPrice()*sale.getQuantity();
        }
        this.totalValue = sum;
    }
     
    public boolean equals(Object o){
        if(o instanceof Product){
            Product p = (Product) o;
            if(this.prodType.equals(p.prodType)){
                return true;
            }
        }
        return false;
    }
    /**
     * @return the prodType
     */
    public String getProdType() {
        return prodType;
    }

    /**
     * @param prodType the prodType to set
     */
    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    /**
     * @return the totalValue
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * @return the noOfSold
     */
    public int getNoOfSold() {
        return noOfSold;
    }

    /**
     * @param noOfSold the noOfSold to set
     */
    public void setNoOfSold(int noOfSold) {
        this.noOfSold = noOfSold;
    }

    /**
     * @return the listOfAdjustment
     */
    public List<Adjustment> getListOfAdjustment() {
        return listOfAdjustment;
    }

    /**
     * @param listOfAdjustment the listOfAdjustment to set
     */
    public void setListOfAdjustment(List<Adjustment> listOfAdjustment) {
        this.listOfAdjustment = listOfAdjustment;
    }


    
    
}
