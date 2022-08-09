package com.easypick.thunderMan.dto.response;

import com.easypick.thunderMan.dto.DlStoreWithFoodsDto;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record StoreWithFoodsResponse(
        StoreResponse storeResponse,
        Set<FoodWithFoodOptionResponse> foodWithFoodOptionResponse
) {

    public static StoreWithFoodsResponse from(DlStoreWithFoodsDto dto) {

        return new StoreWithFoodsResponse(StoreResponse.from(dto.store()), dto.foodWithFoodOptionsDtos().stream()
                                                                                                        .map(FoodWithFoodOptionResponse::from)
                                                                                                        .collect(Collectors.toCollection(LinkedHashSet::new)));
    }

}
