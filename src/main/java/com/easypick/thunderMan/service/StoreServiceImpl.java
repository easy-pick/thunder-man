package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.*;
import com.easypick.thunderMan.repository.FoodRepository;
import com.easypick.thunderMan.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public Slice<DlStoreDto> storeList(long category, long address) {

        Slice<DlStoreDto> dlStores = storeRepository.findByCategory(category).map(DlStoreDto::from);
        log.debug("검색된 List<DlStoreDto> 의 값 :: {}" + dlStores);

        return dlStores;
    }

    @Override
    public List<DlFoodDto> storeFoodList(long storeId) {

        return null;
    }

    @Override
    public List<DlFoodOptionDto> foodsOption(long foodId) {
        return null;
    }

    @Override
    public DlStoreWithFoodsDto storeDetail(long storeId) {

        DlStoreDto storeDto = storeRepository.findById(storeId).map(DlStoreDto::from)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 storeId 입니다 - " + storeId));

        Slice<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos = foodRepository.findByDlStoreId(storeId).map(DlFoodWithFoodOptionsDto::from);

        return DlStoreWithFoodsDto.of(storeDto, foodWithFoodOptionsDtos);
    }
}
