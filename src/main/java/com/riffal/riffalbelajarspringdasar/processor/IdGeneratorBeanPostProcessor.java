/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar.processor;

import com.riffal.riffalbelajarspringdasar.aware.IdAware;
import static java.lang.Math.log;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Acer
 */
@Slf4j
@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor{
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        log.info("Id Generator Processor for Bean {}", beanName);
        if(bean instanceof IdAware){
            log.info("Set Id Generator for Bean {}", beanName);
            IdAware idAware = (IdAware) bean;
            idAware.setId(UUID.randomUUID().toString());
    }
        return bean;
    }
    
}
