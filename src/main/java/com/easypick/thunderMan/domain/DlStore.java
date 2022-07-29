package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    @Column(length = 10) private int minDelivery;
    @Column(length = 10) private int deliveryTime;
    @Column(length = 10) private int deliveryTip;
    @Column(columnDefinition = "varchar(1000) default '매장 소개가 없습니다.'") private String storeDes;

    // insert query 실행 전 default value 값 처리를 위하여 작성
    @PrePersist
    public void prePersist(){
        this.storeDes = this.storeDes == null ? "매장 소개가 없습니다." : this.storeDes;
    }

}