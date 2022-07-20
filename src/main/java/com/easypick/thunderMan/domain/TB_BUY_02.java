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
        @Index(columnList = "BY02_IDX"),
        @Index(columnList = "BY02_FROM_BY01_CODE")
}, name = "TB_BUY_02")
public class TB_BUY_02 {

    @Id
    @Column(name = "BY02_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int by02Idx;

    // 인덱스
    @Column(nullable = false, length = 11, name = "BY02_FROM_BY01_CODE") private int by02FromBy01Code;

    // 일반필드
    @Setter @Column(nullable = false, length = 11, name = "BY02_FROM_BS01_CODE") private String by02FromBs01Code;
    @Setter @Column(nullable = false, length = 11, name = "BY02_FROM_MN01_CODE") private String by02FromMn01Code;
    @Setter @Column(nullable = false, length = 11, name = "BY02_FROM_MN02_CODE") private String by02FromMn02Code;
    @Setter @Column(length = 11, name = "BY02_FROM_MN03_CODE") private String by02FromMn03Code;
    @Setter @Column(length = 40, name = "BY02_MN02_PRICE") private int by02Mn0pPrice;
    @Setter @Column(length = 40, name = "BY02_MN02_CNT") private int by02Mn0pCnt;
    @Setter @Column(length = 40, name = "BY02_MN03_PRICE") private int by03Mn0pPrice;
    @Setter @Column(length = 40, name = "BY02_MN03_CNT") private int by03Mn0pCnt;
    @Setter @Column(nullable = false, name = "BY02_REG_DATE") private LocalDateTime by02LegDate;



}
