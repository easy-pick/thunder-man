package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.DlStoreDto;
import com.easypick.thunderMan.dto.DlStoreWithFoodsDto;
import org.springframework.data.domain.Slice;

public interface StoreService {

    public Slice<DlStoreDto> storeList(long category, long address);
    public DlStoreWithFoodsDto storeDetail(long storeId);
    
}
