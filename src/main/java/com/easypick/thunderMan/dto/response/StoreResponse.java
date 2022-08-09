package com.easypick.thunderMan.dto.response;

import com.easypick.thunderMan.dto.DlStoreDto;

public record StoreResponse(
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
        String storeDes
) {

    public StoreResponse(Long id, Long category, String storeName, String storeAddress1, String storeAddress2, String storeAddress3, String storePhone, String storeImg, String storeThumb, int openingTime, int closingTime, int minDelivery, int deliveryTime, int deliveryTip, String storeDes) {
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
    }

    public static StoreResponse from(DlStoreDto dlStore
    ) {
        return new StoreResponse(
                dlStore.id(),
                dlStore.category(),
                dlStore.storeName(),
                dlStore.storeAddress1(),
                dlStore.storeAddress2(),
                dlStore.storeAddress3(),
                dlStore.storePhone(),
                dlStore.storeImg(),
                dlStore.storeThumb(),
                dlStore.openingTime(),
                dlStore.closingTime(),
                dlStore.minDelivery(),
                dlStore.deliveryTime(),
                dlStore.deliveryTip(),
                dlStore.storeDes());
    }
}
