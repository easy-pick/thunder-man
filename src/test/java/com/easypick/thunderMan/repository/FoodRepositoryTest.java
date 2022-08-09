package com.easypick.thunderMan.repository;

import com.easypick.thunderMan.dto.DlFoodOptionDto;
import com.easypick.thunderMan.service.FoodService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FoodRepositoryTest {

    @Autowired
    FoodService foodService;

    @Test
    @DisplayName("음식의 옵션을 조회한다.")
    void givenFoodId_whenSelecting_thenReturnsFoodOpitons(){

    // Given
    long foodId = 1L;

    // When
    List<DlFoodOptionDto> foodOptionDtoList = foodService.getFoodOptions(foodId);

    // Then
    assertThat(foodOptionDtoList).isNotNull();

    }

}
