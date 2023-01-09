/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import data.Bar;
import data.Foo;
import data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author Acer
 */
@Configuration
public class DependencyInjectionConfiguration {
    
    @Primary
    @Bean
    public Foo fooFirst(){
        return new Foo();
    }
    
    @Bean
    public Foo fooSecond(){
        return new Foo();
    }
    
    @Bean
    public Bar bar(){
        return new Bar();
    }
    
    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}
