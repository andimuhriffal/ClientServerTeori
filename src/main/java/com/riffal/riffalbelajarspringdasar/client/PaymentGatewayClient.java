/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riffal.riffalbelajarspringdasar.client;

import lombok.Data;

/**
 *
 * @author Acer
 */
@Data
public class PaymentGatewayClient {
    
    private String endpoint;
    
    private String publicKey;
    
    private String privateKey;
}
