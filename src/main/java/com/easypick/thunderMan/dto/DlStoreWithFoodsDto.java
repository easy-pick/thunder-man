package com.easypick.thunderMan.dto;

import org.springframework.data.domain.Slice;

public record DlStoreWithFoodsDto(
        DlStoreDto store,
        Slice<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos
) {

    public DlStoreWithFoodsDto(DlStoreDto store, Slice<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos){
        this.store = store;
        this.foodWithFoodOptionsDtos = foodWithFoodOptionsDtos;
    }

    public static DlStoreWithFoodsDto of(DlStoreDto store, Slice<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos) {

        return new DlStoreWithFoodsDto(store, foodWithFoodOptionsDtos);
    }
}
