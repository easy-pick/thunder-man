package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "BY01_IDX"),
        @Index(columnList = "BY01_CODE")
}, name = "TB_BUY_01")
public class TB_BUY_01 {

    @Id
    @Column(name = "BY01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int by01Idx;

    // 인덱스
    @Column(nullable = false, length = 10, name = "BY01_CODE") private String by01Code;

    // 일반필드
    @Setter @Column(nullable = false, length = 50, name = "BY01_MB01_USER_ID" ) private String by01Mb01UserId;
    @Setter @Column(length = 20, name = "BY01_BUYER_NAME" ) private String by01BuyerName;
    @Setter @Column(nullable = false, length = 16, name = "BY01_BUYER_TEL_01" ) private String by01BuyerTel01;
    @Setter @Column(length = 16, name = "BY01_BUYER_TEL_02" ) private String by01BuyerTel02;
    @Setter @Column(nullable = false, name = "BY01_DELIVERY_GUBUN") private String by01DeliveryGubun;
    @Setter @Column(nullable = false, name = "BY01_DELIVERY_FEE") private int by01DeliveryFee;
    @Setter @Column(nullable = false, name = "BY01_USED_POINT") private int by01UsedPoint;
    @Setter @Column(nullable = false, name = "BY01_TOTAL_PRICE") private int by01TotalPrice;
    @Setter @Column(nullable = false, name = "BY01_PAY_GUBUN") private String by01PayGubun;
    @Setter @Column(nullable = false, name = "BY01_PAY_TYPE") private String by01PayType;
    @Setter @Column(nullable = false, length = 80, name = "BY01_DELIVERY_ADDR") private String by01DeliveryAddr;
    @Setter @Column(name = "BY01_MEMO") private String by01Memo;
    @Setter @Column(name = "BY01_OPTION_01") private String by01Option01;
    @Setter @Column(name = "BY01_OPTION_02") private String by01Option02;
    @Setter @Column(length = 40, name = "BY01_OPTION_SELECT") private String by01OptionSelect;
    @Setter @Column(nullable = false, length = 3, name = "BY01_FROM_BS01_DELIVERY_MIN") private String by01FromBs01DeliveryMin;
    @Setter @Column(nullable = false, length = 1, name = "BY01_DELIVERY_STATUS") private String by01DeliveryStatus;
    @Setter @Column(nullable = false, length = 1, name = "BY01_STATUS") private String by01Status;
    @Setter @Column(nullable = false, length = 1, name = "BY01_IP") private String by01Ip;
    @Setter @Column(nullable = false, name = "BY01_REG_DATE") private LocalDateTime by01LegDate;



}
