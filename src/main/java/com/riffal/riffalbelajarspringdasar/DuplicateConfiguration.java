/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author Acer
 */
@Configuration
public class DuplicateConfiguration {
    
    @Bean
    public Foo foo1(){
        return new Foo();
    }
    
    @Bean
    public Foo foo2(){
        return new Foo();
    }
}
