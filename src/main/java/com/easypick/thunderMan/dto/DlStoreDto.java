package com.easypick.thunderMan.dto;

import com.easypick.thunderMan.domain.DlStore;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record DlStoreDto(
        Long id,
        Long category,
        String storeName,
        String storeAddress1,
        String storeAddress2,
        String storeAddress3,
        String storePhone,
        String storeImg,
        String storeThumb,
        int openingTime,
        int closingTime,
        int minDelivery,
        int deliveryTime,
        int deliveryTip,
        String storeDes,

        Set<DlFoodDto> dlFoods
) {

    public DlStoreDto(Long id, Long category, String storeName, String storeAddress1, String storeAddress2, String storeAddress3, String storePhone, String storeImg, String storeThumb, int openingTime, int closingTime, int minDelivery, int deliveryTime, int deliveryTip, String storeDes, Set<DlFoodDto> dlFoods) {
        this.id = id;
        this.category = category;
        this.storeName = storeName;
        this.storeAddress1 = storeAddress1;
        this.storeAddress2 = storeAddress2;
        this.storeAddress3 = storeAddress3;
        this.storePhone = storePhone;
        this.storeImg = storeImg;
        this.storeThumb = storeThumb;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.minDelivery = minDelivery;
        this.deliveryTime = deliveryTime;
        this.deliveryTip = deliveryTip;
        this.storeDes = storeDes;
        this.dlFoods = dlFoods;
    }

    public static DlStoreDto of (Long id,
                                 Long category,
                                 String storeName,
                                 String storeAddress1,
                                 String storeAddress2,
                                 String storeAddress3,
                                 String storePhone,
                                 String storeImg,
                                 String storeThumb,
                                 int openingTime,
                                 int closingTime,
                                 int minDelivery,
                                 int deliveryTime,
                                 int deliveryTip,
                                 String storeDes,
                                 Set<DlFoodDto> dlFoods) {
                return new DlStoreDto(id,
                        category,
                        storeName,
                        storeAddress1,
                        storeAddress2,
                        storeAddress3,
                        storePhone,
                        storeImg,
                        storeThumb,
                        openingTime,
                        closingTime,
                        minDelivery,
                        deliveryTime,
                        deliveryTip,
                        storeDes,
                        dlFoods);
    }

    public static DlStoreDto from(DlStore dlStore
    ) {
        return new DlStoreDto(
                dlStore.getId(),
                dlStore.getCategory(),
                dlStore.getStoreName(),
                dlStore.getStoreAddress1(),
                dlStore.getStoreAddress2(),
                dlStore.getStoreAddress3(),
                dlStore.getStorePhone(),
                dlStore.getStoreImg(),
                dlStore.getStoreThumb(),
                dlStore.getOpeningTime(),
                dlStore.getClosingTime(),
                dlStore.getMinDelivery(),
                dlStore.getDeliveryTime(),
                dlStore.getDeliveryTip(),
                dlStore.getStoreDes(),
                dlStore.getDlFoods().stream().map(DlFoodDto::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
    }

}
