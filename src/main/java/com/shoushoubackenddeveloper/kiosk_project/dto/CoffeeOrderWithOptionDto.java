package com.shoushoubackenddeveloper.kiosk_project.dto;

import com.shoushoubackenddeveloper.kiosk_project.domain.CoffeeOrder;
import com.shoushoubackenddeveloper.kiosk_project.domain.CoffeeOrderOption;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record CoffeeOrderWithOptionDto(
        Long id,
        Set<OptionDto> optionDtos,
        Integer quantity
) {
    public static CoffeeOrderWithOptionDto of(Long id, Set<OptionDto> optionDtos, Integer quantity){
        return new CoffeeOrderWithOptionDto(id, optionDtos, quantity);
    }

    public static CoffeeOrderWithOptionDto from(CoffeeOrderOption entity){
        return new CoffeeOrderWithOptionDto(
                entity.getId(),
                entity.getOption().stream()
                        .map(OptionDto::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)),
                entity.getQuantity()

        );
    }
}
