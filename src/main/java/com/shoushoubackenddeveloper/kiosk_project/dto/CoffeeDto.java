package com.shoushoubackenddeveloper.kiosk_project.dto;

import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.shoushoubackenddeveloper.kiosk_project.domain.Coffee} entity
 */
public record CoffeeDto(
        Long id,
        String coffeeCode,
        String korName,
        String engName,
        Integer price,
        String orderStatus,
        Boolean sizeSelectable,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) implements Serializable {


    public static CoffeeDto of(String coffeeCode, String korName, String engName, Integer price, String orderStatus, Boolean sizeSelectable ){
        return new CoffeeDto(null,coffeeCode, korName, engName, price, orderStatus, sizeSelectable, null,null);
    }

    public static CoffeeDto of(Long id, String coffeeCode, String korName, String engName, Integer price, String orderStatus, Boolean sizeSelectable ,LocalDateTime createdAt, LocalDateTime modifiedAt){
        return new CoffeeDto(id, coffeeCode, korName, engName, price, orderStatus, sizeSelectable, createdAt, modifiedAt);
    }

    public static CoffeeDto from(Coffee entity){
        return new CoffeeDto(
                entity.getId(),
                entity.getCoffeeCode(),
                entity.getKorName(),
                entity.getEngName(),
                entity.getPrice(),
                entity.getOrderStatus(),
                entity.getSizeSelectable(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }

    public Coffee toEntity(){
        return Coffee.of(
                id,
                coffeeCode,
                korName,
                engName,
                price,
                orderStatus,
                sizeSelectable
        );
    }
}