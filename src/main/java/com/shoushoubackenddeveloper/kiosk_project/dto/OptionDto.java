package com.shoushoubackenddeveloper.kiosk_project.dto;

import com.shoushoubackenddeveloper.kiosk_project.domain.Option;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.shoushoubackenddeveloper.kiosk_project.domain.Option} entity
 */
public record OptionDto(
        Long id,
        String korName,
        String engName,
        Integer price,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) implements Serializable {

    public static OptionDto of(Long id, String korName,String engName, Integer price, LocalDateTime createdAt, LocalDateTime modifiedAt){
        return new OptionDto(id, korName, engName, price, createdAt, modifiedAt);
    }

    public static OptionDto from(Option entity){
        return new OptionDto(
                entity.getId(),
                entity.getKorName(),
                entity.getEngName(),
                entity.getPrice(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }
}