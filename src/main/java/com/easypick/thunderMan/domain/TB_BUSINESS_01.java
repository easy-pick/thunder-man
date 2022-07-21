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
        @Index(columnList = "BS01_IDX"),
        @Index(columnList = "BS01_CODE"),
        @Index(columnList = "BS01_ID")
}, name = "TB_BUSINESS_01")
public class TB_BUSINESS_01 {

    @Id
    @Column(name = "BS01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bs01Idx;

    @Column(nullable = false, length = 10, name = "BS01_CODE") private String bs01Code;
    @Column(nullable = false, length = 8, name = "BS01_ID") private String bs01Id;

    @Setter @Column(nullable = false, length = 8, name = "BS01_PWD" ) private String bs01Pwd;
    @Setter @Column(nullable = false, length = 30, name = "BS01_NAME" ) private String bs01Name;
    @Setter @Column(nullable = false, length = 2, name = "BS01_CATE_CODE" ) private String bs01CateCode;
    @Setter @Column(nullable = false, length = 80, name = "BS01_ADDR_01" ) private String bs01Addr01;
    @Setter @Column(nullable = false, name = "BS01_GPS_01") private BigDecimal bs01gps01;
    @Setter @Column(nullable = false, name = "BS01_GPS_02") private BigDecimal bs01gps02;
    @Setter @Column(nullable = false, length = 20, name = "BS01_CEO_NAME" ) private String bs01CeoName;
    @Setter @Column(length = 2000, name = "BS01_INFORMATION" ) private String bs01Information;
    @Setter @Column(length = 20, name = "BS01_THUM_IMG" ) private String bs01ThumImg;
    @Setter @Column(length = 12, name = "BS01_TEL" ) private String bs01Tel;
    @Setter @Column(length = 12, name = "BS01_GP" ) private String bs01Hp;
    @Setter @Column(length = 20, name = "BS01_BUSINESS_NUMBER" ) private String bs01BusinessNumber;
    @Setter @Column(nullable = false, length = 4, name = "BS01_DELIVERY_MIN") private int bs01DeliveryMin;
    @Setter @Column(nullable = false, name = "BS01_DELIVERY_FEE") private BigDecimal bs01DeliveryFee;
    @Setter @Column(nullable = false, length = 1, name = "BS01_CONFIRM_YN") private String bs01ConfirmYn;
    @Setter @Column(nullable = false, name = "BS01_REG_DATE") private LocalDateTime bs01RegDate;


}