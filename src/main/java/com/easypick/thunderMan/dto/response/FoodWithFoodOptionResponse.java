package com.easypick.thunderMan.dto.response;

import com.easypick.thunderMan.dto.DlFoodWithFoodOptionsDto;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record FoodWithFoodOptionResponse(
        Long id,
        String foodName,
        int foodPrice,
        String foodDec,
        String foodImg,
        String foodThumb,
        String deleteYn,
        Set<FoodOptionResponse> dlFoodOption
) {
    public static FoodWithFoodOptionResponse of(  Long id,
                                                  String foodName,
                                                  int foodPrice,
                                                  String foodDec,
                                                  String foodImg,
                                                  String foodThumb,
                                                  String deleteYn,
                                                  Set<FoodOptionResponse> foodOptionResponses) {

        return new FoodWithFoodOptionResponse(id,
                foodName,
                foodPrice,
                foodDec,
                foodImg,
                foodThumb,
                deleteYn,
                foodOptionResponses);
    }

    public static FoodWithFoodOptionResponse from(DlFoodWithFoodOptionsDto dto){

        return new FoodWithFoodOptionResponse(
                dto.id(),
                dto.foodName(),
                dto.foodPrice(),
                dto.foodDec(),
                dto.foodImg(),
                dto.foodThumb(),
                dto.deleteYn(),
                dto.dlFoodOptions().stream()
                        .map(FoodOptionResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }
}
