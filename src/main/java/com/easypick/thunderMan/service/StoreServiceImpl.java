package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlFoodDto;
import com.easypick.thunderMan.dto.DlFoodOptionDto;
import com.easypick.thunderMan.dto.DlStoreDto;
import com.easypick.thunderMan.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Override
    public List<DlStoreDto> storeList(long category, long address) {

        List<DlStoreDto> dlStores = storeRepository.findByCategory(category).stream().map(DlStoreDto::from).toList();
        log.debug("검색된 List<DlStoreDto> 의 값 :: {}" + dlStores);
        log.debug(" List<DlStoreDto> 1번째 어레이의 값 :: {}" + dlStores.get(0).id());

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
}
