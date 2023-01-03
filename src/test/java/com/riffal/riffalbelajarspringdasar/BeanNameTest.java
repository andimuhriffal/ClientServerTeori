/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import com.riffal.riffalbelajarspringdasar.BeanNameConfiguration;
import data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Acer
 */
public class BeanNameTest {
    
    private ApplicationContext applicationContext;
    
    @BeforeEach
    void setup(){
        applicationContext= new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }
    
    @Test
    void testBeanName(){
        Foo foo = applicationContext.getBean(Foo.class);
        Foo fooFirst = applicationContext.getBean("fooFirst",Foo.class);
        Foo fooSecond = applicationContext.getBean("fooSecond",Foo.class);
        
        Assertions.assertSame(foo, fooFirst);
        Assertions.assertNotSame(foo, fooSecond);
    }
}
