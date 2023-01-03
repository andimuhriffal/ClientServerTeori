/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar;

import data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Acer
 */
@Configuration
@ComponentScan(basePackages = {
    "com.fariz.farizbelajarspringdasar.repository",
    "com.fariz.farizbelajarspringdasar.service",
    "com.fariz.farizbelajarspringdasar.configuration",
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
    
}
