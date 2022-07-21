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
        @Index(columnList = "MB01_IDX"),
        @Index(columnList = "MB01_ID")
}, name = "TB_MEMBER_01")
public class TB_MEMBER_01 {

    @Id
    @Column(name = "MB01_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int mb01Idx;

    // 인덱스
    @Column(nullable = false, length = 50, name = "MB01_ID") private String mb01Id;

    // 일반필드
    @Setter @Column(nullable = false, length = 20, name = "MB01_PWD" ) private String mb01Pwd;
    @Setter @Column(length = 20, name = "MB01_NICK_NAME" ) private String mb01NickName;
    @Setter @Column(length = 20, name = "MB01_NAME" ) private String mb01Name;
    @Setter @Column(length = 50, name = "MB01_EMAIL" ) private String mb01Email;
    @Setter @Column(length = 16, name = "MB01_TEL") private String mb01Tel;
    @Setter @Column(name = "MB01_LAST_LOGIN") private LocalDateTime mb01LastLogin;
    @Setter @Column(length = 16, name = "MB01_IP") private String mb01Ip;
    @Setter @Column(length = 1, name = "MB01_USE_YN") private String mb01UseYn;
    @Setter @Column(nullable = false, name = "MB01_REG_DATE") private LocalDateTime mb01LegDate;

}
