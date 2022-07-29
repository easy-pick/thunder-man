package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(indexes = {
        @Index(columnList = "id")
})
public class DlStore extends AuditingFields {

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10) private Long category;
    @Column(nullable = false, length = 100) private String storeName;
    @Column(nullable = false, length = 200) private String  storeAddress1;
    @Column(nullable = false, length = 200) private String storeAddress2;
    @Column(length = 200) private String storeAddress3;
    @Column(nullable = false, length = 20) private String storePhone;
    @Column(length = 200) private String storeImg;
    @Column(length = 200) private String storeThumb;
    @Column(length = 10) private int openingTime;
    @Column(length = 10) private int closingTime;
    @Column(length = 10) private int minDelivery; //최소 주문비용
    @Column(length = 10) private int deliveryTime;// 최소 배달소요시간
    @Column(length = 10) private int deliveryTip; // 배달비
    @Column(columnDefinition = "varchar(1000) default '매장 소개가 없습니다.'") private String storeDes; // 스토어 소개
    @Column(nullable = false, length = 50) private String storeOwner; // 스토어 사업자 유저

    @OrderBy("foodDec DESC")
    @OneToMany(mappedBy = "dlStore", cascade = CascadeType.ALL)
    private final Set<DlFood> dlFoods = new LinkedHashSet<>(); // 스토어 판매요리

    // insert query 실행 전 default value 값 처리를 위하여 작성
    @PrePersist
    public void prePersist(){
        this.storeDes = this.storeDes == null ? "매장 소개가 없습니다." : this.storeDes;
    }



}