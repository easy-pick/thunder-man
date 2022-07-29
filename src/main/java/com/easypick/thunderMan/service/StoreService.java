package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlFoodDto;
import com.easypick.thunderMan.dto.DlFoodOptionDto;
import com.easypick.thunderMan.dto.DlStoreDto;

import java.util.List;

public interface StoreService {

    public List<DlStoreDto> storeList(long category, long address);

    List<DlFoodDto> storeFoodList(long storeId);

    public List<DlFoodOptionDto> foodsOption(long foodId);
}
