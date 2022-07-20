package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "CT01_IDX"),
        @Index(columnList = "CT01_CODE")
}, name = "TB_CART_01")
public class TB_CART_01 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CT01_IDX")
    private int ct01Idx;
    @Column(nullable = false, length = 10, name = "CT01_CODE" ) private int ct01Code;
    @Column(nullable = false, length = 50, name = "CT01_FROM_MN01_ID" ) private String ct01FromMn01Id;
    @Column(nullable = false, length = 10, name = "CT01_FROM_BS01_CODE" ) private String ct01FromBs01Code;
    @Column(nullable = false, length = 10, name = "CT01_FROM_MN01_CODE" ) private String ct01FromMn01Code;
    @Column(nullable = false, length = 10, name = "CT01_FROM_MN02_CODE" ) private String ct01FromMn02Code;
    @Column(nullable = false, length = 10, name = "CT01_FROM_MN03_CODE" ) private String ct01FromMn03Code;
    @Setter @Column(name = "CT01_CNT" ) private int ct01Cnt;
    @Setter @Column(length = 100, name = "CT01_IP" ) private String ct01Ip;
    @Setter @Column(nullable = false, name = "CT01_REG_DATE") private LocalDateTime ct01RegDate;

}

