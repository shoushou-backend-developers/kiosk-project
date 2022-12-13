package com.shoushoubackenddeveloper.kiosk_project.dto;

import com.shoushoubackenddeveloper.kiosk_project.domain.Order;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.shoushoubackenddeveloper.kiosk_project.domain.Order} entity
 */
public record OrderDto(
        Long id,
        Integer orderNo,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) implements Serializable {

    public static OrderDto of(Integer orderNo){
        return new OrderDto(null, orderNo, null, null);
    }

    public static OrderDto of(Long id, Integer orderNo, LocalDateTime createdAt, LocalDateTime modifiedAt){
        return new OrderDto(id, orderNo,createdAt, modifiedAt);
    }

    public static OrderDto from(Order entity){
        return new OrderDto(
                entity.getId(),
                entity.getOrderNo(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }

    public Order toEntity(){
        return Order.of(
                id,
                orderNo
        );
    }
}