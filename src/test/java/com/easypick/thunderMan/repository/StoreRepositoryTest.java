package com.easypick.thunderMan.repository;

import com.easypick.thunderMan.dto.DlFoodWithFoodOptionsDto;
import com.easypick.thunderMan.dto.DlStoreDto;
import com.easypick.thunderMan.dto.response.StoreResponse;
import com.easypick.thunderMan.service.FoodService;
import com.easypick.thunderMan.service.StoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Slice;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class StoreRepositoryTest {

    @Autowired
    StoreService storeService;

    @Autowired
    FoodService foodService;

    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;

    public StoreRepositoryTest(@Autowired FoodRepository foodRepository, @Autowired StoreRepository storeRepository){

        this.foodRepository = foodRepository;
        this.storeRepository = storeRepository;
    }

    @DisplayName("카테고리를 기준으로 스토어리스트를 조회.")
    @Test
    void givenStoreCategory_whenSelecting_thenReturnsStores(){

        // Given
        long category =101L;
        long test = 0L;
        // When

        // DlStore 객체를 Slice<DlStoreDto> 로 변환하여 받는다.
        Slice<DlStoreDto> dlStores =storeService.storeList(category, test);
        System.out.println(dlStores.toString());
        // 받앗던 dlStores를 ResponseDto에 맞게 담는다.
        List<StoreResponse> storeList = dlStores.map(StoreResponse::from).toList();
        System.out.println(storeList.toString());
        // Then
        assertThat(storeList).isNotNull();
    }

    @DisplayName("storeId를 줫을때 스토어상세내용과 음식리스트(옵션포함) 조회")
    @Test
    void givenStoreId_whenSelecting_thenReturnsFoodWithFoodOptionList(){

        // Given
        Long storeId = 1L;
        // When

        // DlStore 객체를 Slice<DlStoreDto> 로 변환하여 받는다.
        List<DlFoodWithFoodOptionsDto> foodWithFoodOptionsDtoList =
                storeService.storeDetail(storeId).foodWithFoodOptionsDtos().stream().toList();
        System.out.println(foodWithFoodOptionsDtoList.get(0));

        // 받앗던 dlStores를 ResponseDto에 맞게 담는다.
        // Then
        assertThat(foodWithFoodOptionsDtoList).isNotNull();
    }
}
