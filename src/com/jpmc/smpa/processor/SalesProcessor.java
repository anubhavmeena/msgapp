/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import com.jpmc.smpa.model.messages.Message;
import com.jpmc.smpa.util.MessageParser;
import com.jpmc.smpa.model.sale.Product;
import com.jpmc.smpa.model.messages.MsgType1;
import com.jpmc.smpa.logger.SalesLogger;
import com.jpmc.smpa.model.handlers.Handler1;
import com.jpmc.smpa.model.handlers.Handler2;
import com.jpmc.smpa.model.handlers.Handler3;
import com.jpmc.smpa.model.messages.MsgType2;
import com.jpmc.smpa.model.messages.MsgType3;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jpmc.smpa.dispatcher.MessageDispatcher;

/**
 * Class: SalesProcessor
 * 
 * This is our main class which reads the processes all messages
 * 
 * @author ANMEENA
 */
public class SalesProcessor {
    
    // A map of all unique products types processed so far
    private static Map<String,Product> productMap = new HashMap<>();
    
    public void start() {
        try {
            // Create a dispatcher
            MessageDispatcher dispatcher = new MessageDispatcher();
            
            //Register message types to their handlers
            dispatcher.registerHandler(MsgType1.class, new Handler1());
            dispatcher.registerHandler(MsgType2.class, new Handler2());
            dispatcher.registerHandler(MsgType3.class, new Handler3());
            
            //Read sales notifications
            String line;
            int count = 0;
            BufferedReader inputFile = new BufferedReader(new FileReader("test/input.txt"));
            while((line = inputFile.readLine()) != null) {
                //Parse the line read into a proper type message object
                Message msg = MessageParser.parseMessage(line);
                if(msg!=null){
                    //Call the respective dispatch method to process this message.
                    dispatcher.dispatch(msg);
                    count++;
                    Thread.sleep(100);
                }
                //When sales notification processed count is 10 print a report
                if(count !=0 && count%10 == 0){
                    SalesLogger.generateReport();
                }
                //When sales notification processed count reaches 50 print a adjustments made
                if(count == 50){
                    SalesLogger.logAdjustments();
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @return the productMap
     */
    public static Map<String,Product> getProductMap() {
        return productMap;
    }

}
