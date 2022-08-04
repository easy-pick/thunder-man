package com.easypick.thunderMan.dto;

import com.easypick.thunderMan.domain.DlFood;
import com.easypick.thunderMan.domain.DlFoodOption;

import java.time.LocalDateTime;

public record DlFoodOptionDto(
        Long id,
        Long dlFoodId,
        String optionName,
        int optionPrice,
        String deleteYn,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
){
    public static DlFoodOptionDto of(Long dlFoodId, String optionName, int optionPrice, String deleteYn){
        return new DlFoodOptionDto(
                null,
                dlFoodId,
                optionName,
                optionPrice,
                deleteYn,
                null,
                null,
                null,
                null);
    }

    public static DlFoodOptionDto of(Long id, Long dlFoodId, String optionName, int optionPrice, String deleteYn, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy){
        return new DlFoodOptionDto(
                id,
                dlFoodId,
                optionName,
                optionPrice,
                deleteYn,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static DlFoodOptionDto from(DlFoodOption entity) {
        return new DlFoodOptionDto(
                entity.getId(),
                entity.getDlFood().getId(),
                entity.getOptionName(),
                entity.getOptionPrice(),
                entity.getDeleteYn(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public DlFoodOption toEntity(DlFood dlFood){
        return DlFoodOption.of(
                dlFood,
                optionName,
                optionPrice,
                deleteYn
        );
    }
}
