/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.util;

import com.jpmc.smpa.model.sale.Sale;
import com.jpmc.smpa.model.sale.Product;
import com.jpmc.smpa.model.messages.Message;
import com.jpmc.smpa.model.operations.Operation;
import com.jpmc.smpa.model.operations.Add;
import com.jpmc.smpa.model.sale.Adjustment;
import com.jpmc.smpa.model.messages.MsgType1;
import com.jpmc.smpa.model.messages.MsgType2;
import com.jpmc.smpa.model.messages.MsgType3;
import com.jpmc.smpa.model.operations.Multiply;
import com.jpmc.smpa.model.operations.Subtract;
import com.jpmc.smpa.processor.SalesProcessor;

/**
 * Class: MessageParser
 * 
 * This class is used to parse sales notifications into proper message objects depending on its pattern
 * 
 * @author ANMEENA
 */
public class MessageParser {
    
    private static String prodType;
    private static double prodPrice;
    private static int prodQuantity;
    private static String operatorType;
    
    static String pattern1 = ".* at .*(p|$)";
    static String pattern2 = "[\\d]* sale[s]? of [a-zA-Z]* at [\\d]*p each[.]?";
    static String pattern3 = "(Add|add|Subtract|subtract|Multiply|multiply) [\\d]*(p|$) [a-zA-Z]*";
    
    public MessageParser(String message){
        parseMessage(message);
    }
    
    /**
     * Matches incoming notification to a pattern
     * 
     * @param msgStr
     * @return Message
     */
    public static Message parseMessage(String msgStr){
        Message msg = null;
        if (msgStr != null && !msgStr.isEmpty()) {
            if(msgStr.matches(pattern2)){
                msg = parseMessage2(msgStr);
            }
            else if(msgStr.matches(pattern1)){
               msg = parseMessage1(msgStr);
            }
            else if(msgStr.matches(pattern3)){
               msg = parseMessage3(msgStr);
            }
        }
        return msg;
    }
    
    /**
     * Parses messages of type 1
     * 
     * @param message
     * @return Message
     */
    private static Message parseMessage1(String message){
        //System.out.println("Type1");
        String[] messageArray = message.trim().split("\\s+");
        if(messageArray.length == 3){
            prodType = parseType(messageArray[0]);
            prodPrice = parsePrice(messageArray[2]);
            prodQuantity = 1;
            Product prod = getProduct(prodType);
            Sale sale  = new Sale(prod,prodQuantity,prodPrice);
            Message msg = new MsgType1(sale);
            return msg;
        }
        return null;
    }
    
    /**
     * Parses messages of type 2
     * 
     * @param message
     * @return Message
     */
    
    private static Message parseMessage2(String message){
        //System.out.println("Type2");
        String[] messageArray = message.trim().split("\\s+");
        if(messageArray.length == 7) {
            prodType = parseType(messageArray[3]);
            prodPrice = parsePrice(messageArray[5]);
            prodQuantity = Integer.parseInt(messageArray[0]);
            Product prod = getProduct(prodType);
            Sale sale  = new Sale(prod,prodQuantity,prodPrice);
            Message msg = new MsgType2(sale,prodQuantity);
            return msg;
        }
        return null;
    }
    
    /**
     * Parses messages of type 3
     * 
     * @param message
     * @return Message
     */
    
    private static Message parseMessage3(String message){
       //System.out.println("Type3");
       String[] messageArray = message.trim().split("\\s+");
       if(messageArray.length == 3){
            operatorType = messageArray[0];
            Operation op = null;
            if(operatorType.toLowerCase().equals("add")){
                op = new Add();
            }
            else if(operatorType.toLowerCase().equals("subtract")){
                op = new Subtract();
            }
            else if(operatorType.toLowerCase().equals("multiply")){
                op = new Multiply();
            }
            prodType = parseType(messageArray[2]);
            prodQuantity = 0;
            prodPrice = parsePrice(messageArray[1]);
            Product prod = getProduct(prodType);
            Sale sale  = new Sale(prod,prodQuantity,prodPrice);
            Adjustment adj = new Adjustment(op,prodPrice);
            Message msg = new MsgType3(sale,adj);
            return msg;
       }
        return null;
    }
    
    /**
     * This method takes care of plural types like mangoes, apples such that they are same as mango or apple.
     * 
     * @param String
     * @return String
     */
    private static String parseType(String s){
        String parsedType = "";
        String typeWithoutLastChar = s.substring(0, s.length() - 1);
        if (s.endsWith("o")) {
            parsedType = String.format("%soes", typeWithoutLastChar);
        } else if (s.endsWith("h")) {
            parsedType = String.format("%shes", typeWithoutLastChar);
        } else if (s.endsWith("y")) {
            parsedType = String.format("%sies", typeWithoutLastChar);
        } else if (!s.endsWith("s")) {
            parsedType = String.format("%ss", s);
        } else {
            parsedType = String.format("%s", s);
        }
        return parsedType.toLowerCase();
    }
    
     /**
     * This method parses the price removing the currency.
     * 
     * @param String
     * @return Double
     */
    private static double parsePrice(String s){
        double price = Double.parseDouble(s.replaceAll("$|p", ""));
        if (!s.contains(".")) {
            price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
    }
    
     /**
     * This method return a Product object if already exists or creates a new one if not.
     * 
     * @param String
     * @return Product
     */
    private static Product getProduct(String prodType){
        Product prod = null;
        if(SalesProcessor.getProductMap().containsKey(prodType)){
            prod = SalesProcessor.getProductMap().get(prodType);
        }
        else{
            prod = new Product(prodType);
            SalesProcessor.getProductMap().put(prodType, prod);
        }
        return prod;
    }
    
    public static void main(String[] args) {
        MessageParser p1 = new MessageParser("apples at 100p");
        MessageParser p2 = new MessageParser("15 sale of apple at 10p each.");
        MessageParser p3 = new MessageParser("add 20p apples");

        System.out.println(p3.prodType);
        System.out.println(p3.prodPrice);
        System.out.println(p3.operatorType);
        
        
    }
    
    
}
