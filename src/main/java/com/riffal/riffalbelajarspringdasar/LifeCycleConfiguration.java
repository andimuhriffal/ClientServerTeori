/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import data.Connection;
import data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Acer
 */
@Configuration
public class LifeCycleConfiguration {
    
    @Bean
    public Connection connection(){
        return new Connection();
    }
    
    @Bean (initMethod = "start", destroyMethod = "stop")
    public Server server(){
        return new Server();
    }
    
}
