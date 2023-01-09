/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.riffal.riffalbelajarspringdasar.aware.IdAware;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Acer
 */
@Component
public class Car implements IdAware{
    
    @Getter
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
