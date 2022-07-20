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
        @Index(columnList = "LH01_IDX"),
        @Index(columnList = "LH01_FROM_MB01_ID")
}, name = "TB_LOGIN_HISTORY_01")
public class TB_LOGIN_HISTORY_01 {

    @Id
    @Column(name = "LH01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int lh01Idx;

    // 인덱스
    @Column(nullable = false, length = 50, name = "LH01_FROM_MB01_ID") private String lh01FromMb01Id;

    // 일반필드
    @Setter @Column(nullable = false, length = 16, name = "LH01_IP" ) private String lh01Ip;
    @Setter @Column(nullable = false, name = "LH01_REG_DATE") private LocalDateTime lh01LegDate;



}
