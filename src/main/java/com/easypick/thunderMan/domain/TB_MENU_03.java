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
        @Index(columnList = "MN03_IDX"),
        @Index(columnList = "MN03_FROM_BS01_CODE"),
        @Index(columnList = "MN03_FROM_MN02_CODE"),
        @Index(columnList = "MN03_CODE")
}, name = "TB_MENU_03")
public class TB_MENU_03 {

    @Id
    @Column(name = "MN03_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int mn03Idx;

    @Column(nullable = false, length = 10, name = "MN03_FROM_BS01_CODE" ) private String mn03FromBs01Code;
    @Column(nullable = false, length = 10, name = "MN03_FROM_MN02_CODE" ) private String mn03FromMn02Code;
    @Column(nullable = false, length = 10, name = "MN03_CODE" ) private String mn03Code;
    @Setter @Column(nullable = false, length = 50, name = "MN03_NAME" ) private String mn03Name;
    @Setter @Column(length = 100, name = "MN03_PRICE" ) private String mn03Price;
    @Setter @Column(nullable = false, length = 1, name = "MN03_DISPLAY_YN" ) private String mn03DisplayYn;
    @Setter @Column(nullable = false, name = "MN03_REG_DATE") private LocalDateTime mn03RegDate;

}

