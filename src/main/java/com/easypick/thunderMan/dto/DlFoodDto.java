package com.easypick.thunderMan.dto;

import java.io.Serializable;
import java.util.Set;

public record DlFoodDto(
        Long id,
        Set<DlFoodOptionDto> dlFoodOption,
        Long storeId,
        String foodName,
        int foodPrice,
        String foodDec,
        String foodImg,
        String foodThumb
) implements Serializable {
}
