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
        @Index(columnList = "RF01_IDX"),
        @Index(columnList = "RF01_FROM_RF01_IDX")
}, name = "TB_REIVEW_FILE_01")
public class TB_REIVEW_FILE_01 {

    @Id
    @Column(name = "RF01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int rf01Idx;

    @Column(nullable = false, length = 10, name = "RF01_FROM_RF01_IDX" ) private String rf01FromRf01Idx;
    @Column(nullable = false, length = 30, name = "RF01_NAME" ) private String rf01Name;
    @Setter @Column(  length = 16, name = "RF01_USE_YN" ) private String rf01UseYN;
    @Setter @Column(nullable = false, name = "RF01_REG_DATE") private LocalDateTime rf01RegDate;

}

