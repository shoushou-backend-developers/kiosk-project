package com.shoushoubackenddeveloper.kiosk_project.dto;

import com.shoushoubackenddeveloper.kiosk_project.domain.CoffeeOrder;

import java.io.Serializable;

/**
 * A DTO for the {@link com.shoushoubackenddeveloper.kiosk_project.domain.CoffeeOrder} entity
 */
public record CoffeeOrderDto(
        Long id,
        Long orderId,
        Long coffeeId,
        String coffeeKorName,
        String coffeeEngName,
        Integer coffeePrice,
        Integer quantity
) implements Serializable {

    public static CoffeeOrderDto of(Long id, Long orderId,Long coffeeId, String coffeeKorName, String coffeeEngName, Integer coffeePrice, Integer quantity){
        return new CoffeeOrderDto(id, orderId, coffeeId, coffeeKorName, coffeeEngName, coffeePrice, quantity);
    }
    public static CoffeeOrderDto from(CoffeeOrder entity){
        return new CoffeeOrderDto(
                entity.getId(),
                entity.getOrder().getId(),
                entity.getCoffee().getId(),
                entity.getCoffee().getKorName(),
                entity.getCoffee().getEngName(),
                entity.getCoffee().getPrice(),
                entity.getQuantity()
        );
    }
}