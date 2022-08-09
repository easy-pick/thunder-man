package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlFoodWithFoodOptionsDto;
import com.easypick.thunderMan.dto.DlStoreDto;
import com.easypick.thunderMan.dto.DlStoreWithFoodsDto;
import com.easypick.thunderMan.repository.FoodRepository;
import com.easypick.thunderMan.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedHashSet;
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
        log.info("parameter value : category = {} value = {} ", category, address);
        Slice<DlStoreDto> dlStores = storeRepository.findByCategory(category).map(DlStoreDto::from);
        log.info("검색된 List<DlStoreDto> 의 값 :: {} ", dlStores);

        return dlStores;
    }

    @Override
    @Transactional(readOnly = true)
    public DlStoreWithFoodsDto storeDetail(long storeId) {

        log.info("parameter value : storeId = {} ", storeId);
        DlStoreDto storeDto = storeRepository.findById(storeId).map(DlStoreDto::from)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 storeId 입니다 - " + storeId));

        log.info("검색된 storeDto = {}" , storeDto);

        DlStoreWithFoodsDto dlStoreWithFoodsDto = DlStoreWithFoodsDto.of(storeDto, foodRepository.findByDlStoreId(storeId).stream()
                .map(DlFoodWithFoodOptionsDto::from)
                .collect(Collectors.toCollection(LinkedHashSet::new)));

        log.info("return value : dlStoreWithFoodsDto = {} " , dlStoreWithFoodsDto);
        return dlStoreWithFoodsDto;
    }
}
