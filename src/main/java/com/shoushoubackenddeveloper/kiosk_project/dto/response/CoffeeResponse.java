package com.shoushoubackenddeveloper.kiosk_project.dto.response;

import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;
import com.shoushoubackenddeveloper.kiosk_project.dto.CoffeeDto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Coffee} entity
 */
public record CoffeeResponse(
        Long id,
        String korName,
        String engName,
        Integer price,
        String orderStatus


) implements Serializable {


    public static CoffeeResponse of(Long id, String korName, String engName, Integer price,String orderStatus ){
        return new CoffeeResponse(id, korName, engName, price, orderStatus);
    }


    public static CoffeeResponse from(CoffeeDto dto){
        return new CoffeeResponse(
                dto.id(),
                dto.korName(),
                dto.engName(),
                dto.price(),
                dto.orderStatus()
        );
    }
}