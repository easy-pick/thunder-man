package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlFoodOptionDto;

import java.util.List;

public interface FoodService {

    public List<DlFoodOptionDto> getFoodOptions(Long foodId);

}
