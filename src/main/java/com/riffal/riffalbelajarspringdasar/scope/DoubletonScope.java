/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar.scope;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 * @author Acer
 */
public class DoubletonScope implements Scope{
    
    private List<Object> objects = new ArrayList<>(2);
    
    private Long counter = -1L;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        counter ++;
        
        if(objects.size()==2){
            int index = (int)(counter % 2);
            return objects.get(index);
        } else {
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
        
    }

    @Override
    public Object remove(String name) {
        if(!objects.isEmpty()){
            return objects.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
    
}
