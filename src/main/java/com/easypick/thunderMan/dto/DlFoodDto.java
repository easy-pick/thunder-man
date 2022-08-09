package com.easypick.thunderMan.dto;

import com.easypick.thunderMan.domain.DlFood;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record DlFoodDto(
        Long id,
        Long storeId,
        String foodName,
        int foodPrice,
        String foodDec,
        String foodImg,
        String foodThumb,
        String deleteYn,
        Set<DlFoodOptionDto> dlFoodOption
        ){

        public DlFoodDto(Long id,
                         Long storeId,
                         String foodName,
                         int foodPrice,
                         String foodDec,
                         String foodImg,
                         String foodThumb,
                         String deleteYn,
                         Set<DlFoodOptionDto> dlFoodOption) {
                this.id = id;
                this.storeId = storeId;
                this.foodName = foodName;
                this.foodPrice = foodPrice;
                this.foodDec = foodDec;
                this.foodImg = foodImg;
                this.foodThumb = foodThumb;
                this.deleteYn = deleteYn;
                this.dlFoodOption = dlFoodOption;
        }

        public static DlFoodDto of(long id, long storeId, String foodName, int foodPrice, String foodDec, String foodImg, String foodThumb, String deleteYn, Set<DlFoodOptionDto> dlFoodOption){
                return new DlFoodDto(id, storeId, foodName, foodPrice, foodDec, foodImg, foodThumb, deleteYn, dlFoodOption);
        }

        public static DlFoodDto from(DlFood entity) {

                return new DlFoodDto(
                        entity.getId(),
                        entity.getDlStore().getId(),
                        entity.getFoodName(),
                        entity.getFoodPrice(),
                        entity.getFoodDec(),
                        entity.getFoodImg(),
                        entity.getFoodThumb(),
                        entity.getDeleteYn() ,
                        entity.getDlFoodOption().stream().map(DlFoodOptionDto::from)
                                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }

}
