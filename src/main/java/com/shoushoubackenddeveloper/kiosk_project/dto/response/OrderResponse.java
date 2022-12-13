package com.shoushoubackenddeveloper.kiosk_project.dto.response;

import com.shoushoubackenddeveloper.kiosk_project.dto.OrderDto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.shoushoubackenddeveloper.kiosk_project.domain.Order} entity
 */
public record OrderResponse(
        Long id,
        Integer orderNo
) implements Serializable {

    public static OrderResponse of(Long id, Integer orderNo){
        return new OrderResponse(id, orderNo);
    }

    public static OrderResponse from(OrderDto dto){
        return new OrderResponse(
                dto.id(),
                dto.orderNo()
        );
    }
}