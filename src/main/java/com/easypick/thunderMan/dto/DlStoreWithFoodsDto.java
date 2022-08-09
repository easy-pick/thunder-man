package com.easypick.thunderMan.dto;

import java.util.Set;

public record DlStoreWithFoodsDto(
        DlStoreDto store,
        Set<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos
) {

    public DlStoreWithFoodsDto(DlStoreDto store, Set<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos){
        this.store = store;
        this.foodWithFoodOptionsDtos = foodWithFoodOptionsDtos;
    }

    public static DlStoreWithFoodsDto of(DlStoreDto store, Set<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos) {

        return new DlStoreWithFoodsDto(store, foodWithFoodOptionsDtos);
    }
}
