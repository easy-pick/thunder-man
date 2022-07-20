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
        @Index(columnList = "MN01_IDX"),
        @Index(columnList = "MN01_FROM_BS01_CODE"),
        @Index(columnList = "MN01_CODE")
}, name = "TB_MENU_01")
public class TB_MENU_01 {

    @Id
    @Column(name = "MN01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int mn01Idx;

    @Column(nullable = false, length = 10, name = "MN01_FROM_BS01_CODE" ) private String mn01FromBs01Code;
    @Column(nullable = false, length = 10, name = "MN01_CODE" ) private String mn01Code;
    @Setter @Column(nullable = false, length = 50, name = "MN01_NAME" ) private String mn01Name;
    @Setter @Column(length = 100, name = "MN01_CONCEPT" ) private String mn01Concept;
    @Setter @Column(nullable = false, length = 1, name = "MN01_DISPLAY_YN" ) private String mn01DisplayYn;
    @Setter @Column(nullable = false, name = "MN01_REG_DATE") private LocalDateTime mn01RegDate;

}

