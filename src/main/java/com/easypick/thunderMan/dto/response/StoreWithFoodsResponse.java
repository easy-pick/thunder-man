package com.easypick.thunderMan.dto.response;

import com.easypick.thunderMan.dto.DlStoreWithFoodsDto;
import org.springframework.data.domain.Slice;

public record StoreWithFoodsResponse(
        StoreResponse storeResponse,
        Slice<FoodWithFoodOptionResponse> foodWithFoodOptionResponse
) {

    public static StoreWithFoodsResponse from(DlStoreWithFoodsDto dto) {

        return new StoreWithFoodsResponse(StoreResponse.from(dto.store()), dto.foodWithFoodOptionsDtos().map(FoodWithFoodOptionResponse::from));
    }

}
