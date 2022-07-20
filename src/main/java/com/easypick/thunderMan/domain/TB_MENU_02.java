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
        @Index(columnList = "MN02_IDX"),
        @Index(columnList = "MN02_FROM_BS01_CODE"),
        @Index(columnList = "MN02_FROM_MN01_CODE"),
        @Index(columnList = "MN02_CODE")
}, name = "TB_MENU_02")
public class TB_MENU_02 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MN02_IDX")
    private int mn02Idx;

    @Column(nullable = false, length = 10, name = "MN02_FROM_BS01_CODE" ) private String mn02FromBs01Code;
    @Column(nullable = false, length = 10, name = "MN02_FROM_MN01_CODE" ) private String mn02FromMn01Code;
    @Column(nullable = false, length = 10, name = "MN02_CODE" ) private String mn02Code;
    @Setter @Column(nullable = false, length = 50, name = "MN02_NAME" ) private String mn02Name;
    @Setter @Column(name = "MN02_CONCEPT" ) private String mn02Concept;
    @Setter @Column(length = 100, name = "MN02_IMG" ) private String mn02Img;
    @Setter @Column(length = 100, name = "MN02_PRICE" ) private String mn02Price;
    @Setter @Column(nullable = false, length = 1, name = "MN02_DISPLAY_YN" ) private String mn02DisplayYn;
    @Setter @Column(nullable = false, name = "MN02_REG_DATE") private LocalDateTime mn02RegDate;

}

