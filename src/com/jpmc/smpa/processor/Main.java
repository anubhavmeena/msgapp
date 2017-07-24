/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.processor;

/**
 * Class: Main
 * 
 * This class starts the execution
 * 
 * @author ANMEENA
 */
public class Main {
    public static void main(String[] args) {
        SalesProcessor processor = new SalesProcessor();
        processor.start();
    }
}
