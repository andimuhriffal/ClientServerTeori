/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import com.riffal.riffalbelajarspringdasar.ScopeConfiguration;
import data.Bar;
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
public class ScopeTest {
    
    private ApplicationContext applicationContext;
    
    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }
    
    @Test
    void testPrototypeScope(){
        
        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);
        
        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo1, foo3);
        Assertions.assertNotSame(foo2, foo3);
    }
    
    @Test
    void testDoubletonScope(){
        
        Bar bar1= applicationContext.getBean(Bar.class);
        Bar bar2= applicationContext.getBean(Bar.class);
        Bar bar3= applicationContext.getBean(Bar.class);
        Bar bar4= applicationContext.getBean(Bar.class);
        
         Assertions.assertSame(bar1, bar3);
         Assertions.assertSame(bar2, bar4);
         
         Assertions.assertNotSame(bar1, bar2);
         Assertions.assertNotSame(bar3, bar4);
    }
}
