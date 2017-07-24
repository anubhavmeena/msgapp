/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.model.sale;

/**
 * Class: Sale
 * 
 * This class will have details about a sale
 * 
 * @author ANMEENA
 */
public class Sale {
    
    private Product product;
    private int quantity;
    private double price;
    
    public Sale(Product product, int quantity, double price){
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * @return the prodType
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param prodType the prodType to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
