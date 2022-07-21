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
        @Index(columnList = "PT01_IDX"),
        @Index(columnList = "PT01_FROM_MB01_ID")
}, name = "TB_POINT_01")
public class TB_POINT_01 {

    @Id
    @Column(name = "PT01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int pt01Idx;

    // 인덱스
    @Column(nullable = false, length = 50, name = "PT01_FROM_MB01_ID") private String pt01FromMb01Id;

    // 일반필드
    @Setter @Column(nullable = false, name = "PT01_POINT" ) private String pt01Point;
    @Setter @Column(length = 1, name = "PT01_POINT_GUBUN" ) private String pt01PointGubun;
    @Setter @Column(length = 100, name = "PT01_REASON" ) private String pt01Reason;
    @Setter @Column(nullable = false, name = "PT01_REG_DATE") private LocalDateTime pt01LegDate;

}
