/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmc.smpa.dispatcher;

import java.util.HashMap;
import java.util.Map;
import com.jpmc.smpa.model.messages.Message;
import com.jpmc.smpa.model.handlers.Handler;

/**
 * Class: MessageDispatcher
 * This class dispatches a message type to it's particular handler.
 * 
 * @author ANMEENA
 */
public class MessageDispatcher implements Router<Message> {

    private Map<Class<? extends Message>, Handler> handlers;

    /**
     *  Default constructor
     */
    public MessageDispatcher() {
        handlers = new HashMap<Class<? extends Message>, Handler>();
    }

    /**
     * This function will register a Handler against a specific message type.
     * 
     * @param messageType
     * @param handler
     */
    @Override
    public void registerHandler(Class<? extends Message> messageType, Handler handler) {
        handlers.put(messageType, handler);
    }

    /**
     * This function will get the registered handler for the given message type and dispatch the message to it.
     * @param message
     */
    @Override
    public void dispatch(Message message) {
        handlers.get(message.getClass()).dispatch(message);
    }
}
