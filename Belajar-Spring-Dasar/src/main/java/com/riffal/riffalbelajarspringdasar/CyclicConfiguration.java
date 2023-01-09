/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import com.riffal.riffalbelajarspringdasar.cyclic.CyclicA;
import com.riffal.riffalbelajarspringdasar.cyclic.CyclicB;
import com.riffal.riffalbelajarspringdasar.cyclic.CyclicC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Acer
 */
@Configuration
public class CyclicConfiguration {
    
    @Bean
    public CyclicA cyclicA(CyclicB cyclicB){
        return new CyclicA(cyclicB);
    }
    
    @Bean
    public CyclicB cyclicB(CyclicC cyclicC){
        return new CyclicB(cyclicC);
    }
    
    @Bean
    public CyclicC cyclicC(CyclicA cyclicA){
        return new CyclicC(cyclicA);
    }
}
