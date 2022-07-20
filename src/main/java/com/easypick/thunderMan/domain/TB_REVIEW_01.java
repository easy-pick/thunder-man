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
        @Index(columnList = "RV01_IDX"),
        @Index(columnList = "RV01_FROM_BS01_CODE"),
        @Index(columnList = "RV01_FROM_MB01_ID")
}, name = "TB_REVIEW_01")
public class TB_REVIEW_01 {

    @Id
    @Column(name = "RV01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int rv01Idx;
    //인덱스
    @Column(nullable = false, length = 10, name = "RV01_FROM_BS01_CODE" ) private String rv01FromBs01Code;
    @Column(nullable = false, length = 50, name = "RV01_FROM_MB01_ID" ) private String rv01FromMb01Id;
    
    //일반필드
    @Setter @Column(nullable = false, length = 30, name = "RV01_SUBJECT" ) private String rv01Subject;
    @Setter @Column(name = "RV01_CONTENTS" ) private String rv01Contents;
    @Setter @Column(nullable = false, name = "RV01_JUMSU" ) private int rv01Jumsu;
    @Setter @Column(nullable = false, length = 16, name = "RV01_IP" ) private String rv01Ip;
    @Setter @Column(nullable = false, name = "RV01_REG_DATE") private LocalDateTime rv01RegDate;

}

