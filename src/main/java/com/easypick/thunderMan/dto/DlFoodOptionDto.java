package com.easypick.thunderMan.dto;

import java.io.Serializable;

public record DlFoodOptionDto(
        Long id,
        Long dlFoodId,
        String optionName,
        int optionPrice
) implements Serializable {
}
