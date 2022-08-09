package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.*;
import com.easypick.thunderMan.repository.FoodRepository;
import com.easypick.thunderMan.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    FoodRepository foodRepository;

    @Override
    @Transactional(readOnly = true)
    public Slice<DlStoreDto> storeList(long category, long address) {

        Slice<DlStoreDto> dlStores = storeRepository.findByCategory(category).map(DlStoreDto::from);
        log.debug("검색된 List<DlStoreDto> 의 값 :: {}" + dlStores.toString());

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
    @Transactional(readOnly = true)
    public DlStoreWithFoodsDto storeDetail(long storeId) {

        DlStoreDto storeDto = storeRepository.findById(storeId).map(DlStoreDto::from)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 storeId 입니다 - " + storeId));

        log.info("storeDto : " + storeDto);
        log.info("검색값 : " + foodRepository.findByDlStoreId(storeId));

        DlStoreWithFoodsDto dlStoreWithFoodsDto = DlStoreWithFoodsDto.of(storeDto, foodRepository.findByDlStoreId(storeId).stream()
                .map(DlFoodWithFoodOptionsDto::from)
                .collect(Collectors.toCollection(LinkedHashSet::new)));

        return dlStoreWithFoodsDto;
    }
}
