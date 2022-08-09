package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlFoodDto;
import com.easypick.thunderMan.dto.DlFoodOptionDto;
import com.easypick.thunderMan.dto.DlFoodWithFoodOptionsDto;
import com.easypick.thunderMan.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;
    @Transactional(readOnly = true)
    public DlFoodWithFoodOptionsDto storeFoodList(Long storeId){

        log.info("검색값 : " + foodRepository.findByDlStoreId(storeId));
//        List<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtos = foodRepository.findByDlStoreId(storeId).stream().toList();
//        log.info("결과값 DlFoodWithFoodOptionsDto : " + foodRepository.findByDlStoreId(storeId).map(DlFoodWithFoodOptionsDto::from));
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DlFoodOptionDto> getFoodOptions(Long foodId) {

        List<DlFoodOptionDto> dlFoodOptionDtoList;

        DlFoodDto dlFood = foodRepository.findById(foodId).map(DlFoodDto::from)
                .orElseThrow(() -> new EntityNotFoundException("해당 foodId가 없습니다. foodId = " + foodId));
        dlFoodOptionDtoList = dlFood.dlFoodOption().stream().toList();
        log.info("foodId 의 OptionList : " + dlFoodOptionDtoList );

        return dlFoodOptionDtoList;
    }
}
