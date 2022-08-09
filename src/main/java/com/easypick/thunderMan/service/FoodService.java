package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlFoodOptionDto;
import com.easypick.thunderMan.dto.DlFoodWithFoodOptionsDto;

import java.util.List;

public interface FoodService {

    public DlFoodWithFoodOptionsDto storeFoodList(Long storeId);

    public List<DlFoodOptionDto> getFoodOptions(Long foodId);
}
