/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar.configuration;

import com.riffal.riffalbelajarspringdasar.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author Acer
 */
@Configuration
public class CustomerConfiguration {
    
    @Primary
    @Bean
    public CustomerRepository normalCustomerRepository(){
        return new CustomerRepository();
    }
    
    @Bean
    public CustomerRepository premiumCustomerRepository(){
        return new CustomerRepository();
    }
}
