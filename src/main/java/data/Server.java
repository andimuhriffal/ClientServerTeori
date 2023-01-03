/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Acer
 */
@Slf4j
public class Server {
    
    @PostConstruct
    public void start(){
        log.info("Start Server");
    }
    
    @PreDestroy
    public void stop(){
        log.info("Stop Server");
    }
}
