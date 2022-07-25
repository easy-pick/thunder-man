package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "id")
})
public class DlOrder {

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNum;

    @Setter @ManyToOne(optional = false) private DlStore dlStore;
    @Setter @ManyToOne(optional = false) private DlUser dlUser;
    @Column(nullable = false, length = 11) private Long userId;
    @Column(nullable = false, columnDefinition = "timestamp default 'current_timestamp()'") private LocalDateTime orderDate;
    @Column(length = 30) private String payMethod;
    @Column(columnDefinition = "varchar(50) default '주문접수 대기 중'") private String deliveryStatus;
    @Column(nullable = false, length = 20) private String phone;
    @Column(nullable = false, length = 11) private int deliveryAddress1;
    @Column(nullable = false, length = 200) private String  deliveryAddress2;
    @Column(length = 200) private String  deliveryAddress3;
    @Column(nullable = false, length = 11) private int totalPrice;
    @Column(length = 11) private int usedPoint;
    @Column(length = 2000) private String  request;
    @Column(length = 30) private String  impUid;

    // insert query 실행 전 default value 값 처리를 위하여 작성
    @PrePersist
    public void prePersist(){
        this.orderDate = this.orderDate == null ? LocalDateTime.now() : this.orderDate;
        this.deliveryStatus = this.deliveryStatus == null ? "주문접수 대기 중" : this.deliveryStatus;

    }


}