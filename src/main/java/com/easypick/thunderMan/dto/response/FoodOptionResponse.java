package com.easypick.thunderMan.dto.response;

import com.easypick.thunderMan.dto.DlFoodOptionDto;

public record FoodOptionResponse(
        Long id,
        String optionName,
        int optionPrice,
        String deleteYn
) {
    public static FoodOptionResponse of( Long id, String optionName, int optionPrice, String deleteYn) {
        return new FoodOptionResponse(id, optionName, optionPrice, deleteYn);
    }

    public static FoodOptionResponse from(DlFoodOptionDto dto){

        return new FoodOptionResponse(
                dto.id(),
                dto.optionName(),
                dto.optionPrice(),
                dto.deleteYn()
        );
    }

}
