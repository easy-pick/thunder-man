package com.easypick.thunderMan.dto;

import com.easypick.thunderMan.domain.DlFood;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record DlFoodWithFoodOptionsDto(
        Long id,
        DlStoreDto dlStoreDto,
        String foodName,
        int foodPrice,
        String foodDec,
        String foodImg,
        String foodThumb,
        String deleteYn,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        Set<DlFoodOptionDto> dlFoodOptions
) {

    public static DlFoodWithFoodOptionsDto of(   Long id,
                                                 DlStoreDto dlStoreDto,
                                                 String foodName,
                                                 int foodPrice,
                                                 String foodDec,
                                                 String foodImg,
                                                 String foodThumb,
                                                 String deleteYn,
                                                 LocalDateTime createdAt,
                                                 String createdBy,
                                                 LocalDateTime modifiedAt,
                                                 String modifiedBy,
                                                 Set<DlFoodOptionDto> dlFoodOptions) {

        return new DlFoodWithFoodOptionsDto(id,
                dlStoreDto,
                foodName,
                foodPrice,
                foodDec,
                foodImg,
                foodThumb,
                deleteYn,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy,
                dlFoodOptions);
    }

    public static DlFoodWithFoodOptionsDto from(DlFood entity){

        return new DlFoodWithFoodOptionsDto(
                entity.getId(),
                DlStoreDto.from(entity.getDlStore()),
                entity.getFoodName(),
                entity.getFoodPrice(),
                entity.getFoodDec(),
                entity.getFoodImg(),
                entity.getFoodThumb(),
                entity.getDeleteYn(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy(),
                entity.getDlFoodOption().stream().map(DlFoodOptionDto::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
    }
}
