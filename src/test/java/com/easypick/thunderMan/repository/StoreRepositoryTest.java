package com.easypick.thunderMan.repository;

import com.easypick.thunderMan.dto.DlStoreDto;
import com.easypick.thunderMan.dto.response.StoreResponse;
import com.easypick.thunderMan.service.StoreService;
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

    @Test
    void givenStoreCategory_whenSelecting_thenReturnsStores(){

        // Given
        Long category =101L;
        Long test = 0L;
        // When

        // DlStore 객체를 Slice<DlStoreDto> 로 변환하여 받는다.
        Slice<DlStoreDto> dlStores =storeService.storeList(category, test);

        // 받앗던 dlStores를 ResponseDto에 맞게 담는다.
        List<StoreResponse> storeList = dlStores.map(StoreResponse::from).toList();

        // Then
        assertThat(storeList).isNotNull();

    }

}
