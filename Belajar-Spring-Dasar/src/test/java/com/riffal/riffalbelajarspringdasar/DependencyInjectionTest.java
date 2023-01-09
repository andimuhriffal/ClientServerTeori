/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import com.riffal.riffalbelajarspringdasar.DependencyInjectionConfiguration;
import data.Bar;
import data.Foo;
import data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Acer
 */
public class DependencyInjectionTest {
    
    private ApplicationContext applicationContext;
    
    @BeforeEach
    void setup(){
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }
    
    @Test
    void testDI(){
        Foo foo = applicationContext.getBean("fooSecond", Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);
        
        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
    
    @Test
    void testNoDI(){
        
        var foo = new Foo();
        var bar = new Bar();
        
        var fooBar = new FooBar(foo, bar);
        
        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
